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
let $doc := doc("file:@default")
for $affiliation in fn:distinct-values($doc/information/authors/author/affiliation/text())
    let $authors := $doc/information/authors/author[affiliation/text()=$affiliation]
    let $authorCount := count($authors)
    let $lastAuthor := $authors[last()]
    let $firstAuthor := $authors[1]
    for $author in $authors
        return
            if ($authorCount = 1) then
            concat('\thanks{', fn:substring($author/name/text(), 1, 1), '. ', $author/surname/text(), ', ', $affiliation, ' (e-mail: ', $author/email/text(), ')}')
            else if ($author = $firstAuthor) then
            concat('\thanks{', fn:substring($author/name/text(), 1,1), '. ', $author/surname/text())
            else if ($author = $lastAuthor) then
            concat(' and ', fn:substring($author/name/text(), 1, 1), '. ', $author/surname/ text(), ', ', $affiliation, ' (email: ', string-join($authors/email/text(), ', '), ')}')
            else
            concat(', ', fn:substring($author/name/text(), 1, 1), '. ', $author/surname/text())
