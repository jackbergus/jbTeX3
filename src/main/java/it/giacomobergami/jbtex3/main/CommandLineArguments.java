/*
 * CommandLineArguments.java
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

import com.beust.jcommander.IDefaultProvider;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;
import org.apache.log4j.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CommandLineArguments {

    @Parameter(names = "--help", description = "Prints the current message", help = true)
    private boolean help = false;

    @Parameter(names = "--logFile", description = "Configuration file for the 'org.apache.log4j.*' loggers. If the provided file does not exists, logs are disabled.", converter = FileConverter.class)
    public File logFile = new File("conf/logger.properties");

    @Parameter(names = "--out", description = "If this parameter is set, redirects the program's output into one single file", converter = FileConverter.class)
    public File latexFile;

    @Parameter(names = "--style", description = "Style used to convert the XML-paper")
    private String style;

    @Parameter(names = "--printStyles", description = "Prints the available styles to be passed to the `--style` argument")
    private boolean printStyles = false;

    public void setLogging() {
        if (logFile != null) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(logFile);
                PropertyConfigurator.configure(fis);
            } catch (java.io.IOException e) {
                BasicConfigurator.configure();
                Logger.getRootLogger().error("error while reading the configuration file", e);
                Logger.getRootLogger().info("disabling logging");
                List<Logger> loggers = Collections.<Logger>list(LogManager.getCurrentLoggers());
                loggers.add(LogManager.getRootLogger());
                for ( Logger logger : loggers ) {
                    logger.setLevel(Level.OFF);
                }
            }
        }
    }

    private static final PrintStream console = System.out;
    private PrintStream o;

    public void resetConsole() {
        if (o != null) {
            o.flush();
            o.close();
            System.setOut(console);
        }
    }

    public void redirectOutput() {
        if (latexFile != null) {
            // Creating a File object that represents the disk file.
            try {
                o = new PrintStream(latexFile);
                // Store current System.out before assigning a new value
                // Assign o to output stream
                System.setOut(o);
            } catch (FileNotFoundException e) {
                Logger.getRootLogger().error("Error while trying to file-writing", e);
            }
        }
    }

    public boolean doPrintStyles() {
        if (printStyles) {
            System.out.println("Currently supported styles:");
            File queries = new File("queries");
            if (queries.exists() && queries.isDirectory()) {
                for (File f : Objects.requireNonNull(queries.listFiles())) {
                    if (f.isDirectory()) {
                        if (new File(f, "main.txt").exists()) {
                            System.out.println("* "+f.getName());
                        }
                    }
                }
            }
        }
        return printStyles;
    }

    public File getConfigurationFile() {
        Logger logger = Logger.getRootLogger();
        if (style == null) {
            logger.error("Error: style non set");
        } else {
            File testFolder = new File("queries/"+style);
            if (!testFolder.exists()) {
                logger.error("Error: the following folder does not exists: "+ testFolder.getName());
            } else {
                File mainTest = new File(testFolder, "main.txt");
                if (!mainTest.exists()) {
                    logger.error("Error: each stylesheets requires a main.txt entry point");
                } else {
                    return mainTest;
                }
            }
        }
        return null;
    }
}
