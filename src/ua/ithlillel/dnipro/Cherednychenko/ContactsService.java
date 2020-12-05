package ua.ithlillel.dnipro.Cherednychenko;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ContactsService {
    public ContactsList getAll() throws IOException;
    public void remove (int index) throws IOException;
    public void add(Contact c) throws IOException;

}
