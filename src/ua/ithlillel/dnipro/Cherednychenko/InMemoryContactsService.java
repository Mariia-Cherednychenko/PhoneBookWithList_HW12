package ua.ithlillel.dnipro.Cherednychenko;

import java.util.Scanner;

public class InMemoryContactsService implements ContactsService {

   ContactsList contactsList;

    public InMemoryContactsService(ContactsList contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public ContactsList getAll() {
        return contactsList;
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    @Override
    public void add(Contact c) {
        contactsList.add(c);
    }
}
