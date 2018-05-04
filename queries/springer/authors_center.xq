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
let $lastAuthor := $doc/information/authors/author[last()]
let $firstAuthor := ($doc/information/authors/author)[1]
for $author in $doc/information/authors/author
    let $fullName := concat($author/name/text(),'~',$author/surname/text())
    return
           if ($author=$lastAuthor) then
                concat('\and ', $fullName, '}', $nl)
           else if ($author=$firstAuthor) then
                concat('\author{',$fullName, $nl)
           else
               concat('\and ', $fullName)


