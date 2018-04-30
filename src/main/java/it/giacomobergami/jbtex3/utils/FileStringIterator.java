/*
 * FileStringIterator.java
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

import java.io.*;
import java.util.Iterator;

public class FileStringIterator implements Iterator<String> {

    BufferedReader in;
    String line;
    public FileStringIterator(File file) throws FileNotFoundException {
        in = new BufferedReader(new FileReader(file));
    }

    public boolean hasNext() {
            if (line == null) {
                try {
                    line = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return line != null;
    }

    public String next() {
        String toreturn = hasNext() ? line : null;
        line = null;
        return toreturn;
    }
}
