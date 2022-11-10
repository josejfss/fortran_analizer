// Generated from D:/vacas-junio-2022/proyecto-olc2/grammar\Gramatica.g4 by ANTLR 4.10.1
package gramatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GramaticaParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lfuncfirst}
	 * labeled alternative in {@link GramaticaParser#lfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLfuncfirst(GramaticaParser.LfuncfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lfuncnext}
	 * labeled alternative in {@link GramaticaParser#lfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLfuncnext(GramaticaParser.LfuncnextContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#unitfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitfunc(GramaticaParser.UnitfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#mainblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainblock(GramaticaParser.MainblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code linstruccionesfirst}
	 * labeled alternative in {@link GramaticaParser#linstrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinstruccionesfirst(GramaticaParser.LinstruccionesfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code linstruccionesnext}
	 * labeled alternative in {@link GramaticaParser#linstrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinstruccionesnext(GramaticaParser.LinstruccionesnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callsub}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallsub(GramaticaParser.CallsubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(GramaticaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code none}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(GramaticaParser.NoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code do}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo(GramaticaParser.DoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dowhile}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhile(GramaticaParser.DowhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exit}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit(GramaticaParser.ExitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cycle}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle(GramaticaParser.CycleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prt}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrt(GramaticaParser.PrtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(GramaticaParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asi}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsi(GramaticaParser.AsiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayasi}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayasi(GramaticaParser.ArrayasiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclarraydi}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclarraydi(GramaticaParser.DclarraydiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asiarray}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsiarray(GramaticaParser.AsiarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code desasiarray}
	 * labeled alternative in {@link GramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesasiarray(GramaticaParser.DesasiarrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#funcinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncinst(GramaticaParser.FuncinstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#funcinstwith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncinstwith(GramaticaParser.FuncinstwithContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#funcinstwithout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncinstwithout(GramaticaParser.FuncinstwithoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#subroutineinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineinst(GramaticaParser.SubroutineinstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#subroutineinstwith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineinstwith(GramaticaParser.SubroutineinstwithContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#subroutineinstwithout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineinstwithout(GramaticaParser.SubroutineinstwithoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lparamfirst}
	 * labeled alternative in {@link GramaticaParser#lparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLparamfirst(GramaticaParser.LparamfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lparamnext}
	 * labeled alternative in {@link GramaticaParser#lparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLparamnext(GramaticaParser.LparamnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callsubinstwith}
	 * labeled alternative in {@link GramaticaParser#callsubinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallsubinstwith(GramaticaParser.CallsubinstwithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callsubinstwithout}
	 * labeled alternative in {@link GramaticaParser#callsubinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallsubinstwithout(GramaticaParser.CallsubinstwithoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lparamexpfirst}
	 * labeled alternative in {@link GramaticaParser#lparamexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLparamexpfirst(GramaticaParser.LparamexpfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lparamexpnext}
	 * labeled alternative in {@link GramaticaParser#lparamexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLparamexpnext(GramaticaParser.LparamexpnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ldclparamsnext}
	 * labeled alternative in {@link GramaticaParser#ldclparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdclparamsnext(GramaticaParser.LdclparamsnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ldclparamsfirst}
	 * labeled alternative in {@link GramaticaParser#ldclparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdclparamsfirst(GramaticaParser.LdclparamsfirstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declarationparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationparams(GramaticaParser.DeclarationparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#noneinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneinst(GramaticaParser.NoneinstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayclsfirst}
	 * labeled alternative in {@link GramaticaParser#arrayinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayclsfirst(GramaticaParser.ArrayclsfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayclssecond}
	 * labeled alternative in {@link GramaticaParser#arrayinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayclssecond(GramaticaParser.ArrayclssecondContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#arraydinainst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraydinainst(GramaticaParser.ArraydinainstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#ldcldims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdcldims(GramaticaParser.LdcldimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#asigdimarray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigdimarray(GramaticaParser.AsigdimarrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#desasigdimarray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesasigdimarray(GramaticaParser.DesasigdimarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asigarray}
	 * labeled alternative in {@link GramaticaParser#asiginst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigarray(GramaticaParser.AsigarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asigarrayuni}
	 * labeled alternative in {@link GramaticaParser#asiginst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigarrayuni(GramaticaParser.AsigarrayuniContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignormal}
	 * labeled alternative in {@link GramaticaParser#asiginst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignormal(GramaticaParser.AsignormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asigdim}
	 * labeled alternative in {@link GramaticaParser#asiginst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigdim(GramaticaParser.AsigdimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ldimeArraynext}
	 * labeled alternative in {@link GramaticaParser#ldimeArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdimeArraynext(GramaticaParser.LdimeArraynextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ldimeArrayfirst}
	 * labeled alternative in {@link GramaticaParser#ldimeArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdimeArrayfirst(GramaticaParser.LdimeArrayfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dimeArraynd}
	 * labeled alternative in {@link GramaticaParser#dimeArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimeArraynd(GramaticaParser.DimeArrayndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dimeArrayexp}
	 * labeled alternative in {@link GramaticaParser#dimeArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimeArrayexp(GramaticaParser.DimeArrayexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onlyif}
	 * labeled alternative in {@link GramaticaParser#ifinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnlyif(GramaticaParser.OnlyifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelse}
	 * labeled alternative in {@link GramaticaParser#ifinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(GramaticaParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lifsecond}
	 * labeled alternative in {@link GramaticaParser#lif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLifsecond(GramaticaParser.LifsecondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code liffirst}
	 * labeled alternative in {@link GramaticaParser#lif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiffirst(GramaticaParser.LiffirstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#ifblck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfblck(GramaticaParser.IfblckContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#elseblck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseblck(GramaticaParser.ElseblckContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unnameddo}
	 * labeled alternative in {@link GramaticaParser#doinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnameddo(GramaticaParser.UnnameddoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameddo}
	 * labeled alternative in {@link GramaticaParser#doinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameddo(GramaticaParser.NameddoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#doconf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoconf(GramaticaParser.DoconfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doconflistsecond}
	 * labeled alternative in {@link GramaticaParser#doconflist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoconflistsecond(GramaticaParser.DoconflistsecondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doconflistfirst}
	 * labeled alternative in {@link GramaticaParser#doconflist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoconflistfirst(GramaticaParser.DoconflistfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unnameddowhile}
	 * labeled alternative in {@link GramaticaParser#dowhileinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnameddowhile(GramaticaParser.UnnameddowhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameddowhile}
	 * labeled alternative in {@link GramaticaParser#dowhileinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameddowhile(GramaticaParser.NameddowhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unnamedexit}
	 * labeled alternative in {@link GramaticaParser#exitinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedexit(GramaticaParser.UnnamedexitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedexit}
	 * labeled alternative in {@link GramaticaParser#exitinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedexit(GramaticaParser.NamedexitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unnamedcycle}
	 * labeled alternative in {@link GramaticaParser#cycleinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedcycle(GramaticaParser.UnnamedcycleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedcycle}
	 * labeled alternative in {@link GramaticaParser#cycleinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedcycle(GramaticaParser.NamedcycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GramaticaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prtfirst}
	 * labeled alternative in {@link GramaticaParser#printexps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrtfirst(GramaticaParser.PrtfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prtnext}
	 * labeled alternative in {@link GramaticaParser#printexps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrtnext(GramaticaParser.PrtnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPrint}
	 * labeled alternative in {@link GramaticaParser#printexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrint(GramaticaParser.ExprPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link GramaticaParser#printexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(GramaticaParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GramaticaParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclnext}
	 * labeled alternative in {@link GramaticaParser#ldeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclnext(GramaticaParser.DclnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclfirst}
	 * labeled alternative in {@link GramaticaParser#ldeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclfirst(GramaticaParser.DclfirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declinit}
	 * labeled alternative in {@link GramaticaParser#indecla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclinit(GramaticaParser.DeclinitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declwithout}
	 * labeled alternative in {@link GramaticaParser#indecla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclwithout(GramaticaParser.DeclwithoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GramaticaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharExpr(GramaticaParser.CharExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complexExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexExpr(GramaticaParser.ComplexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(GramaticaParser.OpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealExpr(GramaticaParser.RealExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(GramaticaParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idenExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdenExpr(GramaticaParser.IdenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accessArray}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessArray(GramaticaParser.AccessArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(GramaticaParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accessFuncWithout}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessFuncWithout(GramaticaParser.AccessFuncWithoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitExpr(GramaticaParser.UnitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(GramaticaParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accessFunc}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessFunc(GramaticaParser.AccessFuncContext ctx);
}