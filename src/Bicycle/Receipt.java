package Bicycle;
import java.io.*;
import java.util.ArrayList;

public class Receipt {

    public ArrayList<File> receipts = new ArrayList<>();

    private String name;
    public String getName() {return this.name;}
    public void setName(String newName){
        this.name = newName;
    }


    //----------------------------Methods developed from testing------------------------------------------//

    public File createFile(String filename){
        return new File(filename);
    }

    /*
    public void writeToReceipt(File csvFile) {
        String message = "testing";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(("receipt.csv")));
            writer.write(message + ",");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
     */

    public void writeSpecsToReceipt(File file, Bicycle bike, String name, String date, String pcode) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter((file.getName())));
            writer.write(bike.getName() + ", " + bike.getType() + ", " + bike.getMaterial() + ", " + bike.getColour() + ", " +
                    bike.getWeight() + ", " + bike.getTopSpeed() + ", " +
                    bike.getTyreDiameter() + ", " + bike.getTotalGears() + ", " + bike.getPrice() + "," + name + ","
                    + pcode + "," + date);
            writer.close();
        } catch (IOException e) {
            System.err.println("There was an error writing to file");
            e.printStackTrace();
        }

    }

    public void readValuesFromFile(File fileToRead){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead.getName()));

            String s = reader.readLine();
            String [] values;

            values = s.split(",");

            System.out.println("ATOM BICYCLE CENTER");
            System.out.println();
            System.out.println("CUSTOMER NAME: " + values[9].toUpperCase());
            System.out.println("POSTCODE: " + values[10].toUpperCase());
            System.out.println("DATE/TIME OF PURCHASE: " + values[11]);
            System.out.println();
            System.out.println("TOTAL PRICE: £" + values[8]);
            System.out.println("MODEL NAME: " + values[0].toUpperCase());
            System.out.println("BICYCLE TYPE: " + values[1].toUpperCase() + " BIKE");
            System.out.println("FRAME MATERIAL: " + values[2].toUpperCase());
            System.out.println("FRAME COLOUR: " + values[3].toUpperCase());
            System.out.println("TOTAL WEIGHT: " + values[4] + "KG");
            System.out.println("TYRE DIAMETER: " + values[5] + "\"");
            System.out.println("TOP SPEED: " + values[6] + "MPH");
            System.out.println("NUMBER OF GEARS: " + values[7]);
            System.out.println();
            System.out.println("THANKS FOR SHOPPING AT ATOM BICYCLE CENTER!");

            } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

}
