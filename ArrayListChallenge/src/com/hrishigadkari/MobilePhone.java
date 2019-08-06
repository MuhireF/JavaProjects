package com.hrishigadkari;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactsList= new ArrayList<Contacts>();

    public void printContactList(){
        if(contactsList.isEmpty()){
            System.out.println("There are no contacts added yet");
        }
        else {
            for (int i = 0; i < contactsList.size(); i++){
                System.out.println((i+1) + ". " + contactsList.get(i).getName());
            }
        }
    }

    public void storeContact(Contacts contact){
        contactsList.add(contact);
        System.out.println("The Contact with name " + contact.getName() + " and number " + contact.getPhoneNumber() + " has been stored");
    }

    public void modifyContact(String name, String newName){
        Contacts contact = contactExists(name);

        if(contact != null){
            contact.setName(newName);
            System.out.println("The Contact with name " + name + " and number " + contact.getPhoneNumber() + " has been modified with new name as " + contact.getName());
        }
        else{
            System.out.println("Contact not found");
        }
    }

    public void removeContact(String name){
        Contacts contact = contactExists(name);
        if(contact != null){
            contactsList.remove(contactsList.indexOf(contact));
            System.out.println("The contact has been successfully removed");
        }
        else{
            System.out.println("Contact not found");
        }
    }
    public void findContact(String name){
        Contacts contact = contactExists(name);
        if(contact != null){
            System.out.println("The Contact with name " + contact.getName() + " and number " + contact.getPhoneNumber() + " has been foound");
        }
        else{
            System.out.println("Contact not found!");
        }
    }

    private Contacts contactExists(String name){
        for (int i = 0; i < contactsList.size(); i++) {
            if(contactsList.get(i).getName().equals(name))
                return contactsList.get(i);
        }

        return null;
    }


}

class Contacts {
    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Contacts createContact(String name, String phoneNumber){
        return new Contacts(name, phoneNumber);
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
