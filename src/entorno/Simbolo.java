package entorno;

import Graficador.ControllerAST;
import Graficador.SimboloAST;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Simbolo {
    private TipoSimbolo tipo;

    private Object valor;

    private RolSimbolo rol;
    private int posicion;

    public String tipo3d;

    public String etiquetaV;
    public String etiquetaF;
    //private String
    public String etiquetaSalida;

    public SimboloAST simboloAST;

    public Simbolo(TipoSimbolo tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.rol = RolSimbolo.VARIABLE;
    }

    /**
     * Simbolo para crear 3D
     * @param tipo
     * @param valor
     * @param _tipo3d
     */
    public Simbolo(TipoSimbolo tipo, Object valor,String _tipo3d) {
        this.tipo = tipo;
        this.tipo3d = _tipo3d;
        this.valor = valor;
    }

    public Simbolo(TipoSimbolo tipo, Object valor,String _tipo3d,String etiquetaV,String etiquetaF) {
        this.tipo = tipo;
        this.tipo3d = _tipo3d;
        this.valor = valor;
        this.etiquetaV = etiquetaV;
        this.etiquetaF = etiquetaF;
    }

    public Simbolo(TipoSimbolo tipo, Object valor,String _tipo3d,String etiquetaV,String etiquetaF, String etiquetaSalida) {
        this.tipo = tipo;
        this.tipo3d = _tipo3d;
        this.valor = valor;
        this.etiquetaV = etiquetaV;
        this.etiquetaF = etiquetaF;
        this.etiquetaSalida = etiquetaSalida;
    }


    public Simbolo(TipoSimbolo tipo, Object valor, RolSimbolo rol) {
        this.tipo = tipo;
        this.valor = valor;
        this.rol = rol;
    }

    public String toStringValor() {
        if (tipo == TipoSimbolo.BOOLEAN) {
            if ((boolean) valor) return "T";
            else return "F";
        } else if (rol == RolSimbolo.ARREGLO || rol == RolSimbolo.ARREGLODINAMICO) {
            Arreglo arreglo = (Arreglo) valor;
            return toStringArray(arreglo.getContenido());
        } else if (tipo == TipoSimbolo.INT || tipo == TipoSimbolo.CHAR || tipo == TipoSimbolo.REAL) {
            return valor.toString();
        } else if (tipo == TipoSimbolo.COMPLEX) {
            Simbolo[] resultado = (Simbolo[]) valor;
            return "(" + resultado[0].toStringValor() + "," + resultado[1].toStringValor() + ")";
        }
        return "";
    }


    public static String toStringArray(ArrayList<Object> arreglo) {
        String retorno = "";

        for (int i = 0; i < arreglo.size(); i++) {
            try {
                if (arreglo.get(i) instanceof ArrayList) {
                    retorno += toStringArray((ArrayList<Object>) arreglo.get(i)) + " ";
                    continue;
                } else if (arreglo.get(i) instanceof Simbolo) {
                    Simbolo iteracion = (Simbolo) arreglo.get(i);
                    retorno += iteracion.toStringValor() + " ";
                    continue;
                }
            } catch (Exception e) {
            }
            retorno += arreglo.get(i).toString() + " ";
//            retorno += "[NULL]" + " ";
        }

        return retorno ;
    }

    /**
     * Devolver el tipo para codigo de 3 direcciones
     * @return String IDSTR or IDFLOAT
     */
    public String toStringTipo(){

        if(tipo == TipoSimbolo.BOOLEAN){
            return "IDBOOLEAN";
        }else if (  tipo == TipoSimbolo.INT){
            return "IDFLOAT";
        }else if( tipo == TipoSimbolo.CHAR){
            return  "IDCHAR";
        }else if(tipo == TipoSimbolo.REAL  ) {
            return "IDFLOAT";
        }else if(tipo == TipoSimbolo.COMPLEX){
            return "IDCOMPLEX";
        }
        return "IDSTR";
    }

    public TipoSimbolo getTipo() {
        return tipo;
    }

    public void setTipo(TipoSimbolo tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public RolSimbolo getRol() {
        return rol;
    }

    public void setRol(RolSimbolo rol) {
        this.rol = rol;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    //Para obtener el tipo de dato del simbolo
    public String _toStringTipo(){
        if(tipo == TipoSimbolo.BOOLEAN){
           return "Logical";
        } else if (  tipo == TipoSimbolo.INT){
            return "Integer";
        }else if( tipo == TipoSimbolo.CHAR){
            return  "Character";
        }else if(tipo == TipoSimbolo.REAL  ) {
            return "Real";
        }else if(tipo == TipoSimbolo.COMPLEX){
            return "Complex";
        }
        return "";
    }

    public SimboloAST getSimboloAST() {
        return simboloAST;
    }

    public void setSimboloAST(SimboloAST simboloAST) {
        this.simboloAST = simboloAST;
    }
}
