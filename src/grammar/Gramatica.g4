grammar Gramatica;

options { caseInsensitive = true; }

// primiteve
fragment NUMBERS: [0-9] ;
fragment EXPO   : [Ee] [+\-]? NUMBERS+ ;
INT             : NUMBERS+ EXPO?;
REAL            : NUMBERS+ '.' NUMBERS+ EXPO? ;
BOOLEAN         : '.' ('true' | 'false') '.';
CHARACTER       : ('"' (~["\r\n] | '""') '"') | ('\'' (~['\r\n] | '\'\'') '\'') ;
STRING          : '\'' (~['\r\n] | '""')* '\'';
IDEN            : [_a-zA-Z][a-zA-Z0-9_]* ;

// relational
EQUAL           : ('==' | '.eq.');
NOTEQUAL        : ('/=' | '.ne.');
GREATEREQUAL    : ('>=' | '.ge.');
LESSEQUAL       : ('<=' | '.le.');
GREATER         : ('>' | '.gt.');
LESS            : ('<' | '.lt.');
// logic
AND             : '.and.';
OR              : '.or.';
NOT             : '.not.' ;
EQUIV           : '.eqv.' ;
NOTEQUIV        : '.neqv.';

//comment
COMMENT :   '!' .*? '\r'? '\n' -> skip ;
WS              : [ \t\r\n]+ -> skip ;

//                  lexer
start   : lfunc ;

//          list of functions
lfunc   :   lfunc unitfunc  #lfuncnext
        |   unitfunc        #lfuncfirst
        ;

unitfunc    : mainblock
            | subroutineinst
            | funcinst
            ;

//          main block
mainblock : 'program' frid=IDEN linstrucciones 'end' 'program' secid=IDEN;

//                list of isntruction
linstrucciones  : linstrucciones instruccion    #linstruccionesnext
                | instruccion                   #linstruccionesfirst
                ;

instruccion     : callsubinst       #callsub
                | ifinst            #if
                | noneinst          #none
                | doinst            #do
                | dowhileinst       #dowhile
                | exitinst          #exit
                | cycleinst         #cycle
                | print             #prt
                | declaration       #decl
                | asiginst          #asi
                | arrayinst         #arrayasi
                | arraydinainst     #dclarraydi
                | asigdimarray      #asiarray
                | desasigdimarray   #desasiarray
                ;
// --------------------------------------------------
//                functions
//funcinst
funcinst    : funcinstwith
            | funcinstwithout
            ;

funcinstwith    : 'function' frid=IDEN  '(' lparam')'  'result' '(' return=IDEN ')' noneinst ldclparams linstrucciones  'end' 'function' secid=IDEN;
funcinstwithout : 'function' frid=IDEN  '('')'  'result' '(' return=IDEN ')' linstrucciones  'end' 'function' secid=IDEN;
// --------------------------------------------------
//                subroutine
subroutineinst  : subroutineinstwith
                | subroutineinstwithout
                ;

subroutineinstwith      : 'subroutine' frid=IDEN '(' lparam ')' noneinst ldclparams linstrucciones 'end' 'subroutine' secid=IDEN;
subroutineinstwithout   : 'subroutine' frid=IDEN '(' ')' linstrucciones 'end' 'subroutine' secid=IDEN;

lparam  : lparam ',' IDEN   #lparamnext
        | IDEN              #lparamfirst
        ;
// --------------------------------------------------
//                call of subroutine
callsubinst     : 'call' id=IDEN '(' lparamexp ')'  #callsubinstwith
                | 'call' id=IDEN '(' ')'            #callsubinstwithout
                ;
lparamexp   : lparamexp ',' expr    #lparamexpnext
            | expr                  #lparamexpfirst
            ;
// --------------------------------------------------
//                declarations params of subroutine
ldclparams : ldclparams declarationparams   #ldclparamsnext
           | declarationparams              #ldclparamsfirst
           ;
declarationparams : type ',' 'intent' '(' 'in' ')' '::' id=IDEN;
// --------------------------------------------------
//                implicit none
noneinst  : 'implicit' 'none';
// --------------------------------------------------
//                declarations of arrays
arrayinst   : type ',' 'dimension' '(' lparamexp ')' '::' id=IDEN   #arrayclsfirst
            | type '::' id=IDEN '(' lparamexp ')'                   #arrayclssecond
            ;
// --------------------------------------------------
//                declarations of dinamics arrays
arraydinainst   : type ',' 'allocatable' '::' id=IDEN  '(' ldcldims ')';
ldcldims    : ':' (',' ':')*;
// --------------------------------------------------
//                allocate of dinamics arrays
asigdimarray    : 'allocate' '(' id=IDEN '(' lparamexp ')'  ')';
// --------------------------------------------------
//                deallocate of dinamics arrays
desasigdimarray    : 'deallocate' '(' id=IDEN  ')';
// --------------------------------------------------
//                asignation
//asiginst    : id=IDEN '=' '(/' lparamexp'/)'        #asigarray
asiginst    : id=IDEN '=' '(/' ldimeArray'/)'       #asigarray
            | id=IDEN '=' '(/' lparamexp'/)'        #asigarrayuni
            | id=IDEN '=' expr                      #asignormal
            | id=IDEN '[' lparamexp ']' '=' expr    #asigdim
            ;

ldimeArray  : ldimeArray ',' dimeArray  #ldimeArraynext
            | dimeArray                 #ldimeArrayfirst
            ;
dimeArray   : '(/' ldimeArray '/)'  #dimeArraynd
            | '(/' lparamexp '/)'   #dimeArrayexp
            ;
// --------------------------------------------------
//                if, else if, else
ifinst  : lif  'end' 'if'           #onlyif
        | lif elseblck 'end' 'if'   #ifelse
        ;

lif     : lif 'else' ifblck #lifsecond
        | ifblck            #liffirst
        ;

ifblck      : 'if' '(' expr ')' 'then' linstrucciones ;
elseblck    : 'else' linstrucciones;
// --------------------------------------------------
//                do - for / solo asignacion
doinst  : 'do' doconf linstrucciones 'end' 'do'                         #unnameddo
        | id=IDEN ':' 'do' doconf linstrucciones 'end' 'do' sec=IDEN    #nameddo
        ;
doconf  : id=IDEN '=' expr ',' doconflist;
doconflist  : end=expr ',' step=expr    #doconflistsecond
            | end=expr                  #doconflistfirst
            ;
// --------------------------------------------------
//                dowhile - for
dowhileinst : 'do' 'while' '(' expr ')' linstrucciones 'end' 'do'                       #unnameddowhile
            | id=IDEN ':' 'do' 'while' '(' expr ')' linstrucciones 'end' 'do' sec=IDEN  #nameddowhile
            ;
// --------------------------------------------------
//                exit - break
exitinst    : 'exit'            #unnamedexit
            | 'exit' id=IDEN    #namedexit
            ;
// --------------------------------------------------
//                cycle - continue
cycleinst   : 'cycle'           #unnamedcycle
            | 'cycle' id=IDEN   #namedcycle
            ;
// --------------------------------------------------
//                print
print   :  printexps
        ;
printexps   : printexps ',' printexp    #prtnext
            |  'print' '*' ',' printexp   #prtfirst
            ;
printexp    : expr      #exprPrint
            | STRING    #stringExpr
            ;
// --------------------------------------------------
//                declarations
declaration : ldeclarations;

ldeclarations   : ldeclarations ',' indecla     #dclnext
                | type '::' indecla             #dclfirst
                ;

indecla : id=IDEN '=' expr #declinit
        | id=IDEN          #declwithout
        ;
// --------------------------------------------------
//                types
type    : 'integer'
        | 'real'
        | 'complex'
        | 'character'
        | 'logical'
        ;
// --------------------------------------------------
//                expresions
expr    : op=('-'| NOT) right=expr                                              #unitExpr
        | left=expr op='**' right=expr                                          #opExpr
        | left=expr op=('*'|'/') right=expr                                     #opExpr
        | left=expr op=('+'|'-') right=expr                                     #opExpr
        | left=expr op=(GREATER | LESS | GREATEREQUAL | LESSEQUAL) right=expr   #opExpr
        | left=expr op=(EQUAL | NOTEQUAL | EQUIV | NOTEQUIV) right=expr         #opExpr
        | left=expr op=AND right=expr                                           #opExpr
        | left=expr op=OR right=expr                                            #opExpr
        | '(' expr ')'                                                          #parenExpr
        | id=IDEN                                                               #idenExpr
        | atom=INT                                                              #atomExpr
        | char=CHARACTER                                                        #charExpr
        | real=REAL                                                             #realExpr
        | bool=BOOLEAN                                                          #boolExpr
        | '(' re=expr ','  im=expr ')'                                          #complexExpr
        | id=IDEN '[' lparamexp ']'                                             #accessArray
        | id=IDEN '(' lparamexp ')'                                             #accessFunc
        | id=IDEN '(' ')'                                                       #accessFuncWithout
        ;
// --------------------------------------------------