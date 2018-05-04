/*
 * HandleBibliographyLegacy.java
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

import it.giacomobergami.jbtex3.legacy_latex.tex.TexWalker;
import it.giacomobergami.jbtex3.utils.FileExtensionWalker;
import it.giacomobergami.jbtex3.utils.FilterIterator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class HandleBibliographyLegacy {

    public static Iterator<File> getFilesWithMissingsLegacy(Set<String> missings, String texFile) throws IOException {
        return new FilterIterator<File>(new TexWalker(texFile).walk().iterator()) {
                    @Override
                    public boolean test(File f) {
                        try {
                            String k = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
                            return missings.stream().anyMatch(k::contains);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                };
    }

    public static Set<String> getMissingsLegacy(String texFile) throws IOException {
        return Files
                        .readAllLines(Paths.get(texFile.replace(".tex",".blg")))
                        .stream()
                        .filter(x -> x.startsWith("Warning--I didn't find a database entry for"))
                        .map(x -> {
                            x = x.replace("Warning--I didn't find a database entry for \"","");
                            return x.substring(0, x.length()-1);
                        })
                        .collect(Collectors.toSet());
    }
}
