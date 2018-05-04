/*
 * Main.java
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

package it.giacomobergami.jbtex3.main;

import com.beust.jcommander.JCommander;
import it.giacomobergami.jbtex3.meta.MetaConfigurator;

import java.io.File;

public class Main {
    private static CommandLineArguments arguments = new CommandLineArguments();

    public static void main(String args[]) {
        JCommander jc = JCommander
                .newBuilder()
                .acceptUnknownOptions(false)
                .addObject(arguments)
                .build();
        try {
            jc.setProgramName("jbTeX3");
            jc.parse(args);
        } catch (Exception e) {
            e.printStackTrace();
            jc.usage();
            System.exit(1);
        }

        if (arguments.doPrintStyles()) {
            System.exit(0);
        }

        arguments.setLogging();
        File stylesheet = arguments.getConfigurationFile();
        if (stylesheet == null) {
            jc.usage();
            System.exit(1);
        }

        if (arguments.haveToCheckMissingCitations()) {
            arguments.checkMissingCitations();
        } else if (arguments.haveToImputeDuplications()) {
            arguments.imputeDuplications();
        } else {
            MetaConfigurator conf = new MetaConfigurator();
            conf.setQueryFile(stylesheet);
            String toWrite = conf.useDocument(null);

            if (toWrite != null){
                arguments.redirectOutput();
                System.out.println(toWrite);
                arguments.resetConsole();
            }
        }


    }

}
