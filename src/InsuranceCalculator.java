import java.util.Scanner;

class InsuranceCalculator {
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

        // Ask about car accidents
        System.out.println("Did you have any car accidents? (Yes/No)");
        CarAccidents carAccidents = CarAccidents.valueOf(scanner.nextLine().toUpperCase());


        // Ask about smoking
        System.out.println("Do you smoke? (Yes/No)");
        HealthStatus healthStatus = HealthStatus.valueOf(scanner.nextLine().toUpperCase());

       // Ask about property
        System.out.println("What kind of property do you have? (House/Apartment)");
        PropertyType propertyType = PropertyType.valueOf(scanner.nextLine().toUpperCase());

        // Calculate premium
        double basePremium = 1000; // Base premium amount
        double premium = calculatePremium(basePremium, carAccidents, healthStatus, propertyType);

        // Display premium
        System.out.println("Your insurance premium is: $" + premium);

    }
    public static double calculatePremium(double basePremium, CarAccidents carAccidents, HealthStatus healthStatus, PropertyType propertyType) {
        // Adjust premium based on car accidents
        if (carAccidents == CarAccidents.YES) {
            basePremium += 500; // Increase premium by $500 for car accidents
        }

        // Adjust premium based on smoking status
        if (healthStatus == HealthStatus.YES) {
            basePremium += 1000; // Increase premium by $1000 for smokers
        }
        // Adjust premium based on smoking status

        if (propertyType == PropertyType.HOUSE) {
            basePremium += 2000; // Increase premium by $2000 for smokers
        }
        if (propertyType == PropertyType.APARTMENT) {
            basePremium += 1500; // Increase premium by $1500 for smokers
        }

        return basePremium;
    }
}

