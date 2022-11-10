package Graficador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Graficador {
    private String graph = "";
    private String path = "/";
    private String formato = "png";

    public Graficador() {
        Path path = FileSystems.getDefault().getPath("");
        this.path = path.toAbsolutePath().toString() + "\\src\\Reportes\\";

    }

    public void CrearDot(String cadena, String nombreArchivo) {

        try {

            File file = new File(this.path + nombreArchivo);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cadena);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Graficador(String graph) {

        this.graph = graph;
    }

    public Graficador(String graph, String path) {
        this.graph = graph;
        this.path = path;
    }

    public void graficar(String archivo, String documentoSalida) {
        try {

            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

            String fileInputPath = this.path + archivo;
            String fileOutputPath = this.path + documentoSalida;

            String tParam = "-Tsvg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    public void cambioFormato(String formato) {
        this.formato = formato;
    }
}
