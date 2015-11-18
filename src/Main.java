import analyser.lexico.Lexico;
import analyser.lexico.Token;
import signature.ILexico;
import util.FileFilter;

import java.io.FileNotFoundException;
import java.util.Hashtable;

/**
 * Created by tales on 15/11/15.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileFilter ff = new FileFilter();
        ff.importFile("/home/tales/IdeaProjects/JCompiler/src/codigo.txt");
        ff.readLines();
        ff.setLines();


        Lexico lexico = new Lexico();

        lexico.getGroup('/');

        String strs = "inicio(eu)'+/ 8997897 +=";

        for(int i =0; i< strs.length();i++){
            String s = lexico.getGroup(strs.charAt(i));
            System.out.println(s);
        }


        System.out.println("...The End");
    }
}
