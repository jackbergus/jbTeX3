/*
 * MetaConfigurator.java
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

// Generated from /media/giacomo/Data/Progetti/jbtex3/src/main/antlr4/meta.g4 by ANTLR 4.7
package it.giacomobergami.jbtex3.meta;
import it.giacomobergami.jbtex3.querying.QueryEvaluator;
import it.giacomobergami.jbtex3.querying.QueryEvaluatorFactory;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Combines the different QueryEvaluators within one single combinator file
 */
public class MetaConfigurator extends AbstractParseTreeVisitor<String> implements metaVisitor<String>, QueryEvaluator {
	private final String emptyString = "";
	private QueryEvaluator instance;
	private metaParser parser;
	private final static Logger logger = Logger.getLogger(MetaConfigurator.class);

	/**
	 * Returns the text-conversion representation
	 */
	public MetaConfigurator() {}

	/**
	 * Instantiates the generator to a given parsed file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static MetaConfigurator fromFile(File file) throws IOException {
		return fromStreams(CharStreams.fromPath(file.toPath()));
	}

	public static MetaConfigurator fromString(String str) {
		return fromStreams(CharStreams.fromString(str));
	}

	private static MetaConfigurator fromStreams(CharStream stream) {
		metaParser parser = new metaParser(new CommonTokenStream(new metaLexer(stream)));
		MetaConfigurator gf = new MetaConfigurator();
		gf.visit(parser.tagList());
		return gf;
	}

	@Override
	protected String defaultResult() {
		return emptyString;
	}

	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		return aggregate == null ? nextResult : aggregate.concat(nextResult);
	}

	/**
	 * Entry point
	 */
	@Override public String visitTagList(metaParser.TagListContext ctx) { return visitChildren(ctx); }
	@Override public String visitPattern(metaParser.PatternContext ctx) { return visitChildren(ctx); }

	/**
	 * Registers a class as a query evaluator. Does not print nothing
	 */
	@Override public String visitRegister(metaParser.RegisterContext ctx) {
		QueryEvaluatorFactory.load(ctx.QSTRING(1).getText(), ctx.QSTRING(0).getText());
		return emptyString;
	}

	/**
	 * Printing the text
	 */
	@Override public String visitPrint(metaParser.PrintContext ctx) { return ctx.QSTRING().getText().concat("\n"); }

	private void recursivePrint(File[] arr, StringBuilder sb)
	{
		ArrayList<File> files = new ArrayList<>(arr.length);
		for (File f : arr) {
			if(f.isFile())
				files.add(f);
			else if(f.isDirectory())
				recursivePrint(Objects.requireNonNull(f.listFiles()), sb);
		}
		for (File file : files) {
			sb.append(instance.useDocument(file));
		}
	}

	/**
	 * Appends the query result to the file
	 */
	@Override public String visitEval(metaParser.EvalContext ctx) {

		// Associating the query evaluator:
		String query = ctx.QSTRING().toString();
		instance = QueryEvaluatorFactory.istantiate(query);

		// Setting the instance parameter, either from file or text
		visit(ctx.opt());

		// Returing the query result to be appended
		File path = new File(ctx.fromfile().QSTRING().toString());
		if (path.exists()) {
			if (path.isFile()) {
				String tmp = instance.useDocument(path);
				return tmp;
			} else if (path.isDirectory()) {
				StringBuilder sb = new StringBuilder();
				recursivePrint(path.listFiles(), sb);
				return sb.toString();
			}
		}
		return emptyString; // If the path is neither a file or a directory or if the file doesn't exist, then return an empty string
	}

	/**
	 * reading the query file
	 */
	@Override public String visitImp(metaParser.ImpContext ctx) {
		File file = new File(ctx.QSTRING().getText());
		try {
			return MetaConfigurator.fromFile(file).useDocument(null);
		} catch (IOException e) {
			logger.error("setQueryFile: error while reading query file [returning empty string]" + file.getName(), e);
			return emptyString;
		}
	}

	/**
	 * visiting opt
	 */
	@Override public String visitOpt(metaParser.OptContext ctx) {
		visitChildren(ctx);
		return emptyString;
	}

	/**
	 * setting query file
	 */
	@Override public String visitFromfile(metaParser.FromfileContext ctx) {
		instance.setQueryFile(new File(ctx.QSTRING().getText()));
		return emptyString;
	}
	/**
	 * setting query value
	 */
	@Override public String visitValue(metaParser.ValueContext ctx) {
		instance.setQueryString(ctx.QSTRING().getText());
		return emptyString;
	}

	@Override
	public QueryEvaluator setQueryFile(File file) {
		if (file == null || !file.exists())
			return setQueryString("");
		else try {
			parser = new metaParser(new CommonTokenStream(new metaLexer(CharStreams.fromPath(file.toPath()))));
			return this;
		} catch (IOException e) {
			logger.error("setQueryFile: error while reading file [returning null]" + file.getName(), e);
			return null;
		}
	}

	@Override
	public QueryEvaluator setQueryString(String query) {
		parser = new metaParser(new CommonTokenStream(new metaLexer(CharStreams.fromString(query))));
		return this;
	}

	/**
	 *
	 * @param document  Ignored document
	 * @return			Evaluated query
	 */
	@Override
	public String useDocument(File document) {
		return this.visit(parser.tagList());
	}
}