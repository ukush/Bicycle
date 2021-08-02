package Bicycle;
import java.util.*;

public class Main {

    //declare all the customisable options that the users will choose from when creating their own bicycle
    private static final String[] types = {"road", "mountain"};
    private static final String[] materials = {"aluminium", "steel", "titanium", "carbon fibre"};
    private static final String[] colours = {"racing red", "volt blue", "gunmetal grey", "silver", "matte black"};
    private static final float[] roadTyres = {22f, 25f, 28f};
    private static final float[] mountainTyres = {26f, 27.5f, 29f};
    private static final int[] prices = {119, 99, 129, 0, 179, 229, 35, 35, 50, 0, 50, 19, 0, 29, 29, 35, 39, 45, 55, 65, 85};
    private static final int[] gears = {7, 12, 16, 21};

    // Initialise hashmap which maps the customisation options to the price associated with each one
    public static HashMap<Integer, Integer> customPrices = new HashMap<>();

    // Initialise scanner object
    private static final Scanner input = new Scanner(System.in);

    //---------------------------------------------------start of main method-----------------------------------------------------------------------------//
    public static void main(String[] args) {

        // Initialise some Bicycle objects that the user can choose from if they do not want to create their own
        Bicycle bike1 = new Bicycle("allez e5 elite", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);
        Bicycle bike2 = new Bicycle("synapse al sora", "road", "titanium", "silver", 10.4f, 27.5f, 40, 16, 1000);
        Bicycle bike3 = new Bicycle("pinnacle laterite 2", "road", "aluminium", "matte black", 9.8f, 27.5f, 40, 12, 500);
        Bicycle bike4 = new Bicycle("trek marlin 4", "mountain", "titanium", "volt blue", 9.1f, 25f, 35, 16, 850);
        Bicycle bike5 = new Bicycle("x-caliber 8", "mountain", "carbon fibre", "matte black", 8.5f, 29f, 45, 21, 1300);
        Bicycle bike6 = new Bicycle("mongoose roscoe 7", "mountain", "steel", "racing red", 10.6f, 27.5f, 30, 7, 250);

        // create an empty java collection (arrayList) and add the bicycle objects to it
        ArrayList<Bicycle> bikes = new ArrayList<>();
        bikes.add(bike1);
        bikes.add(bike2);
        bikes.add(bike3);
        bikes.add(bike4);
        bikes.add(bike5);
        bikes.add(bike6);


        //Map all keys to values using hashmap
        for (int i = 0; i < prices.length; i++) {
            customPrices.put((i + 1), prices[i]);
        }


        int choice;
        do {
            // introduce the program to the user and display the main menu
            welcome(); // Introduce application to user
            displayMenu();
            choice = validateMainMenuInput(); // display options to user and assign the return value to the variable choice.

            // switch based on menu selection
            switch (choice) {
                case 0:{
                    System.out.println("Thanks for visiting");
                    break; // 0 exits the switch statement
                }
                case 1: {
                    viewBicycleMenu();
                    int viewChoice = validateInput(2); //display menu and validate input and set return value of choice to viewChoice variable
                    if (viewChoice == 1) {
                        // print out the names of the bikes
                        for (Bicycle bike : bikes) {
                            System.out.println(bike.getName());
                        }
                        System.out.println("Select a bicycle to view the specifications:");
                        int bikeChoice = validateInput(bikes.size());
                        // find the object where index = bikeChoice and run the showSpecs() method for that object
                        bikes.get(bikeChoice - 1).showSpecs(); // -1 to get the correct index since they start from 0
                    } else { // because the input has already been validated, if it is not 1 it can only be 2 therefore no need for else-if etc.
                        boolean validIndex;
                        do {
                            System.out.println("Enter the name of the bicycle: ");
                            input.nextLine(); // clear scanner
                            String nameSearch = input.nextLine(); // take in user input for search
                            int indexOfSearch = searchList(bikes, nameSearch); // get the index of the object that has a matching name as user input or return an index of -1 if they don't match

                            if (indexOfSearch == -1) { // the method returns -1 if a bike was not found
                                validIndex = false; // trigger the loop to ask again
                                input.nextLine(); // clear the scanner from the last input
                                System.out.println("That bicycle could not be found. Please Try again.");
                            } else {
                                validIndex = true; // stop the loop
                                bikes.get(indexOfSearch).showSpecs(); // run the showSpecs method
                            }
                        } while (!validIndex); // loop to ensure the object is found

                    }
                    System.out.println();
                    System.out.println("Would you like to purchase this bicycle?");

                    // if yes, we want to print the receipt

                    break;

                }
                case 2: {
                    Bicycle newBike = createNewBicycle(); //create new bicycle
                    bikes.add(newBike); // add new bicycle to list
                    System.out.println();
                    newBike.showSpecs(); // show specs of bike
                    System.out.println("Would you like to purchase this bicycle?");
                    break;
                }
                case 3: {
                    System.out.println("Enter the name of the bicycle you want to remove");
                    String removeName = input.nextLine();

                    break;
                }
            }
        }while (choice!=0); // go back to main menu until the user selects the exit option
    }

//---------------------------------------------  END OF MAIN METHOD-------------------------------------------------------------------------------//
    private static void welcome() {
        //application introduction
        System.out.println();
        System.out.println("Welcome to Atom Cycle Centre");
        System.out.println("Select from the options below: ");
    }

