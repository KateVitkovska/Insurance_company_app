import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_InsuranceAPP extends InsuranceInput {
    //Main_InsuranceAPP class inherits methods and parameters from InsuranceInput class, to make calculations accordingly


        public static void main(String[] args) {
            Client client = null;
            Scanner scanner = new Scanner(System.in);

            while (true) {
            //Defining options to choose from
                System.out.println("Hello! What do you want to do:");
                System.out.println("1. Register");
                System.out.println("2. Get client details");
                System.out.println("3. Apply for insurance and calculate premium");
                System.out.println("4. Exit");
                System.out.println("Enter an option");
                int action = scanner.nextInt(); //Input
                scanner.nextLine();

                //Accordingly to chosen action(option) user gets the output
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
                    case 3: /*Apply for insurance and calculate premium -- using methods defined in InsuranceInput
                              class */
                        if (client != null) {
                            //Defining an array with available insurance type options
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
                                //Displays if invalid insurance type is chosen
                                chosenInsurance = scanner.nextLine();
                                System.out.println("You have chosen " + chosenInsurance + " insurance.");

                                if (insuranceTypes.contains(chosenInsurance)) {

                                    if (chosenInsurance.equals("car")) {
                                        handleCarInsurance(scanner);
                                    }
                                    if (chosenInsurance.equals("health")) {
                                        handleHealthInsurance(scanner);
                                    }
                                    if (chosenInsurance.equals("property")) {
                                        handlePropertyInsurance(scanner);
                                    }
                                }
                            }
                        }

                        break;

                    case 4: //Exit app
                        System.out.println("Bye");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please, try again"); //Displays if user inputs invalid option
                }
                System.out.println("=======================================");
            }
        }

    }


