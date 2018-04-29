/*
 * DocumentImportEvaluator.java
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

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
/**
 * The default query plan is the one that simply imports a document
 */
public class DocumentImportEvaluator implements QueryEvaluator {
    private final static Logger logger = Logger.getLogger(DocumentImportEvaluator.class);

    @Override
    public QueryEvaluator setQueryFile(File file) {
        return this;
    }
    @Override
    public QueryEvaluator setQueryString(String query) {
        return this;
    }
    @Override
    public String useDocument(File document)  {
        try {
            return new String(Files.readAllBytes(document.toPath()));
        } catch (IOException e) {
            logger.error("useDocument: error while reading file " + document.getName(), e);
            logger.error("returning an empty string instead");
            return "";
        }
    }
}
