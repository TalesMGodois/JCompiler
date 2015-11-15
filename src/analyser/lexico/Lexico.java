package analyser.lexico;

import signature.ILexico;
import signature.IToken;

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
        this.SymbolTable.put("inicio",new Token("inicio","inicio","palavraREservada"));
        this.SymbolTable.put("varinicio",new Token("varinicio","varinicio","palavraREservada"));
        this.SymbolTable.put("varfim",new Token("varfim","varfim","palavraREservada"));
        this.SymbolTable.put("escreva",new Token("escreva","escreva","palavraREservada"));
        this.SymbolTable.put("leia",new Token("leia","leia","palavraREservada"));
        this.SymbolTable.put("se",new Token("se","se","palavraREservada"));
        this.SymbolTable.put("entao",new Token("entao","entao","palavraREservada"));
        this.SymbolTable.put("fimse",new Token("fimse","fimse","palavraREservada"));
        this.SymbolTable.put("fim",new Token("fim","inicio","palavraREservada"));
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

}
