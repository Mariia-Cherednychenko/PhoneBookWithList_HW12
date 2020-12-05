package ua.ithlillel.dnipro.Cherednychenko;

import java.util.Scanner;

public class CloseContactMenuAction implements MenuAction {

     Scanner scanner;

    public CloseContactMenuAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void doAction() {
        System.out.println("Program is closing.");
    }

    @Override
    public String getName() {
        return "Close Program";
    }

    @Override
    public boolean closeAfter() {
        return true;
    }
}
