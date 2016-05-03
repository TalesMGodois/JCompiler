import analyser.lexico.Lexico;
import analyser.lexico.Token;
import signature.ILexico;
import util.FileFilter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by tales on 15/11/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileFilter ff = new FileFilter("/home/tales/IdeaProjects/JCompiler/src/codigo.txt");
        ff.readLines();


//        Lexico lexico = new Lexico();
//        for(String txt:ff.getLines()){
//
//            lexico.lexico(txt);
//            lexico.reset();
//        }

        System.out.println("...The End");
    }
}
