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
public class Lexico {
    private Hashtable<String,Token> SymbolTable;
    private ArrayList<String> tokens;
    private int positionLine =0;
    private int positionFinal;

    private final int[][] TransitionTable = {

//              D	L	 +	 -	 *	 /	(	 )	“	{	 }	 <	 >	 =	 E	;	\n	QQ	_	.	EOF	SPACE STATES
            {	16,	15,	 1,	 2,	 3,	 4,	10,	 9,	22,	24,	 -1, 5,	12,	14,	 -1,	11,	 0,	-1,	-1,	-1,	26,	 0}, //0

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //1

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //2

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //3

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //4

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	 8,	-1,	 7,	 6,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //5

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //6

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //7

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //8

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //9

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //10

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //11

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	13,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //12

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //13

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //14

            {	15,	15,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	15,	-1,	-1,	-1}, //15

            {	16,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	19,	-1,	-1,	-1,	-1,	17,	-1,	-1}, //16

            {	18,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //17

            {	18,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	19,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //18

            {	21,	-1,	20,	20,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //19

            {	21,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //20

            {	21,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //21

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	23,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	22,	-1,	-1,	-1,	-1}, //22

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //23

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	25,	-1,	-1,	-1,	-1,	-1,	-1,	24,	-1,	-1,	-1,	-1}, //24

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //25

            {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //26

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

    
    public Token getToken(String key) {
        return this.SymbolTable.get(key);
    }

    
    public void addToken(String key,Token tk){
        this.SymbolTable.put(key,tk);
    }


    
    public boolean isToken(String key) {
        Token token = this.SymbolTable.get(key);
        if(token != null){
            return true;
        }else {
            return false;
        }
    }

    
    public Token lexico(String line) {
        int state = 0;
        int i = this.positionLine;

        try{
            while (i < line.length() || this.TransitionTable[state][this.getGroup(line.charAt(i))] != -1 ){
                state = this.TransitionTable[state][this.getGroup(line.charAt(i))];

                i++;
                if(i>= line.length())
                    break;
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("...");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("...");
        }

        String txt = line.substring(this.positionLine,i);
        if(isToken(txt)){
            return this.SymbolTable.get(txt);
        }else{
            Token tk = new Token(this.mapa_estado_token(state),txt,"");
            this.addToken(txt,tk);
        }

        System.out.println(this.getToken(txt).toString());
        this.positionLine = i;
        return this.getToken(txt);
    }


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
        if(character == ')')
            return Flags.FC_P;
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
        if(character == '"')
            return Flags.ASPA_D;
        if(character == '{')
            return Flags.AB_C;
        if(character == '}')
            return Flags.FC_C;
        if(character == '#')
            return Flags.EOF;
        else{
            return Flags.QUALQUER;
        }

    }

    public String mapa_estado_token(int state ) {
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

    public void reset(){
        this.positionLine = 0;
    }
}