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

    public String toString(){
        String aux = "Token = " + token + "\n";
        aux = aux + "Lexema = " + lexema + "\n";
        aux = aux + "Atributo = " + atributo + "\n";

        return aux;
    }

}
