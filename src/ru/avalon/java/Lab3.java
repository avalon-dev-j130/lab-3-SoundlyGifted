package ru.avalon.java;

import java.io.BufferedReader;
import ru.avalon.java.console.ConsoleUI;

import ru.avalon.java.actions.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    
    // Stream that reads console commands.
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));    
       
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        
        FileCopyAction copyAction = new FileCopyAction();
        FileMoveAction moveAction = new FileMoveAction();
        FileCreateAction createAction = new FileCreateAction();
        FileDeleteAction deleteAction = new FileDeleteAction();
        
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                System.out.print("Enter path to file that has to be copied: ");
                copyAction.setPathFrom(Paths.get(in.readLine()));                
                System.out.print("Enter path to copy the file to: ");
                copyAction.setPathTo(Paths.get(in.readLine()));
                copyAction.start();
                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                System.out.print("Enter path to file that has to be moved: ");
                moveAction.setPathFrom(Paths.get(in.readLine()));                
                System.out.print("Enter path to move the file to: ");
                moveAction.setPathTo(Paths.get(in.readLine()));
                moveAction.start();
                break;
            case create:
                System.out.print("Enter path to create a file in "
                        + "(incl. filename with extension): ");
                createAction.setPathTo(Paths.get(in.readLine()));
                createAction.start();
                break;
            case delete:
                System.out.print("Enter path to delete a file from "
                        + "(incl. filename with extension): ");
                deleteAction.setPathFrom(Paths.get(in.readLine()));
                deleteAction.start();
                break;
            case exit:
                try {
                    copyAction.close();
                    moveAction.close();
                    createAction.close();
                    deleteAction.close();
                } catch (Exception ex) { }
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