    private static void displayMenu() {
        System.out.println("1. View Bicycles");
        System.out.println("2. Create Custom Bicycle");
        System.out.println("3. Remove Bicycle from Store");
        System.out.println("0. Exit");
    }

    private static void viewBicycleMenu() {
        System.out.println("Would you like to:");
        System.out.println("1. View all bicycles");
        System.out.println("2. Search for bicycles by name");
    }

    private static int validateMainMenuInput() {

        boolean isInputValid;
        int choice = 0;
        do {
            try {
                choice = input.nextInt(); // take in user input
                // create loop to validate the input is within range
                if (choice < 0 || choice > 3) { // if the input is not in range
                    System.out.println("Error: That is not a valid option. Please try again."); // display error message
                    isInputValid = false; // trigger while loop
                    input.nextLine(); // clear scanner
                } else {
                    isInputValid = true; // stop while loop
                }
            } catch (InputMismatchException e) { //catch exception of input is not a number (InputMismatch exception)
                input.nextLine(); // clear scanner token
                System.out.println("That is not a valid input. Please enter a number using your keypad."); // display error message
                isInputValid = false; // trigger the while loop
            }
        } while (!isInputValid);
        return choice;
    }


    private static int getPrices(int userInput) {
        return customPrices.get(userInput);
    }

    private static int addPrices(int price1, int price2, int price3, int price4, int price5) {
        return price1 + price2 + price3 + price4 + price5;
    }

    private static void printMaterials(int bikeType, String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". " + array[i]);

            if (bikeType == 1) {
                if (i == 3) {
                    System.out.println("(recommended)");
                } else {
                    System.out.println();
                }

            } else {
                if (i == 0) {
                    System.out.println("(recommended)");
                } else {
                    System.out.println();
                }
            }

        }
    }

    private static void printColours(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". " + array[i]);
            System.out.println();
        }
    }

    private static void printTyreDiameters(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". " + array[i] + "\"");
            System.out.println();
        }
    }

    private static void printTypes(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i] + " bike");
        }

    }

    private static void printGears(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }

    }

    private static int validateInput(int numberOfOptions) {

        boolean isInputValid;
        int choice = 0;
        do {
            try {
                choice = input.nextInt(); // take in user input
                // create loop to validate the input is within range
                if (choice <= 0 || choice > numberOfOptions) { // if the input is not in range
                    System.out.println("Error: That is not a valid option. Please try again."); // display error message
                    isInputValid = false; // trigger while loop
                    input.nextLine(); // clear scanner
                } else {
                    isInputValid = true; // stop while loop
                }
            } catch (InputMismatchException e) { //catch exception of input is not a number (InputMismatch exception)
                input.nextLine(); // clear scanner token
                System.out.println("That is not a valid input. Please enter a number using your keypad."); // display error message
                isInputValid = false; // trigger the while loop
            }
        } while (!isInputValid);
        return choice;
    }

    private static Bicycle createNewBicycle() {
        System.out.println("Create your own custom bicycle!");
        //display options to user to create custom bike

        System.out.println("Let's start off by giving your custom bicycle a name");
        input.nextLine();
        String selectedName = input.nextLine();

        System.out.println("Select the type of bike:");
        printTypes(types);
        int choice1 = validateInput(2);
        String selectedType = types[choice1 - 1];


        System.out.println("Select the frame material:");
        printMaterials(choice1, materials);
        int choice2 = validateInput(4);
        String selectedMaterial = materials[choice2 - 1];

        // assign the weight and top speeds based on the material
        float bikeWeight = 0;
        int topSpeed = 0;
        switch (choice2) {
            case 1 -> {
                bikeWeight = 10.2f;
                topSpeed = 45;
            }
            case 2 -> {
                bikeWeight = 12.1f;
                topSpeed = 40;
            }
            case 3 -> {
                bikeWeight = 10.5f;
                topSpeed = 45;
            }
            case 4 -> {
                bikeWeight = 8.3f;
                topSpeed = 53;
            }
        }


        System.out.println("Select the colour:");
        printColours(colours);
        int choice3 = validateInput(5);
        String selectedColour = colours[choice3 - 1];

        System.out.println("Select the tyre diameter:");

        if (choice1 == 1) {
            printTyreDiameters(roadTyres);
        } else {
            printTyreDiameters(mountainTyres);
        }
        int choice4 = validateInput(3);

        float selectedDiameter;
        if (choice1 == 1) {
            selectedDiameter = roadTyres[choice4 - 1];
        } else {
            selectedDiameter = mountainTyres[choice4 - 1];
        }

        System.out.println("Select the number of gears you want to have");
        printGears(gears);
        int choice5 = validateInput(4);
        int selectedGear = gears[choice5 - 1];


        // calculate total price of the bike created
        int totalPrice = addPrices(getPrices(choice1), getPrices(choice2), getPrices(choice3), getPrices(choice4), getPrices(choice5));

        // use all selected attributes in bicycle constructor method to create a new Bicycle object
        // add this new Bicycle object to the arrayList of stored Bicycles

        return new Bicycle(selectedName, selectedType, selectedMaterial, selectedColour, bikeWeight, selectedDiameter, topSpeed, selectedGear, totalPrice);
    }

    private static int searchList(ArrayList<Bicycle> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
