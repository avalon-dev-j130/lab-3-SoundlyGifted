package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    
    private Path pathFrom;  // a path that file to be copied from.
    private Path pathTo;    // a path to copy a file to.

    /* Constructor */
    public FileCopyAction() { }

    public void setPathFrom(Path pathFrom) {
        this.pathFrom = pathFrom;
    }

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
            Files.copy(pathFrom, pathTo, REPLACE_EXISTING);
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
