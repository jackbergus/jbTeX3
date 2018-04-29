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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		SMALLER=10, TEXT=11, QSTRING=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"SMALLER", "TEXT", "QSTRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'.'", "'=>'", "'import'", "'@'", "'@('", "'){'", "'}'", 
		"'%'", null, "'//text()'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "SMALLER", 
		"TEXT", "QSTRING", "WS"
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\6\139\n\13\r\13\16\13:\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\7\rJ\n\r\f\r\16\rM\13\r\3\r\3\r\3\r\3\16\6\16S\n\16\r\16\16\16"+
		"T\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\3\2\6\4\2\62;c|\4\2$$^^\5\2$$*+^^\5\2\13\f\17\17\"\"\2[\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t$\3\2\2"+
		"\2\13+\3\2\2\2\r-\3\2\2\2\17\60\3\2\2\2\21\63\3\2\2\2\23\65\3\2\2\2\25"+
		"8\3\2\2\2\27<\3\2\2\2\31E\3\2\2\2\33R\3\2\2\2\35\36\7=\2\2\36\4\3\2\2"+
		"\2\37 \7\60\2\2 \6\3\2\2\2!\"\7?\2\2\"#\7@\2\2#\b\3\2\2\2$%\7k\2\2%&\7"+
		"o\2\2&\'\7r\2\2\'(\7q\2\2()\7t\2\2)*\7v\2\2*\n\3\2\2\2+,\7B\2\2,\f\3\2"+
		"\2\2-.\7B\2\2./\7*\2\2/\16\3\2\2\2\60\61\7+\2\2\61\62\7}\2\2\62\20\3\2"+
		"\2\2\63\64\7\177\2\2\64\22\3\2\2\2\65\66\7\'\2\2\66\24\3\2\2\2\679\t\2"+
		"\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\26\3\2\2\2<=\7\61\2\2"+
		"=>\7\61\2\2>?\7v\2\2?@\7g\2\2@A\7z\2\2AB\7v\2\2BC\7*\2\2CD\7+\2\2D\30"+
		"\3\2\2\2EK\7$\2\2FJ\n\3\2\2GH\7^\2\2HJ\t\4\2\2IF\3\2\2\2IG\3\2\2\2JM\3"+
		"\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7$\2\2OP\b\r\2\2P\32"+
		"\3\2\2\2QS\t\5\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2V"+
		"W\b\16\3\2W\34\3\2\2\2\7\2:IKT\4\3\r\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}