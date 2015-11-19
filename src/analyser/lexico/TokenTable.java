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

}
