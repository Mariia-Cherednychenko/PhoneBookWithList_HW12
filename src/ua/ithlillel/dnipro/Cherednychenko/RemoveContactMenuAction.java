package ua.ithlillel.dnipro.Cherednychenko;

import java.io.IOException;
import java.util.Scanner;

public class RemoveContactMenuAction implements MenuAction {

    ContactsService contactService;
    Scanner scanner;
    ContactsList contactsList;

    public RemoveContactMenuAction(ContactsService contactService, Scanner scanner, ContactsList contactsList) {
        this.contactService = contactService;
        this.scanner = scanner;
        this.contactsList=contactsList;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Please enter the contact No that you would like to remove. If you want to return to main menu - please enter any letter.");
        int index= scanner.nextInt()-1;
        checkIndexInput(index);
        contactService.remove(index);
        scanner.nextLine();
        System.out.println("The contact was removed.");
    }

    @Override
    public String getName() {
        return "Remove Contact";
    }

    public void checkIndexInput(int index) throws IOException {
        if (index<0 || index > contactsList.size()){
            System.out.println("Incorrect input");
            doAction();
        }
    }

}
