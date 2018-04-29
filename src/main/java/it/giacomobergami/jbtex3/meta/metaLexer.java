// Generated from /media/giacomo/Data/Progetti/jbtex3/src/main/antlr4/meta.g4 by ANTLR 4.7
package it.giacomobergami.jbtex3.meta;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class metaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, QSTRING=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "QSTRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'register'", "'as'", "'print'", "'eval'", "'query'", "'with document'", 
		"'import'", "'from file'", "'val'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "QSTRING", 
		"WS"
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
	 

	public metaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "meta.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\7\fb\n\f\f\f\16\fe\13\f\3\f\3\f\3\f\3\r\6\rk"+
		"\n\r\r\r\16\rl\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\3\2\5\4\2$$^^\5\2$$*+^^\5\2\13\f\17\17\"\"\2r\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7&\3\2\2\2\t)\3\2\2\2\13/\3\2\2\2\r\64"+
		"\3\2\2\2\17:\3\2\2\2\21H\3\2\2\2\23O\3\2\2\2\25Y\3\2\2\2\27]\3\2\2\2\31"+
		"j\3\2\2\2\33\34\7\60\2\2\34\4\3\2\2\2\35\36\7t\2\2\36\37\7g\2\2\37 \7"+
		"i\2\2 !\7k\2\2!\"\7u\2\2\"#\7v\2\2#$\7g\2\2$%\7t\2\2%\6\3\2\2\2&\'\7c"+
		"\2\2\'(\7u\2\2(\b\3\2\2\2)*\7r\2\2*+\7t\2\2+,\7k\2\2,-\7p\2\2-.\7v\2\2"+
		".\n\3\2\2\2/\60\7g\2\2\60\61\7x\2\2\61\62\7c\2\2\62\63\7n\2\2\63\f\3\2"+
		"\2\2\64\65\7s\2\2\65\66\7w\2\2\66\67\7g\2\2\678\7t\2\289\7{\2\29\16\3"+
		"\2\2\2:;\7y\2\2;<\7k\2\2<=\7v\2\2=>\7j\2\2>?\7\"\2\2?@\7f\2\2@A\7q\2\2"+
		"AB\7e\2\2BC\7w\2\2CD\7o\2\2DE\7g\2\2EF\7p\2\2FG\7v\2\2G\20\3\2\2\2HI\7"+
		"k\2\2IJ\7o\2\2JK\7r\2\2KL\7q\2\2LM\7t\2\2MN\7v\2\2N\22\3\2\2\2OP\7h\2"+
		"\2PQ\7t\2\2QR\7q\2\2RS\7o\2\2ST\7\"\2\2TU\7h\2\2UV\7k\2\2VW\7n\2\2WX\7"+
		"g\2\2X\24\3\2\2\2YZ\7x\2\2Z[\7c\2\2[\\\7n\2\2\\\26\3\2\2\2]c\7$\2\2^b"+
		"\n\2\2\2_`\7^\2\2`b\t\3\2\2a^\3\2\2\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd"+
		"\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7$\2\2gh\b\f\2\2h\30\3\2\2\2ik\t\4\2\2"+
		"ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\r\3\2o\32\3\2\2"+
		"\2\6\2acl\4\3\f\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}