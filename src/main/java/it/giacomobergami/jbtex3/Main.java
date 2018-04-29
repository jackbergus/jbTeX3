/*
 * Main.java
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

package it.giacomobergami.jbtex3;

import it.giacomobergami.jbtex3.meta.MetaConfigurator;
import it.giacomobergami.jbtex3.querying.AntlrTagRewriterEvaluator;
import it.giacomobergami.jbtex3.querying.QueryEvaluator;
import it.giacomobergami.jbtex3.querying.QueryEvaluatorFactory;
import it.giacomobergami.jbtex3.querying.XQueryEvaluator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        /*
        QueryEvaluator qe = QueryEvaluatorFactory.istantiate(XQueryEvaluator.class.getCanonicalName());
        qe.setQueryFile(new File("authors.xq"));
        System.out.println(qe.useDocument(new File("informations.xml")));*/
        MetaConfigurator conf = new MetaConfigurator();
        conf.setQueryFile(new File("acm_conference.txt"));
        System.out.println(conf.useDocument(null));
    }

}
