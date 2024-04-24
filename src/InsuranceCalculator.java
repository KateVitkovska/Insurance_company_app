import java.util.Scanner;

class InsuranceCalculator {
    /**
     * Using @ENUM classes to define unchangeable variables for using them in @calculatePremium method
     */

    enum CarAccidents {
        YES, NO
    }

    enum HealthStatus {
        YES, NO
    }
    enum PropertyType{
        HOUSE, APARTMENT, NO
    }

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculate Insurance Premium:");

        // Asking about car accidents using scanner for user input
        System.out.println("Did you have any car accidents? (Yes/No)");
        CarAccidents carAccidents = CarAccidents.valueOf(scanner.nextLine().toUpperCase());


        // Asking about smoking using scanner for user input
        System.out.println("Do you smoke? (Yes/No)");
        HealthStatus healthStatus = HealthStatus.valueOf(scanner.nextLine().toUpperCase());

       // Asking about property using scanner for user input
        System.out.println("What kind of property do you have? (House/Apartment)");
        PropertyType propertyType = PropertyType.valueOf(scanner.nextLine().toUpperCase());

        // Calculating premium using method created below
        double basePremium = 1000; // Base premium amount
        double premium = calculatePremium(basePremium, carAccidents, healthStatus, propertyType);

        // Displaying premium
        System.out.println("Your insurance premium is: $" + premium);

    }
    //Creating method to calculate premium
    public static double calculatePremium(double basePremium, CarAccidents carAccidents, HealthStatus healthStatus, PropertyType propertyType) {
        // Adjusting premium based on car accidents
        //If there were accidents, premium will be higher
        if (carAccidents == CarAccidents.YES) {
            basePremium += 500; // Increases premium by $500 for car accidents
        }

        // Adjusting premium based on smoking status
        //If user smokes, premium will be higher
        if (healthStatus == HealthStatus.YES) {
            basePremium += 1000; // Increases premium by $1000 for smokers
        }
        // Adjusting premium based on property type

        if (propertyType == PropertyType.HOUSE) {
            basePremium += 2000; // Increases premium by $2000 House
        }
        if (propertyType == PropertyType.APARTMENT) {
            basePremium += 1500; // Increases premium by $1500 for Apartment
        }

        return basePremium; //Returns the result
    }
}

