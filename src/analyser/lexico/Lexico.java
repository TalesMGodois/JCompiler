package analyser.lexico;

import util.Erro;
import util.Token;

import java.util.Hashtable;

/**
 * Created by tales on 15/11/15.
 */
public class Lexico {
    private Hashtable<String, Token> SymbolTable;
    private char character = ' ';

    private int positionLine;
    private int line = 1;
    private int position;
    private Token tk;

    private final int[][] TransitionTable = {

//              0   1    2   3   4   5  6   7   8   9   10   11  12  13  14  15  16  17  18  19  20  21
//              D	L	 +	 -	 *	 /	(	 )	“	{	 }	 <	 >	 =	 E	;	\n	QQ	_	.	EOF	SPACE STATES

/*STATE 0*/ {	16,	15,	 1,	 2,	 3,	 4,	10,	 9,	22,	24,	 -1, 5,	12,	14,	-1, 11,	 0,	-1,	-1,	-1,	26,	 0}, //0

/*STATE 1*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //1

/*STATE 2*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //2

/*STATE 3*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //3

/*STATE 4*/ {	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //4

/*STATE 5*/ {	-1,	-1,	-1,	8,	-1,	-1,	-1,	-1,	-1,	-1,	 8,	-1,	 7,	 6,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //5

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

/*STATE 22*/{	22,	22,	22,	22,	22,	22,	22,	22,	23,	22,	22,	22,	22,	22,	22,	22,	22,	22,	22,	22,	22,	22}, //22

/*STATE 23*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //23

/*STATE 24*/{	24,	24,	24,	24,	24,	24,	24,	24,	24,	24,	25,	24,	24,	24,	24,	24,	24,	24,	24,	24,	24,	24}, //24

/*STATE 25*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //25

/*STATE 26*/{	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1}, //26

};

    public Lexico(){
        this.SymbolTable = new Hashtable<String, Token>();
        this.loadReservedKeyWords();
    }

    public Hashtable<String,Token> getHashTable(){
        return this.SymbolTable;
    }

    public void loadReservedKeyWords() {
        this.SymbolTable.put("inicio",TokenTable.PR());
        this.SymbolTable.put("varinicio",TokenTable.PR());
        this.SymbolTable.put("varfim",TokenTable.PR());
        this.SymbolTable.put("escreva",TokenTable.PR());
        this.SymbolTable.put("leia",TokenTable.PR());
        this.SymbolTable.put("se",TokenTable.PR());
        this.SymbolTable.put("entao",TokenTable.PR());
        this.SymbolTable.put("fimse",TokenTable.PR());
        this.SymbolTable.put("fim",TokenTable.PR());
        this.SymbolTable.put("Inteiro",TokenTable.PR());
        this.SymbolTable.put("Real",TokenTable.PR());
        this.SymbolTable.put("Literal",TokenTable.PR());
    }

    
    public Token getToken(String key) {
        return this.SymbolTable.get(key);
    }

    
    public void addToken(String key,Token tk){
        this.SymbolTable.put(key,tk);
    }

    public void updateToken(String key, Token tk){
        Token tok = this.SymbolTable.get(key);
        tok.setLexema(tk.getLexema());
    }
    
    public boolean isToken(String key) {
        Token token = this.SymbolTable.get(key);
        if(token != null){
            return true;
        }else {
            return false;
        }
    }

    public Token getTk(){
        return this.tk;
    }

    public String getLineAndPosition(){
        return ("("+this.line+","+this.positionLine+")");
    }

    public Token lexico(String text) {
        int state_ant;
        int state  		= 0;
        int size 		= text.length();

        String txt;
        int startWord   = this.position;
        int endWord;
        this.positionLine = 0;
        try{
            do {

                this.character = text.charAt(this.position);

                this.positionLine++;
                state_ant = state;
                state = TransitionTable[state][getGroup(this.character)];
                if(state == 0){
                    state_ant = state;
                    state = -1;
                }

                if(this.character == '\n'){
                    this.positionLine = 0;
                }
                this.position++;

            }while(state != -1 && this.position < size  && this.position < size);

            if(state_ant != 0){
                this.position --;
            }

        }catch (StringIndexOutOfBoundsException e){
            System.out.println("string of bounds");
            state_ant = -1;
        }catch (ArrayIndexOutOfBoundsException e){
            state_ant = -1;
            System.out.println("Array Index Of Bounds");
        }

        endWord = this.position;
        txt = text.substring(startWord,endWord);

        this.tk = this.mapa_estado_token(state_ant);
        this.tk.setLexema(txt);

        if(!isToken(txt) && txt != "\n" && txt != " "){
            this.addToken(txt,this.tk);
        }else{
            this.updateToken(txt,tk);
        }

        this.tk = this.getToken(txt);
        return this.tk;

//        return this.mapa_estado_token(state_ant);


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

        if(character == '_')
            return Flags.UL;

        if(character == '#')
            return Flags.EOF;

        else{
            return Flags.QQ;
        }

    }

    public Token mapa_estado_token(int state ) {
        switch (state){
            case 0:
                if(this.character == '\n'){
                    this.positionLine = 0;
                    this.line++;
                }
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
                return new Erro("ERRO","Erro_TEXTO_FINALIZANDO_EM_PONTO","");
            case 18:
                return TokenTable.NUM();
            case 19:
                return new Token("ERRO","ERRO_EXPONENCIAL","");
            case 20:
                return new Token("ERRO","EXPONENCIAL_SINAL_SEM_NUMERO","");
            case 21:
                return TokenTable.NUM();
            case 22:
                return new Token("ERRO","ERRO_ABRE_ASPA","");
            case 23:
                return TokenTable.LITERAL();
            case 24:
                return new Token("ERRO","ERRO_AO_ABRIR_COMENTARIO","");
            case 25:
                return TokenTable.COMMENT();
            case 26:
                return TokenTable.EOF();
            default:
                return new Token("ERRO","ERRO_DEFAULT","");

        }
    }

}