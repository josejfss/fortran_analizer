package entorno;

import Graficador.Graficador;

import java.util.ArrayList;

public class ReporteSimbolo {

    public void GenerarReporteSimbolo(Entorno ent){
        String dot = "digraph G { \n" +
                "  fontname=\"Helvetica,Arial,sans-serif\"\n" +
                "  node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                "  edge [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                " tbl[ shape=plaintext label=< <TABLE >" +
                "  <TR>\n" +
                "  <TD>Identificador</TD>\n" +
                "  <TD>Valor</TD>\n" +
                "  <TD>Tipo</TD>\n" +
                "  <TD>Rol</TD>\n" +
                "  </TR>";


        for (Entorno actual = ent; ent != null; ent = ent.getPadre()) { //for para entornos

            for (String clave:ent.getTablaSimbolo().keySet()) {  //For para recorrer el hashmap de simbolos
                dot += "<TR> \n" +
                        "<TD>" + clave + "</TD>\n" +
                        "  <TD> " + ent.getTablaSimbolo().get(clave).toStringValor() + "</TD>\n" +
                        "  <TD>" +  ent.getTablaSimbolo().get(clave).getTipo().name().toUpperCase()+ "</TD>\n" +
                        "  <TD>" +  ent.getTablaSimbolo().get(clave).getRol().name().toUpperCase()+ "</TD>\n" +
                        "  </TR>";
            }
        }

        dot += "</TABLE>>];\n}" ;

        Graficador graf = new Graficador(); //Instancia de clase
        graf.CrearDot(dot, "ReporteSimbolo.dot"); //Creamos el documento .dot para el reporte
        graf.graficar("ReporteSimbolo.dot", "ReporteSimbolo.svg"); //Creamos la imagen
    }
}
