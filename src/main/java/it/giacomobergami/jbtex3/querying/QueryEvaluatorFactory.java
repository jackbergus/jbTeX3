/*
 * QueryEvaluatorFactory.java
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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class QueryEvaluatorFactory {

    private static Map<String, Class<?>> associations = new HashMap<>();

    public static boolean load(String shortName, String pathName) {
        try {
            Class<?> clazz = Class.forName(pathName);
            associations.put(shortName, clazz);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static QueryEvaluator istantiate(String className) {
        try {
            Class<?> clazz;
            if (associations.containsKey(className)) {
                clazz = associations.get(className);
            } else {
                clazz = Class.forName(className);
            }
            Constructor<?> constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            Object object = constructor.newInstance();
            if (object instanceof QueryEvaluator) {
                return (QueryEvaluator)object;
            } else {
                return null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

}
