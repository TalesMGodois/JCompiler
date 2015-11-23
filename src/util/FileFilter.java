package util;

import signature.IFileFilter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by tales on 15/11/15.
 */
public class FileFilter implements IFileFilter {
    private FileReader main;
    private ArrayList<String> lines;


    public FileFilter(){
        this.lines = new ArrayList<String>();
    }

    @Override
    public FileReader getMain(){
        return this.main;
    }

    @Override
    public void importFile(String file) throws FileNotFoundException {
        FileReader ff = new FileReader(file);
        this.main = ff;
    }

    @Override
    public void setLines(){
        this.lines = this.getArrayStrings();
    }

    public ArrayList<String> getLines(){
        return this.lines;
    }

    @Override
    public void readLines() {
        Scanner input = new Scanner(this.main).useDelimiter("\\||\\n");
        String line = "";
        try{
            while(input.hasNext()){
                line = input.next();

                this.lines.add(line);
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getArrayStrings() {
        return this.lines;
    }

}
