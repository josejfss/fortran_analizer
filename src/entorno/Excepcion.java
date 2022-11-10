package entorno;

public class Excepcion {
    public TipoExcepcion tipo;
    public String descripcion;
    public int fila, columna;

    public Excepcion(TipoExcepcion tipo, String descripcion, int fila, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Excepcion:" +
                "tipo=" + toStringTipo(tipo) +

                ", descripcion='" + descripcion + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                '}';
    }

    public static String toStringTipo(TipoExcepcion tipo) {
        if (tipo == TipoExcepcion.LEXICO) {
            return "léxica";
        } else if (tipo == TipoExcepcion.SEMANTICO) {
            return "semántica";
        } else if (tipo == TipoExcepcion.SINTACTICO) {
            return "sintáctica";
        }
        return "";
    }

    public void setFilaColumna(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public TipoExcepcion getTipo() {
        return tipo;
    }

    public void setTipo(TipoExcepcion tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
