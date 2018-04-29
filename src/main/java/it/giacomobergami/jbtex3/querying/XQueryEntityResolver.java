/*
 * MyEntityResolver.java
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

package it.giacomobergami.jbtex3.querying;

import oracle.xml.xquery.*;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

public class XQueryEntityResolver extends OXQEntityResolver {

    private File file;

    public XQueryEntityResolver() {
        this(null);
    }

    public XQueryEntityResolver(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
        public OXQEntity resolveEntity(OXQEntityKind kind,
                                       OXQEntityLocator locator,
                                       OXQEntityResolverRequestOptions options) throws java.io.IOException {
            if (kind == OXQEntityKind.DOCUMENT) {
                URI systemId = locator.getSystemIdAsURI();
                File file = this.file;
                boolean set = false;
                if ("file".equals(systemId.getScheme())) {
                    set = true;
                    if (!"@default".equals(systemId.getSchemeSpecificPart())) {
                        file = new File(systemId);
                    }
                }
                if (set) {
                    FileInputStream input = new FileInputStream(file);
                    OXQEntity result = new OXQEntity(input);
                    result.enlistCloseable(input);
                    return result;
                }
            }
            return null;
        }
}