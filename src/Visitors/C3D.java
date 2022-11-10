package Visitors;

import C3DGenerator.CodigoTresD;
import entorno.*;
import gramatica.GramaticaBaseVisitor;
import gramatica.GramaticaParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;

public class C3D extends GramaticaBaseVisitor {
    public int contadorSub = 0;
    public Entorno global = new Entorno();

    public CodigoTresD c3d = new CodigoTresD();
    public String consola = "";
    public ArrayList<Excepcion> listaExcepciones = new ArrayList<>();

    public ArrayList<Object> pila = new ArrayList<>();

    public Entorno getGlobal() {
        return global;
    }

    public int contadorMain = 0;
    private GramaticaParser.MainblockContext bloqueMain;

    //public C3D(Entorno _global) {
    //    this.global = _global;
    //}

    public GramaticaParser.MainblockContext getBloqueMain() {
        return bloqueMain;
    }

    public void setBloqueMain(GramaticaParser.MainblockContext bloqueMain) {
        this.bloqueMain = bloqueMain;
    }

    public void imprimirEnConsola(String valor) {
        consola += valor;
    }

    public void setGlobal(Entorno global) {
        this.global = global;
    }

    public ArrayList<Excepcion> getListaExcepciones() {
        return listaExcepciones;
    }

    public void setListaExcepciones(ArrayList<Excepcion> listaExcepciones) {
        this.listaExcepciones = listaExcepciones;
    }
    //------------------------------------------------------------------------------------------------
    // ------------------------ produccion inicial

    public Object visitStart(GramaticaParser.StartContext ctx) {
        c3d.codigo3d.add("int main() \n{\n\n");
        visitChildren(ctx);

        if (contadorMain < 1) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Falta metodo main para iniciar programa", 0, 0);
            listaExcepciones.add(excepcion);
            return false;
        }

        visit(bloqueMain);
        System.out.println(consola);

