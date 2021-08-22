package BicycleTesting;

import Bicycle.Bicycle;
import Bicycle.Receipt;
import jdk.jfr.Description;
import jdk.jfr.StackTrace;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class ReceiptTest {
    /**
     * When a user chooses to purchase a bicycle, the following details are recorded in the form of
     * a receipt:
     * - The bicycle specifications
     * - The time of purchase
     *
     * These details will then be exported to a csv file named "receipt.csv"
     * There needs to be a way to automatically name the file differently each time as to avoid
     * conflicting names.
     *
     * This class will define the fields and methods for:
     * - The creation of a new receipt file
     * - Reading in receipt file and displaying it to the user
     * - Renaming a receipt file's name
     */

    public Receipt receipt = new Receipt();
    public Bicycle testBike1 = new Bicycle("Test Bike 1", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);



    @Description("Initial fail test")
    @Test
    public void failTest(){
        Assert.fail();
    }

    @Description("Test for file creation")
    @Test
    public void createFileTest(){
        Assert.assertTrue(receipt.createFile("receipt.csv").exists());
    }

    @Description("Test for write to file")
    @Test
    public void writeToFileTest(){
        String fileName = "receipt.csv";
        receipt.writeSpecsToReceipt(receipt.createFile(fileName), testBike1);

    }







}
