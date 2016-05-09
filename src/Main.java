import analyser.lexico.Lexico;
import analyser.lexico.Token;
import analyser.lexico.TokenTable;
import util.FileFilter;

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
            System.out.println(lexico.getTk().toString());

        }

        if(token == TokenTable.ERRO()){
            System.out.println("Erro em (linha,posicao): "+ lexico.getLineAndPosition());
        }
//        Hashtable<String,Token> hashtable = lexico.getHashTable();

        System.out.println("...The End");
    }
}
