package Bicycle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {


    // Initialise scanner object
    public static final Scanner input = new Scanner(System.in);

    // create instance of Inventory class to be able to use the methods
    public static BicycleInventory inv = new BicycleInventory();

    public static Receipt r = new Receipt();


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
                        System.out.println();
                        for (Bicycle bike : inv.getList()) {
                            System.out.println((inv.getList().indexOf(bike) + 1) + ". " + bike.getName());
                        }
                        System.out.println("\nSelect from the options below:");
                        System.out.println("1. View technical specifications\n2. Display list in reverse order\n3. Remove bicycle from inventory");
                        int selection = validateInput(3);
                        if (selection == 1) {
                            System.out.println("Select a bicycle to view the technical specifications: ");
                            int bikeChoice = validateInput(inv.getList().size());
                            // find the object where index = bikeChoice and run the showSpecs() method for that object
                            inv.getList().get(bikeChoice - 1).showSpecs(); // -1 to get the correct index since they start from 0
                            System.out.println("""
                            Would you like to purchase this bicycle?
                            1. Yes
                            2. No""");
                            int purchaseChoice = validateInput(2);
                            if (purchaseChoice==1) {
                                System.out.println("Thanks for your purchase.\nWould you like a receipt?\n1.Yes\n2.No");
                                int print = validateInput(2);
                                if (print ==1){
                                 saveReceipt(inv.getList().get(bikeChoice-1));
                                }
                            }
                        }
                        else if (selection ==2){
//------------------------------------------Reverse List Order-----------------------------------------------------------------//
                        ArrayList<Bicycle> reversedList = new ArrayList<>(inv.getList()); // make a copy of the list
                        inv.reverseListRecursively(reversedList, 0, reversedList.size() - 1); // reverse the list
                            System.out.println();
                            System.out.println("Inventory: ");
                        for (Bicycle bike : reversedList) { //display reversed list
                            System.out.println((reversedList.indexOf(bike) + 1) + ". " + bike.getName());
                        }
                        break;
                    }
                        else { // if user selects remove bicycle

// --------------------------------------Remove Bicycle from List--------------------------------------------------------------------------------//
                            System.out.println("Select which bicycle you would like to remove:");
                            int removeIndex = validateInput(inv.getList().size()); //get index of
                            Bicycle bicycleToRemove = inv.getList().get(removeIndex -1);
                            System.out.println("Are you sure you want to remove " + "\"" + bicycleToRemove.getName().toUpperCase() + "\"" + " from the inventory list?");
                            System.out.println("1. Remove this bike from the list\n2. Return to main menu");
                            int remove = validateInput(2);
                            if (remove ==1) {
                                inv.removeBicycleFromList(bicycleToRemove);
                            }
                            else {
                                break;
                            }

                        }
                    } else { // if user selects search by name

//------------------------------------------- Search Bicycle By Name------------------------------------------------------------//
                        boolean validIndex;
                        Bicycle found;
                        do {
                            System.out.println("Enter the name of the bicycle: ");
                            String nameSearch = input.nextLine(); // take in user input for search
                            int indexOfSearch = inv.searchList(nameSearch); // get the index of the object that has a matching name as user input or return an index of -1 if they don't match
                            if (indexOfSearch == -1) { // the method returns -1 if a bike was not found
                                input.nextLine(); // clear the scanner
                                validIndex = false; // trigger the loop to ask again
                                System.out.println("That bicycle could not be found. Please Try again.");
                            } else {
                                validIndex = true;
                                found = inv.getList().get(indexOfSearch); // run the showSpecs method for the bicycle object in the arraylist found at the index returned
                                found.showSpecs();
                                System.out.println("""
                                Would you like to purchase this bicycle?
                                1. Yes
                                2. No""");
                                int purchaseChoice = validateInput(2);
                                if (purchaseChoice==1) {
                                    System.out.println("Thanks for your purchase.\nWould you like a receipt?\n1.Yes\n2.No");
                                    int print = validateInput(2);
                                    if (print ==1){
                                        saveReceipt(found);
                                    }
                                }
                            }
                        } while (!validIndex); // loop to ensure the object is found
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
                        System.out.println("Thanks for your purchase.\nWould you like a receipt?\n1.Yes\n2.No");
                        int print = validateInput(2);
                        if (print ==1){
                            saveReceipt(newBike);
                        }
                    }
                    else{
                        break;
                    }
                    break;
                } // end of case 2
