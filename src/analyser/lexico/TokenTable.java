package analyser.lexico;

import util.Token;

import java.util.ArrayList;

/**
 * Created by tales on 16/11/15.
 */
public class TokenTable {
    private static TokenTable ourInstance = new TokenTable();
    private static ArrayList<Token> tokens = new ArrayList<>();
    public static TokenTable getInstance() {
        return ourInstance;
    }

//    private TokenTable() {
//        tokens.add(new Erro(""))
//
//    }

    public static Token PR(){
        return new Token("PR","","");
    }

    public static Token SPACE(){
        return new Token("SPACE","","");
    }

    public static Token ID(){
        return new Token("ID","","");
    }

    public static Token COMMENT(){
        return new Token("Comment","","");
    }

    public static Token NUM(){
        return new Token("Num","","");
    }

    public static Token LITERAL(){
        return new Token("Literal","","");
    }

    public static Token OPR(){
        return new Token("OPR","","");
    }

    public static Token RCB(){
        return new Token("RCB","","");
    }

    public static Token OPM(){
        return new Token("OPM","","");
    }

    public static Token EOF() {
        return new Token("EOF","","");
    }

    public static Token AB_P(){
        return new Token("AB_P","","");
    }

    public static Token FC_P(){
        return new Token("FC_P","","");
    }

    public static Token PT_V(){
        return new Token("PT_V","","");
    }

    public static  String ERRO(){return "ERRO";}

//    public static String FIM_ARQUIVO(){return "FIM_ARQUIVO";}

}
