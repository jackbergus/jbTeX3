
/*
 * Antlr4Utils.java
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

import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Antlr4Utils {

    /**
     * Given a file to parse and two associated lexers and parser classes, instantiates the desired parser
     * @param classLexer        Lexer to be istantiated
     * @param classParser       Parser to be istantiated and returned
     * @param file              File to parse
     * @param <LEX>
     * @param <PAR>
     * @return  Istantiated parser
     * @throws NoSuchMethodException
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <LEX extends Lexer, PAR extends Parser> PAR instantiate(Class<LEX> classLexer, Class<PAR> classParser, File file) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LEX lexer;
        {
            Constructor<LEX> cLexer = classLexer.getConstructor(CharStream.class);
            cLexer.setAccessible(true);
            lexer = cLexer.newInstance(CharStreams.fromPath(file.toPath()));
        }
        TokenStream tokens = new CommonTokenStream(lexer);
        PAR parser;
        {
            Constructor<PAR> cParser = classParser.getConstructor(TokenStream.class);
            cParser.setAccessible(true);
            parser = cParser.newInstance(tokens);
        }
        return parser;
    }

}
