package Bicycle;
import java.util.*;

public class Main {


    // Initialise scanner object
    public static final Scanner input = new Scanner(System.in);

    // create instance of Inventory class to be able to use the methods
    public static BicycleInventory inv = new BicycleInventory();


    //---------------------------------------------------start of main method-----------------------------------------------------------------------------//
    public static void main(String[] args) {


        // Initialise some Bicycle objects that the user can choose from if they do not want to create their own
        Bicycle bike1 = new Bicycle("allez e5 elite", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);
        Bicycle bike2 = new Bicycle("synapse al sora", "road", "titanium", "silver", 10.4f, 27.5f, 40, 16, 1000);
        Bicycle bike3 = new Bicycle("pinnacle laterite 2", "road", "aluminium", "matte black", 9.8f, 27.5f, 40, 12, 500);
        Bicycle bike4 = new Bicycle("trek marlin 4", "mountain", "titanium", "volt blue", 9.1f, 25f, 35, 16, 850);
        Bicycle bike5 = new Bicycle("x-caliber 8", "mountain", "carbon fibre", "matte black", 8.5f, 29f, 45, 21, 1300);
        Bicycle bike6 = new Bicycle("mongoose roscoe 7", "mountain", "steel", "racing red", 10.6f, 27.5f, 30, 7, 250);


        // add bikes to list using the addBicycleToList method in the inventory class
        inv.addBicyclesToList(bike1);
        inv.addBicyclesToList(bike2);
        inv.addBicyclesToList(bike3);
        inv.addBicyclesToList(bike4);
        inv.addBicyclesToList(bike5);
        inv.addBicyclesToList(bike6);


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
                } // end of case 1
//--------------------------------------View Bikes--------------------------------------------------------------------------------//
                case 1: {
                    viewBicycleMenu();
                    int viewChoice = validateInput(2); //display menu and validate input and set return value of choice to viewChoice variable
                    if (viewChoice == 1) {

                        System.out.println("Inventory: ");

                        // print out the names of the bikes
                        for (Bicycle bike : inv.getList()) {
                            System.out.println((inv.getList().indexOf(bike) + 1) + "." + bike.getName());
                        }
                        System.out.println("\nSelect from the options below:");
                        System.out.println("1. View technical specifications\n2. Display list in reverse order");
                        int selection = validateInput(2);
                        if (selection == 1) {
                            System.out.println("Select a bicycle to view the technical specifications: ");
                            int bikeChoice = validateInput(inv.getList().size());
                            // find the object where index = bikeChoice and run the showSpecs() method for that object
                            inv.getList().get(bikeChoice - 1).showSpecs(); // -1 to get the correct index since they start from 0
                        }
                    else {
//------------------------------------------Reverse List Order-----------------------------------------------------------------//
                        ArrayList<Bicycle> reversedList = new ArrayList<Bicycle>(inv.getList()); // make a copy of the list
                        inv.reverseListRecursively(reversedList, 0, reversedList.size() - 1); // reverse the list
                        for (Bicycle bike : reversedList) { //display reversed list
                            System.out.println((reversedList.indexOf(bike) + 1) + "." + bike.getName());
                        }
                        break;
                    }
                    } else { // because the input has already been validated, if it is not 1 it can only be 2 therefore no need for else-if etc.

//------------------------------------------- Search Bicycle By Name------------------------------------------------------------//
                        boolean validIndex;
                        do {
                            System.out.println("Enter the name of the bicycle: ");
                            input.nextLine(); // clear scanner
                            String nameSearch = input.nextLine(); // take in user input for search
                            int indexOfSearch = inv.searchList(nameSearch); // get the index of the object that has a matching name as user input or return an index of -1 if they don't match
                            if (indexOfSearch == -1) { // the method returns -1 if a bike was not found
                                validIndex = false; // trigger the loop to ask again
                                input.nextLine(); // clear the scanner from the last input
                                System.out.println("That bicycle could not be found. Please Try again.");
                            } else {
                                validIndex = true; // stop the loop
                                inv.getList().get(indexOfSearch).showSpecs(); // run the showSpecs method for the bicycle object in the arraylist found at the index returned
                            }
                        } while (!validIndex); // loop to ensure the object is found
                    }
                    System.out.println();
                    System.out.println("Would you like to purchase this bicycle?\n1. Yes\n2. No");
                    int purchaseChoice = validateInput(2);
                    if (purchaseChoice==1) {
                        System.out.println("Thanks for your purchase.\nWould you like a receipt?");
                    }
                    else{
                        break;
                    }
                    break;
                }
                // end of case 1
// --------------------------------------Create Custom Bicycle--------------------------------------------------------------------------------//
                case 2: {
                    Bicycle newBike = createNewBicycle(); //create new bicycle
                    if (inv.checkForDuplicateBicycles(inv.getList(), newBike)){
                        Bicycle duplicatedBicycle = inv.returnDuplicatedBicycle(inv.getList(), newBike);
                        System.out.println("We have a bicycle called " + "\"" + duplicatedBicycle.getName().toUpperCase() + "\" that exactly matches the custom bicycle you've just made.");
                        System.out.println("""
                            Would you like to view its specifications?
                            1. Yes
                            2. No""");
                        int viewSpecs = validateInput(2);
                        if (viewSpecs == 1){
                            duplicatedBicycle.showSpecs();
                        }
                    }
                    else {
                        System.out.println("Nice ride, we're creating your custom bicycle now!");
                        inv.addBicyclesToList(newBike); // add new bicycle to list
                        System.out.println();
                        newBike.showSpecs(); // show specs of bike
                    }
                    System.out.println("""
                            Would you like to purchase this bicycle?
                            1. Yes
                            2. No""");
                    int purchaseChoice = validateInput(2);
                    if (purchaseChoice==1) {
                        System.out.println("Thanks for your purchase.\nWould you like a receipt?");
                    }
                    else{
                        break;
                    }
                    break;
                } // end of case 2
// --------------------------------------Remove Bicycle from List--------------------------------------------------------------------------------//
                case 3: {
                    System.out.println();
                    boolean validIndex;
                    do {
                        input.nextLine();
                        System.out.println("Enter the name of the bicycle you want to remove");
                        String searchName = input.nextLine();
                        int indexOfSearch = inv.searchList(searchName); // get the index of the object that has a matching name as user input or return an index of -1 if they don't match
                        if (indexOfSearch == -1) { // the method returns -1 if a bike was not found
                            validIndex = false; // trigger the loop to ask again
                            input.nextLine(); // clear the scanner from the last input
                            System.out.println("That bicycle could not be found. Please Try again.");
                        } else {
                            validIndex = true; // stop the loop
                            String nameOfBikeToBeRemoved = inv.getList().get(indexOfSearch).getName();
                            System.out.println("Are you sure you want to remove " + "\"" + nameOfBikeToBeRemoved.toUpperCase() + "\"?\n" +
                                    "Press 1 to continue or 2 to abort:");
                            int remove = validateInput(2);
                            if (remove == 1){
                                System.out.println("You have removed " + "'" + nameOfBikeToBeRemoved.toUpperCase() + "'" + " from the list");
                                inv.removeBicycleFromList(inv.getList().get(indexOfSearch)); // get the object at the index returned and remove it from the list
                            }
                          else System.out.println("Aborted.");
                        }
                    } while (!validIndex); // loop to ensure the object is found
                    break;
                } // end of case 3
            }// end of switch statement
        } while (choice!=0); // go back to main menu until the user selects the exit option
    } //---------------------------------------------  END OF MAIN METHOD-------------------------------------------------------------------------------//
    private static void welcome() {
        //application introduction
        System.out.println();
        System.out.println("Welcome to Atom Cycle Centre\nSelect from the options below:");
    }

    private static void displayMenu() {
        System.out.println("1. View Bicycles\n2. Create Custom Bicycle\n3. Remove Bicycle from Store\n0. Exit");
    }

    private static void viewBicycleMenu() {
        System.out.println("Would you like to:\n1. View all bicycles\n2. Search for bicycles by name");
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

        // declare new instance of customisation class to use the methods
        Customisation custom = new Customisation();

        System.out.println("Create your own custom bicycle!");
        //display options to user to create custom bike

        System.out.println("Give your custom bicycle a name");
        input.nextLine();
        String selectedName = input.nextLine();

        while (inv.nameCheck(inv.getList(), selectedName)) {
            System.out.println("That name has already been taken. Please choose another.");
            selectedName = input.nextLine();
        }

        System.out.println("Select the type of bike:");
        custom.printTypes(custom.getTypeOptions());
        int choice1 = validateInput(2);
        String selectedType = custom.getTypeOptions()[choice1 - 1];


        System.out.println("Select the frame material:");
        custom.printMaterials(choice1 ,custom.getMaterialOptions());
        int choice2 = validateInput(4);
        String selectedMaterial = custom.getMaterialOptions()[choice2 - 1];

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
        custom.printColours(custom.getColourOptions());
        int choice3 = validateInput(5);
        String selectedColour = custom.getColourOptions()[choice3 - 1];

        System.out.println("Select the tyre diameter:");

        if (choice1 == 1) {
            custom.printTyreDiameters(custom.getRoadTyreDiameters()); // print out road bike tyre diameters
        } else {
            custom.printTyreDiameters(custom.getMountainTyreDiameters()); // print out mountain bike tyre diameters
        }
        int choice4 = validateInput(3);

        float selectedDiameter;
        if (choice1 == 1) {
            selectedDiameter = custom.getRoadTyreDiameters()[choice4 - 1];
        } else {
            selectedDiameter = custom.getMountainTyreDiameters()[choice4 - 1];
        }

        System.out.println("Select the number of gears you want to have");
        custom.printGears(custom.getGearsAvailable());
        int choice5 = validateInput(4);
        int selectedGear = custom.getGearsAvailable()[choice5 - 1];

        custom.mapChoicesToPrices(); // map choices to prices, weight and top speed

        // calculate total price of the bike created
        int totalPrice = custom.addPrices(custom.getPrices(choice1), custom.getPrices(choice2), custom.getPrices(choice3),custom.getPrices(choice4), custom.getPrices(choice5));

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
