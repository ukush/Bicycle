package Bicycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer, Integer> customPrices = new HashMap<>();

    private static final String[] types = {"road", "mountain"};
    private static final String[] materials = {"aluminium", "steel", "titanium", "carbon fibre"};
    private static final String[] colours = {"racing red", "volt blue", "gunmetal grey", "silver", "matte black"};
    private static final float[] roadTyres = {22f, 25f, 28f};
    private static final float[] mountainTyres = {26f, 27.5f, 29f};
    private static final int [] prices = {119, 99, 129, 0, 179, 229, 35, 35, 50, 0, 50, 19, 0, 29, 29, 35, 39, 45, 55, 65, 85};
    private static final int[] gears = {7,12,16,21};

    private static final Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        //Map all keys to values using hashmap
        for (int i = 0; i < prices.length; i++){
            customPrices.put((i+1), prices[i]);
        }


        // introduce the program to the user and display the main menu
        welcome(); // Introduce application to user
        displayMenu();
        int choice = validateMainMenuInput(); // display options to user and assign the return value to the variable choice.

        switch (choice) {
            case 0: break;
            case 1:{
                viewBicycleMenu();
                int viewChoice = validateInput(2); //display menu and validate input and set return value of choice to viewChoice variable
                if (viewChoice ==1){
                    System.out.println("Run method that prints out all names of bicycles in a list");
                }
                else { // because the input has already been validated, if it is not 1 it can only be 2 therefore no need for else-if etc.
                    System.out.println("Enter the name of the bicycle: ");
                }
                break;
            }
            case 2: {
               Bicycle newBike = createNewBicycle();
                System.out.println();
                newBike.showSpecs();
                break;
            }
            case 3: {
                System.out.println("Enter the name of the bicycle you want to remove");
                break;
            }
        }
    }
    public static void welcome(){
        //application introduction
        System.out.println();
        System.out.println("Welcome to Atom Cycle Centre");
        System.out.println("Select from the options below: ");
    }

    public static void displayMenu() {
        System.out.println("1. View Bicycles");
        System.out.println("2. Create Custom Bicycle");
        System.out.println("3. Remove Bicycle from Store");
        System.out.println("0. Exit");
    }

    public static void viewBicycleMenu(){
        System.out.println("Would you like to:");
        System.out.println("1. View all bicycles");
        System.out.println("2. Search for bicycles by name");
    }

    public static int validateMainMenuInput(){

        boolean isInputValid;
        int choice = 0;
        do {
            try {
                choice = input.nextInt(); // take in user input
                // create loop to validate the input is within range
                if (choice<0||choice>3) { // if the input is not in range
                    System.out.println("Error: That is not a valid option. Please try again."); // display error message
                    isInputValid = false; // trigger while loop
                    input.nextLine(); // clear scanner
                }
                else {
                    isInputValid = true; // stop while loop
                }
            } catch (InputMismatchException e) { //catch exception of input is not a number (InputMismatch exception)
                input.nextLine(); // clear scanner token
                System.out.println("That is not a valid input. Please enter a number using your keypad."); // display error message
                isInputValid = false; // trigger the while loop
            }
        }while(!isInputValid);
        return choice;
    }


    public static int getPrices(int userInput){
        return customPrices.get(userInput);
    }

    public static int addPrices(int price1, int price2, int price3, int price4, int price5){
        return price1 + price2 + price3 + price4 +price5;
    }

    public static void printMaterials(int bikeType, String [] array){
        for (int i = 0; i< array.length; i++) {
            System.out.print(( i+1) + ". " + array[i]);

            if (bikeType == 1) {
                if (i ==3) {
                    System.out.println("(recommended)");
                }
                else {
                    System.out.println();
                }

            }
            else {
                if (i == 0) {
                    System.out.println("(recommended)");
                }
                else {
                    System.out.println();
                }
            }

        }
    }

    public static void printColours(String [] array){
        for (int i=0; i< array.length; i++) {
            System.out.print(( i+1) + ". " + array[i]);
            System.out.println();
        }
    }

    public static void printTyreDiameters(float [] array){
        for (int i=0; i< array.length; i++) {
            System.out.print(( i+1) + ". " + array[i] + "\"");
            System.out.println();
        }
    }

    public static void printTypes(String [] array){
        for (int i = 0; i< array.length; i++) {
            System.out.println(( i+1) + ". " + array[i] + " bike");
        }

    }

    public static void printGears(int [] array){
        for (int i = 0; i< array.length; i++) {
            System.out.println(( i+1) + ". " + array[i]);
        }

    }

    public static int validateInput(int numberOfOptions){

        boolean isInputValid;
        int choice = 0;
        do {
            try {
                choice = input.nextInt(); // take in user input
                // create loop to validate the input is within range
                if (choice<=0||choice>numberOfOptions) { // if the input is not in range
                    System.out.println("Error: That is not a valid option. Please try again."); // display error message
                    isInputValid = false; // trigger while loop
                    input.nextLine(); // clear scanner
                }
                else {
                    isInputValid = true; // stop while loop
                }
            } catch (InputMismatchException e) { //catch exception of input is not a number (InputMismatch exception)
                input.nextLine(); // clear scanner token
                System.out.println("That is not a valid input. Please enter a number using your keypad."); // display error message
                isInputValid = false; // trigger the while loop
            }
        }while(!isInputValid);
        return choice;
    }

    public static Bicycle createNewBicycle(){
        System.out.println("Create your own custom bicycle!");
        //display options to user to create custom bike

        System.out.println("Let's start off by giving your custom bicycle a name");
        input.nextLine();
        String selectedName = input.nextLine();

        System.out.println("Select the type of bike:");
        printTypes(types);
        int choice1 = validateInput(2);
        String selectedType = types[choice1 -1];


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

        if (choice1 ==1){
            printTyreDiameters(roadTyres);
        }
        else {
            printTyreDiameters(mountainTyres);
        }
        int choice4 = validateInput(3);

        float selectedDiameter;
        if (choice1 == 1){
            selectedDiameter = roadTyres[choice4 - 1];
        }
        else{
            selectedDiameter = mountainTyres[choice4 - 1];
        }

        System.out.println("Select the number of gears you want to have");
        printGears(gears);
        int choice5 = validateInput(4);
        int selectedGear = gears[choice5 -1];



        // calculate total price of the bike created
        int totalPrice = addPrices(getPrices(choice1), getPrices(choice2), getPrices(choice3), getPrices(choice4), getPrices(choice5));

        // use all selected attributes in bicycle constructor method to create a new Bicycle object
        // add this new Bicycle object to the arrayList of stored Bicycles

        return new Bicycle(selectedName, selectedType, selectedMaterial, selectedColour, bikeWeight, selectedDiameter, topSpeed, selectedGear, totalPrice);
    }





}
