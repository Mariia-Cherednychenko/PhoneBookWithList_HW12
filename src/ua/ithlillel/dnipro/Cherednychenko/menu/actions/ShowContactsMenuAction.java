package ua.ithlillel.dnipro.Cherednychenko.menu.actions;

import ua.ithlillel.dnipro.Cherednychenko.contacts.Contact;
import ua.ithlillel.dnipro.Cherednychenko.contacts.ContactsRepository;
import ua.ithlillel.dnipro.Cherednychenko.menu.MenuAction;

import java.io.IOException;
import java.util.List;

public class ShowContactsMenuAction implements ShowContactList, MenuAction {

    private ContactsRepository contactsRepository;

    public ShowContactsMenuAction(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public String getName() {
        return "show all contacts";
    }

    @Override
    public void execute() throws IOException {
        List<Contact> contactList = contactsRepository.getAll();
        showChosenContacts(contactList);

    }
}


