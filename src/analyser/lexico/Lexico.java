package analyser.lexico;

import signature.ILexico;
import signature.IToken;

import java.awt.datatransfer.FlavorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tales on 15/11/15.
 */
public class Lexico implements ILexico{
    private Hashtable<String,Token> SymbolTable;
    private ArrayList<String> tokens;
    private int positionLine =0;
    private int positionFinal;

    private final int[][] TransitionTable = {

            {0,9,1,-1,24,25,7,0,0,-1,12,20,21,11,10,-1,-1,13,17,19,23,22},

            {1,-1,1,4,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {2,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {3,-1,3,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {4,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,5,5,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {5,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {6,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {7,-1,-1,-1,-1,-1,8,-1,-1,7,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {9,9,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {10,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,10,-1,-1,-1,-1,-1},

            {11,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {12,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {13,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14,-1,-1,-1,-1,-1,15,16,-1,-1},

            {14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {15,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1},

            {18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {23,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

            {25,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}



    };

    public Lexico(){
        this.SymbolTable = new Hashtable<String, Token>();
        this.tokens = new ArrayList<String>();
        this.loadReservedKeyWords();
    }


    public void loadReservedKeyWords() {
        this.SymbolTable.put("inicio",new Token(TokenTable.PR(),"inicio",""));
        this.SymbolTable.put("varinicio",new Token(TokenTable.PR(),"varinicio",""));
        this.SymbolTable.put("varfim",new Token(TokenTable.PR(),"varfim",""));
        this.SymbolTable.put("escreva",new Token(TokenTable.PR(),"escreva",""));
        this.SymbolTable.put("leia",new Token(TokenTable.PR(),"leia",""));
        this.SymbolTable.put("se",new Token(TokenTable.PR(),"se",""));
        this.SymbolTable.put("entao",new Token(TokenTable.PR(),"entao",""));
        this.SymbolTable.put("fimse",new Token(TokenTable.PR(),"fimse",""));
        this.SymbolTable.put("fim",new Token(TokenTable.PR(),"inicio",""));
    }

    @Override
    public Token getToken(String key) {
        return this.SymbolTable.get(key);
    }

    @Override
    public void addToken(String key,Token tk){
        this.SymbolTable.put(key,tk);
    }

    @Override
    public Token[] getTokensFromLine(String line) {

        return new Token[0];
    }

    @Override
    public boolean isToken(String key) {
        Token token = this.SymbolTable.get(key);
        if(token != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Token lexico(String line) {
        int state = 0;
        int i = this.positionLine;
        while (this.TransitionTable[state][line.charAt(i)] != -1){
            state = this.TransitionTable[state][line.charAt(i)];
            i++;
        }

        String txt = line.substring(this.positionLine,i);
        if(isToken(txt)){
            return this.SymbolTable.get(txt);
        }else{
            Token tk = new Token(this.getTokenName(state),txt,"");
            this.addToken(txt,tk);
        }

        return this.getToken(txt);
    }

    @Override
    public int getGroup(char character) {

        if(character == 'E')
            return Flags.E;
        if(Character.isLetter(character))
            return Flags.L;
        if(Character.isDigit(character)) {
            return Flags.D;
        }
        if(character == '(')
            return Flags.AB_P;
        if(character == ' ')
            return Flags.SPACE;
        if(character == '\n')
            return Flags.barraN;
        if(character == '*')
            return Flags.MULT;
        if(character == '/')
            return Flags.DIV;
        if(character == '+')
            return Flags.PLUS;
        if(character == '-' )
            return Flags.MINUS;
        if(character == '>' )
            return Flags.MAIOR;
        if(character == '=' )
            return Flags.IGUAL;
        if(character == '<' )
            return Flags.MENOR;
        if(character == '.')
            return Flags.PT_F;
        if(character == ';')
            return Flags.PT_V;
        if(character == '{')
            return Flags.AB_C;
        if(character == '}')
            return Flags.FC_C;
        else{
            return Flags.QUALQUER;
        }

    }

    public String getTokenName(int state ) {
        switch (state){
            case 0:
                return TokenTable.LITERAL();
            case 1:
                return TokenTable.NUM();
            case 2:
                return TokenTable.COMMENT();
            case 3:
                return TokenTable.AB_P();
            case 4:
                return TokenTable.FC_P();
            case 5:
                return TokenTable.PT_V();
            case 6:
                return TokenTable.ID();
            default:
                return TokenTable.ERRO();

        }
    }
    

}