package ua.ithlillel.dnipro.Cherednychenko.contacts.repositories;

import ua.ithlillel.dnipro.Cherednychenko.contacts.Contact;
import ua.ithlillel.dnipro.Cherednychenko.contacts.ContactsRepository;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InMemoryContactsRepository implements ContactsRepository {

    private List<Contact> contactsList = new ArrayList<>();

    @Override
    public List<Contact> getAll() {
        return contactsList;
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    @Override
    public boolean add(Contact contact) {

        if (!checkPhoneValidation(contact.getPhone())){
            return false;
        }
        else {
            contactsList.add(contact);
            return true;
        }
    }

    @Override
    public List<Contact> checkPartPhoneNumber(String partPhoneNumber) {
        List<Contact> contactsListPartPhone = new ArrayList<>();
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhone().replaceAll("\\s", "").contains(partPhoneNumber)) {
                contactsListPartPhone.add(contactsList.get(i));
            }
        }
        return contactsListPartPhone;

    }

    @Override
    public List<Contact> checkBeginningName(String beginningName) throws IOException {
        List<Contact> contactsListBeginningName = new ArrayList<>();
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getName().toLowerCase().startsWith(beginningName.toLowerCase())){
                contactsListBeginningName.add(contactsList.get(i));
            }
        }
        return contactsListBeginningName;
    }


}
