package emailapp;

import java.util.Hashtable;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength;
    private String email;
    private String companySuffix;
    private int mailboxCapacity;
    Hashtable<String, String> details = new Hashtable<>();

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        defaultPasswordLength = 16;
        this.password = generatePassword(defaultPasswordLength);

        // Combine elements to generate email
        companySuffix = "company.com";
        if(department.equals("")) email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        else email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

        mailboxCapacity = 500;

        details.put("Name", firstName + " " + lastName);
        details.put("Department", department);
        details.put("Password", password);
        details.put("Email", email);
        details.put("Mail Box Capacity", "" + mailboxCapacity);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none\nEnter the department");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if(depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "";
    }

    // Generate a random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*<>?,./{}|[];':`~-=_+";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set alternate email
    public void setAlternateEmail(String alternateEmail) {
        details.put("Alternate Email", alternateEmail);
    }

    public void display() {
        System.out.println("\nName - " + details.get("Name") +
                "\nDepartment - " + details.get("Department") +
                "\nEmail - " + details.get("Email") +
                "\nPassword - " + details.get("Password") +
                "\nAlternate Email - " + details.get("Alternate Email") +
                "\nMailbox Capacity - " + details.get("Mail Box Capacity"));
    }
}