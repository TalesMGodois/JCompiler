import analyser.lexico.Lexico;
import analyser.lexico.Token;
import analyser.lexico.TokenTable;
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
        String text = ff.getSFile();

        Lexico lexico = new Lexico();
        
        String token = "";
        while(( token = lexico.lexico(text)) != TokenTable.ERRO() && token !=TokenTable.EOF()){
            System.out.println(token);

        }
        
//        for(int i =0;i< size -1;i++){
//        	char character = text.charAt(i);
//        	lexico.lexico(character);
//        }
//        

        System.out.println("...The End");
    }
}
