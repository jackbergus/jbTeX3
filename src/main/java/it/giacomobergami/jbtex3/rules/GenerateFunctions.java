/*
 * GenerateFunctions.java
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

// Generated from /media/giacomo/Data/Progetti/jbtex3/src/main/antlr4/patterns.g4 by ANTLR 4.7
package it.giacomobergami.jbtex3.rules;
import it.giacomobergami.jbtex3.State;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

/**
 * This class provides an empty implementation of {@link patternsVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 */
public class GenerateFunctions extends AbstractParseTreeVisitor<Function<State, String>> implements patternsVisitor<Function<State, String>> {

	public Map<String, Function<State, String>> rewritings = new HashMap<>();
	private static final Function<State, String> emptyFunction = x -> "";
	private static final Function<State, String> toText = State::getText;

	/**
	 * Returns the text-conversion representation
	 */
	public GenerateFunctions() {}

	/**
	 * Instantiates the generator to a given parsed file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static GenerateFunctions fromFile(File file) throws IOException {
		patternsParser parser = new patternsParser(new CommonTokenStream(new patternsLexer(CharStreams.fromPath(file.toPath()))));
		GenerateFunctions gf = new GenerateFunctions();
		gf.visit(parser.tagList());
		return gf;
	}

	public Function<State,String> getOrDefault(String key) {
		return rewritings.getOrDefault(key, toText);
	}

	/**
	 * The default basic function is the one associating the current state to an empty string
	 * @return
	 */
	@Override
	protected Function<State, String> defaultResult() {
		return emptyFunction;
	}

	@Override
	protected Function<State, String> aggregateResult(Function<State, String> aggregate, Function<State, String> nextResult) {
		if (aggregate == emptyFunction && nextResult == emptyFunction)
			return emptyFunction;
		else if (aggregate == emptyFunction)
			return nextResult;
		else
			return x -> aggregate.apply(x)+nextResult.apply(x);
	}

	/**
	 * for each element of the tag list, visit each tag rewriting definition
	 */
	@Override public Function<State, String> visitTagList(patternsParser.TagListContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Function<State, String> visitTag(patternsParser.TagContext ctx) {
		Function<State, String> fun = ctx.pattern().accept(this);
		String attribute = ctx.SMALLER().getText();
		rewritings.put(attribute, fun);
		return emptyFunction;
	}


	/**
	 * A pattern is just the compostion of the caller's functions
	 */
	@Override
	public Function<State, String> visitPattern(patternsParser.PatternContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * Expands the current attribute with the tag association. If the tag is not present, then it is associated with
	 * an empty string
	 */
	@Override
	public Function<State, String>  visitExpandAttribute(patternsParser.ExpandAttributeContext ctx) {
		return x -> x.getAttribute(ctx.SMALLER().getText());
	}

	/**
	 * Any quoted string is rewritten into its unquoted representation
	 */
	@Override
	public Function<State, String> visitQuotedString(patternsParser.QuotedStringContext ctx) {
		return x -> ctx.QSTRING().getText();
	}

	/**
	 * Expands with a non-empty string if the attribute is matched
	 */
	@Override
	public Function<State, String> visitConditionalExpand(patternsParser.ConditionalExpandContext ctx) {
		return x -> (x.containsAttribute(ctx.SMALLER().getText()) ? visitPattern(ctx.pattern()).apply(x) : "");
	}

	/**
	 * Defines two different expand politics depending whether the tag is defined or not
	 */
	@Override
	public Function<State, String> visitConditionalExpandOrFalse(patternsParser.ConditionalExpandOrFalseContext ctx) {
		return x ->
				(x.containsAttribute(ctx.SMALLER().getText()) ?
						visitPattern(ctx.pattern().get(0)) :
						visitPattern(ctx.pattern().get(1))
				).apply(x);
	}

	/**
	 * A text expanction rule simply replaces the current pattern with the text that has been traversed
	 */
	@Override
	public Function<State,String> visitExpandText(patternsParser.ExpandTextContext ctx) {
		return State::getCurrentString;
	}
}