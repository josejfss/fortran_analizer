package Visitors;

import entorno.*;
import gramatica.GramaticaBaseVisitor;
import gramatica.GramaticaParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter extends GramaticaBaseVisitor {

    public Entorno global = new Entorno();
    public String consola = "";
    public ArrayList<Excepcion> listaExcepciones = new ArrayList<>();

    public Entorno getGlobal() {
        return global;
    }

    public int contadorMain = 0;
    private GramaticaParser.MainblockContext bloqueMain;

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
//        visitChildren(ctx);
        visit(ctx.lfunc());
        if (contadorMain < 1) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Falta metodo main para iniciar programa", 0, 0);
            listaExcepciones.add(excepcion);
            return false;
        }

        visit(bloqueMain);
        System.out.println(consola);
        return "";
    }
    // comprobacion de entornos
    // comprobacion de entornos

    public Object visitLinstruccionesnext(GramaticaParser.LinstruccionesnextContext ctx) {
        Object instruccionesRetorno = visit(ctx.linstrucciones());
        if (instruccionesRetorno instanceof Instruccion) return instruccionesRetorno;

        return visit(ctx.instruccion());
    }
    // ------------------------ asignacion de arreglo completo
    public Object visitAsigarrayuni(GramaticaParser.AsigarrayuniContext ctx) {
        Object lsimbolosRetorno = visit(ctx.lparamexp());
        if (lsimbolosRetorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) lsimbolosRetorno);
            return false;
        }

        String identificador = ctx.id.getText();
        Simbolo simbolo = global.buscar(identificador);
        if (simbolo == null){
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo no encontrado: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        if (!(simbolo.getRol() == RolSimbolo.ARREGLO || simbolo.getRol() == RolSimbolo.ARREGLODINAMICO)) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Se esperaba un valor de tipo arreglo: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Arreglo arreglo = (Arreglo) simbolo.getValor();
        ArrayList<Object> arregloLleno = (ArrayList<Object>) lsimbolosRetorno;
        Object comprobacion = arreglo.comprobacionDimensiones(0, arregloLleno, simbolo.getTipo());
        if (comprobacion instanceof Excepcion){
            ((Excepcion) comprobacion).setFilaColumna(ctx.lparamexp().start.getLine(),ctx.lparamexp().start.getCharPositionInLine());
            return false;
        }

        arreglo.inicio();
        arreglo.llenadoDeArreglo(arregloLleno);

        return true;


    }

    public Object visitAsigarray(GramaticaParser.AsigarrayContext ctx) {
        Object retorno = visit(ctx.ldimeArray());
        if (retorno instanceof Excepcion){
            listaExcepciones.add((Excepcion) retorno);
            return false;
        }
        ArrayList<Object> arregloLleno = (ArrayList<Object>) retorno;

        String identificador = ctx.id.getText();
        Simbolo simbolo = global.buscar(identificador);
        if (simbolo == null){
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo no encontrado: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        if (!(simbolo.getRol() == RolSimbolo.ARREGLO || simbolo.getRol() == RolSimbolo.ARREGLODINAMICO)) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Se esperaba un valor de tipo arreglo: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Arreglo arreglo = (Arreglo) simbolo.getValor();
        Object comprobacion = arreglo.comprobacionDimensiones(0, arregloLleno, simbolo.getTipo());
        if (comprobacion instanceof Excepcion){
            ((Excepcion) comprobacion).setFilaColumna(ctx.ldimeArray().start.getLine(),ctx.ldimeArray().start.getCharPositionInLine());
            return false;
        }

        arreglo.inicio();
        arreglo.llenadoDeArreglo(arregloLleno);

        return true;
    }
    public Object visitLdimeArraynext(GramaticaParser.LdimeArraynextContext ctx) {
        Object dimensionesRetorno = visit(ctx.ldimeArray());
        Object nuevoRetorno = visit(ctx.dimeArray());

        if (dimensionesRetorno instanceof Excepcion) return dimensionesRetorno;
        if (nuevoRetorno instanceof Excepcion) return nuevoRetorno;

        ArrayList<Object> dimensiones = (ArrayList<Object>) dimensionesRetorno;
        ArrayList<Object> nuevo = (ArrayList<Object>) nuevoRetorno;
        dimensiones.addAll(nuevo);

        return dimensiones;
    }

    public Object visitDimeArraynd(GramaticaParser.DimeArrayndContext ctx) {
        Object dimensionesRetorno = visit(ctx.ldimeArray());
        if (dimensionesRetorno instanceof Excepcion) return dimensionesRetorno;

        ArrayList<Object> dimensiones = (ArrayList<Object>) dimensionesRetorno;
        ArrayList<Object> nuevo = new ArrayList<>();
        nuevo.add(dimensiones);
        return nuevo;
    }

    public Object visitDimeArrayexp(GramaticaParser.DimeArrayexpContext ctx) {
        Object simbolosRetorno = visit(ctx.lparamexp());
        if (simbolosRetorno instanceof Excepcion) return simbolosRetorno;

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) simbolosRetorno;

        ArrayList<Object> dimension = new ArrayList<>();
        dimension.add(parametros);

        return dimension;
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

        boolean declaracion = global.nuevoSimbolo(identificador, simbolo);
        if (!declaracion) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Error en declaracion de arreglo dinamico, ya existe una variable: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

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
        if (retornoElemento instanceof Excepcion) {
            int fila = ctx.lparamexp().start.getLine(), columna = ctx.lparamexp().start.getCharPositionInLine();
            ((Excepcion) retornoElemento).setFilaColumna(fila, columna);
            return retornoElemento;
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

        boolean declaracion = global.nuevoSimbolo(identificador, simbolo);
        if (!declaracion) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Existe una variable: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

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

        boolean declaracion = global.nuevoSimbolo(identificador, simbolo);
        if (!declaracion) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Existe una variable: " + identificador,
                    fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

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

        global = new Entorno(global);
        visit((ParseTree) funcion.getLinstrucciones());
        simboloRetorno = global.buscar(identificadorRetorno);
        global = global.getPadre();

        if (simboloRetorno == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Variable de retorno de no encontrada: " + identificadorRetorno, fila, columna);
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
        global = new Entorno(global);
        for (int i = 0; i < listaParametros.size(); i++) {
            declaracion = parametros.get(i);
            global.nuevoSimbolo(listaParametros.get(i), declaracion);
        }
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

        Simbolo subrutina = global.buscar(identificador);
        if (subrutina == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Subrutina no encontrada: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        if (subrutina.getTipo() != TipoSimbolo.SUBRUTINA) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba el nombre de una subrutina: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Subrutina subrutina1 = (Subrutina) subrutina.getValor();
        ArrayList<String> listaParametros = subrutina1.getListaNombreParametros();
        HashMap<String, TipoSimbolo> dclParametros = subrutina1.getDclParametros();


        if (listaParametros != null || dclParametros != null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Faltan parametros en el llamado de la subrutina: " + identificador, fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        global = new Entorno(global);
        visit((ParseTree) subrutina1.getLinstrucciones());
        global = global.getPadre();

        return true;
    }

    public Object visitCallsubinstwith(GramaticaParser.CallsubinstwithContext ctx) {
        String identificador = ctx.id.getText();
        Object retornoListaExpresiones = visit(ctx.lparamexp());
        if (retornoListaExpresiones instanceof Excepcion) {
            listaExcepciones.add((Excepcion) retornoListaExpresiones);
            return false;
        }
        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) retornoListaExpresiones;

        Simbolo subrutina = global.buscar(identificador);
        if (subrutina == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Subrutina no encontrada: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }
        if (subrutina.getTipo() != TipoSimbolo.SUBRUTINA) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba el nombre de una subrutina: " + ctx.id.getText(), fila, columna);
            listaExcepciones.add(excepcion);
            return false;
        }

        Subrutina subrutina1 = (Subrutina) subrutina.getValor();
        ArrayList<String> listaParametros = subrutina1.getListaNombreParametros();
        HashMap<String, TipoSimbolo> dclParametros = subrutina1.getDclParametros();

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

        global = new Entorno(global);
        for (int i = 0; i < listaParametros.size(); i++) {
            declaracion = parametros.get(i);
            global.nuevoSimbolo(listaParametros.get(i), declaracion);
        }
        visit((ParseTree) subrutina1.getLinstrucciones());
        global = global.getPadre();

        return true;
    }

    public Object visitLparamexpnext(GramaticaParser.LparamexpnextContext ctx) {
        Object retornoListaExpresiones = visit(ctx.lparamexp());
        if (retornoListaExpresiones instanceof Excepcion) return retornoListaExpresiones;

        Object retornoExpresion = visit(ctx.expr());
        if (retornoExpresion instanceof Excepcion) {
            ((Excepcion) retornoExpresion).setFilaColumna(ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            return retornoExpresion;
        }

        ArrayList<Simbolo> parametros = (ArrayList<Simbolo>) retornoListaExpresiones;
        Simbolo simbolo = (Simbolo) retornoExpresion;
        parametros.add(simbolo);

        return parametros;
    }

    public Object visitLparamexpfirst(GramaticaParser.LparamexpfirstContext ctx) {
        Object retornoExpresion = visit(ctx.expr());
        if (retornoExpresion instanceof Excepcion) {
            ((Excepcion) retornoExpresion).setFilaColumna(ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            return retornoExpresion;
        }

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

            global = new Entorno(global);
            global.setNombre(identificador);
            if (variable == null) {
                variable = new Simbolo(TipoSimbolo.INT, i);
                global.nuevoSimbolo(identificadorVariable, variable);
            } else {
                variable = new Simbolo(TipoSimbolo.INT, i);
                global.actualizarSimbolo(identificadorVariable, variable);
            }

            Object instruccionesRetorno = visit(ctx.linstrucciones());
            if (instruccionesRetorno instanceof Instruccion) {
                Instruccion instruccion = (Instruccion) instruccionesRetorno;
                if (instruccion.getEntorno() != null) {
                    if (identificador.equals(instruccion.getEntorno())) {
                        if (instruccion.getTipo() == Instruccion.TipoInstruccion.CYCLE) continue;
                        break;
                    }
                    return instruccion;
                }

                if (instruccion.getTipo() == Instruccion.TipoInstruccion.CYCLE) continue;
                break;
            }

            global = global.getPadre();
        }

        return true;
    }

    public Object visitUnnameddo(GramaticaParser.UnnameddoContext ctx) {
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
        for (int i = valorInicio; i <= valorFinal; i += valorPaso) {
            variable = global.buscar(identificadorVariable);

            global = new Entorno(global);
            if (variable == null) {
                variable = new Simbolo(TipoSimbolo.INT, i);
                global.nuevoSimbolo(identificadorVariable, variable);
            } else {
                variable = new Simbolo(TipoSimbolo.INT, i);
                global.actualizarSimbolo(identificadorVariable, variable);
            }

            Object instruccionesRetorno = visit(ctx.linstrucciones());
            if (instruccionesRetorno instanceof Instruccion) {
                Instruccion instruccion = (Instruccion) instruccionesRetorno;
                if (instruccion.getTipo() == Instruccion.TipoInstruccion.CYCLE) continue;
                break;
            }

            global = global.getPadre();
        }

        return true;
    }

    public Object visitDoconf(GramaticaParser.DoconfContext ctx) {
        Object retornoConfig = visit(ctx.doconflist());
        if (retornoConfig instanceof Excepcion) return retornoConfig;

        Object expresionRetorno = visit(ctx.expr());
        if (expresionRetorno instanceof Excepcion) {
            ((Excepcion) expresionRetorno).setFilaColumna(ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            return expresionRetorno;
        }
        Simbolo expresion = (Simbolo) expresionRetorno;
        if (expresion.getTipo() != TipoSimbolo.INT) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor tipo int en el inicio de sentencia do", ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            return excepcion;
        }

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

        if (end.getTipo() != TipoSimbolo.INT) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor tipo int en el final de instruccion Do", ctx.end.getStart().getLine(), ctx.end.getStart().getCharPositionInLine());
            return excepcion;
        }
        if (paso.getTipo() != TipoSimbolo.INT) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor tipo int en el paso de instruccion Do", ctx.step.getStart().getLine(), ctx.step.getStart().getCharPositionInLine());
            return excepcion;
        }

        Simbolo conf[] = {end, paso};
        return conf;
    }

    public Object visitDoconflistfirst(GramaticaParser.DoconflistfirstContext ctx) {
        Simbolo end = (Simbolo) visit(ctx.end);

        if (end.getTipo() != TipoSimbolo.INT) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor tipo int en el final de instruccion Do", ctx.end.getStart().getLine(), ctx.end.getStart().getCharPositionInLine());
            return excepcion;
        }
        Simbolo paso = new Simbolo(TipoSimbolo.INT, 1);
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
        global.nuevoSimbolo(identificador1, simbolo);

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

        for (String nombre : listaParametros) {
            if (!dclParametros.containsKey(nombre)) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Declaracion de parametro no realizada: " + nombre, ctx.ldclparams().start.getLine(), ctx.ldclparams().start.getCharPositionInLine());
                listaExcepciones.add(excepcion);
                return false;
            }
        }

        Subrutina subrutina = new Subrutina(listaParametros, dclParametros, ctx.linstrucciones(), retorno);

        Simbolo simbolo = new Simbolo(TipoSimbolo.FUNCION, subrutina, RolSimbolo.FUNCION);
        global.nuevoSimbolo(identificador1, simbolo);

        return true;
    }

    public Object visitSubroutineinstwithout(GramaticaParser.SubroutineinstwithoutContext ctx) {
        String identificador1 = ctx.frid.getText();
        String identificador2 = ctx.secid.getText();

        if (!identificador1.equals(identificador2)) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Identificador diferente en subrutina, se esperaba: " + identificador1 + contadorMain, ctx.secid.getLine(), ctx.secid.getCharPositionInLine());
            listaExcepciones.add(excepcion);
            return false;
        }

        Subrutina subrutina = new Subrutina(null, null, ctx.linstrucciones());
        Simbolo simbolo = new Simbolo(TipoSimbolo.SUBRUTINA, subrutina, RolSimbolo.SUBRUTINA);
        global.nuevoSimbolo(identificador1, simbolo);

        return true;
    }

    public Object visitSubroutineinstwith(GramaticaParser.SubroutineinstwithContext ctx) {

        String identificador1 = ctx.frid.getText();
        String identificador2 = ctx.secid.getText();

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

        for (String nombre : listaParametros) {
            if (!dclParametros.containsKey(nombre)) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Declaracion de parametro no realizada: " + nombre, ctx.ldclparams().start.getLine(), ctx.ldclparams().start.getCharPositionInLine());
                listaExcepciones.add(excepcion);
                return false;
            }
        }
        Subrutina subrutina = new Subrutina(listaParametros, dclParametros, ctx.linstrucciones());
        Simbolo simbolo = new Simbolo(TipoSimbolo.SUBRUTINA, subrutina, RolSimbolo.SUBRUTINA);
        global.nuevoSimbolo(identificador1, simbolo);

        return true;
    }

    // lista de identificadores de parametros
    public Object visitLparamnext(GramaticaParser.LparamnextContext ctx) {
        ArrayList<String> parametros = (ArrayList<String>) visit(ctx.lparam());
        String identificador = ctx.IDEN().getText();

        if (parametros.contains(identificador)) {
            int fila = ctx.IDEN().getSymbol().getLine(), columna = ctx.IDEN().getSymbol().getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor booleano.", fila, columna);
            listaExcepciones.add(excepcion);
        } else parametros.add(identificador);

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

        if (dclParametros.containsKey(parametro[0])) {
            int fila = ctx.declarationparams().start.getLine(), columna = ctx.declarationparams().start.getLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor booleano.", fila, columna);
            listaExcepciones.add(excepcion);
        } else {
            dclParametros.put((String) parametro[0], (TipoSimbolo) parametro[1]);
        }

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
        Object expresion = visit(ctx.expr());
        if (expresion instanceof Excepcion) {
            ((Excepcion) expresion).setFilaColumna(ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            listaExcepciones.add((Excepcion) expresion);
            return false;
        }

        Simbolo simbolo = (Simbolo) expresion;
        Object actualizacion = global.actualizarSimbolo(ctx.id.getText(), simbolo);

        if (actualizacion instanceof Excepcion) {
            ((Excepcion) actualizacion).setFilaColumna(ctx.id.getLine(), ctx.id.getCharPositionInLine());
            listaExcepciones.add((Excepcion) actualizacion);
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
                global = new Entorno(global);
                global.setNombre(nombre);

                Object instruccionesRetorno = visit(ctx.linstrucciones());
                if (instruccionesRetorno instanceof Instruccion) {
                    Instruccion instruccion = (Instruccion) instruccionesRetorno;
                    if (instruccion.getEntorno() != null) {
                        if (nombre.equals(instruccion.getEntorno())) {
                            if (instruccion.getTipo() == Instruccion.TipoInstruccion.CYCLE) continue;
                            break;
                        }
                        return instruccion;
                    }

                    if (instruccion.getTipo() == Instruccion.TipoInstruccion.CYCLE) continue;
                    break;
                }

                global = global.getPadre();
            } else break;
        }
        return true;
    }


    public Object visitUnnameddowhile(GramaticaParser.UnnameddowhileContext ctx) {
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

            if ((boolean) simbolo.getValor()) {
                global = new Entorno(global);

                Object instruccionesRetorno = visit(ctx.linstrucciones());
                if (instruccionesRetorno instanceof Instruccion) {
                    Instruccion instruccion = (Instruccion) instruccionesRetorno;
                    if (instruccion.getTipo() == Instruccion.TipoInstruccion.CYCLE) continue;
                    break;
                }

                global = global.getPadre();
            } else break;
        }
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
        Object retorno = visit(ctx.lif());

        if (retorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) retorno);
            return false;
        }
        if (retorno instanceof Instruccion) return retorno;

        return true;
    }

    public Object visitIfelse(GramaticaParser.IfelseContext ctx) {
        Object anterior = visit(ctx.lif());

        if (anterior instanceof Excepcion) {
            listaExcepciones.add((Excepcion) anterior);
            return false;
        }
        if (anterior instanceof Instruccion) return anterior;

        if ((boolean) anterior) return true;

        Object retornoelse = visit(ctx.elseblck());
        if (retornoelse instanceof Excepcion) {
            listaExcepciones.add((Excepcion) retornoelse);
            return false;
        }

        return true;
    }

    public Object visitLifsecond(GramaticaParser.LifsecondContext ctx) {
        Object retorno = visit(ctx.lif());
        if (retorno instanceof Excepcion) return retorno;
        if (retorno instanceof Instruccion) return retorno;

        if ((boolean) retorno) return true; // ya se evaluo

        Object retornoif = visit(ctx.ifblck());
        if (retornoif instanceof Excepcion) return retornoif;

        return (boolean) retornoif;
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
        if (retorno instanceof Excepcion) {
            ((Excepcion) retorno).setFilaColumna(ctx.expr().getStart().getLine(), ctx.expr().getStart().getCharPositionInLine());
            return retorno;
        }

        Simbolo simbolo = (Simbolo) retorno;
        if (simbolo.getTipo() != TipoSimbolo.BOOLEAN) {
            int fila = ctx.expr().getStart().getLine(), columna = ctx.expr().getStart().getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Se esperaba un valor booleano.", fila, columna);
            return excepcion;
        }

        if ((boolean) simbolo.getValor()) {
            global = new Entorno(global);

            Object instruccionesRetorno = visit(ctx.linstrucciones());
            if (instruccionesRetorno instanceof Instruccion) return instruccionesRetorno;

            global = global.getPadre();
        }

        return (boolean) simbolo.getValor();
    }

    // ------------------------ impresion
    public Object visitPrint(GramaticaParser.PrintContext ctx) {
        visit(ctx.printexps());
        imprimirEnConsola("\n");
        return true;
    }

    public Object visitExprPrint(GramaticaParser.ExprPrintContext ctx) {
        Object retorno = visit(ctx.expr());
        if (retorno instanceof Excepcion) {
            listaExcepciones.add((Excepcion) retorno);
            return true;
        }

        Simbolo simbolo = (Simbolo) retorno;
        String valor = simbolo.toStringValor();
        imprimirEnConsola(valor + ' ');
        return true;
    }

    public Object visitStringExpr(GramaticaParser.StringExprContext ctx) {
        String valor = ctx.STRING().getText();
        valor = valor.substring(1, valor.length() - 1);

        imprimirEnConsola(valor + ' ');
        return true;
    }

    // ------------------------ declaraciones
    public Object declaracionNuevaVariable(String nombre, Simbolo simbolo, TipoSimbolo tipo) {
        if (simbolo != null) {
            if (simbolo.getTipo() != tipo) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de dato diferente en declaracion, se esperaba: " + tipo.name().toLowerCase(), 0, 0);
                return excepcion;
            }
            if (!global.nuevoSimbolo(nombre, simbolo)) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Existe una variable " + nombre, 0, 0);
                return excepcion;
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
                Simbolo nuevoSimbolo = new Simbolo(TipoSimbolo.COMPLEX, valor);
                global.nuevoSimbolo(nombre, nuevoSimbolo);
            } else if (tipo == TipoSimbolo.CHAR) {
                simbolo = new Simbolo(TipoSimbolo.CHAR, "");
                global.nuevoSimbolo(nombre, simbolo);
            } else if (tipo == TipoSimbolo.LOGICAL) {
                simbolo = new Simbolo(TipoSimbolo.LOGICAL, false);
                global.nuevoSimbolo(nombre, simbolo);
            } else {
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

        return tipo;
    }

    public Object visitDclfirst(GramaticaParser.DclfirstContext ctx) {
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
        Object simbolo = (Object) visit(ctx.right);

        if (simbolo instanceof Excepcion) return simbolo;

        Simbolo derecho = (Simbolo) simbolo;

        Object retorno = evaluarOperacionUnitaria(derecho, operador);
        if (retorno instanceof Excepcion) {
            int fila = ctx.right.getStart().getLine(), columna = ctx.right.getStart().getCharPositionInLine();
            ((Excepcion) retorno).setFilaColumna(fila, columna);
        }

        return retorno;
    }

    public Object evaluarOperacionUnitaria(Simbolo simbolo, String operacion) {
        operacion = operacion.toLowerCase();
        if (operacion.equals(".not.")) {
            if (simbolo.getTipo() != TipoSimbolo.BOOLEAN) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de operacion no valida", 0, 0);
                return excepcion;
            }
            boolean valor = (boolean) simbolo.getValor();
            simbolo.setValor(!valor);
        } else {
            if (simbolo.getTipo() == TipoSimbolo.REAL) {
                double valor = (double) simbolo.getValor();
                simbolo.setValor(-valor);
            } else if (simbolo.getTipo() == TipoSimbolo.INT) {
                int valor = (int) simbolo.getValor();
                simbolo.setValor(-valor);
            } else if (simbolo.getTipo() == TipoSimbolo.COMPLEX) {
                Simbolo contenido[] = (Simbolo[]) simbolo.getValor();

                Simbolo resultado1 = (Simbolo) evaluarOperacionUnitaria(contenido[0], "-");
                Simbolo resultado2 = (Simbolo) evaluarOperacionUnitaria(contenido[1], "-");

                contenido = new Simbolo[]{resultado1, resultado2};
                simbolo.setValor(contenido);
            } else {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de operacion no valida", 0, 0);
                return excepcion;
            }
        }
        return simbolo;
    }

    public Object evaluarOperacion(Simbolo izquierda, Simbolo derecha, String operacion) {
        operacion = operacion.toLowerCase();
        switch (operacion) {
            case "*": {
                if (izquierda.getTipo() == TipoSimbolo.INT && derecha.getTipo() == TipoSimbolo.INT) {
                    int result = (int) izquierda.getValor() * (int) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.INT, result);
                    return simbolo;
                } else if ((izquierda.getTipo() == TipoSimbolo.REAL && (derecha.getTipo() == TipoSimbolo.REAL || derecha.getTipo() == TipoSimbolo.INT)) ||
                        (derecha.getTipo() == TipoSimbolo.REAL && (izquierda.getTipo() == TipoSimbolo.REAL || izquierda.getTipo() == TipoSimbolo.INT))) {
                    double result = (double) izquierda.getValor() * (double) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.REAL, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.COMPLEX && izquierda.getTipo() == TipoSimbolo.COMPLEX) {
                    Simbolo real[] = (Simbolo[]) izquierda.getValor();
                    Simbolo imaginario[] = (Simbolo[]) derecha.getValor();

                    Simbolo resultado1 = (Simbolo) evaluarOperacion(real[0], imaginario[0], "*");
                    Simbolo resultado2 = (Simbolo) evaluarOperacion(real[1], imaginario[1], "*");

                    Simbolo resultados[] = {resultado1, resultado2};
                    Simbolo simbolo = new Simbolo(TipoSimbolo.COMPLEX, resultados);
                    return simbolo;
                }
            }
            case "/": {
                if (izquierda.getTipo() == TipoSimbolo.COMPLEX && izquierda.getTipo() == TipoSimbolo.COMPLEX) {
                    Simbolo real[] = (Simbolo[]) izquierda.getValor();
                    Simbolo imaginario[] = (Simbolo[]) derecha.getValor();

                    Simbolo resultado1 = (Simbolo) evaluarOperacion(real[0], imaginario[0], "/");
                    Simbolo resultado2 = (Simbolo) evaluarOperacion(real[1], imaginario[1], "/");

                    Simbolo resultados[] = {resultado1, resultado2};
                    Simbolo simbolo = new Simbolo(TipoSimbolo.COMPLEX, resultados);
                    return simbolo;
                }

                if ((Integer) derecha.getValor() == 0 ) {
                    Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Division entre 0", 0, 0);
                    return excepcion;
                }

                if (izquierda.getTipo() == TipoSimbolo.INT && derecha.getTipo() == TipoSimbolo.INT) {
                    int result = (int) izquierda.getValor() / (int) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.INT, result);
                    return simbolo;
                } else if ((izquierda.getTipo() == TipoSimbolo.REAL && (derecha.getTipo() == TipoSimbolo.REAL || derecha.getTipo() == TipoSimbolo.INT)) ||
                        (derecha.getTipo() == TipoSimbolo.REAL && (izquierda.getTipo() == TipoSimbolo.REAL || izquierda.getTipo() == TipoSimbolo.INT))) {
                    double result = (double) izquierda.getValor() / (double) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.REAL, result);
                    return simbolo;
                }
            }
            case "+": {
                if (izquierda.getTipo() == TipoSimbolo.INT && derecha.getTipo() == TipoSimbolo.INT) {
                    int result = (int) izquierda.getValor() + (int) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.INT, result);
                    return simbolo;
                } else if ((izquierda.getTipo() == TipoSimbolo.REAL && (derecha.getTipo() == TipoSimbolo.REAL || derecha.getTipo() == TipoSimbolo.INT)) ||
                        (derecha.getTipo() == TipoSimbolo.REAL && (izquierda.getTipo() == TipoSimbolo.REAL || izquierda.getTipo() == TipoSimbolo.INT))) {
                    double result = (double) izquierda.getValor() + (double) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.REAL, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.COMPLEX && izquierda.getTipo() == TipoSimbolo.COMPLEX) {
                    Simbolo real[] = (Simbolo[]) izquierda.getValor();
                    Simbolo imaginario[] = (Simbolo[]) derecha.getValor();

                    Simbolo resultado1 = (Simbolo) evaluarOperacion(real[0], imaginario[0], "+");
                    Simbolo resultado2 = (Simbolo) evaluarOperacion(real[1], imaginario[1], "+");

                    Simbolo resultados[] = {resultado1, resultado2};
                    Simbolo simbolo = new Simbolo(TipoSimbolo.COMPLEX, resultados);
                    return simbolo;
                }
            }
            case "-": {
                if (izquierda.getTipo() == TipoSimbolo.INT && derecha.getTipo() == TipoSimbolo.INT) {
                    int result = (int) izquierda.getValor() - (int) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.INT, result);
                    return simbolo;
                } else if ((izquierda.getTipo() == TipoSimbolo.REAL && (derecha.getTipo() == TipoSimbolo.REAL || derecha.getTipo() == TipoSimbolo.INT)) ||
                        (derecha.getTipo() == TipoSimbolo.REAL && (izquierda.getTipo() == TipoSimbolo.REAL || izquierda.getTipo() == TipoSimbolo.INT))) {
                    double result = (double) izquierda.getValor() - (double) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.REAL, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.COMPLEX && izquierda.getTipo() == TipoSimbolo.COMPLEX) {
                    Simbolo real[] = (Simbolo[]) izquierda.getValor();
                    Simbolo imaginario[] = (Simbolo[]) derecha.getValor();

                    Simbolo resultado1 = (Simbolo) evaluarOperacion(real[0], imaginario[0], "-");
                    Simbolo resultado2 = (Simbolo) evaluarOperacion(real[1], imaginario[1], "-");

                    Simbolo resultados[] = {resultado1, resultado2};
                    Simbolo simbolo = new Simbolo(TipoSimbolo.COMPLEX, resultados);
                    return simbolo;
                }
            }
            case "**": {
                if (izquierda.getTipo() == TipoSimbolo.INT && derecha.getTipo() == TipoSimbolo.INT) {
                    int result = (int) Math.pow((int) izquierda.getValor(), (int) derecha.getValor());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.INT, result);
                    return simbolo;
                } else if ((izquierda.getTipo() == TipoSimbolo.REAL && (derecha.getTipo() == TipoSimbolo.REAL || derecha.getTipo() == TipoSimbolo.INT)) ||
                        (derecha.getTipo() == TipoSimbolo.REAL && (izquierda.getTipo() == TipoSimbolo.REAL || izquierda.getTipo() == TipoSimbolo.INT))) {
                    double result = Math.pow((double) izquierda.getValor(), (double) derecha.getValor());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.REAL, result);
                    return simbolo;
                }
            }
            case "==":
            case ".eq.": {
                if ((izquierda.getTipo() == TipoSimbolo.INT || izquierda.getTipo() == TipoSimbolo.REAL) &&
                        (derecha.getTipo() == TipoSimbolo.INT || derecha.getTipo() == TipoSimbolo.REAL)) {
                    boolean result = izquierda.getValor().toString().equals(derecha.getValor().toString());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.BOOLEAN && izquierda.getTipo() == TipoSimbolo.BOOLEAN) {
                    boolean result = (boolean) izquierda.getValor() == (boolean) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.CHAR && izquierda.getTipo() == TipoSimbolo.CHAR) {
                    boolean result = (boolean) izquierda.getValor().equals((String) derecha.getValor());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.COMPLEX && izquierda.getTipo() == TipoSimbolo.COMPLEX) {
                    Simbolo real[] = (Simbolo[]) izquierda.getValor();
                    Simbolo imaginario[] = (Simbolo[]) derecha.getValor();

                    Simbolo resultado1 = (Simbolo) evaluarOperacion(real[0], imaginario[0], "==");
                    Simbolo resultado2 = (Simbolo) evaluarOperacion(real[1], imaginario[1], "==");

                    boolean result = (boolean) resultado1.getValor() && (boolean) resultado2.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            case "/=":
            case ".ne.": {
                if ((izquierda.getTipo() == TipoSimbolo.INT || izquierda.getTipo() == TipoSimbolo.REAL) &&
                        (derecha.getTipo() == TipoSimbolo.INT || derecha.getTipo() == TipoSimbolo.REAL)) {
                    boolean result = !(izquierda.getValor().toString().equals(derecha.getValor().toString()));
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.BOOLEAN && izquierda.getTipo() == TipoSimbolo.BOOLEAN) {
                    boolean result = (boolean) izquierda.getValor() != (boolean) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.CHAR && izquierda.getTipo() == TipoSimbolo.CHAR) {
                    boolean result = (boolean) izquierda.getValor().equals((String) derecha.getValor());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, !result);
                    return simbolo;
                } else if (izquierda.getTipo() == TipoSimbolo.COMPLEX && izquierda.getTipo() == TipoSimbolo.COMPLEX) {
                    Simbolo real[] = (Simbolo[]) izquierda.getValor();
                    Simbolo imaginario[] = (Simbolo[]) derecha.getValor();

                    Simbolo resultado1 = (Simbolo) evaluarOperacion(real[0], imaginario[0], "/=");
                    Simbolo resultado2 = (Simbolo) evaluarOperacion(real[1], imaginario[1], "/=");

                    boolean result = (boolean) resultado1.getValor() || (boolean) resultado2.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            case ">":
            case ".gt.": {
                if ((izquierda.getTipo() == TipoSimbolo.INT || izquierda.getTipo() == TipoSimbolo.REAL) &&
                        (derecha.getTipo() == TipoSimbolo.INT || derecha.getTipo() == TipoSimbolo.REAL)) {
                    boolean result = Double.valueOf(izquierda.getValor().toString()) > Double.valueOf(derecha.getValor().toString());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            case ">=":
            case ".ge.": {
                if ((izquierda.getTipo() == TipoSimbolo.INT || izquierda.getTipo() == TipoSimbolo.REAL) &&
                        (derecha.getTipo() == TipoSimbolo.INT || derecha.getTipo() == TipoSimbolo.REAL)) {
                    boolean result = Double.valueOf(izquierda.getValor().toString()) >= Double.valueOf(derecha.getValor().toString());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            case "<":
            case ".lt.": {
                if ((izquierda.getTipo() == TipoSimbolo.INT || izquierda.getTipo() == TipoSimbolo.REAL) &&
                        (derecha.getTipo() == TipoSimbolo.INT || derecha.getTipo() == TipoSimbolo.REAL)) {
                    boolean result = Double.valueOf(izquierda.getValor().toString()) < Double.valueOf(derecha.getValor().toString());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            case "<=":
            case ".le.": {
                if ((izquierda.getTipo() == TipoSimbolo.INT || izquierda.getTipo() == TipoSimbolo.REAL) &&
                        (derecha.getTipo() == TipoSimbolo.INT || derecha.getTipo() == TipoSimbolo.REAL)) {
                    boolean result = Double.valueOf(izquierda.getValor().toString()) <= Double.valueOf(derecha.getValor().toString());
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            // logicas
            case ".eqv.":
            case ".and.": {
                if (izquierda.getTipo() == TipoSimbolo.BOOLEAN && derecha.getTipo() == TipoSimbolo.BOOLEAN) {
                    boolean result = (boolean) izquierda.getValor() && (boolean) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            case ".neqv.":
            case ".or.": {
                if (izquierda.getTipo() == TipoSimbolo.BOOLEAN && derecha.getTipo() == TipoSimbolo.BOOLEAN) {
                    boolean result = (boolean) izquierda.getValor() || (boolean) derecha.getValor();
                    Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, result);
                    return simbolo;
                }
            }
            default: {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo de operacion no valida", 0, 0);
                return excepcion;
            }
        }
    }

    public Object visitOpExpr(GramaticaParser.OpExprContext ctx) {
        Object izquierda = (Object) visit(ctx.left);
        Object derecha = (Object) visit(ctx.right);
        String operacion = ctx.op.getText();

        if (izquierda instanceof Excepcion) {
            int fila = ctx.left.getStart().getLine(), columna = ctx.left.getStart().getCharPositionInLine();
            ((Excepcion) izquierda).setFilaColumna(fila, columna);
            return izquierda;
        }
        if (derecha instanceof Excepcion) {
            int fila = ctx.left.getStart().getLine(), columna = ctx.left.getStart().getCharPositionInLine();
            ((Excepcion) derecha).setFilaColumna(fila, columna);
            return derecha;
        }

        Object evaluacion = evaluarOperacion((Simbolo) izquierda, (Simbolo) derecha, operacion);
        if (evaluacion instanceof Excepcion) {
            int fila = ctx.left.getStart().getLine(), columna = ctx.left.getStart().getCharPositionInLine();
            ((Excepcion) evaluacion).setFilaColumna(fila, columna);
        }
        return evaluacion;
    }

    // ------------------------ simbolos primitivos

    public Object visitIdenExpr(GramaticaParser.IdenExprContext ctx) {
        Simbolo simbolo = global.buscar(ctx.id.getText());

        if (simbolo == null) {
            int fila = ctx.id.getLine(), columna = ctx.id.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Variable no encontrada: " + ctx.id.getText(), fila, columna);
            return excepcion;
        }

        return simbolo;
    }

    public Object visitComplexExpr(GramaticaParser.ComplexExprContext ctx) {
        Object retorno1 = visit(ctx.re);
        Object retorno2 = visit(ctx.im);

        if (retorno1 instanceof Excepcion) return retorno1;
        if (retorno2 instanceof Excepcion) return retorno2;

        Simbolo real = (Simbolo) retorno1;
        Simbolo imaginario = (Simbolo) retorno2;

        if (!(real.getTipo() == TipoSimbolo.INT || real.getTipo() == TipoSimbolo.REAL)) {
            int fila = ctx.re.start.getLine(), columna = ctx.re.start.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo no valido en complex", fila, columna);
            return excepcion;
        }

        if (!(imaginario.getTipo() == TipoSimbolo.INT || imaginario.getTipo() == TipoSimbolo.REAL)) {
            int fila = ctx.im.start.getLine(), columna = ctx.im.start.getCharPositionInLine();
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Tipo no valido en complex", fila, columna);
            return excepcion;
        }

        Simbolo valor[] = {real, imaginario};
        Simbolo simbolo = new Simbolo(TipoSimbolo.COMPLEX, valor);
        return simbolo;
    }

    public Object visitBoolExpr(GramaticaParser.BoolExprContext ctx) {
        boolean valor = ctx.bool.getText().equals(".true.") ? true : false;
        Simbolo simbolo = new Simbolo(TipoSimbolo.BOOLEAN, valor);
        return simbolo;
    }

    public Object visitCharExpr(GramaticaParser.CharExprContext ctx) {
        String valor = ctx.char_.getText();
        valor = valor.substring(1, valor.length() - 1);
        Simbolo simbolo = new Simbolo(TipoSimbolo.CHAR, valor);
        return simbolo;
    }

    public Object visitRealExpr(GramaticaParser.RealExprContext ctx) {
        double valor = Double.parseDouble(ctx.real.getText());
        Simbolo simbolo = new Simbolo(TipoSimbolo.REAL, valor);
        return simbolo;
    }

    public Object visitAtomExpr(GramaticaParser.AtomExprContext ctx) {
        int valor = Integer.parseInt(ctx.atom.getText());
        Simbolo simbolo = new Simbolo(TipoSimbolo.INT, valor);
        return simbolo;
    }


    public Object visitParenExpr(GramaticaParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

}

