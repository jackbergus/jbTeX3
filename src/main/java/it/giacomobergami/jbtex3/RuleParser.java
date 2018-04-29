package it.giacomobergami.jbtex3;

import it.giacomobergami.jbtex3.rules.GenerateFunctions;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements the whole logic through which we convert a given XML file to a part of the LaTeX file body
 * The header/authors should be done within a different pre-processing step
 */
public class RuleParser {

    private final DocumentBuilderFactory dbFactory;
    private final DocumentBuilder dBuilder;
    private State state;
    private GenerateFunctions functions;

    /**
     * Creates the default to plain text conversion
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public RuleParser() throws IOException, ParserConfigurationException { this(null); }

    /**
     *
     * @param file                              File to be used to generate the parsing functions
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public RuleParser(File file) throws ParserConfigurationException, IOException {
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        functions = file == null ? new GenerateFunctions() : GenerateFunctions.fromFile(file);
    }

    public void visit(File fXmlFile) throws IOException, SAXException {
        initState(fXmlFile);
        parse(state.getCurrentVisit());
    }

    private void initState(File fXmlFile) throws IOException, SAXException {
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        state = new State(doc.getDocumentElement());
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
}
