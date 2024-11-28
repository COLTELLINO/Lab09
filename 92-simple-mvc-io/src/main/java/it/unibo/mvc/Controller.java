package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile =  new File(System.getProperty("user.home") + File.separator + "output.txt");

    public void setFile(File f) {
        currentFile = f;
    }

    public File getFile() {
        return currentFile;
    }

    public String getPath() {
        return currentFile.getAbsolutePath().toString();
    }
    
    public void writeOnFile(String s) throws IOException {
        final BufferedWriter w = new BufferedWriter(new FileWriter(currentFile));
        w.write(s);
        w.close();
    }

}
