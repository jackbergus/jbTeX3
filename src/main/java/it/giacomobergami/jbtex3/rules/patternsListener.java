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
	 * Enter a parse tree produced by {@link patternsParser#imp}.
	 * @param ctx the parse tree
	 */
	void enterImp(patternsParser.ImpContext ctx);
	/**
	 * Exit a parse tree produced by {@link patternsParser#imp}.
	 * @param ctx the parse tree
	 */
	void exitImp(patternsParser.ImpContext ctx);
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