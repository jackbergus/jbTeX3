/*
 * XMLCitations.java
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

package it.giacomobergami.jbtex3.bibliography.xml;

import it.giacomobergami.jbtex3.hierarchy.Algorithms;
import it.giacomobergami.jbtex3.utils.FileExtensionWalker;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public interface XMLCitations extends Algorithms {

    /**
     * Extracts the references from the file
     * @param file              File from which extract the citations
     * @return                  Set in which add the citations
     */
    Set<String> getQuotesInFile(File file);

    /**
     *
     * @param walker            Directories over which extract
     * @return                  Set of citations within the file
     */
    default HashMap<File, Set<String>> walkFiles(FileExtensionWalker walker) {
        HashMap<File, Set<String>> hashString = new HashMap<>();
        try {
            for (File f : walker.walk()) {
                hashString.put(f, getQuotesInFile(f));
            }
        } catch (IOException e) {
            Logger.getLogger(XMLCitations.class).error("Error while traversing "+walker.parentDir, e);
            return new HashMap<>();
        }
        return hashString;
    }

}
