/*
 * XQueryRewriter.java
 * This file is part of jbtex3
 *
 * Copyright (C) 2018 giacomo
 *
 * jbtex3 is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * jbtex3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jbtex3. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package it.giacomobergami.jbtex3.querying;

import oracle.xml.xquery.OXQConnection;
import oracle.xml.xquery.OXQDataSource;
import oracle.xml.xquery.OXQView;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.xml.xquery.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XQueryEvaluator implements QueryEvaluator {

    private static final Logger logger = Logger.getLogger(XQueryEvaluator.class);
    private XQueryEntityResolver mer = new XQueryEntityResolver();
    private File queryFile;
    private String queryString;

    private enum queryType {
        QUERYFILE,
        QUERYSTRING
    }
    private queryType t;

    @Override
    public QueryEvaluator setQueryFile(File file) {
        queryFile = file;
        queryString = null;
        t = queryType.QUERYFILE;
        return this;
    }

    @Override
    public QueryEvaluator setQueryString(String query) {
        queryString = query;
        queryFile = null;
        t = queryType.QUERYSTRING;
        return this;
    }

    @Override
    public String useDocument(File document) {
        mer.setFile(document);
        OXQDataSource ds = new OXQDataSource();
        XQConnection con = null;
        try {
            con = ds.getConnection();
            // OXQView is used to access Oracle extensions on XQJ objects.
            OXQConnection ocon = OXQView.getConnection(con);
            ocon.setEntityResolver(mer);
            XQPreparedExpression expr;

            switch (t) {
                case QUERYFILE: {
                    File query = queryFile;
                    XQStaticContext ctx = con.getStaticContext();
                    ctx.setBaseURI(query.toURI().toString());
                    FileInputStream in = new FileInputStream(queryFile);
                    expr = con.prepareExpression(in, ctx);
                    in.close();
                }
                    break;
                case QUERYSTRING: {
                    expr = con.prepareExpression(queryString);
                }
                    break;
                default:
                    return null;
            }

            XQSequence result = expr.executeQuery();
            String toReturn = result.getSequenceAsString(null);

            result.close();
            expr.close();
            con.close();
            return toReturn;
        } catch (XQException | IOException e) {
            logger.error("error while trying to read "+document.getName(), e);
        }
        return null;
    }

}
