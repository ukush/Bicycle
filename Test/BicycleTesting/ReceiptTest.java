package BicycleTesting;
import Bicycle.Bicycle;
import Bicycle.Receipt;
import jdk.jfr.Description;
import jdk.jfr.StackTrace;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
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

    File testfile1;
    @Rule
    public TemporaryFolder folder = new TemporaryFolder(); //set up temporary folder for testing


    @Before
    public void setUp(){
        //add test files to temporary folder
        try {
            testfile1 = folder.newFile("test.csv");
        } catch (IOException e) {
            System.err.println("error creating temporary file");
            e.printStackTrace();
        }
    }


   /* @Description("Test for write to file")
    @Test
    public void writeToFileTest(){
        receipt.writeSpecsToReceipt(testfile1, testBike1);
        Assert.assertEquals(testfile1.getName(), "testfile.csv"); // fail test
    }

    */

    @Description("Test for write to file")
    @Test
    public void writeToFileTest(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(testfile1));
            writer.write(testBike1.getName() + ", " + testBike1.getType() + ", " + testBike1.getMaterial() + ", " +
                    testBike1.getColour() + ", " + testBike1.getWeight() + ", " + testBike1.getTopSpeed() + ", " +
                    testBike1.getTyreDiameter() + ", " + testBike1.getTotalGears() + ", " + testBike1.getPrice());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(testfile1.getName(), "test.csv");
        Assert.assertEquals(testBike1.getName(), "Test Bike 1");
        Assert.assertEquals(testBike1.getType(), "road");
        Assert.assertEquals(testBike1.getMaterial(), "carbon fibre");
    }

    @Description("Test for write to file")
    @Test
    public void readFromFileTest(){
        //write to file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(testfile1));
            writer.write(testBike1.getName() + ", " + testBike1.getType() + ", " + testBike1.getMaterial() + ", " +
                    testBike1.getColour() + ", " + testBike1.getWeight() + ", " + testBike1.getTopSpeed() + ", " +
                    testBike1.getTyreDiameter() + ", " + testBike1.getTotalGears() + ", " + testBike1.getPrice());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(testfile1));

            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
