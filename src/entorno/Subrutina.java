package entorno;

import java.util.ArrayList;
import java.util.HashMap;

public class Subrutina {
    ArrayList<String> listaNombreParametros = null;
    // a, b, c, d
    HashMap<String, TipoSimbolo> dclParametros = null;
    // <a, INT>, <b, INT>, <c, INT>, <d, INT>,
    Object linstrucciones;
    String retorno = null;
    // result ( x )

    public Subrutina(ArrayList<String> listaNombreParametros, HashMap<String, TipoSimbolo> dclParametros, Object linstrucciones) {
        this.listaNombreParametros = listaNombreParametros;
        this.dclParametros = dclParametros;
        this.linstrucciones = linstrucciones;
    }

    public Subrutina(ArrayList<String> listaNombreParametros, HashMap<String, TipoSimbolo> dclParametros, Object linstrucciones, String retorno) {
        this.listaNombreParametros = listaNombreParametros;
        this.dclParametros = dclParametros;
        this.linstrucciones = linstrucciones;
        this.retorno = retorno;
    }

    public ArrayList<String> getListaNombreParametros() {
        return listaNombreParametros;
    }

    public void setListaNombreParametros(ArrayList<String> listaNombreParametros) {
        this.listaNombreParametros = listaNombreParametros;
    }

    public HashMap<String, TipoSimbolo> getDclParametros() {
        return dclParametros;
    }

    public void setDclParametros(HashMap<String, TipoSimbolo> dclParametros) {
        this.dclParametros = dclParametros;
    }

    public Object getLinstrucciones() {
        return linstrucciones;
    }

    public void setLinstrucciones(Object linstrucciones) {
        this.linstrucciones = linstrucciones;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
}
