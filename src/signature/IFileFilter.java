package signature;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by tales on 15/11/15.
 */
public interface IFileFilter {
    public void importFile(String file) throws FileNotFoundException;

    public void readLines();

    public void setLines();

    public FileReader getMain();

    public ArrayList<String> getArrayStrings();

}
