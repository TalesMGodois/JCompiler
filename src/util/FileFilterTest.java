package util;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class FileFilterTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test(expected=FileNotFoundException.class)
    public void testarSeNaoEncontraArquivo() throws FileNotFoundException {
        FileFilter filef = new FileFilter();
        filef.importFile("");
        assertNotNull(filef.getMain());

    }
    @Test
    public void testarSeArquivoNaoENulo() throws FileNotFoundException {
        FileFilter filef = new FileFilter();
        filef.importFile("/home/tales/IdeaProjects/JCompiler/src/codigo.txt");
        assertNotNull(filef.getMain());
    }



}