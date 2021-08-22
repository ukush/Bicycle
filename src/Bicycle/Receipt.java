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
    public void writeToReceipt(File file) {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(("receipt.csv")));

            writer.write(bike.getName() + ", " + bike.getType() + ", " + bike.getMaterial() + ", " +
                    bike.getColour() + ", " + bike.getWeight() + ", " + bike.getTopSpeed() + ", " +
                    bike.getTyreDiameter() + ", " + bike.getTotalGears() + ", " + bike.getPrice());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
