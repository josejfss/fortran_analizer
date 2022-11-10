package Graficador;

import entorno.TipoSimbolo;

public class SimboloAST {

    public Object valor;

    private TipoSimbolo tipo;


    public SimboloAST(Object _valor) {
        this.valor = _valor;
        this.tipo = null;
    }
    public SimboloAST(TipoSimbolo _tipo,Object _valor) {
        this.valor = _valor;
        this.tipo = _tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public TipoSimbolo getTipo(){
        return tipo;
    }
}






