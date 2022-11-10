package Interfaz;

import Graficador.Graficador;
import Visitors.C3D;
import Visitors.Interpreter;
import Visitors.TAST;
import entorno.ReporteSimbolo;
import grammarController.GrammarController;
import org.antlr.v4.runtime.CharStream;
import Error.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static org.antlr.v4.runtime.CharStreams.fromFileName;
import static org.antlr.v4.runtime.CharStreams.fromString;

public class interfaz extends JFrame{
    private JPanel panel1;
    public JTextArea txtEntrada;
    private JScrollPane Jpanel;
    public JTextArea txtSalida;
    public JTextArea txtC3d;
    private JButton button1;
    private JButton archivoButton;
    private JButton analizarButton;
    private JButton c3DButton;
    private JButton CSTButton;
    private Path path = FileSystems.getDefault().getPath("");
    private String path2 = path.toAbsolutePath().toString() +"\\src\\Reportes\\";
    public  GrammarController grammarController; //Controlador de antlr
    public ReporteSimbolo simb = new ReporteSimbolo();

    NumeroLinea numeroLinea;



    public void AbrirReporte(){
        JFileChooser selectorArchivos = new JFileChooser(path2);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Reporte", "svg");
        selectorArchivos.setFileFilter(filtro);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // indica cual fue la accion de usuario sobre el jfilechooser
        int resultado = selectorArchivos.showOpenDialog(this);

        try {
            File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado
            String _archivo = archivo.getAbsolutePath();
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + _archivo);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());;
        }
    }

    public void abrirArchivoTexto(){
        JFileChooser selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de fortran Analyzer", "f90");
        selectorArchivos.setFileFilter(filtro);
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // indica cual fue la accion de usuario sobre el jfilechooser
        int resultado = selectorArchivos.showOpenDialog(this);

        File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

        // muestra error si es inválido
        if ((archivo == null) || (archivo.getName().equals("")) || !archivo.getName().endsWith(".f90")) {
            JOptionPane.showMessageDialog(this, "Archivo no valido", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            txtEntrada.setText("");
            File doc = new File(archivo.getAbsolutePath());
            try (Scanner scn = new Scanner(doc)) {
                while (scn.hasNext()) {
                    txtEntrada.append(scn.nextLine() + "\n");
                }
            }catch (java.io.FileNotFoundException exception){
                System.out.println("Error " + exception);
            }
        }
    }


    public interfaz() {
        setTitle("Fortran Analyzer");
        setContentPane(panel1);
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        //Para numero de linea
        numeroLinea = new NumeroLinea(txtEntrada);
        Jpanel.setRowHeaderView(numeroLinea);

        archivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Archivo");
                abrirArchivoTexto();
            }
        });
        analizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Analizar");
                CharStream cs = fromString(txtEntrada.getText().toString());
                try {

                    txtSalida.setText("");
                    //txtSalida.replaceSelection("");
                    grammarController =  new GrammarController(cs);
                    Interpreter interpreter = new Interpreter(); //Interprete
                    interpreter.visit(grammarController.getStartContext());
                    String [] consola = interpreter.consola.split("\n");
                    for (String consol: consola) {
                        txtSalida.append(consol + "\n");
                    }
                    simb.GenerarReporteSimbolo(interpreter.getGlobal());
                    interpreter.listaExcepciones.addAll(Lexico.INSTANCE.getError());
                    Lexico.INSTANCE.GenerarReporteError(interpreter.listaExcepciones);

                    //----------------------------- Reporte AST  ---------------------------
                    TAST tast = new TAST();
                    tast.visit(grammarController.getStartContext());
                    ArrayList<String> ast =  tast.controllerAST.codigoDot;
                    String dot = "graph g{\n";
                    for (String val: ast){
                        dot += val;
                    }
                    dot += "}\n";
                    Graficador graf = new Graficador();
                    graf.CrearDot(dot, "ReporteAst.dot");
                    graf.graficar("ReporteAst.dot", "ReporteAst.svg");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reporte");
                AbrirReporte();
            }
        });
        c3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Analizar 3d");
                CharStream cs = fromString(txtEntrada.getText().toString());
                try {

                    txtC3d.setText("");
                    //txtSalida.replaceSelection("");
                    grammarController =  new GrammarController(cs);
                    C3D codigo3d = new C3D(); //Interprete
                    codigo3d.visit(grammarController.getStartContext());
                    //encabezado
                    String [] encabezado = codigo3d.c3d.getHeader().split("\n");
                    for (String consol: encabezado) {
                        txtC3d.append(consol + "\n");
                    }
                    for (String consol: codigo3d.c3d.codigo3d) {
                        txtC3d.append(consol + "\n");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        CSTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grammarController.GenerarCST();
            }
        });
    }

    //Interfaz Grafica

    public static void main(String[] args) {
        interfaz my = new interfaz();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
