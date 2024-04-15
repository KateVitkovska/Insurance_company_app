import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsuranceInput {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Define the list of available insurance types
        List<String> insuranceTypes = Arrays.asList("health", "property", "car");

        System.out.println("Choose the type of insurance: ");
        System.out.println("Available options: " + insuranceTypes);
        String chosenInsurance = scanner.nextLine();

        if (insuranceTypes.contains(chosenInsurance)) {
            System.out.println("You have chosen " + chosenInsurance + " insurance.");
            if (chosenInsurance.equals("car")) {
                handleCarInsurance(scanner);
            } else if (chosenInsurance.equals("health")) {
                handleHealthInsurance(scanner);
            } else if (chosenInsurance.equals("property")) {
                handlePropertyInsurance(scanner);
            }
        } else {
            System.out.println("Invalid insurance type. Please choose from the available options.");
            chosenInsurance = scanner.nextLine();
            System.out.println("You have chosen " + chosenInsurance + " insurance.");
        }
    }


    public static void handlePropertyInsurance(Scanner scanner) {
        System.out.println("What kind of property do you have? (House/Apartment)");
        String propertyType = scanner.nextLine().toUpperCase();

        InsuranceCalculator.PropertyType type = InsuranceCalculator.PropertyType.valueOf(propertyType);
        double premium = InsuranceCalculator.calculatePremium(1000, InsuranceCalculator.CarAccidents.NO, InsuranceCalculator.HealthStatus.NO, type);
        System.out.println("Your insurance premium is: " + premium);

        if (propertyType.equals("APARTMENT")) {
            System.out.println("Insurance premium will be lower.");
        } else if (propertyType.equals("HOUSE")) {
            System.out.println("Insurance premium will be higher.");
        } else {
            System.out.println("Invalid input. Please answer with 'House' or 'Apartment'.");
            handlePropertyInsurance(scanner); // Prompt the user again for input
        }
    }


    public static void handleCarInsurance(Scanner scanner) {


        System.out.println("Did you have accidents before? (Yes/No)");
        String carAccidents = scanner.nextLine().toLowerCase();
        InsuranceCalculator.CarAccidents accidents = carAccidents.equals("yes") ? InsuranceCalculator.CarAccidents.YES : InsuranceCalculator.CarAccidents.NO;

        double premium = InsuranceCalculator.calculatePremium(1000, accidents, InsuranceCalculator.HealthStatus.NO, InsuranceCalculator.PropertyType.NO);

        System.out.println("Your insurance premium is: $" + premium);

        if (carAccidents.equals("yes")) {
            System.out.println("Insurance premium will be higher.");
        } else if (carAccidents.equals("no")) {
            System.out.println("Insurance premium will be lower.");
        } else {
            System.out.println("Invalid input. Please answer with 'Yes' or 'No'.");
            handleCarInsurance(scanner); // Prompt the user again for input
        }
    }

    public static void handleHealthInsurance(Scanner scanner) {
        System.out.println("Do you smoke? (Yes/No)");
        String smoke = scanner.nextLine();

        InsuranceCalculator.HealthStatus status = smoke.equals("yes") ? InsuranceCalculator.HealthStatus.YES : InsuranceCalculator.HealthStatus.NO;
        double premium = InsuranceCalculator.calculatePremium(1000, InsuranceCalculator.CarAccidents.NO, status, InsuranceCalculator.PropertyType.NO);

        System.out.println("Your insurance premium is: " + premium);

        if (smoke.equals("yes")) {
            System.out.println("Insurance premium will be higher.");
        } else if (smoke.equals("no")) {
            System.out.println("Insurance premium will be lower.");
        } else {
            System.out.println("Invalid input. Please answer with 'Yes' or 'No'.");
            handleCarInsurance(scanner); // Prompt the user again for input
        }
    }

}