        c3d.codigo3d.add("\nreturn 0;\n}");
        return "";
    }
    // comprobacion de entornos

    public Object visitLinstruccionesnext(GramaticaParser.LinstruccionesnextContext ctx) {
        Object instruccionesRetorno = visit(ctx.linstrucciones());
        if (instruccionesRetorno instanceof Instruccion) return instruccionesRetorno;

        return visit(ctx.instruccion());
    }

    // ------------------------ funcion deallocate - desasignacion de dimensiones
    public Object visitDesasigdimarray(GramaticaParser.DesasigdimarrayContext ctx) {
        String identificador = ctx.id.getText();
        Simbolo simboloRetorno = global.buscar(identificador);
        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo dinamico no encontrado: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        Simbolo arreglo = (Simbolo) simboloRetorno;
        if (arreglo.getRol() != RolSimbolo.ARREGLODINAMICO) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Se esperaba un valor de tipo arreglo dinamico: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Arreglo arreglo1 = (Arreglo) arreglo.getValor();

        if (arreglo1.getDimensiones() == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Error en desasignacion de dimensiones, arreglo sin dimensiones: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        arreglo1.setDimensiones(null);

        return true;
    }

    // ------------------------ funcion allocate - asignacion de dimensiones
    public Object visitAsigdimarray(GramaticaParser.AsigdimarrayContext ctx) {
        String identificador = ctx.id.getText();
        Object expresionesRetorno = visit(ctx.lparamexp());
        if (expresionesRetorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) expresionesRetorno);
            return false;
        }
        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) expresionesRetorno;

        Simbolo simboloRetorno = global.buscar(identificador);
        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo dinamico no encontrado: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Simbolo arreglo = (Simbolo) simboloRetorno;
        if (arreglo.getRol() != RolSimbolo.ARREGLODINAMICO) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Se esperaba un valor de tipo arreglo dinamico: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Simbolo simboloIndividual = null;
        int dimensiones[] = new int[parametros.size()];

        //TODO comprobar que no venga un 0 en una dimension

        for (int i = 0; i < parametros.size(); i++) {
            simboloIndividual = parametros.get(i);
            if (TipoSimbolo.INT != simboloIndividual.getTipo()) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Se esperaba un dato tipo int para asignacion de dimensiones del arreglo: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
            if ((int) simboloIndividual.getValor() == 0) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "La asignacion de dimensiones en un arreglo no puede ser 0: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
            dimensiones[i] = (int) simboloIndividual.getValor();
        }

        Arreglo arreglo1 = (Arreglo) arreglo.getValor();

        if (arreglo1.getDimensiones() != null) {
            int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Dimensiones ya inicializadas de arreglo: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        if (arreglo1.getNumeroDimensiones() != dimensiones.length) {
            int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "El numero de dimensiones es diferente al permitido:" + arreglo1.getNumeroDimensiones(),
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        arreglo1.setDimensiones(dimensiones);

        return true;
    }

    // ------------------------ declaracion de arreglo dianmico
    public Object visitArraydinainst(GramaticaParser.ArraydinainstContext ctx) {
        int numeroDimensiones = (int) visit(ctx.ldcldims());
        Object tipoRetorno = visit(ctx.type());
        String identificador = ctx.id.getText();

        if (tipoRetorno instanceof Excepcion) {
            ((Excepcion) tipoRetorno).setFilaColumna(ctx.type().getStart().getLine(), ctx.type().getStart().getCharPositionInLine());
            listaExcepciones.add((Excepcion) tipoRetorno);
            return false;
        }

        TipoSimbolo tipo = (TipoSimbolo) tipoRetorno;
        Arreglo arreglo = new Arreglo(numeroDimensiones);
        Simbolo simbolo = new Simbolo(tipo, arreglo, RolSimbolo.ARREGLODINAMICO);


        return true;
    }

    public Object visitLdcldims(GramaticaParser.LdcldimsContext ctx) {
        String cadena = ctx.getText();
        String arreglo[] = cadena.split(",");

        return arreglo.length;
    }

    // ------------------------ obtener dimension
    public Object visitAccessArray(GramaticaParser.AccessArrayContext ctx) {
        String identificador = ctx.id.getText();
        Object parametrosRetorno = visit(ctx.lparamexp());
        if (parametrosRetorno instanceof Excepcion) return parametrosRetorno;

        Object simboloRetorno = global.buscar(identificador);
        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo no encontrado: " + identificador,
                    fila, columna);
            return excepcion;
        }
        Simbolo arreglo = (Simbolo) simboloRetorno;


        if (!(arreglo.getRol() == RolSimbolo.ARREGLO || arreglo.getRol() == RolSimbolo.ARREGLODINAMICO)) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Se esperaba un valor de tipo arreglo: " + identificador,
                    fila, columna);
            return excepcion;
        }

        Arreglo arreglo1 = (Arreglo) arreglo.getValor();
        if (arreglo.getRol() == RolSimbolo.ARREGLODINAMICO) {
            if (arreglo1.getDimensiones() == null) {
                int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Arreglo no inicializado: " + identificador,
                        fila, columna);
                return excepcion;
            }
        }

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) parametrosRetorno;
        Simbolo simboloIndividual = null;
        int dimensiones[] = new int[parametros.size()];

        for (int i = 0; i < parametros.size(); i++) {
            simboloIndividual = parametros.get(i);
            if (TipoSimbolo.INT != simboloIndividual.getTipo()) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Se esperaba un dato tipo int para acceso de dimensiones del arreglo: " + identificador,
                        fila, columna);
                return excepcion;
            }
            if ((int) simboloIndividual.getValor() == 0) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "El acceso a una dimensiones en un arreglo no puede ser 0: " + identificador,
                        fila, columna);
                return excepcion;
            }
            dimensiones[i] = (int) simboloIndividual.getValor();
        }

        Object retornoElemento = arreglo1.getElement(dimensiones);

        if (retornoElemento instanceof Integer) {
            int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Valor no inicializado, retorno nulo en: " + identificador,
                    fila, columna);
            return excepcion;
        }
        Simbolo simboloRetorno2 = (Simbolo) retornoElemento;

        return simboloRetorno2;
    }


    // ------------------------ asignacion de dimension
    public Object visitAsigdim(GramaticaParser.AsigdimContext ctx) {
        String identificador = ctx.id.getText();
        Object parametrosRetorno = visit(ctx.lparamexp());
        Object expresionRetorno = visit(ctx.expr());

        if (parametrosRetorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) parametrosRetorno);
            return false;
        }
        if (expresionRetorno instanceof Excepcion) {
            ((Excepcion) expresionRetorno).setFilaColumna(ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            listaExcepciones.add((Excepcion) expresionRetorno);
            return false;
        }

        Object simboloRetorno = global.buscar(identificador);
        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo no encontrado: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        Simbolo arreglo = (Simbolo) simboloRetorno;

        if (!(arreglo.getRol() == RolSimbolo.ARREGLO || arreglo.getRol() == RolSimbolo.ARREGLODINAMICO)) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Se esperaba un valor de tipo arreglo: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Arreglo arreglo1 = (Arreglo) arreglo.getValor();
        if (arreglo.getRol() == RolSimbolo.ARREGLODINAMICO) {
            if (arreglo1.getDimensiones() == null) {
                int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Arreglo no inicializado: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
        }

        Simbolo expresion = (Simbolo) expresionRetorno;
        if (arreglo.getTipo() != expresion.getTipo()) {
            int fila = ctx.expr().getStart().getLine(), columna = ctx.expr().getStart().getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Tipo de dato diferente en asignacion a una dimension en: " + identificador + " se esperaba un " + arreglo.getTipo().name().toLowerCase(),
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) parametrosRetorno;
        Simbolo simboloIndividual = null;
        int dimensiones[] = new int[parametros.size()];

        for (int i = 0; i < parametros.size(); i++) {
            simboloIndividual = parametros.get(i);
            if (TipoSimbolo.INT != simboloIndividual.getTipo()) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Se esperaba un dato tipo int para acceso de dimensiones del arreglo: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
            if ((int) simboloIndividual.getValor() == 0) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Para la asignacion a una dimensiones en un arreglo no puede ser 0: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
            dimensiones[i] = (int) simboloIndividual.getValor();
        }

        Object asignacionRetorno = arreglo1.setElement(dimensiones, expresion);
        if (asignacionRetorno instanceof Excepcion) {
            int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
            ((Excepcion) asignacionRetorno).setFilaColumna(fila, columna);
            listaExcepciones.add((Excepcion) asignacionRetorno);
            return false;
        }

        return true;
    }

    // ------------------------ arreglos - los arreglos inician con el indice 1
    public Object visitArrayclsfirst(GramaticaParser.ArrayclsfirstContext ctx) {
        String identificador = ctx.id.getText();
        TipoSimbolo tipo = (TipoSimbolo) visit(ctx.type());
        Object parametrosRetorno = visit(ctx.lparamexp());

        if (parametrosRetorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) parametrosRetorno);
            return false;
        }

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) parametrosRetorno;
        Simbolo simboloIndividual = null;
        int dimensiones[] = new int[parametros.size()];

        for (int i = 0; i < parametros.size(); i++) {
            simboloIndividual = parametros.get(i);
            if (TipoSimbolo.INT != simboloIndividual.getTipo()) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Se esperaba un dato tipo int para la declaracion de dimensiones del arreglo: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
            dimensiones[i] = (int) simboloIndividual.getValor();
        }

        Arreglo arreglo = new Arreglo(dimensiones);
        Simbolo simbolo = new Simbolo(tipo, arreglo, RolSimbolo.ARREGLO);


        return true;
    }

    public Object visitArrayclssecond(GramaticaParser.ArrayclssecondContext ctx) {
        String identificador = ctx.id.getText();
        TipoSimbolo tipo = (TipoSimbolo) visit(ctx.type());
        Object parametrosRetorno = visit(ctx.lparamexp());
        if (parametrosRetorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) parametrosRetorno);
            return false;
        }

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) parametrosRetorno;
        Simbolo simboloIndividual = null;
        int dimensiones[] = new int[parametros.size()];

        for (int i = 0; i < parametros.size(); i++) {
            simboloIndividual = parametros.get(i);
            if (TipoSimbolo.INT != simboloIndividual.getTipo()) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                        "Se esperaba un dato tipo int para la declaracion de dimensiones del arreglo: " + identificador,
                        fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
            dimensiones[i] = (int) simboloIndividual.getValor();
        }

        Arreglo arreglo = new Arreglo(dimensiones);
        Simbolo simbolo = new Simbolo(tipo, arreglo, RolSimbolo.ARREGLO);


        return true;
    }


    // ------------------------ llamadas de funcion
    public Object visitAccessFuncWithout(GramaticaParser.AccessFuncWithoutContext ctx) {
        String identificador = ctx.id.getText();

        Simbolo funcionRetorno = global.buscar(identificador);
        if (funcionRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Funcion no encontrada: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        if (funcionRetorno.getTipo() != TipoSimbolo.FUNCION) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba el nombre de una funcion: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Subrutina funcion = (Subrutina) funcionRetorno.getValor();
        ArrayList<String> listaParametros = funcion.getListaNombreParametros();
        HashMap<String, TipoSimbolo> dclParametros = funcion.getDclParametros();
        String identificadorRetorno = funcion.getRetorno();

        if (listaParametros != null || dclParametros != null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Faltan parametros en el llamado de la subrutina: " + identificador, fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Simbolo simboloRetorno = null;

        global = global.getSiguiente();
        visit((ParseTree) funcion.getLinstrucciones());
        simboloRetorno = global.buscar(identificadorRetorno);
        global = global.getPadre();

        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Variable de retorno de no encontrada: " + ctx.id.getText(), fila, columna);
            return excepcion;
        }

        return simboloRetorno;
    }

    public Object visitAccessFunc(GramaticaParser.AccessFuncContext ctx) {
        String identificador = ctx.id.getText();
        Object retornoListaExpresiones = visit(ctx.lparamexp());
        if (retornoListaExpresiones instanceof Excepcion) {
            listaExcepciones.add((Excepcion) retornoListaExpresiones);
            return false;
        }
        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) retornoListaExpresiones;

        Simbolo funcionRetorno = global.buscar(identificador);
        if (funcionRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Funcion no encontrada: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        if (funcionRetorno.getTipo() != TipoSimbolo.FUNCION) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba el nombre de una funcion: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Subrutina funcion = (Subrutina) funcionRetorno.getValor();
        ArrayList<String> listaParametros = funcion.getListaNombreParametros();
        HashMap<String, TipoSimbolo> dclParametros = funcion.getDclParametros();
        String identificadorRetorno = funcion.getRetorno();

        if (parametros.size() != listaParametros.size()) {
            int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Cantidad diferente de parametros en llamado a: " + identificador, fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        TipoSimbolo tipoDeclaracion = null;
        Simbolo declaracion = null;

        for (int i = 0; i < listaParametros.size(); i++) {
            tipoDeclaracion = dclParametros.get(listaParametros.get(i));
            declaracion = parametros.get(i);
            if (tipoDeclaracion != declaracion.getTipo()) {
                int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de dato diferente en declaracion de parametro " + listaParametros.get(i) + ", se esparaba un: " + tipoDeclaracion.name().toLowerCase(), fila, columna);
                listaExcepciones.add(excepcion);
                return false;
            }
        }

        Simbolo simboloRetorno = null;
        global = global.getSiguiente();

        visit((ParseTree) funcion.getLinstrucciones());
        simboloRetorno = global.buscar(identificadorRetorno);
        global = global.getPadre();

        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Variable de retorno de no encontrada: " + ctx.id.getText(), fila, columna);
            return excepcion;
        }

        return simboloRetorno;
    }

    // ------------------------ llamadas de subrutinas
    public Object visitCallsubinstwithout(GramaticaParser.CallsubinstwithoutContext ctx) {
        String identificador = ctx.id.getText();

        Simbolo subrutina_ = global.buscar(identificador);


        Subrutina subrutina1_ = (Subrutina) subrutina_.getValor();
        ArrayList<String> listaParametros = subrutina1_.getListaNombreParametros();
        HashMap<String, TipoSimbolo> dclParametros = subrutina1_.getDclParametros();

        //Crear llamadado en main
        String c_3d = "" +
                identificador + "();\n";
        c3d.codigo3d.add(c_3d);

        int tamanoInicialC3d = c3d.codigo3d.size();
        global = new Entorno(global);
        visit((ParseTree) subrutina1_.getLinstrucciones());
        global = global.getPadre();

        int tamanoFinalC3d = c3d.codigo3d.size();
        c_3d = "void " + identificador + "(){";
        for (int z = tamanoInicialC3d; z < tamanoFinalC3d; z++) {
            c_3d += c3d.codigo3d.get(z) + "\n";
        }
        //eliminacion de codigo sobrante
        for (int z = tamanoFinalC3d - 1; z >= tamanoInicialC3d; z--) {
            c3d.codigo3d.remove(z);
        }
        c_3d += "}\n";
        c3d.AgregarFuncion(c_3d, identificador);

        return true;
    }

    public Object visitCallsubinstwith(GramaticaParser.CallsubinstwithContext ctx) {
        String identificador = ctx.id.getText();
        Object retornoListaExpresiones = visit(ctx.lparamexp());

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) retornoListaExpresiones;

        Simbolo subrutina = global.buscar(identificador);


        Subrutina subrutina1 = (Subrutina) subrutina.getValor();
        ArrayList<String> listaParametros = subrutina1.getListaNombreParametros();
        HashMap<String, TipoSimbolo> dclParametros = subrutina1.getDclParametros();

        TipoSimbolo tipoDeclaracion = null;
        Simbolo declaracion = null;
        String c_3d = "";

        //parte modificada-----------------------------
        global = new Entorno(global);

        for (int i = 0; i < listaParametros.size(); i++) {
            declaracion = parametros.get(i);
            global.nuevoSimbolo(listaParametros.get(i), declaracion);
        }

        //Agregacion de parametros en main
        for (int i = 0; i < listaParametros.size(); i++) {
            c3d.AgregarVariable(listaParametros.get(i));
            c_3d += "" +
                    listaParametros.get(i) + " = " + parametros.get(i).getValor() + ";\n";
        }
        c_3d += "" +
                identificador + "();\n";
        c3d.codigo3d.add(c_3d);
        //---------------------------------
        int tamanoInicialC3d = c3d.codigo3d.size();
        //----------------
        visit((ParseTree) subrutina1.getLinstrucciones());
        global = global.getPadre();
        //--------------------------------
        int tamanoFinalC3d = c3d.codigo3d.size();

        c_3d = "void " + identificador + "(){";
        for (int z = tamanoInicialC3d; z < tamanoFinalC3d; z++) {
            c_3d += c3d.codigo3d.get(z) + "\n";
        }
        //eliminacion de codigo sobrante
        for (int z = tamanoFinalC3d - 1; z >= tamanoInicialC3d; z--) {
            c3d.codigo3d.remove(z);
        }
        c_3d += "}\n";
        c3d.AgregarFuncion(c_3d, identificador);


        return true;
    }

    public Object visitLparamexpnext(GramaticaParser.LparamexpnextContext ctx) {
        Object retornoListaExpresiones = visit(ctx.lparamexp());
        Object retornoExpresion = visit(ctx.expr());

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) retornoListaExpresiones;
        Simbolo simbolo = (Simbolo) retornoExpresion;
        parametros.add(simbolo);

        return parametros;
    }

    public Object visitLparamexpfirst(GramaticaParser.LparamexpfirstContext ctx) {
        Object retornoExpresion = visit(ctx.expr());
        ArrayList<Simbolo> parametros = new ArrayList<>();
        Simbolo simbolo = (Simbolo) retornoExpresion;
        parametros.add(simbolo);

        return parametros;
    }

    // ------------------------ funciones y main !iteraciones
    public Object visitUnitfunc(GramaticaParser.UnitfuncContext ctx) {
        if (ctx.mainblock() != null) {
            contadorMain++;
            if (contadorMain == 1) {
                setBloqueMain(ctx.mainblock());
            } else {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Ya existe un metodo main: " + contadorMain, ctx.mainblock().getStart().getLine(), ctx.mainblock().getStart().getCharPositionInLine());
                listaExcepciones.add(excepcion);
            }
        } else {
            visitChildren(ctx);
        }
        return true;
    }

    // ------------------------ do - parecido a un for
    // sino existe la variable a usar se declara automaticamente
    public Object visitNameddo(GramaticaParser.NameddoContext ctx) {
        Object doconfRetorno = visit(ctx.doconf());
        if (doconfRetorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) doconfRetorno);
            return false;
        }
        Object arr[] = (Object[]) doconfRetorno;
        Simbolo conf[] = (Simbolo[]) arr[0];

        Simbolo inicio = conf[0];
        int valorInicio = (int) inicio.getValor();
        Simbolo final_ = conf[1];
        int valorFinal = (int) final_.getValor();
        Simbolo paso = conf[2];
        int valorPaso = (int) paso.getValor();

        String identificadorVariable = (String) arr[1];

        Simbolo variable = null;
        String identificador = ctx.id.getText();
        String identificador2 = ctx.sec.getText();

        if (!identificador.equals(identificador2)) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Ya existe un metodo main: " + contadorMain, ctx.sec.getLine(), ctx.sec.getCharPositionInLine());
            listaExcepciones.add(excepcion);
            return false;
        }

        for (int i = valorInicio; i <= valorFinal; i += valorPaso) {
            variable = global.buscar(identificadorVariable);
            if (variable == null) {
                global = global.getSiguiente();
                global.setNombre(identificador);
                variable = new Simbolo(TipoSimbolo.INT, i);

                visit(ctx.linstrucciones());
                global = global.getPadre();
            } else {
                global = global.getSiguiente();
                global.setNombre(identificador);
                variable = new Simbolo(TipoSimbolo.INT, i);

                visit(ctx.linstrucciones());
                global = global.getPadre();
            }
        }

        return true;
    }

    public Object visitUnnameddo(GramaticaParser.UnnameddoContext ctx) {
        Object doconfRetorno = visit(ctx.doconf());

        Object arr[] = (Object[]) doconfRetorno;
        Simbolo conf[] = (Simbolo[]) arr[0];
        String etiquetaCiclo = c3d.generateLabel();
        String etiquetaT = c3d.generateLabel();
        String etiquetaF = c3d.generateLabel();


        String identificadorVariable = (String) arr[1];
        Simbolo inicio_ = conf[0];
        Simbolo final_ = conf[1];
        Simbolo paso = conf[2];
        String c_3d = "" +
                identificadorVariable + " = " + inicio_.getValor() + ";\n" +
                etiquetaCiclo + ":\n" +
                "if(" + identificadorVariable + " <= " + final_.getValor() + ") goto " + etiquetaT + ";\n" +
                "goto " + etiquetaF + ";\n" +
                etiquetaT + ":";
        c3d.codigo3d.add(c_3d);

        Simbolo variable = null;

        global = new Entorno(global);
        /*
        if (variable == null) {
            variable = new Simbolo(TipoSimbolo.INT, i);
            global.nuevoSimbolo(identificadorVariable, variable);
        } else {
            variable = new Simbolo(TipoSimbolo.INT, i);
            global.actualizarSimbolo(identificadorVariable, variable);
        }

         */

        Object instruccionesRetorno = visit(ctx.linstrucciones());
        //Sigue el cycle

        global = global.getPadre();

        c_3d = "" +
                identificadorVariable + " = " + identificadorVariable + " + " + paso.getValor() + ";\n" +
                "goto " + etiquetaCiclo + ";\n" +
                etiquetaF + ":\n";
        c3d.codigo3d.add(c_3d);
        return true;
    }

    public Object visitDoconf(GramaticaParser.DoconfContext ctx) {
        Object retornoConfig = visit(ctx.doconflist());
        Object expresionRetorno = visit(ctx.expr());

        Simbolo expresion = (Simbolo) expresionRetorno;

        Simbolo conf[] = (Simbolo[]) retornoConfig;
        Simbolo configuracion[] = new Simbolo[3];

        String identificador = ctx.id.getText();
        configuracion[2] = conf[1];
        configuracion[1] = conf[0];
        configuracion[0] = expresion;
        Object arr[] = {configuracion, identificador};

        return arr;
    }

    public Object visitDoconflistsecond(GramaticaParser.DoconflistsecondContext ctx) {
        Simbolo end = (Simbolo) visit(ctx.end);
        Simbolo paso = (Simbolo) visit(ctx.step);

        Simbolo conf[] = {end, paso};
        return conf;
    }

    public Object visitDoconflistfirst(GramaticaParser.DoconflistfirstContext ctx) {
        Simbolo end = (Simbolo) visit(ctx.end);
        Simbolo paso = new Simbolo(TipoSimbolo.C3D, "1", "IDFLOAT");
        Simbolo conf[] = {end, paso};

        return conf;
    }

    // ------------------------ subrutinas
    public Object visitFuncinstwithout(GramaticaParser.FuncinstwithoutContext ctx) {
        String identificador1 = ctx.frid.getText();
        String identificador2 = ctx.secid.getText();
        String retorno = ctx.return_.getText();

        if (!identificador1.equals(identificador2)) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Identificador diferente en subrutina, se esperaba: " + identificador1 + contadorMain, ctx.secid.getLine(), ctx.secid.getCharPositionInLine());
            listaExcepciones.add(excepcion);
            return false;
        }

        Subrutina subrutina = new Subrutina(null, null, ctx.linstrucciones(), retorno);
        Simbolo simbolo = new Simbolo(TipoSimbolo.FUNCION, subrutina, RolSimbolo.FUNCION);


        return true;
    }

    public Object visitFuncinstwith(GramaticaParser.FuncinstwithContext ctx) {
        String identificador1 = ctx.frid.getText();
        String identificador2 = ctx.secid.getText();
        String retorno = ctx.return_.getText();

        if (!identificador1.equals(identificador2)) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Identificador diferente en subrutina, se esperaba: " + identificador1 + contadorMain, ctx.secid.getLine(), ctx.secid.getCharPositionInLine());
            listaExcepciones.add(excepcion);
            return false;
        }
        ArrayList<String> listaParametros = (ArrayList<String>) visit(ctx.lparam());
        HashMap<String, TipoSimbolo> dclParametros = (HashMap<String, TipoSimbolo>) visit(ctx.ldclparams());

        if (listaParametros.size() != dclParametros.size()) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Numero distinto de declaraciones de parametros en: " + identificador1, ctx.ldclparams().start.getLine(), ctx.ldclparams().start.getCharPositionInLine());
            listaExcepciones.add(excepcion);
            return false;
        }

        boolean verificacionRetorno = false;
        for (String nombre : listaParametros) {
            if (!dclParametros.containsKey(nombre)) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Declaracion de parametro no realizada: " + nombre, ctx.ldclparams().start.getLine(), ctx.ldclparams().start.getCharPositionInLine());
                listaExcepciones.add(excepcion);
                return false;
            }
        }

        Subrutina subrutina = new Subrutina(listaParametros, dclParametros, ctx.linstrucciones(), retorno);

        Simbolo simbolo = new Simbolo(TipoSimbolo.FUNCION, subrutina, RolSimbolo.FUNCION);


        return true;
    }

    public Object visitSubroutineinstwithout(GramaticaParser.SubroutineinstwithoutContext ctx) {
        String identificador1 = ctx.frid.getText();
        String identificador2 = ctx.secid.getText();

        Subrutina subrutina_ = new Subrutina(null, null, ctx.linstrucciones());
        Simbolo simbolo = new Simbolo(TipoSimbolo.SUBRUTINA, subrutina_, RolSimbolo.SUBRUTINA);
        global.nuevoSimbolo(identificador1, simbolo);
        return true;
    }

    public Object visitSubroutineinstwith(GramaticaParser.SubroutineinstwithContext ctx) {

        String identificador1 = ctx.frid.getText();
        String identificador2 = ctx.secid.getText();
        ArrayList<String> listaParametros = (ArrayList<String>) visit(ctx.lparam());
        HashMap<String, TipoSimbolo> dclParametros = (HashMap<String, TipoSimbolo>) visit(ctx.ldclparams());
        Subrutina subrutina = new Subrutina(listaParametros, dclParametros, ctx.linstrucciones());
        Simbolo simbolo = new Simbolo(TipoSimbolo.SUBRUTINA, subrutina, RolSimbolo.SUBRUTINA);
        global.nuevoSimbolo(identificador1, simbolo);

        return true;
    }

    // lista de identificadores de parametros
    public Object visitLparamnext(GramaticaParser.LparamnextContext ctx) {
        ArrayList<String> parametros = (ArrayList<String>) visit(ctx.lparam());
        String identificador = ctx.IDEN().getText();

        parametros.add(identificador);

        return parametros;
    }

    public Object visitLparamfirst(GramaticaParser.LparamfirstContext ctx) {
        ArrayList<String> parametros = new ArrayList<>();
        String identificador = ctx.IDEN().getText();
        parametros.add(identificador);
        return parametros;
    }

    // ------------------------ declaracion de parametros
    public Object visitLdclparamsnext(GramaticaParser.LdclparamsnextContext ctx) {
        HashMap<String, TipoSimbolo> dclParametros = (HashMap<String, TipoSimbolo>) visit(ctx.ldclparams());
        Object parametro[] = (Object[]) visit(ctx.declarationparams());

        dclParametros.put((String) parametro[0], (TipoSimbolo) parametro[1]);

        return dclParametros;
    }

    public Object visitLdclparamsfirst(GramaticaParser.LdclparamsfirstContext ctx) {
        HashMap<String, TipoSimbolo> dclParametros = new HashMap<>();
        Object parametro[] = (Object[]) visit(ctx.declarationparams());

        dclParametros.put((String) parametro[0], (TipoSimbolo) parametro[1]);

        return dclParametros;
    }

    public Object visitDeclarationparams(GramaticaParser.DeclarationparamsContext ctx) {
        TipoSimbolo tipo = (TipoSimbolo) visit(ctx.type());
        String identificador = ctx.id.getText();

        Object parametro[] = new Object[2];
        parametro[0] = identificador;
        parametro[1] = tipo;

        return parametro;
    }

    // ------------------------ asignaciones
    public Object visitAsignormal(GramaticaParser.AsignormalContext ctx) {
        Simbolo expresion = (Simbolo) visit(ctx.expr());
        Object actualizacion = null;

        if (expresion.tipo3d.equals("IDBOOLEAN")) {
            c3d.codigo3d.remove(c3d.codigo3d.size() - 1);
            String etiquetaSalida1 = c3d.generateLabel();
            String temp1 = c3d.generateTemporal();
            String c_3d = "" +
                    expresion.getValor() + "\n" +
                    expresion.etiquetaV + ":\n" +
                    temp1 + " = T;\n" +
                    "goto " + etiquetaSalida1 + ";\n" +
                    expresion.etiquetaF + ":\n" +
                    temp1 + " = F;\n" +
                    "goto " + etiquetaSalida1 + ";\n" +
                    etiquetaSalida1 + ":\n" +
                    "";
            Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, temp1, "IDBOOLEAN");
            actualizacion = global.actualizarSimbolo(ctx.id.getText(), sim3d);
            c3d.codigo3d.add(c_3d);
            c_3d = "" +
                    ctx.id.getText() + " = " + temp1 + ";\n" +
                    "";
            c3d.codigo3d.add(c_3d);

        } else if (expresion.tipo3d.equals("IDFLOAT")) {
            Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, expresion.getValor(), "IDFLOAT");
            String c_3d = "" +
                    ctx.id.getText() + " = " + expresion.getValor() + ";\n" +
                    "";
            c3d.codigo3d.add(c_3d);
            actualizacion = global.actualizarSimbolo(ctx.id.getText(), sim3d);

        }


        return true;
    }

    // ------------------------ dowhile
    public Object visitNameddowhile(GramaticaParser.NameddowhileContext ctx) {
        while (true) {
            Object retorno = visit(ctx.expr());
            if (retorno instanceof Excepcion) {
                listaExcepciones.add((Excepcion) retorno);
                break;
            }

            Simbolo simbolo = (Simbolo) retorno;
            if (simbolo.getTipo() != TipoSimbolo.BOOLEAN) {
                int fila = ctx.expr().getStart().getLine(), columna = ctx.expr().getStart().getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor booleano.", fila, columna);
                listaExcepciones.add(excepcion);
                break;
            }

            String nombre = ctx.id.getText();
            String nombre2 = ctx.sec.getText();

            if (!nombre.equals(nombre2)) {
                int fila = ctx.sec.getLine(), columna = ctx.sec.getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Nombre diferente en etiqueta: " + nombre2 + " se esperaba: " + nombre, fila, columna);
                listaExcepciones.add(excepcion);
                break;
            }

            if ((boolean) simbolo.getValor()) {
                global = global.getSiguiente();
                global.setNombre(nombre);
                visit(ctx.linstrucciones());

                Object instruccionesRetorno = (ctx.linstrucciones());
                if (instruccionesRetorno instanceof Instruccion) {
                    Instruccion instruccion = (Instruccion) instruccionesRetorno;
                    if (instruccion.getEntorno() != null) {
                        if (nombre.equals(instruccion.getEntorno())) {

                        }
                    } else {

                    }
                }

                global = global.getPadre();
            } else break;
        }
        return true;
    }


    public Object visitUnnameddowhile(GramaticaParser.UnnameddowhileContext ctx) {
        Simbolo retorno = (Simbolo) visit(ctx.expr());
        c3d.codigo3d.remove(c3d.codigo3d.size() - 1);
        //Declaraciones
        String etiquetaCiclo = c3d.generateLabel();

        String c_3d = "" +
                etiquetaCiclo + ":\n" +
                retorno.getValor() + "\n" +
                retorno.etiquetaV + ": \n";
        c3d.codigo3d.add(c_3d);

        global = new Entorno(global);
        Object instruccionesRetorno = visit(ctx.linstrucciones());
        global = global.getPadre();

        c_3d = "" +
                "goto " + etiquetaCiclo + ";\n" +
                retorno.etiquetaF + ":\n";
        c3d.codigo3d.add(c_3d);

        return true;
    }

    // instrucciones de devolucion
    // cycle - continue
    public Object visitUnnamedcycle(GramaticaParser.UnnamedcycleContext ctx) {
        Instruccion instruccion = new Instruccion(Instruccion.TipoInstruccion.CYCLE);
        return instruccion;
    }

    public Object visitNamedcycle(GramaticaParser.NamedcycleContext ctx) {
        Instruccion instruccion = new Instruccion(Instruccion.TipoInstruccion.CYCLE, ctx.id.getText().toLowerCase());
        return instruccion;
    }

    // exit - break
    public Object visitUnnamedexit(GramaticaParser.UnnamedexitContext ctx) {
        Instruccion instruccion = new Instruccion(Instruccion.TipoInstruccion.EXIT);
        return instruccion;
    }

    public Object visitNamedexit(GramaticaParser.NamedexitContext ctx) {
        Instruccion instruccion = new Instruccion(Instruccion.TipoInstruccion.EXIT, ctx.id.getText().toLowerCase());
        return instruccion;
    }

    // ------------------------ if
    public Object visitOnlyif(GramaticaParser.OnlyifContext ctx) {
        Simbolo retorno = (Simbolo) visit(ctx.lif());
        String c_3d = "" +
                retorno.etiquetaF + ":\n" +
                "goto " + retorno.etiquetaSalida + ";\n" +
                retorno.etiquetaSalida + ":\n";
        c3d.codigo3d.add(c_3d);

        return true;
    }

    public Object visitIfelse(GramaticaParser.IfelseContext ctx) {
        Simbolo anterior = (Simbolo) visit(ctx.lif());

        String c_3d = "" +
                "goto " + anterior.etiquetaSalida + ";\n" +
                anterior.etiquetaF + ":\n";
        c3d.codigo3d.add(c_3d);

        Object retornoelse = visit(ctx.elseblck());
        c_3d = "goto " + anterior.etiquetaSalida + ";\n" +
                anterior.etiquetaSalida + ":";
        c3d.codigo3d.add(c_3d);

        return true;
    }

    public Object visitLifsecond(GramaticaParser.LifsecondContext ctx) {
        Simbolo retorno = (Simbolo) visit(ctx.lif());
        String c_3d = "" +
                "goto " + retorno.etiquetaSalida + ";\n" +
                retorno.etiquetaF + ":\n" +
                "";
        c3d.codigo3d.add(c_3d);

        //visita el otro else if
        Simbolo retornoif = (Simbolo) visit(ctx.ifblck());
        c_3d = "goto " + retorno.etiquetaSalida + ";";
        c3d.codigo3d.add(c_3d);
        return new Simbolo(TipoSimbolo.C3D, "", "label", "", retornoif.etiquetaF, retorno.etiquetaSalida);
    }

    public Object visitElseblck(GramaticaParser.ElseblckContext ctx) {
        global = new Entorno(global);

        Object instruccionesRetorno = visit(ctx.linstrucciones());
        if (instruccionesRetorno instanceof Instruccion) return instruccionesRetorno;

        global = global.getPadre();
        return true;
    }

    public Object visitIfblck(GramaticaParser.IfblckContext ctx) {
        Object retorno = visit(ctx.expr());
        Simbolo simbolo = (Simbolo) retorno;

        int fila = ctx.expr().getStart().getLine(), columna = ctx.expr().getStart().getCharPositionInLine();
        if (simbolo.tipo3d.equals("---")) {
            c3d.AgregarError("Error en la expresion IF, ", fila + "", columna + "");
            return simbolo;
        }
        if (!simbolo.tipo3d.equals("IDBOOLEAN")) {
            c3d.AgregarError("Expresion no booleana IF, ", fila + "", columna + "");
            return new Simbolo(TipoSimbolo.C3D, "---", "---");
        }

        //nuevo entorno
        global = new Entorno(global);

        //c3d
        String temp = c3d.generateLabel();
        c3d.codigo3d.remove(c3d.codigo3d.size() - 1);
        String c_3d = "" +
                simbolo.getValor() + "\n" +
                simbolo.etiquetaV + ":\n";
        c3d.codigo3d.add(c_3d);

        Object instruccionesRetorno = visit(ctx.linstrucciones());
        if (instruccionesRetorno instanceof Instruccion) return instruccionesRetorno;

        global = global.getPadre();
        /*
        c_3d = "" +
                "goto " + temp + ";\n" ;
        c3d.codigo3d.add(c_3d);

         */

        return new Simbolo(TipoSimbolo.C3D, "", "label", "", simbolo.etiquetaF, temp);
    }

    // ------------------------ impresion

    public Object visitPrint(GramaticaParser.PrintContext ctx) {
        String resultado = (String) visit(ctx.printexps());
        resultado += "printf(\"\\n\");";
        c3d.codigo3d.add(resultado);
        //imprimirEnConsola("\n");
        return true;
    }

    public Object visitPrtnext(GramaticaParser.PrtnextContext ctx) {
        String resultado = "";
        String cadena1 = (String) visit(ctx.printexps());
        String cadena2 = (String) visit(ctx.printexp());

        resultado += cadena1 + " " + cadena2;

        return resultado;
    }

    public Object visitPrtfirst(GramaticaParser.PrtfirstContext ctx) {
        String cadena2 = (String) visit(ctx.printexp());
        return cadena2;
    }
    public Object visitExprPrint(GramaticaParser.ExprPrintContext ctx) {
        Simbolo retorno = (Simbolo) visit(ctx.expr());
        String c_3d;
        if (retorno.tipo3d.equals("IDFLOAT")) {
            c_3d = "" +
                    "printf(\"%f\"," + retorno.getValor() + ");\n" +
                    "";

        } else {
            c_3d = "" +
                    "printf(\"%c\", (char)" + retorno.getValor() + ");\n" +
                    "";

        }
        return c_3d;
    }

    public Object visitStringExpr(GramaticaParser.StringExprContext ctx) {
        String valor = ctx.STRING().getText();
        valor = valor.substring(1, valor.length() - 1);
        String temp = c3d.generateTemporal(valor.length());
        String c_3d = "" ;
        int cont = 0;
        for (char val : valor.toCharArray()) {
            c_3d += temp + "[" + cont + "] = " + (int)val  + ";\n";
            cont++;
        }
        cont = 0;
        for (char val : valor.toCharArray()) {
            c_3d += "printf(\"%c\",(char)" + temp + "[" + cont + "]" + ");\n";
            cont++;
        }
        //c_3d += "printf(\"\\n\");";
        /*
        ArrayList<Simbolo> simb = new ArrayList<>();
        Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDSTR");
        simb.add(sim3d);

         */
        return c_3d;
    }

    // ------------------------ declaraciones
    public Object declaracionNuevaVariable(String nombre, Simbolo simbolo, TipoSimbolo tipo) {
        if (simbolo != null) {
            if(simbolo.getTipo() == TipoSimbolo.C3D){
                global.nuevoSimbolo(nombre, simbolo);
            }else {
                if (simbolo.getTipo() != tipo) {
                    Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de dato diferente en declaracion, se esperaba: " + tipo.name().toLowerCase(), 0, 0);
                    return excepcion;
                }
            }

        } else {
            if (tipo == TipoSimbolo.INT) {
                simbolo = new Simbolo(TipoSimbolo.INT, 0);
                global.nuevoSimbolo(nombre, simbolo);
            } else if (tipo == TipoSimbolo.REAL) {
                simbolo = new Simbolo(TipoSimbolo.REAL, 0.0);
                global.nuevoSimbolo(nombre, simbolo);
            } else if (tipo == TipoSimbolo.COMPLEX) {
                simbolo = new Simbolo(TipoSimbolo.REAL, 9.192517926e-43);
                Simbolo imaginario = new Simbolo(TipoSimbolo.REAL, 0.0);
                Simbolo valor[] = {simbolo, imaginario};
                global.nuevoSimbolo(nombre, simbolo);
            } else if (tipo == TipoSimbolo.CHAR) {
                simbolo = new Simbolo(TipoSimbolo.CHAR, "");
                global.nuevoSimbolo(nombre, simbolo);
            } else if (tipo == TipoSimbolo.LOGICAL) {
                simbolo = new Simbolo(TipoSimbolo.LOGICAL, false);
                global.nuevoSimbolo(nombre, simbolo);
            }
            else if (tipo == TipoSimbolo.C3D) {
                simbolo = new Simbolo(TipoSimbolo.C3D, "", c3d.getTipoDato3d(tipo));
                global.nuevoSimbolo(nombre, simbolo);
            }
            else {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de dato no inicializable: " + tipo.name().toLowerCase(), 0, 0);
                return excepcion;
            }
        }
        return true;
    }

    public Object visitDclnext(GramaticaParser.DclnextContext ctx) {
        TipoSimbolo tipo = (TipoSimbolo) visit(ctx.ldeclarations());
        Object declaracion = visit(ctx.indecla());

        if (declaracion instanceof Excepcion) {
            listaExcepciones.add((Excepcion) declaracion);
            return tipo;
        }

        Object valores[] = (Object[]) declaracion;

        Object resultado = declaracionNuevaVariable((String) valores[0], (Simbolo) valores[1], tipo);

        if (resultado instanceof Excepcion) {
            ((Excepcion) resultado).setFilaColumna(ctx.indecla().getStart().getLine(), ctx.indecla().getStart().getCharPositionInLine());
            listaExcepciones.add((Excepcion) resultado);
        }

        Simbolo valorInicial = (Simbolo) valores[1];
        if (valorInicial != null) {

            String c_3d = "" +
                    c3d.getTipoDato3d(tipo) + " " + valores[0] + ";\n" +
                    valores[0] + " = " + valorInicial.getValor() + ";\n";
            c3d.codigo3d.add(c_3d);

        } else {
            String c_3d = "" +
                    c3d.getTipoDato3d(tipo) + " " + valores[0] + ";\n" +
                    "";
            c3d.codigo3d.add(c_3d);
        }

        return tipo;
    }

    public Object visitDclfirst(GramaticaParser.DclfirstContext ctx) {
        //C3D
        TipoSimbolo tipo = (TipoSimbolo) visit(ctx.type());
        Object retorno = visit(ctx.indecla());

        if (retorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) retorno);
            return tipo;
        }

        Object[] valores = (Object[]) retorno;
        Object resultado = declaracionNuevaVariable((String) valores[0], (Simbolo) valores[1], tipo);

        if (resultado instanceof Excepcion) {
            ((Excepcion) resultado).setFilaColumna(ctx.indecla().getStart().getLine(), ctx.indecla().getStart().getCharPositionInLine());
            listaExcepciones.add((Excepcion) resultado);
        }
        Simbolo valorInicial = (Simbolo) valores[1];

        if (valorInicial != null) {

            String c_3d = "" +
                    c3d.getTipoDato3d(tipo) + " " + valores[0] + ";\n" +
                    valores[0] + " = " + valorInicial.getValor() + ";\n";
            c3d.codigo3d.add(c_3d);

        } else {
            c3d.AgregarVariable(valores[0] + "");
            /*
            String c_3d = "" +
                    c3d.getTipoDato3d(tipo) + " " + valores[0] + ";\n" +
                    "";
            c3d.codigo3d.add(c_3d);

             */
        }


        return tipo;
    }

    public Object visitDeclinit(GramaticaParser.DeclinitContext ctx) {
        String identificador = ctx.id.getText();
        Object retorno = visit(ctx.expr());

        if (retorno instanceof Excepcion) return retorno;

        Simbolo simbolo = (Simbolo) retorno;
        Object valores[] = {identificador, simbolo};
        return valores;
    }

    public Object visitDeclwithout(GramaticaParser.DeclwithoutContext ctx) {
        String identificador = ctx.id.getText();
        Object valores[] = {identificador, null};
        return valores;
    }

    // tipos
    public Object visitType(GramaticaParser.TypeContext ctx) {
        String tipo = ctx.getText().toLowerCase();
        switch (tipo) {
            case "integer":
                return TipoSimbolo.INT;
            case "real":
                return TipoSimbolo.REAL;
            case "complex":
                return TipoSimbolo.COMPLEX;
            case "character":
                return TipoSimbolo.CHAR;
            case "logical":
                return TipoSimbolo.LOGICAL;
            default:
                int fila = ctx.getStart().getLine(), columna = ctx.getStart().getCharPositionInLine();
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de dato no existente:" + tipo, fila, columna);
                return excepcion;
        }
    }

    // ------------------------ operaciones
    public Object visitUnitExpr(GramaticaParser.UnitExprContext ctx) {
        String operador = ctx.op.getText();
        Simbolo simbolo = (Simbolo) visit(ctx.right);

        switch (operador) {
            case "-": {
                String temp1 = c3d.generateTemporal();
                String c_3d = "" +
                        temp1 + " = " + simbolo.getValor() + " * -1";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, temp1, "IDFLOAT");
                c3d.codigo3d.add(c_3d);
                return sim3d;
            }
            default: {
                // Realizar condicion logica NOT
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c3d.generateTemporal(), "IDFLOAT");
                //c3d.codigo3d.add(sim3d.getValor() + " = " + izq.valor + operacion + der.valor + ";");
                return sim3d;
            }
        }

    }

    public Object visitOpExpr(GramaticaParser.OpExprContext ctx) {
        Simbolo izquierda = (Simbolo) visit(ctx.left);
        Simbolo derecha = (Simbolo) visit(ctx.right);
        String operacion = ctx.op.getText();

        if(izquierda.tipo3d.equals("---") || derecha.tipo3d.equals("---") ){
           return false;
        }
        String etiquetaEntrada = c3d.generateLabel();
        String etiquetaSalida = c3d.generateLabel();
        switch (operacion){
            case "**":{
                String Temp1 = c3d.generateTemporal();
                String Temp2 = c3d.generateTemporal();

                String cod3d = "" +
                                Temp1 + " = " + izquierda.getValor() + ";\n" +
                                Temp2 + " = 1;\n" +
                                etiquetaEntrada + ":\n" +
                                "if(" + Temp2 + " == " + derecha.getValor() + ") goto " + etiquetaSalida + ";\n" +
                                Temp1 + " = " + Temp1 + " * " + izquierda.getValor() + ";\n" +
                                Temp2 + " = " + Temp2 + " + " + " 1;\n" +
                                "goto " + etiquetaEntrada + ";\n" +
                                etiquetaSalida + ":\n";

                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, Temp1, "IDFLOAT");
                c3d.codigo3d.add(cod3d);
                return  sim3d;
            }

            case ".eq.":
            case "==":{
                //String temp1 = c3d.generateTemporal();
                String c_3d = "" +
                        "if(" + izquierda.getValor() + " == " + derecha.getValor() + ") goto " + etiquetaEntrada + ";\n" +
                        "goto " + etiquetaSalida + ";\n";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN",etiquetaEntrada,etiquetaSalida);
                c3d.codigo3d.add(c_3d);
                return  sim3d;
            }
            case ".ne.":
            case "/=":{
                //String temp1 = c3d.generateTemporal();
                String c_3d = "" +
                        "if(" + izquierda.getValor() + " != " + derecha.getValor() + ") goto " + etiquetaEntrada + ";\n" +
                        "goto " + etiquetaSalida + ";\n";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN",etiquetaEntrada,etiquetaSalida);
                c3d.codigo3d.add(c_3d);
                return  sim3d;
            }
            case ".gt.":
            case ">":{
                //String temp1 = c3d.generateTemporal();
                String c_3d = "" +
                        "if(" + izquierda.getValor() + " > " + derecha.getValor() + ") goto " + etiquetaEntrada + ";\n" +
                        "goto " + etiquetaSalida + ";\n";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN",etiquetaEntrada,etiquetaSalida);
                c3d.codigo3d.add(c_3d);
                return  sim3d;
            }
            case ".lt.":
            case "<":{
                //String temp1 = c3d.generateTemporal();
                String c_3d = "" +
                        "if(" + izquierda.getValor() + " < " + derecha.getValor() + ") goto " + etiquetaEntrada + ";\n" +
                        "goto " + etiquetaSalida + ";\n";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN",etiquetaEntrada,etiquetaSalida);
                c3d.codigo3d.add(c_3d);
                return  sim3d;
            }
            case ".ge.":
            case ">=":{
                //String temp1 = c3d.generateTemporal();
                String c_3d = "" +
                        "if(" + izquierda.getValor() + " >= " + derecha.getValor() + ") goto " + etiquetaEntrada + ";\n" +
                        "goto " + etiquetaSalida + ";\n";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN",etiquetaEntrada,etiquetaSalida);
                c3d.codigo3d.add(c_3d);
                return  sim3d;
            }
            case ".le.":
            case "<=":{
                String c_3d = "" +
                        "if(" + izquierda.getValor() + " <= " + derecha.getValor() + ") goto " + etiquetaEntrada + ";\n" +
                        "goto " + etiquetaSalida + ";\n" +
                        "";
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN",etiquetaEntrada,etiquetaSalida);
                c3d.codigo3d.add(c_3d);
                return  sim3d;
            }

            case ".and.":{
                //String temp1 = c3d.generateTemporal();
                c3d.codigo3d.remove(c3d.codigo3d.size() - 1);
                c3d.codigo3d.remove(c3d.codigo3d.size() - 3);
                if(izquierda.tipo3d.equals("IDBOOLEAN") && derecha.tipo3d.equals("IDBOOLEAN")) {

                    String c_3d = "" +
                            izquierda.getValor() + "\n" +
                            izquierda.etiquetaV + ":\n " +
                            derecha.getValor() + "\n";
                    Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN", derecha.etiquetaV, izquierda.etiquetaF + ":" + derecha.etiquetaF);
                    c3d.codigo3d.add(c_3d);
                    return sim3d;
                }

            }
            case ".or.":{
                c3d.codigo3d.remove(c3d.codigo3d.size() - 1);
                c3d.codigo3d.remove(c3d.codigo3d.size() - 3);
                if(izquierda.tipo3d.equals("IDBOOLEAN") && derecha.tipo3d.equals("IDBOOLEAN")) {
                    String c_3d = "" +
                            izquierda.getValor() + "\n" +
                            izquierda.etiquetaF + ":\n" +
                            derecha.getValor() + "\n";
                    Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c_3d, "IDBOOLEAN", izquierda.etiquetaV + ":" +derecha.etiquetaV, derecha.etiquetaF);
                    c3d.codigo3d.add(c_3d);
                    return sim3d;
                }
            }
            case ".not.":{
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, derecha.getValor(), "IDBOOLEAN", derecha.etiquetaF,derecha.etiquetaV);
                return sim3d;
            }
            default:{
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c3d.generateTemporal(), "IDFLOAT");
                c3d.codigo3d.add(sim3d.getValor() + " = " + izquierda.getValor() + operacion + derecha.getValor() + ";");
                return  sim3d;
            }
        }


    }

    // ------------------------ simbolos primitivos

    public Object visitIdenExpr(GramaticaParser.IdenExprContext ctx) {
        //C3D
        Simbolo simbolo = global.buscar(ctx.id.getText());
        if(simbolo != null){
            if(simbolo.getTipo() != TipoSimbolo.C3D) {
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, ctx.id.getText(), simbolo.toStringTipo());
                return sim3d;
            }else{
                Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, ctx.id.getText(), simbolo.tipo3d);
                return sim3d;
            }
        }else{
            c3d.AgregarError("Variable no encontrada: " + ctx.id.getText(), ctx.id.getLine() +"", ctx.id.getCharPositionInLine()+"");
        }



        /*
         * t0 = 12 + 4;
         * P = t0;
         * t1 = STACK[(int)P];
         * */
        /*c3d.codigo3d.add(c3d.generateTemporal() + "=" + global.getPrevSizes() + " + " + simbolo.getPosicion() + ";");
        c3d.codigo3d.add("P = " + c3d.lastTemporal() + ";");
        c3d.codigo3d.add(sim3d.getValor() + "= STACK[(int)P];");*/

       return  new Simbolo(TipoSimbolo.C3D, "---","---");
    }

    public Object visitComplexExpr(GramaticaParser.ComplexExprContext ctx) {
        Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, "---","---");
        return sim3d;
    }

    public Object visitBoolExpr(GramaticaParser.BoolExprContext ctx) {
        Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c3d.generateTemporal(), "IDFLOAT");
        c3d.codigo3d.add(sim3d.getValor() + " = " + (Boolean.valueOf(ctx.getText()) ? "T" : "F") + ";");
        return sim3d;
    }

    public Object visitCharExpr(GramaticaParser.CharExprContext ctx) {
        String valor = ctx.char_.getText();
        valor = valor.substring(1, valor.length() - 1);
        char hola =  valor.charAt(0);
        Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, (int)hola ,"IDCHAR");
        return sim3d;
    }

    public Object visitRealExpr(GramaticaParser.RealExprContext ctx) {
        Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c3d.generateTemporal(),"IDFLOAT");

        c3d.codigo3d.add(sim3d.getValor() + " = " + ctx.getText() + ";");
        return sim3d;
    }

    public Object visitAtomExpr(GramaticaParser.AtomExprContext ctx) {
        //C3D
        Simbolo sim3d = new Simbolo(TipoSimbolo.C3D, c3d.generateTemporal(),"IDFLOAT");

        c3d.codigo3d.add(sim3d.getValor() + " = " + ctx.getText() + ";");
        return sim3d;
    }

    public Object visitParenExpr(GramaticaParser.ParenExprContext ctx)
    {
       Simbolo sim = (Simbolo) visit(ctx.expr());

       return sim;

    }


}




