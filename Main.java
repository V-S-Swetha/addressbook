import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private final String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

class AddressBook{
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void editContact(String name, String newPhoneNumber, String newEmail){
        for (Contact c : contacts){
           if(c.getName().equalsIgnoreCase(name)){
               c.setPhoneNumber(newPhoneNumber);
               c.setEmail(newEmail);
               System.out.println("updated successfully");
               return;
           }
        }
    }

    public void deleteContact(String name){
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public void searchByName(String name){
        int found=0;
        for(Contact c : contacts){
            if(c.getName().equalsIgnoreCase(name)){
                System.out.println("Name: " + c.getName() + "\nPhoneNumber:" + c.getPhoneNumber() + "\nEmail:" + c.getEmail());
                found=1;
            }
        }
        if(found==0){
            System.out.println("Contact not found");
        }
    }

    public void searchByPhoneNumber(String phoneNumber){
        int found=0;
        for(Contact c : contacts){
            if(c.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                System.out.println("Name: " + c.getName() + "\nPhoneNumber:" + c.getPhoneNumber() + "\nEmail:" + c.getEmail());
                found=1;
            }
        }
        if(found==0){
            System.out.println("Contact not found");
        }
    }

    public void searchByEmail(String email){
        int found=0;
        for(Contact c : contacts){
            if(c.getEmail().equalsIgnoreCase(email)){
                System.out.println("Name: " + c.getName() + "\nPhoneNumber:" + c.getPhoneNumber() + "\nEmail:" + c.getEmail());
                found=1;
            }
        }
        if(found==0){
            System.out.println("Contact not found");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Phone Number");
            System.out.println("6. Search by Email");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    addressBook.addContact(new Contact(name, phoneNumber, email));
                    break;
                case 2:
                    System.out.print("Enter name of contact to edit: ");
                    String nameToEdit = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email address: ");
                    String newEmail = scanner.nextLine();
                    addressBook.editContact(nameToEdit, newPhoneNumber, newEmail);
                    break;
                case 3:
                    System.out.print("Enter name of contact to delete: ");
                    String nameToDelete = scanner.nextLine();
                    addressBook.deleteContact(nameToDelete);
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    addressBook.searchByName(nameToSearch);
                    break;
                case 5:
                    System.out.print("Enter phone number to search: ");
                    String phoneNumberToSearch = scanner.nextLine();
                    addressBook.searchByPhoneNumber(phoneNumberToSearch);
                    break;
                case 6:
                    System.out.print("Enter email to search: ");
                    String emailToSearch = scanner.nextLine();
                    addressBook.searchByEmail(emailToSearch);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

}