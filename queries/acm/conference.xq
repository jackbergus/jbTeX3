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
return concat('\copyrightyear{', $doc/information/year/text(),  '}', $nl,
              '\acmYear{', $doc/information/year/text(),  '}', $nl,
              '\acmConference[', $doc/information/short/text() ,
              ']{', $doc/information/long/text(),
              '}{', $doc/information/days/text(), ',', $doc/information/year,
              '}{', $doc/information/place/text(), '}', $nl,
              '\acmBooktitle{', $doc/information/short/text() ,
              ' : ', $doc/information/long/text(),
              ', ', $doc/information/days/text(), ', ', $doc/information/year,
              ', ', $doc/information/place/text(), '}', $nl,
              '\acmPrice{', $doc/information/price/text() , '}', $nl,
              '\acmDOI{', $doc/information/doi/text() , '}', $nl,
              '\acmISBN{', $doc/information/isbn/text() , '}', $nl,
              '\title{', $doc/information/title/text(), '}', $nl, $nl,
              '\begin{abstract}', $nl, $doc/information/abstract, $nl, '\end{abstract}', $nl )
