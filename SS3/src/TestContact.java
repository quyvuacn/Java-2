import java.util.Scanner;

/*
Author : Quy Vu
*/
public class TestContact {
    public static void main(String[] args) {

        ContactList contactList = new ContactList();
        Contact contact1 = new Contact("Vu Viet Quy","0326459773");
        Contact contact2 = new Contact("Ta Duy Linh","12345678910");

        contactList.addContact(contact1);
        contactList.addContact(contact2);

        contactList.updateContact(contact1,contact2);
        contactList.getListContact();



    }
}
