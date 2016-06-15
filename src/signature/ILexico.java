package signature;

import util.Token;

/**
 * Created by tales on 15/11/15.
 */
public interface ILexico {

    public Token getToken(String key);

    public void loadReservedKeyWords();

    public void addToken(String key,Token tk);

    public boolean isToken(String key);

    public Token lexico(String line);

    public String getTokenName(int state );

    public int getGroup(char character);

}
