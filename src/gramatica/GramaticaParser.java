// Generated from D:/vacas-junio-2022/proyecto-olc2/grammar\Gramatica.g4 by ANTLR 4.10.1
package gramatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, INT=43, REAL=44, BOOLEAN=45, CHARACTER=46, 
		STRING=47, IDEN=48, EQUAL=49, NOTEQUAL=50, GREATEREQUAL=51, LESSEQUAL=52, 
		GREATER=53, LESS=54, AND=55, OR=56, NOT=57, EQUIV=58, NOTEQUIV=59, COMMENT=60, 
		WS=61;
	public static final int
		RULE_start = 0, RULE_lfunc = 1, RULE_unitfunc = 2, RULE_mainblock = 3, 
		RULE_linstrucciones = 4, RULE_instruccion = 5, RULE_funcinst = 6, RULE_funcinstwith = 7, 
		RULE_funcinstwithout = 8, RULE_subroutineinst = 9, RULE_subroutineinstwith = 10, 
		RULE_subroutineinstwithout = 11, RULE_lparam = 12, RULE_callsubinst = 13, 
		RULE_lparamexp = 14, RULE_ldclparams = 15, RULE_declarationparams = 16, 
		RULE_noneinst = 17, RULE_arrayinst = 18, RULE_arraydinainst = 19, RULE_ldcldims = 20, 
		RULE_asigdimarray = 21, RULE_desasigdimarray = 22, RULE_asiginst = 23, 
		RULE_ldimeArray = 24, RULE_dimeArray = 25, RULE_ifinst = 26, RULE_lif = 27, 
		RULE_ifblck = 28, RULE_elseblck = 29, RULE_doinst = 30, RULE_doconf = 31, 
		RULE_doconflist = 32, RULE_dowhileinst = 33, RULE_exitinst = 34, RULE_cycleinst = 35, 
		RULE_print = 36, RULE_printexps = 37, RULE_printexp = 38, RULE_declaration = 39, 
		RULE_ldeclarations = 40, RULE_indecla = 41, RULE_type = 42, RULE_expr = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "lfunc", "unitfunc", "mainblock", "linstrucciones", "instruccion", 
			"funcinst", "funcinstwith", "funcinstwithout", "subroutineinst", "subroutineinstwith", 
			"subroutineinstwithout", "lparam", "callsubinst", "lparamexp", "ldclparams", 
			"declarationparams", "noneinst", "arrayinst", "arraydinainst", "ldcldims", 
			"asigdimarray", "desasigdimarray", "asiginst", "ldimeArray", "dimeArray", 
			"ifinst", "lif", "ifblck", "elseblck", "doinst", "doconf", "doconflist", 
			"dowhileinst", "exitinst", "cycleinst", "print", "printexps", "printexp", 
			"declaration", "ldeclarations", "indecla", "type", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'end'", "'function'", "'('", "')'", "'result'", "'subroutine'", 
			"','", "'call'", "'intent'", "'in'", "'::'", "'implicit'", "'none'", 
			"'dimension'", "'allocatable'", "':'", "'allocate'", "'deallocate'", 
			"'='", "'(/'", "'/)'", "'['", "']'", "'if'", "'else'", "'then'", "'do'", 
			"'while'", "'exit'", "'cycle'", "'print'", "'*'", "'integer'", "'real'", 
			"'complex'", "'character'", "'logical'", "'-'", "'**'", "'/'", "'+'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'.and.'", "'.or.'", "'.not.'", "'.eqv.'", "'.neqv.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "INT", "REAL", "BOOLEAN", "CHARACTER", 
			"STRING", "IDEN", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "GREATER", 
			"LESS", "AND", "OR", "NOT", "EQUIV", "NOTEQUIV", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public LfuncContext lfunc() {
			return getRuleContext(LfuncContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			lfunc(0);
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

	public static class LfuncContext extends ParserRuleContext {
		public LfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lfunc; }
	 
		public LfuncContext() { }
		public void copyFrom(LfuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LfuncfirstContext extends LfuncContext {
		public UnitfuncContext unitfunc() {
			return getRuleContext(UnitfuncContext.class,0);
		}
		public LfuncfirstContext(LfuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLfuncfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LfuncnextContext extends LfuncContext {
		public LfuncContext lfunc() {
			return getRuleContext(LfuncContext.class,0);
		}
		public UnitfuncContext unitfunc() {
			return getRuleContext(UnitfuncContext.class,0);
		}
		public LfuncnextContext(LfuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLfuncnext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LfuncContext lfunc() throws RecognitionException {
		return lfunc(0);
	}

	private LfuncContext lfunc(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LfuncContext _localctx = new LfuncContext(_ctx, _parentState);
		LfuncContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_lfunc, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LfuncfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(91);
			unitfunc();
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LfuncnextContext(new LfuncContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lfunc);
					setState(93);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(94);
					unitfunc();
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnitfuncContext extends ParserRuleContext {
		public MainblockContext mainblock() {
			return getRuleContext(MainblockContext.class,0);
		}
		public SubroutineinstContext subroutineinst() {
			return getRuleContext(SubroutineinstContext.class,0);
		}
		public FuncinstContext funcinst() {
			return getRuleContext(FuncinstContext.class,0);
		}
		public UnitfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitfunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitUnitfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitfuncContext unitfunc() throws RecognitionException {
		UnitfuncContext _localctx = new UnitfuncContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unitfunc);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				mainblock();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				subroutineinst();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				funcinst();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MainblockContext extends ParserRuleContext {
		public Token frid;
		public Token secid;
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public MainblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainblock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMainblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainblockContext mainblock() throws RecognitionException {
		MainblockContext _localctx = new MainblockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__0);
			setState(106);
			((MainblockContext)_localctx).frid = match(IDEN);
			setState(107);
			linstrucciones(0);
			setState(108);
			match(T__1);
			setState(109);
			match(T__0);
			setState(110);
			((MainblockContext)_localctx).secid = match(IDEN);
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

	public static class LinstruccionesContext extends ParserRuleContext {
		public LinstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linstrucciones; }
	 
		public LinstruccionesContext() { }
		public void copyFrom(LinstruccionesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LinstruccionesfirstContext extends LinstruccionesContext {
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public LinstruccionesfirstContext(LinstruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLinstruccionesfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LinstruccionesnextContext extends LinstruccionesContext {
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public LinstruccionesnextContext(LinstruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLinstruccionesnext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinstruccionesContext linstrucciones() throws RecognitionException {
		return linstrucciones(0);
	}

	private LinstruccionesContext linstrucciones(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LinstruccionesContext _localctx = new LinstruccionesContext(_ctx, _parentState);
		LinstruccionesContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_linstrucciones, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LinstruccionesfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(113);
			instruccion();
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LinstruccionesnextContext(new LinstruccionesContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_linstrucciones);
					setState(115);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(116);
					instruccion();
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InstruccionContext extends ParserRuleContext {
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	 
		public InstruccionContext() { }
		public void copyFrom(InstruccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclContext extends InstruccionContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoneContext extends InstruccionContext {
		public NoneinstContext noneinst() {
			return getRuleContext(NoneinstContext.class,0);
		}
		public NoneContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoContext extends InstruccionContext {
		public DoinstContext doinst() {
			return getRuleContext(DoinstContext.class,0);
		}
		public DoContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CycleContext extends InstruccionContext {
		public CycleinstContext cycleinst() {
			return getRuleContext(CycleinstContext.class,0);
		}
		public CycleContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCycle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayasiContext extends InstruccionContext {
		public ArrayinstContext arrayinst() {
			return getRuleContext(ArrayinstContext.class,0);
		}
		public ArrayasiContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitArrayasi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DclarraydiContext extends InstruccionContext {
		public ArraydinainstContext arraydinainst() {
			return getRuleContext(ArraydinainstContext.class,0);
		}
		public DclarraydiContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDclarraydi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DowhileContext extends InstruccionContext {
		public DowhileinstContext dowhileinst() {
			return getRuleContext(DowhileinstContext.class,0);
		}
		public DowhileContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDowhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallsubContext extends InstruccionContext {
		public CallsubinstContext callsubinst() {
			return getRuleContext(CallsubinstContext.class,0);
		}
		public CallsubContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCallsub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitContext extends InstruccionContext {
		public ExitinstContext exitinst() {
			return getRuleContext(ExitinstContext.class,0);
		}
		public ExitContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DesasiarrayContext extends InstruccionContext {
		public DesasigdimarrayContext desasigdimarray() {
			return getRuleContext(DesasigdimarrayContext.class,0);
		}
		public DesasiarrayContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDesasiarray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrtContext extends InstruccionContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public PrtContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPrt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsiarrayContext extends InstruccionContext {
		public AsigdimarrayContext asigdimarray() {
			return getRuleContext(AsigdimarrayContext.class,0);
		}
		public AsiarrayContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsiarray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsiContext extends InstruccionContext {
		public AsiginstContext asiginst() {
			return getRuleContext(AsiginstContext.class,0);
		}
		public AsiContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends InstruccionContext {
		public IfinstContext ifinst() {
			return getRuleContext(IfinstContext.class,0);
		}
		public IfContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instruccion);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new CallsubContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				callsubinst();
				}
				break;
			case 2:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				ifinst();
				}
				break;
			case 3:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				noneinst();
				}
				break;
			case 4:
				_localctx = new DoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				doinst();
				}
				break;
			case 5:
				_localctx = new DowhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				dowhileinst();
				}
				break;
			case 6:
				_localctx = new ExitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				exitinst();
				}
				break;
			case 7:
				_localctx = new CycleContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				cycleinst();
				}
				break;
			case 8:
				_localctx = new PrtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				print();
				}
				break;
			case 9:
				_localctx = new DeclContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(130);
				declaration();
				}
				break;
			case 10:
				_localctx = new AsiContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(131);
				asiginst();
				}
				break;
			case 11:
				_localctx = new ArrayasiContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(132);
				arrayinst();
				}
				break;
			case 12:
				_localctx = new DclarraydiContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(133);
				arraydinainst();
				}
				break;
			case 13:
				_localctx = new AsiarrayContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(134);
				asigdimarray();
				}
				break;
			case 14:
				_localctx = new DesasiarrayContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(135);
				desasigdimarray();
				}
				break;
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

	public static class FuncinstContext extends ParserRuleContext {
		public FuncinstwithContext funcinstwith() {
			return getRuleContext(FuncinstwithContext.class,0);
		}
		public FuncinstwithoutContext funcinstwithout() {
			return getRuleContext(FuncinstwithoutContext.class,0);
		}
		public FuncinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcinst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitFuncinst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncinstContext funcinst() throws RecognitionException {
		FuncinstContext _localctx = new FuncinstContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcinst);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				funcinstwith();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				funcinstwithout();
				}
				break;
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

	public static class FuncinstwithContext extends ParserRuleContext {
		public Token frid;
		public Token return_;
		public Token secid;
		public LparamContext lparam() {
			return getRuleContext(LparamContext.class,0);
		}
		public NoneinstContext noneinst() {
			return getRuleContext(NoneinstContext.class,0);
		}
		public LdclparamsContext ldclparams() {
			return getRuleContext(LdclparamsContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public FuncinstwithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcinstwith; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitFuncinstwith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncinstwithContext funcinstwith() throws RecognitionException {
		FuncinstwithContext _localctx = new FuncinstwithContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcinstwith);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__2);
			setState(143);
			((FuncinstwithContext)_localctx).frid = match(IDEN);
			setState(144);
			match(T__3);
			setState(145);
			lparam(0);
			setState(146);
			match(T__4);
			setState(147);
			match(T__5);
			setState(148);
			match(T__3);
			setState(149);
			((FuncinstwithContext)_localctx).return_ = match(IDEN);
			setState(150);
			match(T__4);
			setState(151);
			noneinst();
			setState(152);
			ldclparams(0);
			setState(153);
			linstrucciones(0);
			setState(154);
			match(T__1);
			setState(155);
			match(T__2);
			setState(156);
			((FuncinstwithContext)_localctx).secid = match(IDEN);
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

	public static class FuncinstwithoutContext extends ParserRuleContext {
		public Token frid;
		public Token return_;
		public Token secid;
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public FuncinstwithoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcinstwithout; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitFuncinstwithout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncinstwithoutContext funcinstwithout() throws RecognitionException {
		FuncinstwithoutContext _localctx = new FuncinstwithoutContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcinstwithout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__2);
			setState(159);
			((FuncinstwithoutContext)_localctx).frid = match(IDEN);
			setState(160);
			match(T__3);
			setState(161);
			match(T__4);
			setState(162);
			match(T__5);
			setState(163);
			match(T__3);
			setState(164);
			((FuncinstwithoutContext)_localctx).return_ = match(IDEN);
			setState(165);
			match(T__4);
			setState(166);
			linstrucciones(0);
			setState(167);
			match(T__1);
			setState(168);
			match(T__2);
			setState(169);
			((FuncinstwithoutContext)_localctx).secid = match(IDEN);
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

	public static class SubroutineinstContext extends ParserRuleContext {
		public SubroutineinstwithContext subroutineinstwith() {
			return getRuleContext(SubroutineinstwithContext.class,0);
		}
		public SubroutineinstwithoutContext subroutineinstwithout() {
			return getRuleContext(SubroutineinstwithoutContext.class,0);
		}
		public SubroutineinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineinst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitSubroutineinst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineinstContext subroutineinst() throws RecognitionException {
		SubroutineinstContext _localctx = new SubroutineinstContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subroutineinst);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				subroutineinstwith();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				subroutineinstwithout();
				}
				break;
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

	public static class SubroutineinstwithContext extends ParserRuleContext {
		public Token frid;
		public Token secid;
		public LparamContext lparam() {
			return getRuleContext(LparamContext.class,0);
		}
		public NoneinstContext noneinst() {
			return getRuleContext(NoneinstContext.class,0);
		}
		public LdclparamsContext ldclparams() {
			return getRuleContext(LdclparamsContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public SubroutineinstwithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineinstwith; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitSubroutineinstwith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineinstwithContext subroutineinstwith() throws RecognitionException {
		SubroutineinstwithContext _localctx = new SubroutineinstwithContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_subroutineinstwith);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__6);
			setState(176);
			((SubroutineinstwithContext)_localctx).frid = match(IDEN);
			setState(177);
			match(T__3);
			setState(178);
			lparam(0);
			setState(179);
			match(T__4);
			setState(180);
			noneinst();
			setState(181);
			ldclparams(0);
			setState(182);
			linstrucciones(0);
			setState(183);
			match(T__1);
			setState(184);
			match(T__6);
			setState(185);
			((SubroutineinstwithContext)_localctx).secid = match(IDEN);
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

	public static class SubroutineinstwithoutContext extends ParserRuleContext {
		public Token frid;
		public Token secid;
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public SubroutineinstwithoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineinstwithout; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitSubroutineinstwithout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineinstwithoutContext subroutineinstwithout() throws RecognitionException {
		SubroutineinstwithoutContext _localctx = new SubroutineinstwithoutContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_subroutineinstwithout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__6);
			setState(188);
			((SubroutineinstwithoutContext)_localctx).frid = match(IDEN);
			setState(189);
			match(T__3);
			setState(190);
			match(T__4);
			setState(191);
			linstrucciones(0);
			setState(192);
			match(T__1);
			setState(193);
			match(T__6);
			setState(194);
			((SubroutineinstwithoutContext)_localctx).secid = match(IDEN);
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

	public static class LparamContext extends ParserRuleContext {
		public LparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lparam; }
	 
		public LparamContext() { }
		public void copyFrom(LparamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LparamfirstContext extends LparamContext {
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public LparamfirstContext(LparamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLparamfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LparamnextContext extends LparamContext {
		public LparamContext lparam() {
			return getRuleContext(LparamContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public LparamnextContext(LparamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLparamnext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LparamContext lparam() throws RecognitionException {
		return lparam(0);
	}

	private LparamContext lparam(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LparamContext _localctx = new LparamContext(_ctx, _parentState);
		LparamContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_lparam, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LparamfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(197);
			match(IDEN);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LparamnextContext(new LparamContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lparam);
					setState(199);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(200);
					match(T__7);
					setState(201);
					match(IDEN);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CallsubinstContext extends ParserRuleContext {
		public CallsubinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callsubinst; }
	 
		public CallsubinstContext() { }
		public void copyFrom(CallsubinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallsubinstwithContext extends CallsubinstContext {
		public Token id;
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public CallsubinstwithContext(CallsubinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCallsubinstwith(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallsubinstwithoutContext extends CallsubinstContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public CallsubinstwithoutContext(CallsubinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCallsubinstwithout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallsubinstContext callsubinst() throws RecognitionException {
		CallsubinstContext _localctx = new CallsubinstContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callsubinst);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new CallsubinstwithContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(T__8);
				setState(208);
				((CallsubinstwithContext)_localctx).id = match(IDEN);
				setState(209);
				match(T__3);
				setState(210);
				lparamexp(0);
				setState(211);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new CallsubinstwithoutContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(T__8);
				setState(214);
				((CallsubinstwithoutContext)_localctx).id = match(IDEN);
				setState(215);
				match(T__3);
				setState(216);
				match(T__4);
				}
				break;
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

	public static class LparamexpContext extends ParserRuleContext {
		public LparamexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lparamexp; }
	 
		public LparamexpContext() { }
		public void copyFrom(LparamexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LparamexpfirstContext extends LparamexpContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LparamexpfirstContext(LparamexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLparamexpfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LparamexpnextContext extends LparamexpContext {
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LparamexpnextContext(LparamexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLparamexpnext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LparamexpContext lparamexp() throws RecognitionException {
		return lparamexp(0);
	}

	private LparamexpContext lparamexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LparamexpContext _localctx = new LparamexpContext(_ctx, _parentState);
		LparamexpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_lparamexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LparamexpfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(220);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LparamexpnextContext(new LparamexpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lparamexp);
					setState(222);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(223);
					match(T__7);
					setState(224);
					expr(0);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LdclparamsContext extends ParserRuleContext {
		public LdclparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldclparams; }
	 
		public LdclparamsContext() { }
		public void copyFrom(LdclparamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LdclparamsnextContext extends LdclparamsContext {
		public LdclparamsContext ldclparams() {
			return getRuleContext(LdclparamsContext.class,0);
		}
		public DeclarationparamsContext declarationparams() {
			return getRuleContext(DeclarationparamsContext.class,0);
		}
		public LdclparamsnextContext(LdclparamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLdclparamsnext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LdclparamsfirstContext extends LdclparamsContext {
		public DeclarationparamsContext declarationparams() {
			return getRuleContext(DeclarationparamsContext.class,0);
		}
		public LdclparamsfirstContext(LdclparamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLdclparamsfirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdclparamsContext ldclparams() throws RecognitionException {
		return ldclparams(0);
	}

	private LdclparamsContext ldclparams(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LdclparamsContext _localctx = new LdclparamsContext(_ctx, _parentState);
		LdclparamsContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_ldclparams, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LdclparamsfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(231);
			declarationparams();
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LdclparamsnextContext(new LdclparamsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_ldclparams);
					setState(233);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(234);
					declarationparams();
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclarationparamsContext extends ParserRuleContext {
		public Token id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclarationparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationparams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclarationparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationparamsContext declarationparams() throws RecognitionException {
		DeclarationparamsContext _localctx = new DeclarationparamsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declarationparams);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			type();
			setState(241);
			match(T__7);
			setState(242);
			match(T__9);
			setState(243);
			match(T__3);
			setState(244);
			match(T__10);
			setState(245);
			match(T__4);
			setState(246);
			match(T__11);
			setState(247);
			((DeclarationparamsContext)_localctx).id = match(IDEN);
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

	public static class NoneinstContext extends ParserRuleContext {
		public NoneinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noneinst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNoneinst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoneinstContext noneinst() throws RecognitionException {
		NoneinstContext _localctx = new NoneinstContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_noneinst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__12);
			setState(250);
			match(T__13);
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

	public static class ArrayinstContext extends ParserRuleContext {
		public ArrayinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayinst; }
	 
		public ArrayinstContext() { }
		public void copyFrom(ArrayinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayclsfirstContext extends ArrayinstContext {
		public Token id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ArrayclsfirstContext(ArrayinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitArrayclsfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayclssecondContext extends ArrayinstContext {
		public Token id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ArrayclssecondContext(ArrayinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitArrayclssecond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayinstContext arrayinst() throws RecognitionException {
		ArrayinstContext _localctx = new ArrayinstContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayinst);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new ArrayclsfirstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				type();
				setState(253);
				match(T__7);
				setState(254);
				match(T__14);
				setState(255);
				match(T__3);
				setState(256);
				lparamexp(0);
				setState(257);
				match(T__4);
				setState(258);
				match(T__11);
				setState(259);
				((ArrayclsfirstContext)_localctx).id = match(IDEN);
				}
				break;
			case 2:
				_localctx = new ArrayclssecondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				type();
				setState(262);
				match(T__11);
				setState(263);
				((ArrayclssecondContext)_localctx).id = match(IDEN);
				setState(264);
				match(T__3);
				setState(265);
				lparamexp(0);
				setState(266);
				match(T__4);
				}
				break;
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

	public static class ArraydinainstContext extends ParserRuleContext {
		public Token id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LdcldimsContext ldcldims() {
			return getRuleContext(LdcldimsContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public ArraydinainstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraydinainst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitArraydinainst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraydinainstContext arraydinainst() throws RecognitionException {
		ArraydinainstContext _localctx = new ArraydinainstContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arraydinainst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			type();
			setState(271);
			match(T__7);
			setState(272);
			match(T__15);
			setState(273);
			match(T__11);
			setState(274);
			((ArraydinainstContext)_localctx).id = match(IDEN);
			setState(275);
			match(T__3);
			setState(276);
			ldcldims();
			setState(277);
			match(T__4);
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

	public static class LdcldimsContext extends ParserRuleContext {
		public LdcldimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldcldims; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLdcldims(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdcldimsContext ldcldims() throws RecognitionException {
		LdcldimsContext _localctx = new LdcldimsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ldcldims);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__16);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(280);
				match(T__7);
				setState(281);
				match(T__16);
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AsigdimarrayContext extends ParserRuleContext {
		public Token id;
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsigdimarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asigdimarray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsigdimarray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsigdimarrayContext asigdimarray() throws RecognitionException {
		AsigdimarrayContext _localctx = new AsigdimarrayContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_asigdimarray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__17);
			setState(288);
			match(T__3);
			setState(289);
			((AsigdimarrayContext)_localctx).id = match(IDEN);
			setState(290);
			match(T__3);
			setState(291);
			lparamexp(0);
			setState(292);
			match(T__4);
			setState(293);
			match(T__4);
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

	public static class DesasigdimarrayContext extends ParserRuleContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DesasigdimarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desasigdimarray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDesasigdimarray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesasigdimarrayContext desasigdimarray() throws RecognitionException {
		DesasigdimarrayContext _localctx = new DesasigdimarrayContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_desasigdimarray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__18);
			setState(296);
			match(T__3);
			setState(297);
			((DesasigdimarrayContext)_localctx).id = match(IDEN);
			setState(298);
			match(T__4);
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

	public static class AsiginstContext extends ParserRuleContext {
		public AsiginstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asiginst; }
	 
		public AsiginstContext() { }
		public void copyFrom(AsiginstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AsignormalContext extends AsiginstContext {
		public Token id;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsignormalContext(AsiginstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsignormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsigarrayuniContext extends AsiginstContext {
		public Token id;
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsigarrayuniContext(AsiginstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsigarrayuni(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsigdimContext extends AsiginstContext {
		public Token id;
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsigdimContext(AsiginstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsigdim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsigarrayContext extends AsiginstContext {
		public Token id;
		public LdimeArrayContext ldimeArray() {
			return getRuleContext(LdimeArrayContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AsigarrayContext(AsiginstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAsigarray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsiginstContext asiginst() throws RecognitionException {
		AsiginstContext _localctx = new AsiginstContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_asiginst);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new AsigarrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				((AsigarrayContext)_localctx).id = match(IDEN);
				setState(301);
				match(T__19);
				setState(302);
				match(T__20);
				setState(303);
				ldimeArray(0);
				setState(304);
				match(T__21);
				}
				break;
			case 2:
				_localctx = new AsigarrayuniContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				((AsigarrayuniContext)_localctx).id = match(IDEN);
				setState(307);
				match(T__19);
				setState(308);
				match(T__20);
				setState(309);
				lparamexp(0);
				setState(310);
				match(T__21);
				}
				break;
			case 3:
				_localctx = new AsignormalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(312);
				((AsignormalContext)_localctx).id = match(IDEN);
				setState(313);
				match(T__19);
				setState(314);
				expr(0);
				}
				break;
			case 4:
				_localctx = new AsigdimContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				((AsigdimContext)_localctx).id = match(IDEN);
				setState(316);
				match(T__22);
				setState(317);
				lparamexp(0);
				setState(318);
				match(T__23);
				setState(319);
				match(T__19);
				setState(320);
				expr(0);
				}
				break;
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

	public static class LdimeArrayContext extends ParserRuleContext {
		public LdimeArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldimeArray; }
	 
		public LdimeArrayContext() { }
		public void copyFrom(LdimeArrayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LdimeArraynextContext extends LdimeArrayContext {
		public LdimeArrayContext ldimeArray() {
			return getRuleContext(LdimeArrayContext.class,0);
		}
		public DimeArrayContext dimeArray() {
			return getRuleContext(DimeArrayContext.class,0);
		}
		public LdimeArraynextContext(LdimeArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLdimeArraynext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LdimeArrayfirstContext extends LdimeArrayContext {
		public DimeArrayContext dimeArray() {
			return getRuleContext(DimeArrayContext.class,0);
		}
		public LdimeArrayfirstContext(LdimeArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLdimeArrayfirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdimeArrayContext ldimeArray() throws RecognitionException {
		return ldimeArray(0);
	}

	private LdimeArrayContext ldimeArray(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LdimeArrayContext _localctx = new LdimeArrayContext(_ctx, _parentState);
		LdimeArrayContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_ldimeArray, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LdimeArrayfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(325);
			dimeArray();
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LdimeArraynextContext(new LdimeArrayContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_ldimeArray);
					setState(327);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(328);
					match(T__7);
					setState(329);
					dimeArray();
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DimeArrayContext extends ParserRuleContext {
		public DimeArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimeArray; }
	 
		public DimeArrayContext() { }
		public void copyFrom(DimeArrayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DimeArrayexpContext extends DimeArrayContext {
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public DimeArrayexpContext(DimeArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDimeArrayexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DimeArrayndContext extends DimeArrayContext {
		public LdimeArrayContext ldimeArray() {
			return getRuleContext(LdimeArrayContext.class,0);
		}
		public DimeArrayndContext(DimeArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDimeArraynd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimeArrayContext dimeArray() throws RecognitionException {
		DimeArrayContext _localctx = new DimeArrayContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dimeArray);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new DimeArrayndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				match(T__20);
				setState(336);
				ldimeArray(0);
				setState(337);
				match(T__21);
				}
				break;
			case 2:
				_localctx = new DimeArrayexpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(T__20);
				setState(340);
				lparamexp(0);
				setState(341);
				match(T__21);
				}
				break;
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

	public static class IfinstContext extends ParserRuleContext {
		public IfinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifinst; }
	 
		public IfinstContext() { }
		public void copyFrom(IfinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OnlyifContext extends IfinstContext {
		public LifContext lif() {
			return getRuleContext(LifContext.class,0);
		}
		public OnlyifContext(IfinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitOnlyif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseContext extends IfinstContext {
		public LifContext lif() {
			return getRuleContext(LifContext.class,0);
		}
		public ElseblckContext elseblck() {
			return getRuleContext(ElseblckContext.class,0);
		}
		public IfelseContext(IfinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfinstContext ifinst() throws RecognitionException {
		IfinstContext _localctx = new IfinstContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_ifinst);
		try {
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new OnlyifContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				lif(0);
				setState(346);
				match(T__1);
				setState(347);
				match(T__24);
				}
				break;
			case 2:
				_localctx = new IfelseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				lif(0);
				setState(350);
				elseblck();
				setState(351);
				match(T__1);
				setState(352);
				match(T__24);
				}
				break;
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

	public static class LifContext extends ParserRuleContext {
		public LifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lif; }
	 
		public LifContext() { }
		public void copyFrom(LifContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LifsecondContext extends LifContext {
		public LifContext lif() {
			return getRuleContext(LifContext.class,0);
		}
		public IfblckContext ifblck() {
			return getRuleContext(IfblckContext.class,0);
		}
		public LifsecondContext(LifContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLifsecond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiffirstContext extends LifContext {
		public IfblckContext ifblck() {
			return getRuleContext(IfblckContext.class,0);
		}
		public LiffirstContext(LifContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLiffirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LifContext lif() throws RecognitionException {
		return lif(0);
	}

	private LifContext lif(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LifContext _localctx = new LifContext(_ctx, _parentState);
		LifContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_lif, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LiffirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(357);
			ifblck();
			}
			_ctx.stop = _input.LT(-1);
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LifsecondContext(new LifContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lif);
					setState(359);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(360);
					match(T__25);
					setState(361);
					ifblck();
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IfblckContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public IfblckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifblck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfblck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfblckContext ifblck() throws RecognitionException {
		IfblckContext _localctx = new IfblckContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifblck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__24);
			setState(368);
			match(T__3);
			setState(369);
			expr(0);
			setState(370);
			match(T__4);
			setState(371);
			match(T__26);
			setState(372);
			linstrucciones(0);
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

	public static class ElseblckContext extends ParserRuleContext {
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public ElseblckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseblck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitElseblck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseblckContext elseblck() throws RecognitionException {
		ElseblckContext _localctx = new ElseblckContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_elseblck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(T__25);
			setState(375);
			linstrucciones(0);
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

	public static class DoinstContext extends ParserRuleContext {
		public DoinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doinst; }
	 
		public DoinstContext() { }
		public void copyFrom(DoinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnnameddoContext extends DoinstContext {
		public DoconfContext doconf() {
			return getRuleContext(DoconfContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public UnnameddoContext(DoinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitUnnameddo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NameddoContext extends DoinstContext {
		public Token id;
		public Token sec;
		public DoconfContext doconf() {
			return getRuleContext(DoconfContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public NameddoContext(DoinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNameddo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoinstContext doinst() throws RecognitionException {
		DoinstContext _localctx = new DoinstContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_doinst);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				_localctx = new UnnameddoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(T__27);
				setState(378);
				doconf();
				setState(379);
				linstrucciones(0);
				setState(380);
				match(T__1);
				setState(381);
				match(T__27);
				}
				break;
			case IDEN:
				_localctx = new NameddoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				((NameddoContext)_localctx).id = match(IDEN);
				setState(384);
				match(T__16);
				setState(385);
				match(T__27);
				setState(386);
				doconf();
				setState(387);
				linstrucciones(0);
				setState(388);
				match(T__1);
				setState(389);
				match(T__27);
				setState(390);
				((NameddoContext)_localctx).sec = match(IDEN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DoconfContext extends ParserRuleContext {
		public Token id;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoconflistContext doconflist() {
			return getRuleContext(DoconflistContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DoconfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doconf; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoconf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoconfContext doconf() throws RecognitionException {
		DoconfContext _localctx = new DoconfContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_doconf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			((DoconfContext)_localctx).id = match(IDEN);
			setState(395);
			match(T__19);
			setState(396);
			expr(0);
			setState(397);
			match(T__7);
			setState(398);
			doconflist();
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

	public static class DoconflistContext extends ParserRuleContext {
		public DoconflistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doconflist; }
	 
		public DoconflistContext() { }
		public void copyFrom(DoconflistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoconflistfirstContext extends DoconflistContext {
		public ExprContext end;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoconflistfirstContext(DoconflistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoconflistfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoconflistsecondContext extends DoconflistContext {
		public ExprContext end;
		public ExprContext step;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DoconflistsecondContext(DoconflistContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDoconflistsecond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoconflistContext doconflist() throws RecognitionException {
		DoconflistContext _localctx = new DoconflistContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_doconflist);
		try {
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new DoconflistsecondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				((DoconflistsecondContext)_localctx).end = expr(0);
				setState(401);
				match(T__7);
				setState(402);
				((DoconflistsecondContext)_localctx).step = expr(0);
				}
				break;
			case 2:
				_localctx = new DoconflistfirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				((DoconflistfirstContext)_localctx).end = expr(0);
				}
				break;
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

	public static class DowhileinstContext extends ParserRuleContext {
		public DowhileinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhileinst; }
	 
		public DowhileinstContext() { }
		public void copyFrom(DowhileinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NameddowhileContext extends DowhileinstContext {
		public Token id;
		public Token sec;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public List<TerminalNode> IDEN() { return getTokens(GramaticaParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(GramaticaParser.IDEN, i);
		}
		public NameddowhileContext(DowhileinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNameddowhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnnameddowhileContext extends DowhileinstContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LinstruccionesContext linstrucciones() {
			return getRuleContext(LinstruccionesContext.class,0);
		}
		public UnnameddowhileContext(DowhileinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitUnnameddowhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DowhileinstContext dowhileinst() throws RecognitionException {
		DowhileinstContext _localctx = new DowhileinstContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dowhileinst);
		try {
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				_localctx = new UnnameddowhileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				match(T__27);
				setState(408);
				match(T__28);
				setState(409);
				match(T__3);
				setState(410);
				expr(0);
				setState(411);
				match(T__4);
				setState(412);
				linstrucciones(0);
				setState(413);
				match(T__1);
				setState(414);
				match(T__27);
				}
				break;
			case IDEN:
				_localctx = new NameddowhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(416);
				((NameddowhileContext)_localctx).id = match(IDEN);
				setState(417);
				match(T__16);
				setState(418);
				match(T__27);
				setState(419);
				match(T__28);
				setState(420);
				match(T__3);
				setState(421);
				expr(0);
				setState(422);
				match(T__4);
				setState(423);
				linstrucciones(0);
				setState(424);
				match(T__1);
				setState(425);
				match(T__27);
				setState(426);
				((NameddowhileContext)_localctx).sec = match(IDEN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExitinstContext extends ParserRuleContext {
		public ExitinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitinst; }
	 
		public ExitinstContext() { }
		public void copyFrom(ExitinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnnamedexitContext extends ExitinstContext {
		public UnnamedexitContext(ExitinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitUnnamedexit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NamedexitContext extends ExitinstContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public NamedexitContext(ExitinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNamedexit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitinstContext exitinst() throws RecognitionException {
		ExitinstContext _localctx = new ExitinstContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_exitinst);
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new UnnamedexitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(T__29);
				}
				break;
			case 2:
				_localctx = new NamedexitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(T__29);
				setState(432);
				((NamedexitContext)_localctx).id = match(IDEN);
				}
				break;
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

	public static class CycleinstContext extends ParserRuleContext {
		public CycleinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycleinst; }
	 
		public CycleinstContext() { }
		public void copyFrom(CycleinstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnnamedcycleContext extends CycleinstContext {
		public UnnamedcycleContext(CycleinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitUnnamedcycle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NamedcycleContext extends CycleinstContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public NamedcycleContext(CycleinstContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNamedcycle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleinstContext cycleinst() throws RecognitionException {
		CycleinstContext _localctx = new CycleinstContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_cycleinst);
		try {
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new UnnamedcycleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				match(T__30);
				}
				break;
			case 2:
				_localctx = new NamedcycleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				match(T__30);
				setState(437);
				((NamedcycleContext)_localctx).id = match(IDEN);
				}
				break;
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

	public static class PrintContext extends ParserRuleContext {
		public PrintexpsContext printexps() {
			return getRuleContext(PrintexpsContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			printexps(0);
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

	public static class PrintexpsContext extends ParserRuleContext {
		public PrintexpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printexps; }
	 
		public PrintexpsContext() { }
		public void copyFrom(PrintexpsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrtfirstContext extends PrintexpsContext {
		public PrintexpContext printexp() {
			return getRuleContext(PrintexpContext.class,0);
		}
		public PrtfirstContext(PrintexpsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPrtfirst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrtnextContext extends PrintexpsContext {
		public PrintexpsContext printexps() {
			return getRuleContext(PrintexpsContext.class,0);
		}
		public PrintexpContext printexp() {
			return getRuleContext(PrintexpContext.class,0);
		}
		public PrtnextContext(PrintexpsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPrtnext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintexpsContext printexps() throws RecognitionException {
		return printexps(0);
	}

	private PrintexpsContext printexps(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrintexpsContext _localctx = new PrintexpsContext(_ctx, _parentState);
		PrintexpsContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_printexps, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrtfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(443);
			match(T__31);
			setState(444);
			match(T__32);
			setState(445);
			match(T__7);
			setState(446);
			printexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrtnextContext(new PrintexpsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_printexps);
					setState(448);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(449);
					match(T__7);
					setState(450);
					printexp();
					}
					} 
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrintexpContext extends ParserRuleContext {
		public PrintexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printexp; }
	 
		public PrintexpContext() { }
		public void copyFrom(PrintexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringExprContext extends PrintexpContext {
		public TerminalNode STRING() { return getToken(GramaticaParser.STRING, 0); }
		public StringExprContext(PrintexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPrintContext extends PrintexpContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprPrintContext(PrintexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintexpContext printexp() throws RecognitionException {
		PrintexpContext _localctx = new PrintexpContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_printexp);
		try {
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__38:
			case INT:
			case REAL:
			case BOOLEAN:
			case CHARACTER:
			case IDEN:
			case NOT:
				_localctx = new ExprPrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				expr(0);
				}
				break;
			case STRING:
				_localctx = new StringExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(457);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DeclarationContext extends ParserRuleContext {
		public LdeclarationsContext ldeclarations() {
			return getRuleContext(LdeclarationsContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			ldeclarations(0);
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

	public static class LdeclarationsContext extends ParserRuleContext {
		public LdeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldeclarations; }
	 
		public LdeclarationsContext() { }
		public void copyFrom(LdeclarationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DclnextContext extends LdeclarationsContext {
		public LdeclarationsContext ldeclarations() {
			return getRuleContext(LdeclarationsContext.class,0);
		}
		public IndeclaContext indecla() {
			return getRuleContext(IndeclaContext.class,0);
		}
		public DclnextContext(LdeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDclnext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DclfirstContext extends LdeclarationsContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IndeclaContext indecla() {
			return getRuleContext(IndeclaContext.class,0);
		}
		public DclfirstContext(LdeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDclfirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdeclarationsContext ldeclarations() throws RecognitionException {
		return ldeclarations(0);
	}

	private LdeclarationsContext ldeclarations(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LdeclarationsContext _localctx = new LdeclarationsContext(_ctx, _parentState);
		LdeclarationsContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_ldeclarations, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new DclfirstContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(463);
			type();
			setState(464);
			match(T__11);
			setState(465);
			indecla();
			}
			_ctx.stop = _input.LT(-1);
			setState(472);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DclnextContext(new LdeclarationsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_ldeclarations);
					setState(467);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(468);
					match(T__7);
					setState(469);
					indecla();
					}
					} 
				}
				setState(474);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IndeclaContext extends ParserRuleContext {
		public IndeclaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indecla; }
	 
		public IndeclaContext() { }
		public void copyFrom(IndeclaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclwithoutContext extends IndeclaContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclwithoutContext(IndeclaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclwithout(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclinitContext extends IndeclaContext {
		public Token id;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public DeclinitContext(IndeclaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclinit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndeclaContext indecla() throws RecognitionException {
		IndeclaContext _localctx = new IndeclaContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_indecla);
		try {
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new DeclinitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				((DeclinitContext)_localctx).id = match(IDEN);
				setState(476);
				match(T__19);
				setState(477);
				expr(0);
				}
				break;
			case 2:
				_localctx = new DeclwithoutContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				((DeclwithoutContext)_localctx).id = match(IDEN);
				}
				break;
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharExprContext extends ExprContext {
		public Token char_;
		public TerminalNode CHARACTER() { return getToken(GramaticaParser.CHARACTER, 0); }
		public CharExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCharExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComplexExprContext extends ExprContext {
		public ExprContext re;
		public ExprContext im;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComplexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitComplexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(GramaticaParser.GREATER, 0); }
		public TerminalNode LESS() { return getToken(GramaticaParser.LESS, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(GramaticaParser.GREATEREQUAL, 0); }
		public TerminalNode LESSEQUAL() { return getToken(GramaticaParser.LESSEQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(GramaticaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(GramaticaParser.NOTEQUAL, 0); }
		public TerminalNode EQUIV() { return getToken(GramaticaParser.EQUIV, 0); }
		public TerminalNode NOTEQUIV() { return getToken(GramaticaParser.NOTEQUIV, 0); }
		public TerminalNode AND() { return getToken(GramaticaParser.AND, 0); }
		public TerminalNode OR() { return getToken(GramaticaParser.OR, 0); }
		public OpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealExprContext extends ExprContext {
		public Token real;
		public TerminalNode REAL() { return getToken(GramaticaParser.REAL, 0); }
		public RealExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitRealExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public Token atom;
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdenExprContext extends ExprContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public IdenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIdenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessArrayContext extends ExprContext {
		public Token id;
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AccessArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAccessArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public Token bool;
		public TerminalNode BOOLEAN() { return getToken(GramaticaParser.BOOLEAN, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessFuncWithoutContext extends ExprContext {
		public Token id;
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AccessFuncWithoutContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAccessFuncWithout(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnitExprContext extends ExprContext {
		public Token op;
		public ExprContext right;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(GramaticaParser.NOT, 0); }
		public UnitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitUnitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessFuncContext extends ExprContext {
		public Token id;
		public LparamexpContext lparamexp() {
			return getRuleContext(LparamexpContext.class,0);
		}
		public TerminalNode IDEN() { return getToken(GramaticaParser.IDEN, 0); }
		public AccessFuncContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAccessFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new UnitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(484);
				((UnitExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__38 || _la==NOT) ) {
					((UnitExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(485);
				((UnitExprContext)_localctx).right = expr(18);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(486);
				match(T__3);
				setState(487);
				expr(0);
				setState(488);
				match(T__4);
				}
				break;
			case 3:
				{
				_localctx = new IdenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(490);
				((IdenExprContext)_localctx).id = match(IDEN);
				}
				break;
			case 4:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				((AtomExprContext)_localctx).atom = match(INT);
				}
				break;
			case 5:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(492);
				((CharExprContext)_localctx).char_ = match(CHARACTER);
				}
				break;
			case 6:
				{
				_localctx = new RealExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				((RealExprContext)_localctx).real = match(REAL);
				}
				break;
			case 7:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(494);
				((BoolExprContext)_localctx).bool = match(BOOLEAN);
				}
				break;
			case 8:
				{
				_localctx = new ComplexExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(495);
				match(T__3);
				setState(496);
				((ComplexExprContext)_localctx).re = expr(0);
				setState(497);
				match(T__7);
				setState(498);
				((ComplexExprContext)_localctx).im = expr(0);
				setState(499);
				match(T__4);
				}
				break;
			case 9:
				{
				_localctx = new AccessArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(501);
				((AccessArrayContext)_localctx).id = match(IDEN);
				setState(502);
				match(T__22);
				setState(503);
				lparamexp(0);
				setState(504);
				match(T__23);
				}
				break;
			case 10:
				{
				_localctx = new AccessFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(506);
				((AccessFuncContext)_localctx).id = match(IDEN);
				setState(507);
				match(T__3);
				setState(508);
				lparamexp(0);
				setState(509);
				match(T__4);
				}
				break;
			case 11:
				{
				_localctx = new AccessFuncWithoutContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(511);
				((AccessFuncWithoutContext)_localctx).id = match(IDEN);
				setState(512);
				match(T__3);
				setState(513);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(539);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(537);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(516);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(517);
						((OpExprContext)_localctx).op = match(T__39);
						setState(518);
						((OpExprContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(519);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(520);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__40) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(521);
						((OpExprContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(522);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(523);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__41) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(524);
						((OpExprContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(525);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(526);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATEREQUAL) | (1L << LESSEQUAL) | (1L << GREATER) | (1L << LESS))) != 0)) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(527);
						((OpExprContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(528);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(529);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOTEQUAL) | (1L << EQUIV) | (1L << NOTEQUIV))) != 0)) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(530);
						((OpExprContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(531);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(532);
						((OpExprContext)_localctx).op = match(AND);
						setState(533);
						((OpExprContext)_localctx).right = expr(13);
						}
						break;
					case 7:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(534);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(535);
						((OpExprContext)_localctx).op = match(OR);
						setState(536);
						((OpExprContext)_localctx).right = expr(12);
						}
						break;
					}
					} 
				}
				setState(541);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return lfunc_sempred((LfuncContext)_localctx, predIndex);
		case 4:
			return linstrucciones_sempred((LinstruccionesContext)_localctx, predIndex);
		case 12:
			return lparam_sempred((LparamContext)_localctx, predIndex);
		case 14:
			return lparamexp_sempred((LparamexpContext)_localctx, predIndex);
		case 15:
			return ldclparams_sempred((LdclparamsContext)_localctx, predIndex);
		case 24:
			return ldimeArray_sempred((LdimeArrayContext)_localctx, predIndex);
		case 27:
			return lif_sempred((LifContext)_localctx, predIndex);
		case 37:
			return printexps_sempred((PrintexpsContext)_localctx, predIndex);
		case 40:
			return ldeclarations_sempred((LdeclarationsContext)_localctx, predIndex);
		case 43:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lfunc_sempred(LfuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean linstrucciones_sempred(LinstruccionesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lparam_sempred(LparamContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lparamexp_sempred(LparamexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean ldclparams_sempred(LdclparamsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean ldimeArray_sempred(LdimeArrayContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lif_sempred(LifContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean printexps_sempred(PrintexpsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean ldeclarations_sempred(LdeclarationsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 17);
		case 10:
			return precpred(_ctx, 16);
		case 11:
			return precpred(_ctx, 15);
		case 12:
			return precpred(_ctx, 14);
		case 13:
			return precpred(_ctx, 13);
		case 14:
			return precpred(_ctx, 12);
		case 15:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u021f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"`\b\u0001\n\u0001\f\u0001c\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002h\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004v\b\u0004\n\u0004\f\u0004y\t\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0089\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u008d\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u00ae\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00cb\b\f\n\f\f\f\u00ce\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00da\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u00e2\b\u000e\n\u000e\f\u000e\u00e5\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00ec\b\u000f\n\u000f\f\u000f\u00ef\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u010d\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u011b\b\u0014\n"+
		"\u0014\f\u0014\u011e\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u0143\b\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u014b\b\u0018\n"+
		"\u0018\f\u0018\u014e\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0158"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0163\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u016b\b\u001b\n\u001b\f\u001b\u016e\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u0189\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0196\b \u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u01ad\b!\u0001\"\u0001\"\u0001\"\u0003\"\u01b2\b\"\u0001#\u0001"+
		"#\u0001#\u0003#\u01b7\b#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0005%\u01c4\b%\n%\f%\u01c7\t%\u0001&\u0001"+
		"&\u0003&\u01cb\b&\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0005(\u01d7\b(\n(\f(\u01da\t(\u0001)\u0001)\u0001)\u0001"+
		")\u0003)\u01e0\b)\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u0203\b+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0005+\u021a"+
		"\b+\n+\f+\u021d\t+\u0001+\u0000\n\u0002\b\u0018\u001c\u001e06JPV,\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTV\u0000\u0006\u0001\u0000\"&\u0002\u0000"+
		"\'\'99\u0002\u0000!!))\u0002\u0000\'\'**\u0001\u000036\u0002\u000012:"+
		";\u022c\u0000X\u0001\u0000\u0000\u0000\u0002Z\u0001\u0000\u0000\u0000"+
		"\u0004g\u0001\u0000\u0000\u0000\u0006i\u0001\u0000\u0000\u0000\bp\u0001"+
		"\u0000\u0000\u0000\n\u0088\u0001\u0000\u0000\u0000\f\u008c\u0001\u0000"+
		"\u0000\u0000\u000e\u008e\u0001\u0000\u0000\u0000\u0010\u009e\u0001\u0000"+
		"\u0000\u0000\u0012\u00ad\u0001\u0000\u0000\u0000\u0014\u00af\u0001\u0000"+
		"\u0000\u0000\u0016\u00bb\u0001\u0000\u0000\u0000\u0018\u00c4\u0001\u0000"+
		"\u0000\u0000\u001a\u00d9\u0001\u0000\u0000\u0000\u001c\u00db\u0001\u0000"+
		"\u0000\u0000\u001e\u00e6\u0001\u0000\u0000\u0000 \u00f0\u0001\u0000\u0000"+
		"\u0000\"\u00f9\u0001\u0000\u0000\u0000$\u010c\u0001\u0000\u0000\u0000"+
		"&\u010e\u0001\u0000\u0000\u0000(\u0117\u0001\u0000\u0000\u0000*\u011f"+
		"\u0001\u0000\u0000\u0000,\u0127\u0001\u0000\u0000\u0000.\u0142\u0001\u0000"+
		"\u0000\u00000\u0144\u0001\u0000\u0000\u00002\u0157\u0001\u0000\u0000\u0000"+
		"4\u0162\u0001\u0000\u0000\u00006\u0164\u0001\u0000\u0000\u00008\u016f"+
		"\u0001\u0000\u0000\u0000:\u0176\u0001\u0000\u0000\u0000<\u0188\u0001\u0000"+
		"\u0000\u0000>\u018a\u0001\u0000\u0000\u0000@\u0195\u0001\u0000\u0000\u0000"+
		"B\u01ac\u0001\u0000\u0000\u0000D\u01b1\u0001\u0000\u0000\u0000F\u01b6"+
		"\u0001\u0000\u0000\u0000H\u01b8\u0001\u0000\u0000\u0000J\u01ba\u0001\u0000"+
		"\u0000\u0000L\u01ca\u0001\u0000\u0000\u0000N\u01cc\u0001\u0000\u0000\u0000"+
		"P\u01ce\u0001\u0000\u0000\u0000R\u01df\u0001\u0000\u0000\u0000T\u01e1"+
		"\u0001\u0000\u0000\u0000V\u0202\u0001\u0000\u0000\u0000XY\u0003\u0002"+
		"\u0001\u0000Y\u0001\u0001\u0000\u0000\u0000Z[\u0006\u0001\uffff\uffff"+
		"\u0000[\\\u0003\u0004\u0002\u0000\\a\u0001\u0000\u0000\u0000]^\n\u0002"+
		"\u0000\u0000^`\u0003\u0004\u0002\u0000_]\u0001\u0000\u0000\u0000`c\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b\u0003\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000dh\u0003\u0006"+
		"\u0003\u0000eh\u0003\u0012\t\u0000fh\u0003\f\u0006\u0000gd\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gf\u0001\u0000\u0000\u0000h\u0005"+
		"\u0001\u0000\u0000\u0000ij\u0005\u0001\u0000\u0000jk\u00050\u0000\u0000"+
		"kl\u0003\b\u0004\u0000lm\u0005\u0002\u0000\u0000mn\u0005\u0001\u0000\u0000"+
		"no\u00050\u0000\u0000o\u0007\u0001\u0000\u0000\u0000pq\u0006\u0004\uffff"+
		"\uffff\u0000qr\u0003\n\u0005\u0000rw\u0001\u0000\u0000\u0000st\n\u0002"+
		"\u0000\u0000tv\u0003\n\u0005\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\t\u0001"+
		"\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z\u0089\u0003\u001a\r\u0000"+
		"{\u0089\u00034\u001a\u0000|\u0089\u0003\"\u0011\u0000}\u0089\u0003<\u001e"+
		"\u0000~\u0089\u0003B!\u0000\u007f\u0089\u0003D\"\u0000\u0080\u0089\u0003"+
		"F#\u0000\u0081\u0089\u0003H$\u0000\u0082\u0089\u0003N\'\u0000\u0083\u0089"+
		"\u0003.\u0017\u0000\u0084\u0089\u0003$\u0012\u0000\u0085\u0089\u0003&"+
		"\u0013\u0000\u0086\u0089\u0003*\u0015\u0000\u0087\u0089\u0003,\u0016\u0000"+
		"\u0088z\u0001\u0000\u0000\u0000\u0088{\u0001\u0000\u0000\u0000\u0088|"+
		"\u0001\u0000\u0000\u0000\u0088}\u0001\u0000\u0000\u0000\u0088~\u0001\u0000"+
		"\u0000\u0000\u0088\u007f\u0001\u0000\u0000\u0000\u0088\u0080\u0001\u0000"+
		"\u0000\u0000\u0088\u0081\u0001\u0000\u0000\u0000\u0088\u0082\u0001\u0000"+
		"\u0000\u0000\u0088\u0083\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000"+
		"\u0000\u0000\u0088\u0085\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u000b\u0001\u0000"+
		"\u0000\u0000\u008a\u008d\u0003\u000e\u0007\u0000\u008b\u008d\u0003\u0010"+
		"\b\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\r\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0003\u0000\u0000"+
		"\u008f\u0090\u00050\u0000\u0000\u0090\u0091\u0005\u0004\u0000\u0000\u0091"+
		"\u0092\u0003\u0018\f\u0000\u0092\u0093\u0005\u0005\u0000\u0000\u0093\u0094"+
		"\u0005\u0006\u0000\u0000\u0094\u0095\u0005\u0004\u0000\u0000\u0095\u0096"+
		"\u00050\u0000\u0000\u0096\u0097\u0005\u0005\u0000\u0000\u0097\u0098\u0003"+
		"\"\u0011\u0000\u0098\u0099\u0003\u001e\u000f\u0000\u0099\u009a\u0003\b"+
		"\u0004\u0000\u009a\u009b\u0005\u0002\u0000\u0000\u009b\u009c\u0005\u0003"+
		"\u0000\u0000\u009c\u009d\u00050\u0000\u0000\u009d\u000f\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0005\u0003\u0000\u0000\u009f\u00a0\u00050\u0000\u0000"+
		"\u00a0\u00a1\u0005\u0004\u0000\u0000\u00a1\u00a2\u0005\u0005\u0000\u0000"+
		"\u00a2\u00a3\u0005\u0006\u0000\u0000\u00a3\u00a4\u0005\u0004\u0000\u0000"+
		"\u00a4\u00a5\u00050\u0000\u0000\u00a5\u00a6\u0005\u0005\u0000\u0000\u00a6"+
		"\u00a7\u0003\b\u0004\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8\u00a9"+
		"\u0005\u0003\u0000\u0000\u00a9\u00aa\u00050\u0000\u0000\u00aa\u0011\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ae\u0003\u0014\n\u0000\u00ac\u00ae\u0003\u0016"+
		"\u000b\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u0013\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0007"+
		"\u0000\u0000\u00b0\u00b1\u00050\u0000\u0000\u00b1\u00b2\u0005\u0004\u0000"+
		"\u0000\u00b2\u00b3\u0003\u0018\f\u0000\u00b3\u00b4\u0005\u0005\u0000\u0000"+
		"\u00b4\u00b5\u0003\"\u0011\u0000\u00b5\u00b6\u0003\u001e\u000f\u0000\u00b6"+
		"\u00b7\u0003\b\u0004\u0000\u00b7\u00b8\u0005\u0002\u0000\u0000\u00b8\u00b9"+
		"\u0005\u0007\u0000\u0000\u00b9\u00ba\u00050\u0000\u0000\u00ba\u0015\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0005\u0007\u0000\u0000\u00bc\u00bd\u0005"+
		"0\u0000\u0000\u00bd\u00be\u0005\u0004\u0000\u0000\u00be\u00bf\u0005\u0005"+
		"\u0000\u0000\u00bf\u00c0\u0003\b\u0004\u0000\u00c0\u00c1\u0005\u0002\u0000"+
		"\u0000\u00c1\u00c2\u0005\u0007\u0000\u0000\u00c2\u00c3\u00050\u0000\u0000"+
		"\u00c3\u0017\u0001\u0000\u0000\u0000\u00c4\u00c5\u0006\f\uffff\uffff\u0000"+
		"\u00c5\u00c6\u00050\u0000\u0000\u00c6\u00cc\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\n\u0002\u0000\u0000\u00c8\u00c9\u0005\b\u0000\u0000\u00c9\u00cb"+
		"\u00050\u0000\u0000\u00ca\u00c7\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cd\u0019\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005\t\u0000\u0000\u00d0\u00d1\u00050"+
		"\u0000\u0000\u00d1\u00d2\u0005\u0004\u0000\u0000\u00d2\u00d3\u0003\u001c"+
		"\u000e\u0000\u00d3\u00d4\u0005\u0005\u0000\u0000\u00d4\u00da\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0005\t\u0000\u0000\u00d6\u00d7\u00050\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0004\u0000\u0000\u00d8\u00da\u0005\u0005\u0000"+
		"\u0000\u00d9\u00cf\u0001\u0000\u0000\u0000\u00d9\u00d5\u0001\u0000\u0000"+
		"\u0000\u00da\u001b\u0001\u0000\u0000\u0000\u00db\u00dc\u0006\u000e\uffff"+
		"\uffff\u0000\u00dc\u00dd\u0003V+\u0000\u00dd\u00e3\u0001\u0000\u0000\u0000"+
		"\u00de\u00df\n\u0002\u0000\u0000\u00df\u00e0\u0005\b\u0000\u0000\u00e0"+
		"\u00e2\u0003V+\u0000\u00e1\u00de\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e4\u001d\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0006\u000f\uffff\uffff\u0000\u00e7\u00e8"+
		"\u0003 \u0010\u0000\u00e8\u00ed\u0001\u0000\u0000\u0000\u00e9\u00ea\n"+
		"\u0002\u0000\u0000\u00ea\u00ec\u0003 \u0010\u0000\u00eb\u00e9\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u001f\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003T*\u0000"+
		"\u00f1\u00f2\u0005\b\u0000\u0000\u00f2\u00f3\u0005\n\u0000\u0000\u00f3"+
		"\u00f4\u0005\u0004\u0000\u0000\u00f4\u00f5\u0005\u000b\u0000\u0000\u00f5"+
		"\u00f6\u0005\u0005\u0000\u0000\u00f6\u00f7\u0005\f\u0000\u0000\u00f7\u00f8"+
		"\u00050\u0000\u0000\u00f8!\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\r"+
		"\u0000\u0000\u00fa\u00fb\u0005\u000e\u0000\u0000\u00fb#\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0003T*\u0000\u00fd\u00fe\u0005\b\u0000\u0000\u00fe"+
		"\u00ff\u0005\u000f\u0000\u0000\u00ff\u0100\u0005\u0004\u0000\u0000\u0100"+
		"\u0101\u0003\u001c\u000e\u0000\u0101\u0102\u0005\u0005\u0000\u0000\u0102"+
		"\u0103\u0005\f\u0000\u0000\u0103\u0104\u00050\u0000\u0000\u0104\u010d"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0003T*\u0000\u0106\u0107\u0005\f"+
		"\u0000\u0000\u0107\u0108\u00050\u0000\u0000\u0108\u0109\u0005\u0004\u0000"+
		"\u0000\u0109\u010a\u0003\u001c\u000e\u0000\u010a\u010b\u0005\u0005\u0000"+
		"\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u00fc\u0001\u0000\u0000"+
		"\u0000\u010c\u0105\u0001\u0000\u0000\u0000\u010d%\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0003T*\u0000\u010f\u0110\u0005\b\u0000\u0000\u0110\u0111"+
		"\u0005\u0010\u0000\u0000\u0111\u0112\u0005\f\u0000\u0000\u0112\u0113\u0005"+
		"0\u0000\u0000\u0113\u0114\u0005\u0004\u0000\u0000\u0114\u0115\u0003(\u0014"+
		"\u0000\u0115\u0116\u0005\u0005\u0000\u0000\u0116\'\u0001\u0000\u0000\u0000"+
		"\u0117\u011c\u0005\u0011\u0000\u0000\u0118\u0119\u0005\b\u0000\u0000\u0119"+
		"\u011b\u0005\u0011\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b"+
		"\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d)\u0001\u0000\u0000\u0000\u011e\u011c"+
		"\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u0012\u0000\u0000\u0120\u0121"+
		"\u0005\u0004\u0000\u0000\u0121\u0122\u00050\u0000\u0000\u0122\u0123\u0005"+
		"\u0004\u0000\u0000\u0123\u0124\u0003\u001c\u000e\u0000\u0124\u0125\u0005"+
		"\u0005\u0000\u0000\u0125\u0126\u0005\u0005\u0000\u0000\u0126+\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0005\u0013\u0000\u0000\u0128\u0129\u0005\u0004"+
		"\u0000\u0000\u0129\u012a\u00050\u0000\u0000\u012a\u012b\u0005\u0005\u0000"+
		"\u0000\u012b-\u0001\u0000\u0000\u0000\u012c\u012d\u00050\u0000\u0000\u012d"+
		"\u012e\u0005\u0014\u0000\u0000\u012e\u012f\u0005\u0015\u0000\u0000\u012f"+
		"\u0130\u00030\u0018\u0000\u0130\u0131\u0005\u0016\u0000\u0000\u0131\u0143"+
		"\u0001\u0000\u0000\u0000\u0132\u0133\u00050\u0000\u0000\u0133\u0134\u0005"+
		"\u0014\u0000\u0000\u0134\u0135\u0005\u0015\u0000\u0000\u0135\u0136\u0003"+
		"\u001c\u000e\u0000\u0136\u0137\u0005\u0016\u0000\u0000\u0137\u0143\u0001"+
		"\u0000\u0000\u0000\u0138\u0139\u00050\u0000\u0000\u0139\u013a\u0005\u0014"+
		"\u0000\u0000\u013a\u0143\u0003V+\u0000\u013b\u013c\u00050\u0000\u0000"+
		"\u013c\u013d\u0005\u0017\u0000\u0000\u013d\u013e\u0003\u001c\u000e\u0000"+
		"\u013e\u013f\u0005\u0018\u0000\u0000\u013f\u0140\u0005\u0014\u0000\u0000"+
		"\u0140\u0141\u0003V+\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u012c"+
		"\u0001\u0000\u0000\u0000\u0142\u0132\u0001\u0000\u0000\u0000\u0142\u0138"+
		"\u0001\u0000\u0000\u0000\u0142\u013b\u0001\u0000\u0000\u0000\u0143/\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0006\u0018\uffff\uffff\u0000\u0145\u0146"+
		"\u00032\u0019\u0000\u0146\u014c\u0001\u0000\u0000\u0000\u0147\u0148\n"+
		"\u0002\u0000\u0000\u0148\u0149\u0005\b\u0000\u0000\u0149\u014b\u00032"+
		"\u0019\u0000\u014a\u0147\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000"+
		"\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000"+
		"\u0000\u0000\u014d1\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0005\u0015\u0000\u0000\u0150\u0151\u00030\u0018\u0000"+
		"\u0151\u0152\u0005\u0016\u0000\u0000\u0152\u0158\u0001\u0000\u0000\u0000"+
		"\u0153\u0154\u0005\u0015\u0000\u0000\u0154\u0155\u0003\u001c\u000e\u0000"+
		"\u0155\u0156\u0005\u0016\u0000\u0000\u0156\u0158\u0001\u0000\u0000\u0000"+
		"\u0157\u014f\u0001\u0000\u0000\u0000\u0157\u0153\u0001\u0000\u0000\u0000"+
		"\u01583\u0001\u0000\u0000\u0000\u0159\u015a\u00036\u001b\u0000\u015a\u015b"+
		"\u0005\u0002\u0000\u0000\u015b\u015c\u0005\u0019\u0000\u0000\u015c\u0163"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u00036\u001b\u0000\u015e\u015f\u0003"+
		":\u001d\u0000\u015f\u0160\u0005\u0002\u0000\u0000\u0160\u0161\u0005\u0019"+
		"\u0000\u0000\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u0159\u0001\u0000"+
		"\u0000\u0000\u0162\u015d\u0001\u0000\u0000\u0000\u01635\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0006\u001b\uffff\uffff\u0000\u0165\u0166\u00038\u001c"+
		"\u0000\u0166\u016c\u0001\u0000\u0000\u0000\u0167\u0168\n\u0002\u0000\u0000"+
		"\u0168\u0169\u0005\u001a\u0000\u0000\u0169\u016b\u00038\u001c\u0000\u016a"+
		"\u0167\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c"+
		"\u016a\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d"+
		"7\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f\u0170"+
		"\u0005\u0019\u0000\u0000\u0170\u0171\u0005\u0004\u0000\u0000\u0171\u0172"+
		"\u0003V+\u0000\u0172\u0173\u0005\u0005\u0000\u0000\u0173\u0174\u0005\u001b"+
		"\u0000\u0000\u0174\u0175\u0003\b\u0004\u0000\u01759\u0001\u0000\u0000"+
		"\u0000\u0176\u0177\u0005\u001a\u0000\u0000\u0177\u0178\u0003\b\u0004\u0000"+
		"\u0178;\u0001\u0000\u0000\u0000\u0179\u017a\u0005\u001c\u0000\u0000\u017a"+
		"\u017b\u0003>\u001f\u0000\u017b\u017c\u0003\b\u0004\u0000\u017c\u017d"+
		"\u0005\u0002\u0000\u0000\u017d\u017e\u0005\u001c\u0000\u0000\u017e\u0189"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u00050\u0000\u0000\u0180\u0181\u0005"+
		"\u0011\u0000\u0000\u0181\u0182\u0005\u001c\u0000\u0000\u0182\u0183\u0003"+
		">\u001f\u0000\u0183\u0184\u0003\b\u0004\u0000\u0184\u0185\u0005\u0002"+
		"\u0000\u0000\u0185\u0186\u0005\u001c\u0000\u0000\u0186\u0187\u00050\u0000"+
		"\u0000\u0187\u0189\u0001\u0000\u0000\u0000\u0188\u0179\u0001\u0000\u0000"+
		"\u0000\u0188\u017f\u0001\u0000\u0000\u0000\u0189=\u0001\u0000\u0000\u0000"+
		"\u018a\u018b\u00050\u0000\u0000\u018b\u018c\u0005\u0014\u0000\u0000\u018c"+
		"\u018d\u0003V+\u0000\u018d\u018e\u0005\b\u0000\u0000\u018e\u018f\u0003"+
		"@ \u0000\u018f?\u0001\u0000\u0000\u0000\u0190\u0191\u0003V+\u0000\u0191"+
		"\u0192\u0005\b\u0000\u0000\u0192\u0193\u0003V+\u0000\u0193\u0196\u0001"+
		"\u0000\u0000\u0000\u0194\u0196\u0003V+\u0000\u0195\u0190\u0001\u0000\u0000"+
		"\u0000\u0195\u0194\u0001\u0000\u0000\u0000\u0196A\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0005\u001c\u0000\u0000\u0198\u0199\u0005\u001d\u0000\u0000"+
		"\u0199\u019a\u0005\u0004\u0000\u0000\u019a\u019b\u0003V+\u0000\u019b\u019c"+
		"\u0005\u0005\u0000\u0000\u019c\u019d\u0003\b\u0004\u0000\u019d\u019e\u0005"+
		"\u0002\u0000\u0000\u019e\u019f\u0005\u001c\u0000\u0000\u019f\u01ad\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u00050\u0000\u0000\u01a1\u01a2\u0005\u0011"+
		"\u0000\u0000\u01a2\u01a3\u0005\u001c\u0000\u0000\u01a3\u01a4\u0005\u001d"+
		"\u0000\u0000\u01a4\u01a5\u0005\u0004\u0000\u0000\u01a5\u01a6\u0003V+\u0000"+
		"\u01a6\u01a7\u0005\u0005\u0000\u0000\u01a7\u01a8\u0003\b\u0004\u0000\u01a8"+
		"\u01a9\u0005\u0002\u0000\u0000\u01a9\u01aa\u0005\u001c\u0000\u0000\u01aa"+
		"\u01ab\u00050\u0000\u0000\u01ab\u01ad\u0001\u0000\u0000\u0000\u01ac\u0197"+
		"\u0001\u0000\u0000\u0000\u01ac\u01a0\u0001\u0000\u0000\u0000\u01adC\u0001"+
		"\u0000\u0000\u0000\u01ae\u01b2\u0005\u001e\u0000\u0000\u01af\u01b0\u0005"+
		"\u001e\u0000\u0000\u01b0\u01b2\u00050\u0000\u0000\u01b1\u01ae\u0001\u0000"+
		"\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2E\u0001\u0000\u0000"+
		"\u0000\u01b3\u01b7\u0005\u001f\u0000\u0000\u01b4\u01b5\u0005\u001f\u0000"+
		"\u0000\u01b5\u01b7\u00050\u0000\u0000\u01b6\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7G\u0001\u0000\u0000\u0000\u01b8"+
		"\u01b9\u0003J%\u0000\u01b9I\u0001\u0000\u0000\u0000\u01ba\u01bb\u0006"+
		"%\uffff\uffff\u0000\u01bb\u01bc\u0005 \u0000\u0000\u01bc\u01bd\u0005!"+
		"\u0000\u0000\u01bd\u01be\u0005\b\u0000\u0000\u01be\u01bf\u0003L&\u0000"+
		"\u01bf\u01c5\u0001\u0000\u0000\u0000\u01c0\u01c1\n\u0002\u0000\u0000\u01c1"+
		"\u01c2\u0005\b\u0000\u0000\u01c2\u01c4\u0003L&\u0000\u01c3\u01c0\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6K\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01cb\u0003V+\u0000"+
		"\u01c9\u01cb\u0005/\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c9\u0001\u0000\u0000\u0000\u01cbM\u0001\u0000\u0000\u0000\u01cc\u01cd"+
		"\u0003P(\u0000\u01cdO\u0001\u0000\u0000\u0000\u01ce\u01cf\u0006(\uffff"+
		"\uffff\u0000\u01cf\u01d0\u0003T*\u0000\u01d0\u01d1\u0005\f\u0000\u0000"+
		"\u01d1\u01d2\u0003R)\u0000\u01d2\u01d8\u0001\u0000\u0000\u0000\u01d3\u01d4"+
		"\n\u0002\u0000\u0000\u01d4\u01d5\u0005\b\u0000\u0000\u01d5\u01d7\u0003"+
		"R)\u0000\u01d6\u01d3\u0001\u0000\u0000\u0000\u01d7\u01da\u0001\u0000\u0000"+
		"\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000"+
		"\u0000\u01d9Q\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000\u0000\u0000"+
		"\u01db\u01dc\u00050\u0000\u0000\u01dc\u01dd\u0005\u0014\u0000\u0000\u01dd"+
		"\u01e0\u0003V+\u0000\u01de\u01e0\u00050\u0000\u0000\u01df\u01db\u0001"+
		"\u0000\u0000\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01e0S\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e2\u0007\u0000\u0000\u0000\u01e2U\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e4\u0006+\uffff\uffff\u0000\u01e4\u01e5\u0007\u0001\u0000"+
		"\u0000\u01e5\u0203\u0003V+\u0012\u01e6\u01e7\u0005\u0004\u0000\u0000\u01e7"+
		"\u01e8\u0003V+\u0000\u01e8\u01e9\u0005\u0005\u0000\u0000\u01e9\u0203\u0001"+
		"\u0000\u0000\u0000\u01ea\u0203\u00050\u0000\u0000\u01eb\u0203\u0005+\u0000"+
		"\u0000\u01ec\u0203\u0005.\u0000\u0000\u01ed\u0203\u0005,\u0000\u0000\u01ee"+
		"\u0203\u0005-\u0000\u0000\u01ef\u01f0\u0005\u0004\u0000\u0000\u01f0\u01f1"+
		"\u0003V+\u0000\u01f1\u01f2\u0005\b\u0000\u0000\u01f2\u01f3\u0003V+\u0000"+
		"\u01f3\u01f4\u0005\u0005\u0000\u0000\u01f4\u0203\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f6\u00050\u0000\u0000\u01f6\u01f7\u0005\u0017\u0000\u0000\u01f7"+
		"\u01f8\u0003\u001c\u000e\u0000\u01f8\u01f9\u0005\u0018\u0000\u0000\u01f9"+
		"\u0203\u0001\u0000\u0000\u0000\u01fa\u01fb\u00050\u0000\u0000\u01fb\u01fc"+
		"\u0005\u0004\u0000\u0000\u01fc\u01fd\u0003\u001c\u000e\u0000\u01fd\u01fe"+
		"\u0005\u0005\u0000\u0000\u01fe\u0203\u0001\u0000\u0000\u0000\u01ff\u0200"+
		"\u00050\u0000\u0000\u0200\u0201\u0005\u0004\u0000\u0000\u0201\u0203\u0005"+
		"\u0005\u0000\u0000\u0202\u01e3\u0001\u0000\u0000\u0000\u0202\u01e6\u0001"+
		"\u0000\u0000\u0000\u0202\u01ea\u0001\u0000\u0000\u0000\u0202\u01eb\u0001"+
		"\u0000\u0000\u0000\u0202\u01ec\u0001\u0000\u0000\u0000\u0202\u01ed\u0001"+
		"\u0000\u0000\u0000\u0202\u01ee\u0001\u0000\u0000\u0000\u0202\u01ef\u0001"+
		"\u0000\u0000\u0000\u0202\u01f5\u0001\u0000\u0000\u0000\u0202\u01fa\u0001"+
		"\u0000\u0000\u0000\u0202\u01ff\u0001\u0000\u0000\u0000\u0203\u021b\u0001"+
		"\u0000\u0000\u0000\u0204\u0205\n\u0011\u0000\u0000\u0205\u0206\u0005("+
		"\u0000\u0000\u0206\u021a\u0003V+\u0012\u0207\u0208\n\u0010\u0000\u0000"+
		"\u0208\u0209\u0007\u0002\u0000\u0000\u0209\u021a\u0003V+\u0011\u020a\u020b"+
		"\n\u000f\u0000\u0000\u020b\u020c\u0007\u0003\u0000\u0000\u020c\u021a\u0003"+
		"V+\u0010\u020d\u020e\n\u000e\u0000\u0000\u020e\u020f\u0007\u0004\u0000"+
		"\u0000\u020f\u021a\u0003V+\u000f\u0210\u0211\n\r\u0000\u0000\u0211\u0212"+
		"\u0007\u0005\u0000\u0000\u0212\u021a\u0003V+\u000e\u0213\u0214\n\f\u0000"+
		"\u0000\u0214\u0215\u00057\u0000\u0000\u0215\u021a\u0003V+\r\u0216\u0217"+
		"\n\u000b\u0000\u0000\u0217\u0218\u00058\u0000\u0000\u0218\u021a\u0003"+
		"V+\f\u0219\u0204\u0001\u0000\u0000\u0000\u0219\u0207\u0001\u0000\u0000"+
		"\u0000\u0219\u020a\u0001\u0000\u0000\u0000\u0219\u020d\u0001\u0000\u0000"+
		"\u0000\u0219\u0210\u0001\u0000\u0000\u0000\u0219\u0213\u0001\u0000\u0000"+
		"\u0000\u0219\u0216\u0001\u0000\u0000\u0000\u021a\u021d\u0001\u0000\u0000"+
		"\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000"+
		"\u0000\u021cW\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000\u0000\u0000"+
		"\u001dagw\u0088\u008c\u00ad\u00cc\u00d9\u00e3\u00ed\u010c\u011c\u0142"+
		"\u014c\u0157\u0162\u016c\u0188\u0195\u01ac\u01b1\u01b6\u01c5\u01ca\u01d8"+
		"\u01df\u0202\u0219\u021b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}