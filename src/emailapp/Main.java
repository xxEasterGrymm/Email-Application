package emailapp;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();

        Email app = new Email(firstName, lastName);

        System.out.print("Enter an alternate email: ");
        String alternateEmail = sc.nextLine();
        app.setAlternateEmail(alternateEmail);

        app.display();
    }
}
