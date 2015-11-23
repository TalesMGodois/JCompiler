package analyser.lexico;

/**
 * Created by tales on 16/11/15.
 */
public class TokenTable {
    private static TokenTable ourInstance = new TokenTable();

    public static TokenTable getInstance() {
        return ourInstance;
    }

    private TokenTable() {
    }

    public static String PR(){
        return "PR";
    }

    public static String OCM(){
        return "OCM";
    }

    public static String EOF(){
        return "EOF";
    }

    public static String ID(){
        return "ID";
    }

    public static String COMMENT(){
        return "Comment";
    }

    public static String NUM(){
        return "Num";
    }

    public static String LITERAL(){
        return "Literal";
    }

    public static String OPR(){
        return "OPR";
    }

    public static String RCB(){
        return "RCB";
    }

    public static String OPM(){
        return "OPM";
    }

    public static String AB_P(){
        return "AB_P";
    }

    public static String FC_P(){
        return "FC_P";
    }

    public static String PT_V(){
        return "PT_V";
    }

    public static String ERRO(){
        return "ERRO";
    }

}
