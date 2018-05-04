/*
 * BBLRepresent.java
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

package it.giacomobergami.jbtex3.bibliography.legacy;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BBLRepresent {

    HashMap<String, List<String>> bibtex_To_Item;

    /**
     * Univoquely associating the key to the value it represents
     */
    HashBiMap<String,String> generatedToBibItem;

    public BBLRepresent(File f) {
        Iterator<List<String>> bfs = BBLFileSplit.iterateOver(f);
        generatedToBibItem = HashBiMap.create();
        bibtex_To_Item = new HashMap<>();
        while (bfs.hasNext()) {
            List<String> item = bfs.next();

            // 1) Getting the reference as a name
            String header = item.remove(0).replace("\\bibitem","");
            Pattern logEntry = Pattern.compile("\\[(.*?)\\]\\{(.*?)\\}");
            Matcher matchPattern = logEntry.matcher(header);
            if (matchPattern.find()) {
                String key = matchPattern.group(1);
                String bib_item_information = matchPattern.group(2);
                generatedToBibItem.put(key, bib_item_information);
                bibtex_To_Item.put(bib_item_information, item);
            }
        }
    }

    /**
     * Checks which is the
     * @return
     */
    @Deprecated
    public Stream<Collection<String>> uniformKeysWithSameValue() {
        Multimap<List<String>, String> multiMap = HashMultimap.create();
        for (Map.Entry<String, List<String>> entry : bibtex_To_Item.entrySet()) {
            multiMap.put(entry.getValue(), entry.getKey());
        }
        return multiMap
                .asMap()
                .entrySet()
                .stream()
                .filter(x -> x.getValue().size()>1)
                .map(Map.Entry::getValue);
    }

    public static void main(String args[]) {
        new BBLRepresent(new File("/media/giacomo/Data/thesis/main.bbl")).uniformKeysWithSameValue();
    }

    public String seekBibitemFromGenerated(String k) {
        return generatedToBibItem.get(k);
    }
}
