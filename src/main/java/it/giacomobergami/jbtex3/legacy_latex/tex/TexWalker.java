/*
 * TexWalker.java
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

import org.apache.commons.io.DirectoryWalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TexWalker extends DirectoryWalker<File> {

    public String parentDir;
    public TexWalker(String fileMainTex) {
        parentDir = new File(new File(fileMainTex).getAbsolutePath()).getParent();
    }

    public static String getRelativePath(File file, File folder) {
        String filePath = file.getAbsolutePath();
        String folderPath = folder.getAbsolutePath();
        if (filePath.equals(folderPath))
            return "";
        if (filePath.startsWith(folderPath)) {
            return filePath.substring(folderPath.length() + 1);
        } else {
            return null;
        }
    }

    public List<File> walk() throws IOException {
        List<File> arrayList = new ArrayList<>();
        walk(new File(parentDir), arrayList);
        return arrayList;
    }

    @Override
    protected boolean handleDirectory(File directory, int depth, Collection<File> results){
        return !TexIgnore.configuration.doesMatch(getRelativePath(directory, new File(parentDir)));
    }

    @Override
    protected void handleFile(File file, int depth, Collection<File> results) {
        if (!TexIgnore.configuration.doesMatch(getRelativePath(file, new File(parentDir))))
            if (file.getName().endsWith(".tex"))
                results.add(file);
    }

}
