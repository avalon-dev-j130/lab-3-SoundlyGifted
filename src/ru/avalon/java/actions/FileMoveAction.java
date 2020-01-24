package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    
    private Path pathFrom;  // a path that file to be moved from.
    private Path pathTo;    // a path to move a file to.    

    /* Constructor */
    public FileMoveAction() { }

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
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        try {    
            Files.move(pathFrom, pathTo, REPLACE_EXISTING);
        } catch (IOException ex) {/*ex.printStackTrace();*/}         
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        threadPool.shutdownNow();
    }

}
