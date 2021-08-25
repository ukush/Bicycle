package Bicycle;

import java.io.*;

public class Receipt {

    Bicycle b = new Bicycle();

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

    public void writeSpecsToReceipt(File file, Bicycle bike) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter((file.getName())));
            writer.write("Model Name: " + bike.getName() + ", " + "Bicycle Type: " + bike.getType() + ", " + "Material: " + bike.getMaterial() + ", " +
                    "Colour: " + bike.getColour() + ", " + "Weight: " + bike.getWeight() + ", " + "Top Speed: " + bike.getTopSpeed() + ", " +
                    "Tyre Diameter: " + bike.getTyreDiameter() + ", " + "Number of Gears: " + bike.getTotalGears() + ", " + "Price: £ " + bike.getPrice());
            writer.close();
        } catch (IOException e) {
            System.err.println("There was an error writing to file");
            e.printStackTrace();
        }

    }



}
