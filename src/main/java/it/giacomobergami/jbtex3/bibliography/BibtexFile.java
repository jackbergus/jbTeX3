/*
 * BibtexFile.java
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

import it.giacomobergami.jbtex3.utils.FileProvider;
import org.jbibtex.*;

import java.io.*;

public class BibtexFile {

    BibTeXDatabase db;
    private BibTeXParser bibtexParser;
    File self;

    public BibtexFile(File file) throws FileNotFoundException, ParseException {
        self = file;
        bibtexParser = new BibTeXParser() {
            @Override
            public void checkCrossReferenceResolution(Key key, BibTeXEntry entry){
            }
        };
        db = bibtexParser.parse(new FileReader(file));
    }

    public BibTeXEntry getEntry(String key) {
        return db.resolveEntry(new Key(key));
    }

    public void removeEntry(String key) {
        BibTeXEntry entry;
        if ((entry = getEntry(key))!= null) {
            db.removeObject(entry);
        }
    }

    public void save(boolean reload) throws IOException {
        if (db != null && self != null) {
            new BibTeXFormatter().format(db, new FileWriter(self));
            if (reload) {
                // Reloading the new database
                bibtexParser = new BibTeXParser(new FileProvider(new FileReader(self)));
                db = bibtexParser.getDatabase();
            }
        }
    }
}
