package grammarController;

//import static org.antlr.v4.runtime.CharStreams.fromString;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

import Error.Lexico;
import org.antlr.v4.gui.JFileChooserConfirmOverwrite;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import gramatica.*;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GrammarController {
    GramaticaLexer lexer;
    CommonTokenStream tokens;
    GramaticaParser parser;
    GramaticaParser.StartContext startContext;

    public GrammarController(CharStream cs) throws IOException {
        lexer = new GramaticaLexer(cs);
        tokens = new CommonTokenStream(lexer);
        parser = new GramaticaParser(tokens);

        //Manejo de errores lexicos
        lexer.removeErrorListeners();
        lexer.addErrorListener(Lexico.INSTANCE);

        //Manejo de errores Sintacticos
        parser.removeErrorListeners();
        parser.addErrorListener(Lexico.INSTANCE);

        startContext = parser.start();



    }

    public GramaticaParser.StartContext getStartContext() {
        return startContext;
    }

    public void GenerarCST(){
        List<String> rulesName = Arrays.asList(parser.getRuleNames());
        TreeViewer viewr = new TreeViewer(rulesName, startContext);
        viewr.open();
    }

}
