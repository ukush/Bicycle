package Bicycle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //set up scanner
    public static Scanner keyboard = new Scanner(System.in);

    public static String[] bikeType = new String[]{ "Road", "Mountain"};
    public static String[] bikeColours = new String[]{ "Matt Black", "Matt Grey", "Racing Red", "Volt Blue", "Silver", "Gloss Black"};
    public static String[] bikeMaterials = new String[]{"Carbon fibre", "Titanium", "Steel", "Aluminium"};
    public static int[] tyreDiameters = new int[]{22,25,28};


    // List of bicycle models
    // Separately store road bikes and mountain bikes
    ArrayList<Bicycle> mountainBikes = new ArrayList<>();
    ArrayList<Bicycle> roadBikes = new ArrayList<>();



    public static void main(String[] args) {

        welcome();
        System.out.println("Choose which type of bike you want to create.");

        for (int i = 0; i<2; i++) {
            System.out.println(( i+1) + ". " + bikeType[i] + " bike");
        }


        int typeChoice = keyboard.nextInt();

        if (typeChoice == 1) {
            //they chose road bike
            System.out.println("Ah so you like cycling on the roads?");
        }
        else {
            System.out.println("Adventurous are we?");
        }
        System.out.println("Now you need to decide which material you want your bike to made out of. We offer a few different choices:");
        for (int i = 0; i<4; i++) {
            System.out.println(( i+1) + ". " + bikeMaterials[i]);
        }
        int materialChoice = keyboard.nextInt();




    }

    public static void welcome(){
        //application introduction
        System.out.println();
        System.out.println("Welcome to the interactive bicycle simulator");
        System.out.println("In this application, you will be able to create your own custom bicycle " +
                "and take it for a virtual ride (you'll have to use your imagination).");
        System.out.println();
        System.out.println("Let's start off by creating your own custom bike.");
    }


}
