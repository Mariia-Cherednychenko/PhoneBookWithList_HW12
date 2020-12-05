package ua.ithlillel.dnipro.Cherednychenko;

import java.io.*;
import java.util.Scanner;

public class FileContactsService implements ContactsService {

    ContactsList contactsList;
    File file;


    public FileContactsService(ContactsList contactsList, File file) {
        this.contactsList = contactsList;
        this.file = file;
    }

    @Override
    public ContactsList getAll() throws IOException {

        ContactsList contactListFromFile = new ContactsList();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;

        while (true) {
            line = reader.readLine();
            if (line == null) {
                break;
            } else {
                String[] contactLine = line.split(" ");
                contactListFromFile.add(new Contact(contactLine[0], contactLine[1]));
            }
        }
        reader.close();
        return contactListFromFile;
    }


    @Override
    public void remove(int index) throws IOException {
        File tmp = File.createTempFile("tmp", "");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tmp, true));
        String line = null;

        for (int i = 0; i < index; i++) {
            line = reader.readLine();
            if (line == null) {
                break;
            }
            writer.write(line);
        }
        line = reader.readLine();

        while (true) {
            line = reader.readLine();
            if (line == null) {
                break;
            }
            writer.write(line);

        }
        reader.close();
        writer.close();

        file.renameTo(new File("OldPhoneBook.txt"));
        tmp.renameTo(new File("PhoneBook.txt"));


    }


    @Override
    public void add(Contact c) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        writer.write(c.toString()+"\n");
        writer.close();
    }
}
