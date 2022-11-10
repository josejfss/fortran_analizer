package entorno;

import java.util.ArrayList;

public class Arreglo {
    int numeroDimensiones = -1;
    int dimensiones[] = null;
    int tamanio = -1;
    ArrayList<Object> contenido = null;


    public Arreglo(int[] dimensiones) {
        this.dimensiones = dimensiones;
        inicializacion();
    }

    public Arreglo(int numeroDimensiones) {
        this.numeroDimensiones = numeroDimensiones;
    }

    public void inicializacion() {
        this.tamanio = 1;
        contenido = new ArrayList<>();
        this.numeroDimensiones = dimensiones.length;

        for (int dimension : dimensiones) {
            this.tamanio *= dimension;
        }
        for (int i = 0; i < tamanio; i++) {
            contenido.add(0);
        }
    }

    public void inicio(){
        contenido = new ArrayList<>();
    }

    public void setDimensiones(int[] dimensiones) {
        this.dimensiones = dimensiones;
        if (dimensiones == null) {
            tamanio = -1;
            numeroDimensiones = -1;
        }else inicializacion();
    }

    public Object setElement(int[] dim, Object elemento) {
        Object dimensionRetorno = obtenerDimension(dim);
        if (dimensionRetorno instanceof Excepcion) return dimensionRetorno;

        int dimension = (int) dimensionRetorno;

        contenido.set(dimension, elemento);
        return true;
    }

    public Object getElement(int[] dim) {
        Object dimensionRetorno = obtenerDimension(dim);
        if (dimensionRetorno instanceof Excepcion) return dimensionRetorno;

        int dimension = (int) dimensionRetorno;

        return contenido.get(dimension);
    }

    public Object obtenerDimension(int[] dim) {
        if (dimensiones == null) {
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                    "Arreglo no inicializado, no cuenta con dimensiones", 0, 0);
            return excepcion;
        }

        int dimensionBuscada = 0;

        for (int i = 0; i < dim.length; i++) {
            if (dim[i] > dimensiones[i]) {
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "Acceso a arreglo fuera de rango: " + dim[i] + " tamanio: " + dimensiones[i], 0, 0);
                return excepcion;
            }
            if (i == 0) dimensionBuscada += dim[i] - 1;
            else dimensionBuscada = dimensionBuscada * dimensiones[i] + dim[i] - 1;
        }
        return dimensionBuscada;
    }

    public Object comprobacionDimensiones(int dimensionEvaluada, ArrayList<Object> arreglo, TipoSimbolo tipo){
        if (arreglo.size() != dimensiones[dimensionEvaluada]){
            Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO, "No coinciden las dimensiones evaluadas", 0, 0);
            return excepcion;
        }

        for (int i = 0; i < arreglo.size(); i++) {
                if (arreglo.get(i) instanceof ArrayList) {
                    Object dimension = comprobacionDimensiones(dimensionEvaluada+1, (ArrayList<Object>) arreglo.get(i), tipo);
                    if (dimension instanceof Excepcion) return dimension;
                } else {
                    Simbolo iteracion = (Simbolo) arreglo.get(i);
                    if (iteracion.getTipo() != tipo){
                        Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,
                                "Hay un valor de diferente en tipo en asignacion de dimensiones a arreglos" + iteracion.getTipo().name().toLowerCase() + " se esperaba: " + tipo.name().toLowerCase(),
                                0, 0);
                        return excepcion;
                    }
                }
        }

        return true;
    }

    public void llenadoDeArreglo(ArrayList<Object> arreglo){
        for (int i = 0; i < arreglo.size(); i++) {
                if (arreglo.get(i) instanceof ArrayList) {
                    llenadoDeArreglo((ArrayList<Object>) arreglo.get(i));
                } else {
                    Simbolo iteracion = (Simbolo) arreglo.get(i);
                    contenido.add(iteracion);
                }
        }
    }

    public int getNumeroDimensiones() {
        return numeroDimensiones;
    }

    public void setNumeroDimensiones(int numeroDimensiones) {
        this.numeroDimensiones = numeroDimensiones;
    }

    public int[] getDimensiones() {
        return dimensiones;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public ArrayList<Object> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<Object> contenido) {
        this.contenido = contenido;
    }
}
