import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainImpl extends InsuranceInput {


    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


        public static void main(String[] args) {
            Client client = null;
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("What you want to do:");
                System.out.println("1. Register:");
                System.out.println("2. Get client details");
                System.out.println("3. Apply for insurance and calculate premium");
                System.out.println("4. Exit");
                System.out.println("Enter an option");
                int action = scanner.nextInt();
                scanner.nextLine();

                switch (action) {
                    case 1: //register new client
                        if (client == null) {

                            System.out.println("Enter your full name: ");
                            String fullName = scanner.nextLine();


                            System.out.println("Enter your age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();

                            client = new Client(fullName,
                                    age);
                            System.out.println("Client registered");

                        } else {
                            System.out.println("Client already registered");
                        }

                        break;

                    case 2: //get client details
                        if (client != null) {
                            client.getClientInfo();
                        } else {
                            System.out.println("Register first");
                        }
                        break;
                    case 3: //Apply for insurance and calculate premium
                        if (client != null) {

                            List<String> insuranceTypes = Arrays.asList("health", "property", "car");

                            System.out.println("Choose the type of insurance: ");
                            System.out.println("Available options: " + insuranceTypes);
                            String chosenInsurance = scanner.nextLine();
                            if (insuranceTypes.contains(chosenInsurance)) {
                                System.out.println("You have chosen " + chosenInsurance + " insurance.");
                                if (chosenInsurance.equals("car")) {
                                    handleCarInsurance(scanner);
                                } if (chosenInsurance.equals("health")) {
                                    handleHealthInsurance(scanner);
                                } if(chosenInsurance.equals("property")){
                                    handlePropertyInsurance(scanner);
                                }
                            } else {
                                System.out.println("Invalid insurance type. Please choose from the available options.");
                                chosenInsurance = scanner.nextLine();
                                System.out.println("You have chosen " + chosenInsurance + " insurance.");
                            }
                        }

                        break;

                    case 4: //Exit app
                        System.out.println("Bye");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please, try again");
                }
                System.out.println("=======================================");
            }
        }

    }