//----------------------------------------Purchases--------------------------------------------------------//

                case 3: {


                    //check if file exists
                    if (r.receipts.size() == 0) {
                        System.out.println("There are no receipts to view");
                    }


                    //print out list of receipts in directory
                    r.printReceiptList(r.receipts); //print out list

                    System.out.println("\nPlease select a receipt: ");
                    int viewReceipt = input.nextInt();
                    System.out.println("What would you like to do with this receipt?");
                    System.out.println("1. View receipt details");
                    System.out.println("2. Rename receipt");
                    int receiptChoice = validateInput(2);
                    if (receiptChoice == 1){
                        //view receipt details
                        r.readValuesFromFile(r.receipts.get(viewReceipt-1));
                    }
                    else {
                        System.out.println("Rename the receipt by entering the new name below: ");
                        String newReceiptName = input.nextLine();


                        Path source = Paths.get("/Users/admin/Desktop/Projects/Side Projects/Java/Bicycle/" + r.receipts.get(viewReceipt-1).getName());
                        try {
                            Files.move(source, source.resolveSibling(newReceiptName + ".csv"));
                            System.out.println("File renamed successfully");
                        } catch (IOException e) {
                            System.err.println("Error: cannot rename file");
                            e.printStackTrace();
                        }
                    }





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
        System.out.println("1. View Bicycles\n2. Create Custom Bicycle\n3. View Purchases\n0. Exit");
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
                if (choice <0 || choice > 3) { // if the input is not in range
                    System.out.println("Error: That is not a valid option. Please try again."); // display error message
                    isInputValid = false; // trigger while loop
                } else {
                    isInputValid = true; // stop while loop
                }
            } catch (InputMismatchException e) { //catch exception input is not a number (InputMismatch exception)
                System.out.println("That is not a valid input. Please enter a number using your keypad."); // display error message
                input.nextLine(); // clear scanner
                isInputValid = false; // trigger the while loop
            }
        } while (!isInputValid);
        input.nextLine(); // clear scanner
        return choice;
    }

    private static int validateInput(int numberOfOptions) {

        boolean isInputValid;
        int choice = 0;
        do {
            try {
                choice = input.nextInt(); // take in user input
                // create loop to validate the input is within range
                if (choice <=0 || choice > numberOfOptions) { // if the input is not in range
                    System.out.println("Error: That is not a valid option. Please try again."); // display error message
                    isInputValid = false; // trigger while loop
                } else {
                    isInputValid = true; // stop while loop
                }
            } catch (InputMismatchException e) { //catch exception input is not a number (InputMismatch exception)
                System.out.println("That is not a valid input. Please enter a number using your keypad."); // display error message
                input.nextLine(); // clear scanner
                isInputValid = false; // trigger the while loop
            }
        } while (!isInputValid);
        input.nextLine(); // clear scanner
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

    private static void saveReceipt(Bicycle bike){
        System.out.println("Please enter your name: ");
        String name = input.nextLine();

        System.out.println("Please enter your postcode: ");
        String postcode = input.nextLine();

        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);  //get the current date time
        String receiptName = dateTime + ".csv"; //make the name of the file to be the current date/time it was created.

        r.setName(receiptName); // set the name of the receipt
        File receipt = r.createFile(receiptName); // create file and pass name as param
        r.writeSpecsToReceipt(receipt, bike, name, dateTime.toString(), postcode); // write to file
        r.receipts.add(receipt); //add file to receipt lists
        System.out.println("Your receipt has been saved");
    }


}
