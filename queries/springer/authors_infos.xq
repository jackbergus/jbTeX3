(:~
 : authors_center.xq
 : This file is part of jbtex3
 :
 : Copyright (C) 2018 giacomo
 :
 : jbtex3 is free software; you can redistribute it and/or modify
 : it under the terms of the GNU General Public License as published by
 : the Free Software Foundation; either version 2 of the License, or
 : (at your option) any later version.
 :
 : jbtex3 is distributed in the hope that it will be useful,
 : but WITHOUT ANY WARRANTY; without even the implied warranty of
 : MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 : GNU General Public License for more details.
 :
 : You should have received a copy of the GNU General Public License
 : along with jbtex3. If not, see <http://www.gnu.org/licenses/>.
 :
 :)
let $nl := "&#10;"
let $doc := doc("file:@default")
let $affiliations := fn:distinct-values($doc/information/authors/author/affiliation/text())
for $affiliation in fn:distinct-values($doc/information/authors/author/affiliation/text())
    let $authors := $doc/information/authors/author[affiliation/text()=$affiliation]
    let $affHeader := if ($affiliation=$affiliations[1]) then '' else '\and '
    let $affTailer := if ($affiliation=$affiliations[last()]) then '}' else concat('\\',$nl)
    let $authorCount := count($authors)
    let $lastAuthor := $authors[last()]
    let $firstAuthor := $authors[1]
    for $author in $authors
        return
            if ($authorCount = 1) then
            concat($affHeader, fn:substring($author/name/text(), 1, 1), '. ', $author/surname/text(), '\at', $nl, $affiliation, '\\', $nl, '\email{', $author/email/text(), '}\\', $affTailer)
            else if ($author = $firstAuthor) then
            concat($affHeader, fn:substring($author/name/text(), 1,1), '. ', $author/surname/text())
            else if ($author = $lastAuthor) then
            concat(', ', fn:substring($author/name/text(), 1, 1), '. ', $author/surname/ text(), '\at', $nl, $affiliation, '\\', $nl, '\email{', string-join($authors/email/text(), ', '), '}', $affTailer)
            else
            concat(', ', fn:substring($author/name/text(), 1, 1), '. ', $author/surname/text())
