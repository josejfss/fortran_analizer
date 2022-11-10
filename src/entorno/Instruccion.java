package entorno;



public class Instruccion {
    TipoInstruccion tipo = null;
    String entorno = null;

    public Instruccion(TipoInstruccion tipo, String entorno) {
        this.tipo = tipo;
        this.entorno = entorno;
    }

    public Instruccion(TipoInstruccion tipo) {
        this.tipo = tipo;
    }

    public enum TipoInstruccion {
        EXIT,
        CYCLE
    }

    public TipoInstruccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstruccion tipo) {
        this.tipo = tipo;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }
}
