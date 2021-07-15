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

        welcome(); // Introduce user to the application

        System.out.println("Choose which type of bike you want.");
        printTypes(); // print out the types of bikes the user can choose from
        int typeChoice = keyboard.nextInt(); // store the user's choice

        if (typeChoice == 1) {
            //if the user chooses road bike
            System.out.println("Are you ready for some serious speeds?");
        }
        else {
            System.out.println("Nice, You must be the adventurous type!");
        }

        System.out.println("Now you need to decide which material you want your bike to be made out of. We offer a few different choices:");
        printMaterialList(typeChoice); //show the user the list of materials they can choose from
        int materialChoice = keyboard.nextInt(); // store choice

        System.out.println("Select a colour:");
        printColours();
        int colourChoice = keyboard.nextInt();

        /*
         * The weight of the bike depends on the frame material and the size of the wheels
         * carbon fibre => 9.0kg
         * Titanium => 11.6kg
         * steel => 12.2kg
         * aluminium => 10.7kg
         *
         * for road bikes:
         * 22mm tyres add 0.6kg
         * 25mm tyres add 0.8kg
         * 28mm tyres add 1.0kg
         *
         *
         */


        System.out.println();








    }

    public static void welcome(){
        //application introduction
        System.out.println();
        System.out.println("Welcome to Atom Cycle Centre");
        System.out.println("In this application, you will be able to create your own custom bicycle " +
                "and take it for a virtual ride (you'll have to use your imagination).");
        System.out.println();
        System.out.println("Let's make sure we get you the best bike for you.");
    }

    public static void printTypes(){
        for (int i = 0; i<2; i++) {
            System.out.println(( i+1) + ". " + bikeType[i] + " bike");
        }

    }

    public static void printMaterialList(int type){
        for (int i = 0; i<4; i++) {
            System.out.print(( i+1) + ". " + bikeMaterials[i]);

            if (type == 1) {
                if (i ==0) {
                    System.out.println("(recommended)");
                }
                else {
                    System.out.println();
                }

            }
            else {
                if (i == 3) {
                    System.out.println("(recommended)");
                }
                else {
                    System.out.println();
                }
            }

        }
    }

    public static void printColours(){
        for (int i=0; i<5; i++) {
            System.out.print(( i+1) + ". " + bikeColours[i]);
        }
    }


}
