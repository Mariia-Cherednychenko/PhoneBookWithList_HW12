package ua.ithlillel.dnipro.Cherednychenko.contacts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ContactsRepository {

    List<Contact> getAll() throws IOException;
    void remove (int index) throws IOException;
    boolean add (Contact contact) throws IOException;
    List<Contact> checkPartPhoneNumber(String partPhoneNumber) throws IOException;
    List<Contact> checkBeginningName(String beginningName) throws IOException;

    default boolean checkPhoneValidation(String phone) {

        try {
            Pattern pattern = Pattern.compile("^((\\+3\\s?\\-?8\\s?\\-?\\(?0)|(8\\s?\\-?\\(?0)|(\\(?0))\\d{2}\\s?\\-?\\)?((\\d{2}\\s?\\-?\\d{2}\\s?\\-?\\d{3})|(\\d{3}\\s?\\-?\\d{2}\\s?\\-?\\d{2}))$");
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
        }

        catch (Exception e){
            return  false;
        }

    }
}
