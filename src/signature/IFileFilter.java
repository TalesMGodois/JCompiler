package signature;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tales on 15/11/15.
 */
public interface IFileFilter {
    public void importFile(String file) throws FileNotFoundException;

    public void readLines() throws IOException;

    public FileReader getFile();

}
