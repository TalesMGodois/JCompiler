import util.FileFilter;

import java.io.FileNotFoundException;

/**
 * Created by tales on 15/11/15.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileFilter ff = new FileFilter();
        ff.importFile("/home/tales/IdeaProjects/JCompiler/src/codigo.txt");

        ff.readLines();

        ff.setLines();

        for(String str:ff.getArrayStrings()){
            String[] strs= str.split(" ");
            for(int i =0; i< strs.length;i++){

            }
        }

        System.out.println("...The End");
    }
}
