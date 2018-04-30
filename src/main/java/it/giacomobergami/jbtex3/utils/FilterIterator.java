/*
 * FilterIterator.java
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

import java.util.Iterator;
import java.util.function.Predicate;

public abstract class FilterIterator<T> implements Iterator<T>, Predicate<T> {

    private final Iterator<T> it;
    private T current;

    public FilterIterator(Iterator<T> it) {
        this.it = it;
        current = null;
    }

    @Override
    public boolean hasNext() {
        if (current == null || (!test(current))) {
            while (it.hasNext()) {
                current = it.next();
                if (test(current)) return true;
            }
            if (!it.hasNext())
                current = null;
        }
        return current != null;
    }

    @Override
    public T next() {
        T toret = current;
        current = (it.hasNext()) ? it.next() : null;
        return toret;
    }

}
