package Bicycle;
import java.io.*;
import java.util.ArrayList;

public class Receipt {

    public ArrayList<File> receipts = new ArrayList<>();

    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public void printReceiptList(ArrayList<File> list){
        for (File file : list){
            System.out.println(file.getName());
            System.out.println();
        }
    }

    //----------------------------Test methods------------------------------------------//

    public File createFile(String filename){
        File receipt = new File(filename);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(receipt.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receipt;
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

            System.out.println("Model Name: " + values[0]);
            System.out.println("Type: " + values[1]);
            System.out.println("Material: " + values[2]);
            System.out.println("Colour: " + values[3]);
            System.out.println("Weight: " + values[4] + "kg");
            System.out.println("Tyre Diameter: " + values[5] + "\"");
            System.out.println("Top Speed: " + values[6] + "mph");
            System.out.println("Number of Gears: " + values[7]);
            System.out.println("Price: £" + values[8]);
            System.out.println("Name: " + values[9]);
            System.out.println("Postcode: " + values[10]);
            System.out.println("Date of Purchase: " + values[11]);

            } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

}
