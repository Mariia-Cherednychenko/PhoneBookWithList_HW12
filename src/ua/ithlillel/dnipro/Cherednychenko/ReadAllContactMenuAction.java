package ua.ithlillel.dnipro.Cherednychenko;

import java.io.IOException;
import java.util.Scanner;

public class ReadAllContactMenuAction implements MenuAction {

    ContactsService contactService;
    Scanner scanner;

    public ReadAllContactMenuAction(ContactsService contactService, Scanner scanner) {
        this.contactService = contactService;
        this.scanner = scanner;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println(contactService.getAll());
    }

    @Override
    public String getName() {
        return "Read all Contact";
    }

}
