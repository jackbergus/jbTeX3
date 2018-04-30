/*
 * FileProvider.java
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

import org.jbibtex.Provider;

import java.io.FileReader;
import java.io.IOException;

public class FileProvider implements Provider {

    private final FileReader fr;

    public FileProvider(FileReader fr) {
        this.fr = fr;
    }

    @Override
    public int read(char[] buffer, int offset, int len) throws IOException {
        return fr.read(buffer, offset, len);
    }

    @Override
    public void close() throws IOException {
        fr.close();
    }
}
