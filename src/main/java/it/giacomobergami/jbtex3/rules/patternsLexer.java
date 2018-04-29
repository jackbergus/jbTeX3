
/*
 * patternsLexer.java
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
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class patternsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SMALLER=9, 
		TEXT=10, QSTRING=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "SMALLER", 
		"TEXT", "QSTRING", "WS"
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


	    void normalizeQuotedString() {
	        String normalized = getText();
	        normalized = normalized.substring(1, normalized.length()-1);
	        normalized = normalized.replaceAll("\\\\(.)", "$1");
	        setText(normalized);
	    }


	public patternsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "patterns.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10:
			QSTRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void QSTRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 normalizeQuotedString(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16O\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\60\n\n\r\n\16\n\61\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\fA\n\f\f\f\16\fD\13\f\3"+
		"\f\3\f\3\f\3\r\6\rJ\n\r\r\r\16\rK\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\4\2\62;c|\4\2$$^^\5\2$$*+^"+
		"^\5\2\13\f\17\17\"\"\2R\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2"+
		"\2\2\t\"\3\2\2\2\13$\3\2\2\2\r\'\3\2\2\2\17*\3\2\2\2\21,\3\2\2\2\23/\3"+
		"\2\2\2\25\63\3\2\2\2\27<\3\2\2\2\31I\3\2\2\2\33\34\7=\2\2\34\4\3\2\2\2"+
		"\35\36\7\60\2\2\36\6\3\2\2\2\37 \7?\2\2 !\7@\2\2!\b\3\2\2\2\"#\7B\2\2"+
		"#\n\3\2\2\2$%\7B\2\2%&\7*\2\2&\f\3\2\2\2\'(\7+\2\2()\7}\2\2)\16\3\2\2"+
		"\2*+\7\177\2\2+\20\3\2\2\2,-\7\'\2\2-\22\3\2\2\2.\60\t\2\2\2/.\3\2\2\2"+
		"\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\24\3\2\2\2\63\64\7\61\2\2"+
		"\64\65\7\61\2\2\65\66\7v\2\2\66\67\7g\2\2\678\7z\2\289\7v\2\29:\7*\2\2"+
		":;\7+\2\2;\26\3\2\2\2<B\7$\2\2=A\n\3\2\2>?\7^\2\2?A\t\4\2\2@=\3\2\2\2"+
		"@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7$\2\2"+
		"FG\b\f\2\2G\30\3\2\2\2HJ\t\5\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2LM\3\2\2\2MN\b\r\3\2N\32\3\2\2\2\7\2\61@BK\4\3\f\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}