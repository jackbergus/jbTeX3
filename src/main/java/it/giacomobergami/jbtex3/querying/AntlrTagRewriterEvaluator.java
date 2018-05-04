/*
 * ParseAntlrTagRewriter.java
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

import it.giacomobergami.jbtex3.rules.State;
import it.giacomobergami.jbtex3.rules.GenerateFunctions;
import it.giacomobergami.jbtex3.utils.XMLDomRead;
import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * This class implements the whole logic through which we convert a given XML file to a part of the LaTeX file body
 * The header/authors should be done within a different pre-processing step
 */
public class AntlrTagRewriterEvaluator implements QueryEvaluator {

    private final static Logger logger = Logger.getLogger(AntlrTagRewriterEvaluator.class);
    private State state;
    private GenerateFunctions functions;

    /**
     * Creates the default to plain text conversion
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public AntlrTagRewriterEvaluator() throws IOException, ParserConfigurationException { this(null); }

    /**
     *
     * @param file                              File to be used to generate the parsing functions
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public AntlrTagRewriterEvaluator(File file) throws ParserConfigurationException, IOException {
        setQueryFile(file);
    }

    public void visit(File fXmlFile) throws IOException, SAXException {
        initState(fXmlFile);
        parse(state.getCurrentVisit());
    }

    private void initState(File fXmlFile) {
        state = new State(XMLDomRead.readXMLDocument(fXmlFile));
    }

    private void parse(Node current) {
        short type = current.getNodeType();
        if (type == Node.TEXT_NODE) {
            state.appendText(current.getTextContent());
        } else if (type == Node.ELEMENT_NODE) {
            // preserve the previously appended text
            String backUp = state.getCurrentString();
            state.setCurrentString("");

            //preVisit the children
            preVisitChildren(current);

            // visit the current node
            state.setCurrentVisit(current);

            // Starting to parse the current node: setting the attributes
            visitAttributes(current);

            state.setCurrentString(backUp.concat(functions.getOrDefault(current.getNodeName()).apply(state)));

            // Finished to parse the current node
            tagEnd();
        } else if (type == Node.CDATA_SECTION_NODE) {
            CDATASection section = (CDATASection) current;
            state.appendText(section.getData());
        }

    }

    private void tagEnd() {
        state.clearMap();
    }

    private void visitAttributes(Node attributes) {
        NamedNodeMap namedNodeMap = attributes.getAttributes();
        state.clearMap();
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            Node n = namedNodeMap.item(i);
            state.put(n.getNodeName(), n.getNodeValue());
        }
    }

    private void preVisitChildren(Node current) {
        NodeList list = current.getChildNodes();
        if (list == null) return;
        int len = list.getLength();
        for (int i = 0; i<len; i++) {
            parse(list.item(i));
        }
    }

    /**
     * At the end of the visit, it returns the final document.
     * @return
     */
    @Override
    public String toString() {
        return state.getCurrentString();
    }

    @Override
    public QueryEvaluator setQueryFile(File file) {
        try {
            functions = file == null ? new GenerateFunctions() : GenerateFunctions.fromFile(file);
            return this;
        } catch (IOException e) {
            logger.error("setQueryFile: error while reading query file [returning null] " + file.getName(), e);
            return null;
        }
    }

    @Override
    public QueryEvaluator setQueryString(String query) {
        functions = query == null ? new GenerateFunctions() : GenerateFunctions.fromString(query);
        return this;
    }

    @Override
    public String useDocument(File document) {
        try {
            visit(document);
            return toString();
        } catch (IOException | SAXException e) {
            logger.error("setQueryFile: error while reading document file [returning null] " + document.getName(), e);
            return null;
        }
    }
}
