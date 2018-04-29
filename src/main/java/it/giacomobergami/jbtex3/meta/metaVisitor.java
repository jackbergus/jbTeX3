// Generated from /media/giacomo/Data/Progetti/jbtex3/src/main/antlr4/meta.g4 by ANTLR 4.7
package it.giacomobergami.jbtex3.meta;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link metaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface metaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link metaParser#tagList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagList(metaParser.TagListContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(metaParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#register}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegister(metaParser.RegisterContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(metaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(metaParser.EvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#imp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImp(metaParser.ImpContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#opt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt(metaParser.OptContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#fromfile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromfile(metaParser.FromfileContext ctx);
	/**
	 * Visit a parse tree produced by {@link metaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(metaParser.ValueContext ctx);
}