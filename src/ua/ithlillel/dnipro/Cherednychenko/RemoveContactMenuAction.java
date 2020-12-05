package ua.ithlillel.dnipro.Cherednychenko;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Scanner;

public class RemoveContactMenuAction implements MenuAction {

    ContactsService contactService;
    Scanner scanner;

    public RemoveContactMenuAction(ContactsService contactService, Scanner scanner) {
        this.contactService = contactService;
        this.scanner = scanner;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Please enter the contact index (starting with 0) that you would like to remove");
        contactService.remove(scanner.nextInt());
        scanner.nextLine();
        System.out.println("The contact was removed.");
    }

    @Override
    public String getName() {
        return "Remove Contact";
    }

}
