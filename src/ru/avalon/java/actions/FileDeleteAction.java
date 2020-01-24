
package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDeleteAction implements Action{
    
    private Path pathFrom;    // a path to delete a file from.

    /* Constructor */
    public FileDeleteAction() { }

    public void setPathFrom(Path pathFrom) {
        this.pathFrom = pathFrom;
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
            Files.delete(pathFrom);
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
