package Graficador;

public class NodoAst {
    public String body;

    public String retorno;

    public Integer cont;

    public char[] abc;

    public Integer maxContEtiqueta;

    public Integer posicion; // posicion array abc

    public String etiqueta;

    public NodoAst izq;
    public NodoAst der;

    public NodoAst monitor;

    public String label;

    public NodoAst(NodoAst monitor,String label){
        this.izq = null;
        this.der = null;
        this.createArrayAbc();
        this.maxContEtiqueta = 100000;
        this.cont = 0;
        this.posicion = 0;
        this.retorno = "\n\r";
        this.body = "" + this.retorno;
        this.monitor = monitor;
        this.label = label;


        if(monitor == null){
            this.createArrayAbc();
        }else{
            this.create();
        }
    }

    private void aumentarContador(){
        this.cont++;
    }

    private void aumentarPosicion(){
        this.posicion++;
        this.cont = 0;
    }

    private Integer getContador(){
        return this.cont;
    }

    private Integer getPosicion(){
        if(this.cont <= 100000){
            return this.posicion;
        }else{
            this.aumentarPosicion();
            this.cont = 0;
            return this.posicion;
        }

    }

    private String crearEtiqueta(){
        String etiqueta = this.abc[this.getPosicion()] + this.getContador().toString();
        this.aumentarContador();
        return etiqueta;
    }

    private String getEtiqueta(){
        return this.etiqueta;
    }

    private void create(){
        this.etiqueta = this.monitor.crearEtiqueta();
        this.monitor.body += etiqueta + "[label=\"" + this.label + "\"];" + this.retorno;
    }

    public void setIzq(NodoAst nodo){
        //String padreEtiqueta = this.getEtiqueta();
        this.monitor.body += this.getEtiqueta() + " -- " + nodo.getEtiqueta() + ";" + this.retorno;

    }

    public void setDer(NodoAst nodo){
        //String padreEtiqueta = this.getEtiqueta();
        this.monitor.body += this.getEtiqueta() + " -- " + nodo.getEtiqueta() + ";" + this.retorno;
    }

    public void crearDot(){

    }

    public String getDot(){
        return "graph g{" + this.retorno + this.body + this.retorno +"}" + this.retorno;
    }

    public char[] createArrayAbc() {
        this.abc = new char[26];
        for ( int i=0; i<26; i++) {
            this.abc[i] = (char) ('A' + i );
        }
        return this.abc;
    }
}
