// Generated from /media/giacomo/Data/Progetti/jbtex3/src/main/antlr4/patterns.g4 by ANTLR 4.7
package it.giacomobergami.jbtex3.rules;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link patternsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface patternsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link patternsParser#tagList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagList(patternsParser.TagListContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(patternsParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(patternsParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#imp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImp(patternsParser.ImpContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#expandAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandAttribute(patternsParser.ExpandAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#quotedString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedString(patternsParser.QuotedStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#conditionalExpand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpand(patternsParser.ConditionalExpandContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#conditionalExpandOrFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpandOrFalse(patternsParser.ConditionalExpandOrFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link patternsParser#expandText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandText(patternsParser.ExpandTextContext ctx);
}