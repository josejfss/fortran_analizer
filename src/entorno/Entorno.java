package entorno;

import java.util.HashMap;
import java.util.Locale;

public class Entorno {
    private HashMap<String, Simbolo> tablaSimbolo;
    private Entorno padre;
    private Entorno siguiente;
    private String nombre;
    public int ultPosicion;

    public Entorno(Entorno padre) {

        this.padre = padre;
        tablaSimbolo = new HashMap<String, Simbolo>();
        this.padre.siguiente = this;
        this.siguiente = null;
        this.ultPosicion = 0;
    }

    public Entorno() {
        this.padre = null;
        tablaSimbolo = new HashMap<String, Simbolo>();
        this.siguiente = null;
        this.ultPosicion = 0;
    }

    public boolean nuevoSimbolo(String nombre, Simbolo simbolo) {

        if (tablaSimbolo.containsKey(nombre.toUpperCase())) {
            return false;
        }
        /**
         * Guardando la posicion del simbolo dentro de la tabla de simbolos
         */
        simbolo.setPosicion(this.ultPosicion);
        this.ultPosicion++;
        tablaSimbolo.put(nombre.toUpperCase(), simbolo);
        return true;
    }

    public Simbolo buscar(String nombre) {
        for (Entorno ent = this; ent != null; ent = ent.padre) {
            if (ent.tablaSimbolo.containsKey(nombre.toUpperCase()))
                return ent.tablaSimbolo.get(nombre.toUpperCase());
        }
        return null;
    }

    /**
     * Retornar el size de los entornos anteriores al actual
     * @return int  tamaño todas la tablas de simbolos
     * @since 0.0.1
     */
    public int getPrevSizes()
    {
        int size = 0;
        for (Entorno ent = this.padre; ent != null; ent = ent.padre)
            size += ent.tablaSimbolo.size();

        return size;
    }

    public Object actualizarSimbolo(String nombre, Simbolo simbolo) {
        for (Entorno ent = this; ent != null; ent = ent.padre) {
            if (ent.tablaSimbolo.containsKey(nombre.toUpperCase())) {
                Simbolo anterior = ent.tablaSimbolo.get(nombre.toUpperCase());
                if (anterior.getTipo() == simbolo.getTipo()){
                    ent.tablaSimbolo.put(nombre.toUpperCase(), simbolo);
                    return true;
                }
                Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,"Tipo de dato diferente en asignacion a " + nombre + ", se esperaba: " + anterior.getTipo().name().toLowerCase(),0,0);
                return excepcion;
            }
        }
        Excepcion excepcion = new Excepcion(TipoExcepcion.SEMANTICO,"Variable no encontrada: " + nombre,0,0);
        return excepcion;
    }



    public HashMap<String, Simbolo> getTablaSimbolo() {
        return tablaSimbolo;
    }

    public void setTablaSimbolo(HashMap<String, Simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }

    public Entorno getPadre() {
        return padre;
    }

    public void setPadre(Entorno padre) {
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entorno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Entorno siguiente) {
        this.siguiente = siguiente;
    }
}
