/*
 * BBLFileSplit.java
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

package it.giacomobergami.jbtex3.bibliography;

import it.giacomobergami.jbtex3.utils.FileStringIterator;
import it.giacomobergami.jbtex3.utils.FilterIterator;
import it.giacomobergami.jbtex3.utils.VoidIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BBLFileSplit implements Iterator<List<String>> {
    private final FileStringIterator fsi;
    private BBLFileSplit(File fsi) throws FileNotFoundException {
        this.fsi = new FileStringIterator(fsi);
    }

    public static Iterator<List<String>> iterateOver(File f) {
        try {
            return new FilterIterator<List<String>>(new BBLFileSplit(f)) {
                @Override
                public boolean test(List<String> strings) {
                    return !strings.contains("\\end{thebibliography}") && strings.stream().noneMatch(x -> x.contains("\\begin{thebibliography}"));
                }
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new VoidIterator<>();
        }
    }

    @Override
    public boolean hasNext() {
        return fsi.hasNext();
    }

    @Override
    public List<String> next() {
        ArrayList<String> toArray = new ArrayList<>();
        while (fsi.hasNext()) {
            String curr = fsi.next();
            if (curr.trim().isEmpty()) {
                return toArray;
            } else {
                toArray.add(curr);
            }
        }
        return toArray;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Iterable<List<String>> it = () -> BBLFileSplit.iterateOver(new File("/mnt/DEC4763AC47614CD/thesis/main.bbl"));
        for (List<String> x : it) {
            System.out.println(x);
        }
    }

}
