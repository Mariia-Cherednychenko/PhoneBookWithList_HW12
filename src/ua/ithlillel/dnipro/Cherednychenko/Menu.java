package ua.ithlillel.dnipro.Cherednychenko;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    MenuAction[] action;
    Scanner scanner;


    public Menu(MenuAction[] action, Scanner scanner) {
        this.action = action;
        this.scanner = scanner;
    }

    public void addAction(MenuAction action) throws IOException {
        action.doAction();

    }

    public void run() throws IOException {
        boolean close = false;

        while (!close) {
            for (int i = 0; i < action.length; i++) {
                System.out.print((i + 1) + " - ");
                System.out.println(action[i].getName());
            }

            System.out.println("Enter your choice: ");

            try {
                int choice = scanner.nextInt() - 1;
                scanner.nextLine();

                if ((choice >= 0) && (choice <= action.length)) {
                    addAction(action[choice]);
                    close = action[choice].closeAfter();
                } else {
                    System.out.println("Incorrect input. You could try again");
                }

            } catch (Exception E) {
                System.out.println("Incorrect input. You could try again");
                scanner.nextLine();
            }

        }


    }
}

