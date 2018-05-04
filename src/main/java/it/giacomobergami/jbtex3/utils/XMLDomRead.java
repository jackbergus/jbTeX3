/*
 * XMLDomRead.java
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

package it.giacomobergami.jbtex3.utils;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLDomRead {

    private static final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private static final Logger logger = Logger.getLogger(XMLDomRead.class);

    public static Element readXMLDocument(File fXmlFile) {
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc.getDocumentElement();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("Error while reading the document " + fXmlFile.getName(), e);
        }
        return null;
    }

}
