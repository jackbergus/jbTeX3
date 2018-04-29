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
import java.util.Collections;
import java.util.List;

public class CommandLineArguments {
    private static class DefaultArguments implements IDefaultProvider {
        @Override
        public String getDefaultValueFor(String s) {
            if (s.equals("-logFile")) {
                return "conf/logger.properties";
            } else if (s.equals("-out")) {
                return "example.tex";
            } else
                return null;
        }
    }

    public IDefaultProvider provider() {
        return new DefaultArguments();
    }

    @Parameter(names = "-logFile", description = "Where the logging configurations are stored", converter = FileConverter.class)
    public File logFile;

    @Parameter(names = "-out", description = "Output file (if it exists)", converter = FileConverter.class)
    public File latexFile;

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
}
