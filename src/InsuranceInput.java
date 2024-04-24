import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsuranceInput {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Defines the list of available insurance types
        List<String> insuranceTypes = Arrays.asList("health", "property", "car");

        System.out.println("Choose the type of insurance: "); //Returns "Choose the type of insurance: "
        System.out.println("Available options: " + insuranceTypes); /*Returns "Choose the type of insurance:
        ["health", "property", "car"]"*/

        String chosenInsurance = scanner.nextLine();

        /** Defining the logic: insurance calculation method, defined in InsuranceCalculator class will be
         called accordingly to chosen insurance type. Also
         * @handlePropertyInsurance method when called will calculate property insurance
         * @handleCarInsurance method when called will calculate car insurance
         * @handleHealthInsurance method when called will calculate health insurance
         *
         * If user chooses action 3 (Apply for insurance and calculate premium) he will be asked to choose
         * the insurance type and accordingly to chosen type some questions will be asked to make precise calculations.
         *
         * Accordingly, to the chosen insurance type appropriate method will be called.
         */

        if (insuranceTypes.contains(chosenInsurance)) {
            System.out.println("You have chosen " + chosenInsurance + " insurance.");
            if (chosenInsurance.equals("car")) {
                handleCarInsurance(scanner);
            } else if (chosenInsurance.equals("health")) {
                handleHealthInsurance(scanner);
            } else if (chosenInsurance.equals("property")) {
                handlePropertyInsurance(scanner);
            }
        } else { //if invalid insurance type is chosen (that is not on the list), then a notification
            //will be displayed with the option to try again and choose from the available options.
            System.out.println("Invalid insurance type. Please choose from the available options.");
            chosenInsurance = scanner.nextLine();
            //if this time chosen option is chosen from the available ones, then notification will be displayed
            //"You have chosen:...... insurance"
            System.out.println("You have chosen " + chosenInsurance + " insurance.");
        }
    }

    /**
     * @handlePropertyInsurance method asks user some questions about property and then calls @calculatePremium method
     * for property insurance type.
     * User shall input from two options @propertyType : House or Apartment
     */
    public static void handlePropertyInsurance(Scanner scanner) {
        System.out.println("What kind of property do you have? (House/Apartment)");
        String propertyType = scanner.nextLine().toUpperCase();


        if (propertyType.equals("APARTMENT")) {
            System.out.println("Insurance premium will be lower.");
        } else if (propertyType.equals("HOUSE")) {
            System.out.println("Insurance premium will be higher.");
        } else {
            System.out.println("Invalid input. Please answer with 'House' or 'Apartment'.");
            handlePropertyInsurance(scanner); // Prompt the user again for input
        }
        InsuranceCalculator.PropertyType type = InsuranceCalculator.PropertyType.valueOf(propertyType);
        double premium = InsuranceCalculator.calculatePremium(1000, InsuranceCalculator.CarAccidents.NO, InsuranceCalculator.HealthStatus.NO, type);
        System.out.println("Your insurance premium is: " + premium);
    }

    /**
     * @handleCarInsurance method asks user some questions about a car and then calls @calculatePremium method
     * for car insurance type.
     *
     */
    public static void handleCarInsurance(Scanner scanner) {


        System.out.println("Did you have accidents before? (Yes/No)");
        String carAccidents = scanner.nextLine().toLowerCase();
        if (carAccidents.equals("yes")) {
            System.out.println("Insurance premium will be higher.");
        } else if (carAccidents.equals("no")) {
            System.out.println("Insurance premium will be lower.");
        } else {
            System.out.println("Invalid input. Please answer with 'Yes' or 'No'.");
            handleCarInsurance(scanner); // Prompt the user again for input
        }
        InsuranceCalculator.CarAccidents accidents = carAccidents.equals("yes") ? InsuranceCalculator.CarAccidents.YES : InsuranceCalculator.CarAccidents.NO;

        double premium = InsuranceCalculator.calculatePremium(1000, accidents, InsuranceCalculator.HealthStatus.NO, InsuranceCalculator.PropertyType.NO);

        System.out.println("Your insurance premium is: $" + premium);


    }
    /**
     * @handleHealthInsurance method asks user some questions about health and then calls @calculatePremium method
     * for health insurance type.
     *
     */
    public static void handleHealthInsurance(Scanner scanner) {
        System.out.println("Do you smoke? (Yes/No)"); //User should choose between provided options
        String smoke = scanner.nextLine();

        if (smoke.equals("yes")) {
            System.out.println("Insurance premium will be higher.");
        } else if (smoke.equals("no")) {
            System.out.println("Insurance premium will be lower.");
        } else {
            //if user enters inappropriate input, program prompts user to try again
            System.out.println("Invalid input. Please answer with 'Yes' or 'No'.");
            handleCarInsurance(scanner); // Prompt the user again for input
        }

        InsuranceCalculator.HealthStatus status = smoke.equals("yes") ? InsuranceCalculator.HealthStatus.YES : InsuranceCalculator.HealthStatus.NO;
        double premium = InsuranceCalculator.calculatePremium(1000, InsuranceCalculator.CarAccidents.NO, status, InsuranceCalculator.PropertyType.NO);

        System.out.println("Your insurance premium is: " + premium);


    }

}












