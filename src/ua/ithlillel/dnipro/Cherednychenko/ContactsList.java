package ua.ithlillel.dnipro.Cherednychenko;

import java.util.Arrays;

public class ContactsList {

    private final double RATE =1.5;
    private int limitSize = 10;
    Contact [] contacts = new Contact[limitSize];
    private int size =0;

    public Contact getContacts(int index) {
        checkIndexValidation(index);
        return contacts [index];
    }

    public void setContacts(int index, Contact c) {
        checkIndexValidation(index);
        contacts [index] = c;
    }

    public int size(){
        return size;
    }

    public void remove (int index){
        checkIndexValidation(index);

        for (int i = index; i<size; i++){
            contacts[i]=contacts[i+1];
        }
        size--;
    }

    public void add (Contact c){
        checkLimitSize();
        contacts[size]=c;
        size++;
    }

    private void checkIndexValidation(int index) {
        if (index > size || index < 0) {
            System.out.println("You indicate incorrect input. Index is not exist. It is IndexOutOfBoundsException. The program will be closed");
            throw new IndexOutOfBoundsException();
        }
    }

    private  void checkLimitSize(){
        if (size==limitSize){
            limitSize= (int) Math.ceil( limitSize*RATE);
        }
        contacts= Arrays.copyOf(contacts,limitSize);
    }

    @Override
    public String toString() {
        if (size!=0) {
            String contactsInfo = "All contacts are below: ";
            for (int i = 0; i < size; i++) {
                contactsInfo = contactsInfo + "\nContact No " + (i + 1) +
                        " " + contacts[i];
            }
            return contactsInfo;
        }
        else return "The Contacts list is empty";
    }
}
