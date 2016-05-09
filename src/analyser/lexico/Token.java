package analyser.lexico;

import signature.IToken;

/**
 * Created by tales on 15/11/15.
 */
public class Token implements IToken{
    private String token;
    private String lexema;
    private String atributo;

    public Token(String token, String lexema, String atributo){
        this.token = token;
        this.lexema = lexema;
        this.atributo = atributo;
    }

    public String getLexema() {
        return lexema;
    }

    public String getToken() {
        return token;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public void setLexema(String lexema){
        this.lexema = lexema;

    }

    public String toString(){

        return "Token("+this.token+","+this.lexema+")";
    }

}
