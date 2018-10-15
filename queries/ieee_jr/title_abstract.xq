(:~
 : queries/acm/title_abstract.xq
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
let $nl := '&#10;'
let $doc := doc('file:@default')
let $header := concat('\title{', $doc/information/title/text(), '}', $nl, $nl,'\IEEEtitleabstractindextext{', $nl,
        '\begin{abstract}', $nl, $doc/information/abstract/text(), $nl, '\end{abstract}', $nl, '\begin{IEEEkeywords}')
let $tail := concat('\end{IEEEkeywords}}', $nl , '\maketitle', $nl)
let $keys := $doc/information/keys/key
let $lastKey := $keys[last()]
let $firstKey := ($keys)[1]
for $key in  $keys
return
    if (count($keys)=1) then
        concat($header, $key//text(), $nl, $tail)
    else if ($key=$lastKey) then
        concat(', ', $key//text(), $nl, $tail)
    else if ($key=$firstKey) then
            concat($header, $key//text())
        else
            concat(',', $key//text())
