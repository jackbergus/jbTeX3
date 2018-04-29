/*
 * meta.g4
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
 grammar meta;

 @lexer::members {
     void normalizeQuotedString() {
         String normalized = getText();
         normalized = normalized.substring(1, normalized.length()-1);
         normalized = normalized.replaceAll("\\\\(.)", "$1");
         setText(normalized);
     }
 }

 tagList : (pattern '.')*;
 pattern : (register | print | eval | imp)+;
 register : 'register' QSTRING 'as' QSTRING;
 print    : 'print' QSTRING;
 eval     : 'eval' QSTRING 'query' opt 'with document' fromfile;
 imp      : 'import' QSTRING;

 opt      : fromfile | value;
 fromfile : 'from file' QSTRING;
 value    : 'val'       QSTRING;

 QSTRING : '"' (~[\\"] | '\\' [\\"()])* '"' { normalizeQuotedString(); };
 WS: [ \n\t\r]+ -> skip;