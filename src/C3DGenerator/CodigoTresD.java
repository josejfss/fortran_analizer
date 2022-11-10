package C3DGenerator;
import entorno.*;

import java.util.*;

public class CodigoTresD {
    public ArrayList<String> codigo3d;
    public ArrayList<String> cadenas = new ArrayList<>();
    public ArrayList<String> funciones = new ArrayList<>();
    public ArrayList<String> nombrefunciones = new ArrayList<>();
    private int temporal;
    private int label;

    public CodigoTresD() {
        this.codigo3d = new ArrayList<>();
        this.temporal = -1;
        this.label = -1;
    }

    public String generateTemporal()
    {
        this.temporal++;
        cadenas.add("t" + this.temporal);
        return String.valueOf("t" + this.temporal);
    }

    public String generateTemporal(int valor)
    {
        this.temporal++;
        cadenas.add("t" + this.temporal + "[" + valor + "]");
        return String.valueOf("t" + this.temporal);
    }

    public void AgregarVariable(String valor)
    {

        boolean encontrado = false;
        for (String func: cadenas) {
            if(func.equals(valor)){
                encontrado = true;
            }
        }
        if(!encontrado){
            cadenas.add(valor);
        }

    }

    public void AgregarFuncion(String valor, String identificador)
    {
        boolean encontrado = true;
        for (String func: nombrefunciones) {
            func = func.toLowerCase();
            if(func.equals(identificador.toLowerCase())){
                encontrado = false;
            }
        }
        if(encontrado){
            funciones.add(valor);
            nombrefunciones.add(identificador);
        }
    }

    public String lastTemporal()
    {
        return String.valueOf("t" + this.temporal);
    }

    public String generateLabel()
    {
        this.label++;
        return  "L" + this.label;
    }
    private String getPrintVars()
    {
        String tempStart = this.generateTemporal();
        String labelStart = this.generateLabel();
        return "void imprimir_variable()\n" +
                "{\n" +
                tempStart + " = STACK[(int)P];\n" +
                labelStart + ":\n" +
                this.generateTemporal() + " = HEAP[(int)" + tempStart + "];\n" +
                "if (" + this.lastTemporal() + " != -1) goto L" + (this.label + 1) + ";\n" +
                "goto L" + (this.label + 2) + ";\n" +
                this.generateLabel() + ":\n" +
                "printf(\"%c\", (char)" + this.lastTemporal() + ");\n" +
                tempStart + "=" + tempStart + " + 1;\n" +
                "goto " + labelStart + ";\n" +
                this.generateLabel() + ":\n" +
                "printf(\"%c\\n\", (char)32);\n" +
                "return;\n" +
                "}\n\n";
    }

    private String getPrintVarInt()
    {
        return "void imprimir_var_int()\n{\n" +
                this.generateTemporal() + " = STACK[(int)P];\n" +
                "printf(\"%f\\n\", " + this.lastTemporal() + ");" +
                "return;\n}\n\n";
    }

    public String getHeader()
    {
        String prints = this.getPrintVars() + this.getPrintVarInt();
        // para obtener solo listado de temporales: t1, t2, t3, ... , tn;

        String _cad = "";


        int cont = 0;
        for (String cad: cadenas) {
            if (cont == 0){
                _cad = cad;
            }else{
                _cad += ", " + cad;
            }
            cont++;

        }
        _cad += ";\n";

        //Declaracion de funciones
        String cadF = "";
        for (String cad: funciones) {
            cadF += cad +"\n";
        }

        return "#include <stdio.h>\n" +
                "double STACK[30101999];\n" +
                "double HEAP[30101999];\n" +
                "double P;\n" +
                "double H;\n" +
                "double " + _cad + "\n" +
                "double T = 84;\n" +
                "double F = 70;\n" +
                cadF +
                "\n" + prints;
    }

    public void AgregarError(String mensaje, String lin, String col) {
        String enlinea = " En la Linea: ";
        String encolum = " En la columna: ";
        String errores = "";

        for (char val: mensaje.toCharArray()) {
            errores += "printf(\"%c\", " + (int) val + "); //LETRA-> " + val + "\n";
        }

        errores += "printf(\"%c\", 46);	//PUNTO\n";

        for (char val: enlinea.toCharArray()) {
            errores += "printf(\"%c\", " + (int) val + "); //LETRA-> " + val + "\n";
        }

        errores += "printf(\"%o\", (int)" + lin + ");	//NUM\n";
        errores += "printf(\"%c\", 46);	//PUNTO\n";
        errores += "printf(\"%c\", 32);	//ESPACIO\n";

        for (char val: encolum.toCharArray()) {
            errores += "printf(\"%c\", " + (int) val + "); //LETRA-> " + val + "\n";
        }

        errores += "printf(\"%d\", (int)" + col + ");	//NUM\n";
        errores += "printf(\"%c\", 46);	//PUNTO\n";
        errores += "printf(\"%c\", 10);	//SALTO LINEA\n";
        codigo3d.add(errores);
    }

    public String getTipoDato3d(TipoSimbolo _tipo){
        if(_tipo == TipoSimbolo.BOOLEAN){
            return "bool";
        } else if (  _tipo == TipoSimbolo.INT){
            return "double";
        }else if( _tipo == TipoSimbolo.CHAR){
            return  "char";
        }else if(_tipo == TipoSimbolo.REAL  ) {
            return "double";
        }
        return "";
    }
}