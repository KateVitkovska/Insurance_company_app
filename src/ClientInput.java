

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class ClientInput{
    private String fullName;

    //Getter method for name
    public String getFullName() {
        return this.fullName;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Insurance Company App!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your Full Name: ");
        String fullName = sc.nextLine();

        int age;
        String ageInput = "";

        while (true) {
            try {
                out.println("Please enter your age:");
                ageInput = sc.nextLine();
                age = Integer.parseInt(ageInput);
                out.println("Client registered");
                break;
            } catch (NumberFormatException exception) {
                out.println("Error: '" + ageInput + "' should be a whole number!");

            }

        }
    }

}
