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
    private int line;
    private int position;

    private final int[][] TransitionTable = {

//              0   1    2   3   4   5  6   7   8   9   10   11  12  13  14  15  16  17  18  19  20  21
//              D	L	 +	 -	 *	 /	(	 )	“	{	 }	 <	 >	 =	 E	;	\n	QQ	_	.	EOF	SPACE STATES

/*STATE 0*/ {	16,	15,	 1,	 2,	 3,	 4,	10,	 9,	22,	24,	 -1, 5,	12,	14,	-1, 11,	 0,	-1,	-1,	-1,	26,	 0}, //0

/*STATE 1*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //1

/*STATE 2*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //2

/*STATE 3*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //3

/*STATE 4*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //4

/*STATE 5*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	 8,	-1,	 7,	 6,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //5

/*STATE 6*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //6

/*STATE 7*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //7

/*STATE 8*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //8

/*STATE 9*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //9

/*STATE 10*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //10

/*STATE 11*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //11

/*STATE 12*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	13,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //12

/*STATE 13*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //13

//              0   1    2   3   4   5  6   7   8   9   10   11  12  13  14  15  16  17  18  19  20  21
//              D	L	 +	 -	 *	 /	(	 )	“	{	 }	 <	 >	 =	 E	;	\n	QQ	_	.	EOF	SPACE STATES
/*STATE 14*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //14

/*STATE 15*/{	15,	15,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	15,	-1,	-1,	-1}, //15

/*STATE 16*/{	16,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	19,	-1,	-1,	-1,	-1,	17,	-1,	-1}, //16

/*STATE 17*/{	18,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //17

/*STATE 18*/{	18,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	19,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //18

/*STATE 19*/{	21,	-1,	20,	20,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //19

/*STATE 20*/{	21,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //20

/*STATE 21*/{	21,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //21

/*STATE 22*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	23,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	22,	-1,	-1,	-1,	-1}, //22

/*STATE 23*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //23

/*STATE 24*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	25,	-1,	-1,	-1,	-1,	-1,	-1,	24,	-1,	-1,	-1,	-1}, //24

/*STATE 25*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //25

/*STATE 26*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //26

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
        this.SymbolTable.put("Inteiro",new Token(TokenTable.PR(),"inteiro",""));
        this.SymbolTable.put("Real",new Token(TokenTable.PR(),"real",""));
        this.SymbolTable.put("Literal",new Token(TokenTable.PR(),"literal",""));
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

    
    public String lexico(String text) {
        int state  		= 0;
        int state_ant   = 0;
        int size 		= text.length();

        char character = ' ';
        try{
            do {
                character = text.charAt(this.position);
                state_ant = state;
                state = TransitionTable[state][getGroup(character)];
                if(state == 0){
                    state_ant = state;
                    state = -1;
                }
                this.position++;

            }while(state != -1 && this.position < size );
            if(state_ant != 0){
                this.position --;
            }

        }catch (StringIndexOutOfBoundsException e){
            System.out.println("...");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("...");
        }

//        if(isToken(txt)){
//            return this.SymbolTable.get(txt);
//        }else{
//            Token tk = new Token(this.mapa_estado_token(state),txt,"");
//            this.addToken(txt,tk);
//        }

//        System.out.println(this.getToken(txt).toString());
        return this.mapa_estado_token(state_ant);
    }


    public int getGroup(char character) {

        if(character == 'E')
            return 14;
        if(Character.isLetter(character))
            return 1;
        if(Character.isDigit(character)) {
            return 0 ;
        }
        if(character == '(')
            return 6;

        if(character == ')')
            return 7;

        if(character == ' ')
            return 21;

        if(character == '\n')
            return 16;

        if(character == '*')
            return 4;

        if(character == '/')
            return 5;

        if(character == '+')
            return 2;

        if(character == '-' )
            return 3;

        if(character == '>' )
            return 12;

        if(character == '=' )
            return 13;

        if(character == '<' )
            return 11;

        if(character == '.')
            return 19;

        if(character == ';')
            return 15;

        if(character == '"')
            return 22;

        if(character == '{')
            return 9;

        if(character == '}')
            return 10;

        if(character == '_')
            return 18;

        if(character == '#')
            return 20;

        else{
            return Flags.QQ;
        }

    }

    public String mapa_estado_token(int state ) {
        switch (state){
            case 0:
                return TokenTable.SPACE();
            case 1:
                return TokenTable.OPM();
            case 2:
                return TokenTable.OPM();
            case 3:
                return TokenTable.OPM();
            case 4:
                return TokenTable.OPM();
            case 5:
                return TokenTable.OPR();
            case 6:
                return TokenTable.OPR();
            case 7:
                return TokenTable.OPR();
            case 8:
                return TokenTable.RCB();
            case 9:
                return TokenTable.FC_P();
            case 10:
                return TokenTable.AB_P();
            case 11:
                return TokenTable.PT_V();
            case 12:
                return TokenTable.OPR();
            case 13:
                return TokenTable.OPR();
            case 14:
                return TokenTable.OPR();
            case 15:
                return TokenTable.ID();
            case 16:
                return TokenTable.NUM();
            case 17:
                return TokenTable.ERRO();
            case 18:
                return TokenTable.NUM();
            case 19:
                 return TokenTable.ERRO();
            case 20:
                return TokenTable.ERRO();
            case 21:
                return TokenTable.NUM();
            case 22:
                return TokenTable.ERRO();
            case 23:
                return TokenTable.LITERAL();
            case 24:
                return TokenTable.ERRO();
            case 25:
                return TokenTable.COMMENT();
            case 26:
                return TokenTable.EOF();
            default:
                return TokenTable.ERRO();

        }
    }

    public void reset(){
        this.positionLine = 0;
    }
}