package ua.ithlillel.dnipro.Cherednychenko;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {

    ContactsService contactService;
    Scanner scanner;

    public AddContactMenuAction(ContactsService contactService, Scanner scanner) {
        this.contactService = contactService;
        this.scanner = scanner;
    }

    @Override
    public void doAction() throws IOException {

        System.out.println("Please enter name: ");
        String name=scanner.nextLine();
        System.out.println("Please enter phone number: ");
        String phone=scanner.nextLine();
        Contact contact = new Contact(name, phone);
        contactService.add(contact);
        System.out.println("New contact - " + contact+ " - was added.");

    }

    @Override
    public String getName() {
        return "Add Contact";
    }

}
