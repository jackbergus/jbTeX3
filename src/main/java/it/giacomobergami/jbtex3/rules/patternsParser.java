// Generated from /media/giacomo/Data/Progetti/jbtex3/src/main/antlr4/patterns.g4 by ANTLR 4.7
package it.giacomobergami.jbtex3.rules;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class patternsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SMALLER=9, 
		TEXT=10, QSTRING=11, WS=12;
	public static final int
		RULE_tagList = 0, RULE_tag = 1, RULE_pattern = 2, RULE_expandAttribute = 3, 
		RULE_quotedString = 4, RULE_conditionalExpand = 5, RULE_conditionalExpandOrFalse = 6, 
		RULE_expandText = 7;
	public static final String[] ruleNames = {
		"tagList", "tag", "pattern", "expandAttribute", "quotedString", "conditionalExpand", 
		"conditionalExpandOrFalse", "expandText"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'.'", "'=>'", "'@'", "'@('", "'){'", "'}'", "'%'", null, 
		"'//text()'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "SMALLER", "TEXT", 
		"QSTRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "patterns.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public patternsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TagListContext extends ParserRuleContext {
		public List<TagContext> tag() {
			return getRuleContexts(TagContext.class);
		}
		public TagContext tag(int i) {
			return getRuleContext(TagContext.class,i);
		}
		public TagListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterTagList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitTagList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitTagList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagListContext tagList() throws RecognitionException {
		TagListContext _localctx = new TagListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tagList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(16);
					tag();
					setState(17);
					match(T__0);
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(24);
			tag();
			setState(25);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagContext extends ParserRuleContext {
		public TerminalNode SMALLER() { return getToken(patternsParser.SMALLER, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(27);
			match(SMALLER);
			setState(28);
			match(T__2);
			setState(29);
			pattern();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public List<ExpandAttributeContext> expandAttribute() {
			return getRuleContexts(ExpandAttributeContext.class);
		}
		public ExpandAttributeContext expandAttribute(int i) {
			return getRuleContext(ExpandAttributeContext.class,i);
		}
		public List<QuotedStringContext> quotedString() {
			return getRuleContexts(QuotedStringContext.class);
		}
		public QuotedStringContext quotedString(int i) {
			return getRuleContext(QuotedStringContext.class,i);
		}
		public List<ConditionalExpandContext> conditionalExpand() {
			return getRuleContexts(ConditionalExpandContext.class);
		}
		public ConditionalExpandContext conditionalExpand(int i) {
			return getRuleContext(ConditionalExpandContext.class,i);
		}
		public List<ConditionalExpandOrFalseContext> conditionalExpandOrFalse() {
			return getRuleContexts(ConditionalExpandOrFalseContext.class);
		}
		public ConditionalExpandOrFalseContext conditionalExpandOrFalse(int i) {
			return getRuleContext(ConditionalExpandOrFalseContext.class,i);
		}
		public List<ExpandTextContext> expandText() {
			return getRuleContexts(ExpandTextContext.class);
		}
		public ExpandTextContext expandText(int i) {
			return getRuleContext(ExpandTextContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(36);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(31);
					expandAttribute();
					}
					break;
				case 2:
					{
					setState(32);
					quotedString();
					}
					break;
				case 3:
					{
					setState(33);
					conditionalExpand();
					}
					break;
				case 4:
					{
					setState(34);
					conditionalExpandOrFalse();
					}
					break;
				case 5:
					{
					setState(35);
					expandText();
					}
					break;
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << TEXT) | (1L << QSTRING))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpandAttributeContext extends ParserRuleContext {
		public TerminalNode SMALLER() { return getToken(patternsParser.SMALLER, 0); }
		public ExpandAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expandAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterExpandAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitExpandAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitExpandAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpandAttributeContext expandAttribute() throws RecognitionException {
		ExpandAttributeContext _localctx = new ExpandAttributeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expandAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__3);
			setState(41);
			match(SMALLER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedStringContext extends ParserRuleContext {
		public TerminalNode QSTRING() { return getToken(patternsParser.QSTRING, 0); }
		public QuotedStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterQuotedString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitQuotedString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitQuotedString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedStringContext quotedString() throws RecognitionException {
		QuotedStringContext _localctx = new QuotedStringContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quotedString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(QSTRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpandContext extends ParserRuleContext {
		public TerminalNode SMALLER() { return getToken(patternsParser.SMALLER, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ConditionalExpandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterConditionalExpand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitConditionalExpand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitConditionalExpand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpandContext conditionalExpand() throws RecognitionException {
		ConditionalExpandContext _localctx = new ConditionalExpandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditionalExpand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__4);
			setState(46);
			match(SMALLER);
			setState(47);
			match(T__5);
			setState(48);
			pattern();
			setState(49);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpandOrFalseContext extends ParserRuleContext {
		public TerminalNode SMALLER() { return getToken(patternsParser.SMALLER, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public ConditionalExpandOrFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpandOrFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterConditionalExpandOrFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitConditionalExpandOrFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitConditionalExpandOrFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpandOrFalseContext conditionalExpandOrFalse() throws RecognitionException {
		ConditionalExpandOrFalseContext _localctx = new ConditionalExpandOrFalseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_conditionalExpandOrFalse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__4);
			setState(52);
			match(SMALLER);
			setState(53);
			match(T__5);
			setState(54);
			pattern();
			setState(55);
			match(T__7);
			setState(56);
			pattern();
			setState(57);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpandTextContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(patternsParser.TEXT, 0); }
		public ExpandTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expandText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).enterExpandText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof patternsListener ) ((patternsListener)listener).exitExpandText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof patternsVisitor ) return ((patternsVisitor<? extends T>)visitor).visitExpandText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpandTextContext expandText() throws RecognitionException {
		ExpandTextContext _localctx = new ExpandTextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expandText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\6\4\'\n\4\r\4\16\4(\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2="+
		"\2\27\3\2\2\2\4\35\3\2\2\2\6&\3\2\2\2\b*\3\2\2\2\n-\3\2\2\2\f/\3\2\2\2"+
		"\16\65\3\2\2\2\20=\3\2\2\2\22\23\5\4\3\2\23\24\7\3\2\2\24\26\3\2\2\2\25"+
		"\22\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31"+
		"\27\3\2\2\2\32\33\5\4\3\2\33\34\7\4\2\2\34\3\3\2\2\2\35\36\7\13\2\2\36"+
		"\37\7\5\2\2\37 \5\6\4\2 \5\3\2\2\2!\'\5\b\5\2\"\'\5\n\6\2#\'\5\f\7\2$"+
		"\'\5\16\b\2%\'\5\20\t\2&!\3\2\2\2&\"\3\2\2\2&#\3\2\2\2&$\3\2\2\2&%\3\2"+
		"\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)\7\3\2\2\2*+\7\6\2\2+,\7\13\2\2,\t"+
		"\3\2\2\2-.\7\r\2\2.\13\3\2\2\2/\60\7\7\2\2\60\61\7\13\2\2\61\62\7\b\2"+
		"\2\62\63\5\6\4\2\63\64\7\t\2\2\64\r\3\2\2\2\65\66\7\7\2\2\66\67\7\13\2"+
		"\2\678\7\b\2\289\5\6\4\29:\7\n\2\2:;\5\6\4\2;<\7\t\2\2<\17\3\2\2\2=>\7"+
		"\f\2\2>\21\3\2\2\2\5\27&(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}