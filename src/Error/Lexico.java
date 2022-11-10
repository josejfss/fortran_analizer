package Error;

import Graficador.Graficador;
import entorno.Excepcion;
import entorno.TipoExcepcion;
import gramatica.GramaticaLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lexico extends BaseErrorListener {

    private  ArrayList<Excepcion> error = new ArrayList<>();

    //Genera el dot para el reporte de errores
    public void GenerarReporteError(ArrayList<Excepcion> err){

        String dot = "digraph G { \n" +
                "  fontname=\"Helvetica,Arial,sans-serif\"\n" +
                "  node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                "  edge [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                " tbl[ shape=plaintext label=< <TABLE >" +
                "  <TR>\n" +
                "  <TD>Tipo Error</TD>\n" +
                "  <TD>Descripcion</TD>\n" +
                "  <TD>Fila</TD>\n" +
                "  <TD>Columna</TD>\n" +
                "  </TR>";

        for (Excepcion exec: err) { //recorremos el array list de errores
            dot += "<TR> \n" +
                    "<TD>" + Excepcion.toStringTipo(exec.tipo) + "</TD>\n" +
                    "  <TD> " + exec.getDescripcion() + "</TD>\n" +
                    "  <TD>" + exec.getFila() + "</TD>\n" +
                    "  <TD>" + exec.getColumna() + "</TD>\n" +
                    "  </TR>";
        }
        dot += "</TABLE>>];\n}" ;

        Graficador graf = new Graficador(); //Instancia de clase
        graf.CrearDot(dot, "ReporteError.dot"); //Creamos el documento .dot para el reporte
        graf.graficar("ReporteError.dot", "ReporteError.svg"); //Creamos la imagen
    }

    public ArrayList<Excepcion> getError() {
        return error;
    }

    public void setError(ArrayList<Excepcion> error) {
        this.error = error;
    }

    public static Lexico INSTANCE = new Lexico(); //Instancia de la clase

    // Metodo que obtiene los errores léxicos y sintacticos
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {

        if (recognizer.getClass() == GramaticaLexer.class){
            error.add(new Excepcion(TipoExcepcion.LEXICO, msg, line, charPositionInLine));
        }else{
            error.add(new Excepcion(TipoExcepcion.SINTACTICO, msg, line, charPositionInLine));
        }

    }
}