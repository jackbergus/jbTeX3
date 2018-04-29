
/*
 * State.java
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

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * This class defines the current state of the XML traversing.
 */
public class State {
    /**
     * Node which is currently visited
     */
    private Node currentVisit;
    /**
     * Current string associated to the //text()
     */
    private String currentString;
    /**
     * Attribute map associated to the current node
     */
    private Map<String, String> map;
    /**
     * Default empty string
     */
    private final String emptyString = "";

    public State(Node currentVisit) {
        currentString = "";
        map = new HashMap<>();
        this.currentVisit = currentVisit;
    }

    public Node getCurrentVisit() {
        return currentVisit;
    }

    public void setCurrentVisit(Node currentVisit) {
        this.currentVisit = currentVisit;
    }

    public String getCurrentString() {
        return currentString;
    }

    public void setCurrentString(String currentString) {
        this.currentString = currentString;
    }

    public void appendText(String textContent) {
        currentString = currentString.concat(" ").concat(textContent);
    }

    public void clearMap() {
        map.clear();
    }

    public void put(String nodeName, String nodeValue) {
        map.put(nodeName, nodeValue);
    }

    public String getText() {
        return getCurrentString();
    }

    public boolean containsAttribute(String attributeName) {
        return map.containsKey(attributeName);
    }

    public String getAttribute(String attributeName) {
        return map.getOrDefault(attributeName, emptyString);
    }
}
