import signature.IFileFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by tales on 15/11/15.
 */
public class FileFilter implements IFileFilter {
    private FileReader main;
    private String[] fileData;

    @Override
    public void importFile(String file) {
        try{
            FileReader eFile = new FileReader(file);
            this.main = eFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFirstLine() {
        return null;
    }

    @Override
    public void setFileArray() {

    }

    @Override
    public int getHashCode() {
        return 0;
    }
}
