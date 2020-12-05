package ua.ithlillel.dnipro.Cherednychenko;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        System.out.println("YOUR PHONE BOOK");
        Scanner scanner = new Scanner(System.in);

        File filePhoneBook = new File("PhoneBook.txt");
        filePhoneBook.createNewFile();

        ContactsList contactsList = new ContactsList();

        //ContactsService contactsService = new InMemoryContactsService(contactsList);

        ContactsService contactsService = new FileContactsService(contactsList,filePhoneBook);

        MenuAction[] menuAction = {new AddContactMenuAction(contactsService, scanner),
                new ReadAllContactMenuAction(contactsService, scanner),
                new RemoveContactMenuAction(contactsService, scanner),
                new CloseContactMenuAction(scanner)};


        Menu menu = new Menu(menuAction, scanner);
        menu.run();

    }
}
