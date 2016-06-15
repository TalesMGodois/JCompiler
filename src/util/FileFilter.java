package util;

import signature.IFileFilter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by tales on 15/11/15.
 */
public class FileFilter implements IFileFilter {
    private FileReader file;
    private ArrayList<String> lines;
    private String sFile = "";


    public FileFilter(String file) throws FileNotFoundException {
        this.importFile(file);
    }
    public String getSFile(){
    	return this.sFile;
    }

    @Override
    public FileReader getFile(){
        return this.file;
    }

    @Override
    public void importFile(String file) throws FileNotFoundException {
        FileReader ff = new FileReader(file);
        this.file = ff;
    }

    @Override
    public void readLines() throws IOException {
        BufferedReader br = new BufferedReader(this.file);
        String current;
        while ((current = br.readLine()) != null) {
            this.sFile += current + '\n';
        }
        this.sFile += "#";
    }

}
