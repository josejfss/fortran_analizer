package Graficador;

import entorno.Simbolo;
import entorno.TipoSimbolo;

import java.util.ArrayList;

public class ControllerAST {

    int cont;
    public ArrayList<String> codigoDot;

    private String relacion;
    public ControllerAST(){
        this.codigoDot = new ArrayList<>();
        this.cont = 0;
        this.relacion = "--";
    }

    private String generateTemporal(){
        String temp = "A" + this.cont + "\n";
        this.codigoDot.add(temp);
        this.cont++;
        return temp;
    }

    // temporal con label
    private String generateTemporal(String label){
        String temp = "A" + this.cont;

        this.codigoDot.add(temp + "[label=\""+label+"\"]\n");
        this.cont++;
        return temp;
    }

    /*public Simbolo generateRelation(Object _padre,Object _hijos){
        String padre = (String)_padre;
        Simbolo[] hijos = (Simbolo[]) _hijos;
        String temp_padre = this.generateTemporal(padre);
        for (Simbolo simbolo : hijos){

            if(simbolo.getTipo() == TipoSimbolo.AST){
                //Simbolo simbolo = (Simbolo)objeto;
                this.codigoDot.add(temp_padre + this.relacion + simbolo.getValor() + "\n");
            }else{
                //Simbolo simbolo = (Simbolo)objeto;
                String temp_hijo = this.generateTemporal(simbolo.toStringValor());
                this.codigoDot.add(temp_padre + this.relacion + temp_hijo + "\n");
            }

        }
        return new Simbolo(TipoSimbolo.AST,temp_padre);
    }*/

    public SimboloAST generateRelation(Object _izq,Object _padre,Object _der){

        String padre = (String)_padre;
        String temp_padre = this.generateTemporal(padre);
        if(_izq instanceof Simbolo) {
            Simbolo izq = (Simbolo)_izq;
            if(izq.getSimboloAST() != null){
                this.codigoDot.add(temp_padre + this.relacion + izq.getSimboloAST().getValor() + "\n");
            }else{
                String temp_izq = this.generateTemporal( izq.toStringValor());
                this.codigoDot.add(temp_padre + this.relacion + temp_izq + "\n");
            }
        }else{
            if(_izq instanceof String){
                String izq = (String)_izq;
                String temp_izq = this.generateTemporal(izq);
                this.codigoDot.add(temp_padre + this.relacion + temp_izq + "\n");
            }
        }
        // derecho
        if(_der instanceof Simbolo) {
            Simbolo der = (Simbolo)_der;
            if(der.getSimboloAST() != null){
                this.codigoDot.add(temp_padre + this.relacion + der.getSimboloAST().getValor() + "\n");
            }else{
                String temp_der = this.generateTemporal(der.toStringValor());
                this.codigoDot.add(temp_padre + this.relacion + temp_der + "\n");
            }
        }else{
            if(_der instanceof String){
                String der = (String)_der;
                String temp_der = this.generateTemporal(der);
                this.codigoDot.add(temp_padre + this.relacion + temp_der + "\n");
            }
        }

        return new SimboloAST(TipoSimbolo.AST,temp_padre);
    }





    public void setCodigoDot(ArrayList<String> codigoDot) {
        this.codigoDot = codigoDot;
    }


}
