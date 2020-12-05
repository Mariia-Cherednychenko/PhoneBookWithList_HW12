package ua.ithlillel.dnipro.Cherednychenko;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    MenuAction[] action;
    Scanner scanner;
    boolean close;


    public Menu(MenuAction[] action, Scanner scanner) {
        this.action = action;
        this.scanner = scanner;
    }

    public void addAction(MenuAction action) throws IOException {
        action.doAction();

    }

    public void run() throws IOException {

        while (!close) {
            for (int i = 0; i < action.length; i++) {
                System.out.print((i + 1) + " - ");
                System.out.println(action[i].getName());
            }

            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt() - 1;
            scanner.nextLine();

            addAction(action[choice]);
            close = action[choice].closeAfter();


        }
    }


    private void checkChoiceСorrectness(int choice) throws IOException {
        if (choice < 0 && choice > 3) {
            System.out.println("Incorrect input");
            run();
        }
    }



}
