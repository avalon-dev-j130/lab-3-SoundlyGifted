
package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCreateAction implements Action {
    
    private Path pathTo;    // a path to create a file in.

    /* Constructor */
    public FileCreateAction() { }

    public void setPathTo(Path pathTo) {
        this.pathTo = pathTo;
    }
      
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {

            /*
            * TODO №2 Реализуйте метод run класса FileCopyAction
            */
        try {    
            Files.createFile(pathTo);
        } catch (IOException ex) {/*ex.printStackTrace();*/} 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        threadPool.shutdownNow();
    }
}
