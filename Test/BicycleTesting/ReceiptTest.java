package BicycleTesting;
import Bicycle.Bicycle;
import Bicycle.Receipt;
import jdk.jfr.Description;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import java.io.*;

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
                    testBike1.getColour() + ", " + testBike1.getWeight() + ", " + testBike1.getTyreDiameter() + ", " + testBike1.getTopSpeed() + ", " +
                     testBike1.getTotalGears() + ", " + testBike1.getPrice());
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
                    testBike1.getColour() + ", " + testBike1.getWeight() + ", " + testBike1.getTyreDiameter() + ", " + testBike1.getTopSpeed() + ", " + testBike1.getTotalGears() + ", " + testBike1.getPrice());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(testfile1));
            Assert.assertEquals(reader.readLine(), "Test Bike 1, road, carbon fibre, gunmetal grey, 9.0, 27.5, 45, 21, 1250.0");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void formatFileAsReceipt(){

        //write to temporary test file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(testfile1));
            writer.write(testBike1.getName() + ", " + testBike1.getType() + ", " + testBike1.getMaterial() + ", " +
                    testBike1.getColour() + ", " + testBike1.getWeight() + ", " + testBike1.getTyreDiameter() + ", " + testBike1.getTopSpeed() + ", " + testBike1.getTotalGears() + ", " + testBike1.getPrice());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read file from temp test file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(testfile1)); // initialise reader
            try {
                String s = reader.readLine(); //Each file will only contain a single line
                String [] values; // initialise array

                values = s.split(","); //split string (1st line) by comma

                //print out values in a receipt styling
                System.out.println("Model Name: " + values[0]);
                System.out.println("Type: " + values[1]);
                System.out.println("Material: " + values[2]);
                System.out.println("Colour: " + values[3]);
                System.out.println("Weight: " + values[4] + "kg");
                System.out.println("Tyre Diameter: " + values[5] + "\"");
                System.out.println("Top Speed: " + values[6] + "mph");
                System.out.println("Number of Gears: " + values[7]);
                System.out.println("Price: £" + values[8]);

                Assert.assertEquals(values[3], " gunmetal grey"); // assertion test

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }








}
