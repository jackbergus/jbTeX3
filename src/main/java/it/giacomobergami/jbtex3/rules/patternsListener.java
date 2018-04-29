/*
 * patternsListener.java
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
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link patternsParser}.
 */
public interface patternsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link patternsParser#tagList}.
	 * @param ctx the parse tree
	 */
	void enterTagList(patternsParser.TagListContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#tagList}.
	 * @param ctx the parse tree
	 */
	void exitTagList(patternsParser.TagListContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(patternsParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(patternsParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(patternsParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(patternsParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#expandAttribute}.
	 * @param ctx the parse tree
	 */
	void enterExpandAttribute(patternsParser.ExpandAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#expandAttribute}.
	 * @param ctx the parse tree
	 */
	void exitExpandAttribute(patternsParser.ExpandAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#quotedString}.
	 * @param ctx the parse tree
	 */
	void enterQuotedString(patternsParser.QuotedStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#quotedString}.
	 * @param ctx the parse tree
	 */
	void exitQuotedString(patternsParser.QuotedStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#conditionalExpand}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpand(patternsParser.ConditionalExpandContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#conditionalExpand}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpand(patternsParser.ConditionalExpandContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#conditionalExpandOrFalse}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpandOrFalse(patternsParser.ConditionalExpandOrFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#conditionalExpandOrFalse}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpandOrFalse(patternsParser.ConditionalExpandOrFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link patternsParser#expandText}.
	 * @param ctx the parse tree
	 */
	void enterExpandText(patternsParser.ExpandTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#expandText}.
	 * @param ctx the parse tree
	 */
	void exitExpandText(patternsParser.ExpandTextContext ctx);
}