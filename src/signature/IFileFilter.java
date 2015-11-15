package signature;

import java.io.File;

/**
 * Created by tales on 15/11/15.
 */
public interface IFileFilter {
    public void importFile(String file);

    public String getFirstLine();


    public int getHashCode();

}
