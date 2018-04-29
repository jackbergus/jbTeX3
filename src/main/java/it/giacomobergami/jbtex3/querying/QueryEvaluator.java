/*
 * Runner.java
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

import java.io.File;
import java.io.IOException;

public interface QueryEvaluator {
    /**
     * Initializes the query evaluator with a default file
     * @param file  File containing the query to be interpreted
     * @return      Updated instance of the self object
     */
    QueryEvaluator setQueryFile(File file);

    QueryEvaluator setQueryString(String query);

    /**
     * Evaluates the previously-loaded query over the ingested file
     * @param document  File over which the query is evaluated
     * @return          Query Result
     */
    String useDocument(File document);
}
