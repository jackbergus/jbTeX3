/*
 * TexIgnore.java
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

package it.giacomobergami.jbtex3.legacy_latex.tex;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Pattern;

public class TexIgnore {

    HashSet<String> lines;
    public static final TexIgnore configuration = new TexIgnore();
    private TexIgnore() {
        lines = new HashSet<>();
        File f = new File(".texignore");
        if (f.exists()) {
            lines.add(".texignore");
            try {
                lines.addAll(FileUtils.readLines(f, "utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean doesMatch(String file) {
        return lines.stream().anyMatch(x -> Pattern.compile(x).matcher(file).find());
    }

}
