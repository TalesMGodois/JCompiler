package analyser.lexico;

import signature.ILexico;
import signature.IToken;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tales on 15/11/15.
 */
public class Lexico implements ILexico{
    private Hashtable<String,Token> SymbolTable;

    public Lexico(){
        this.SymbolTable = new Hashtable<String, Token>();
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
    public Token getToken(char key) {
        return this.SymbolTable.get(key);
    }

    @Override
    public void addToken(String key,Token tk){
        this.SymbolTable.put(key,tk);
    }

    @Override
    public Token[] getTokensFromLine(String line) {
        Token[] tokens = new Token[line.length()];
        for(int i=0;i<line.length();i++){
            tokens[i] = this.getToken(line.charAt(i));
            System.out.println(line.charAt(i));
        }

        return tokens ;
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
    public String getGroup(char character) {

        if(character == 'E')
            return "E";
        if(Character.isLetter(character))
            return "L";
        if(Character.isDigit(character))
            return "D";
        if(character == ' ')
            return "Space";
        if(character == '\n')
            return "NBar";
        if(character == '\t')
            return "TBar";
        if(character == '\'')
            return "Aspa";
        if(character == '*' || character == '/'|| character == '+'|| character == '-' )
            return "M";
        if(character == '>' || character == '='|| character == '<' )
            return "B";
        else return "NotSet";

    }

}
