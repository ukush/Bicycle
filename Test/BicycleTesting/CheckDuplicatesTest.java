package BicycleTesting;
import Bicycle.BicycleInventory;
import Bicycle.Bicycle;
import jdk.jfr.Description;
import org.junit.*;

import java.util.ArrayList;

public class CheckDuplicatesTest {


    public static ArrayList<Bicycle> testList = new ArrayList<>(); // create testing list
    public static BicycleInventory testInventory = new BicycleInventory(); // create instance of the Inventory Class
    public static Bicycle testBike1 = new Bicycle("Test Bike 1", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);

    @Description("Initially set up the list by adding a single object")
    @Before
    public void SetUp() throws Exception{
        System.out.println("Initializing Test list...");
        testList.add(testBike1); // The test list now has one bicycle object in it
    }

    @Description("Clears the list")
    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing Test List...");
        testList.clear(); // remove all objects from the list
    }

    @Description("The base case is to reverse a list that contains a single object")
    @Test
    public void failTest() throws AssertionError{
        System.out.println("Running Fail Test Case...\n-------------------------------------------");
        Assert.fail();
    }

    @Description("Test to check if name already exists")
    @Test
    public void returnTrueIfNameAlreadyExists(){
        System.out.println("Running Name Check Test...\n------------------------------------------");
        String name = "Test Bike 1";
        System.out.println("Name of Object in Test List: " + testBike1.getName());
        System.out.println("The Name: \"Test Bike 1\", already exists ");
        Assert.assertTrue(testInventory.nameCheck(testList, name));
    }

    @Description("Test to check if the list contains a duplicate bicycle object. This test will fail unless the equals() and hashcode() methods are" +
            "overridden.")
    @Test
    public void returnTrueIfBicycleAlreadyExists(){
        System.out.println("Running Check Duplicate Bicycle Test...\n-------------------------------------------");
        Bicycle duplicateBike = new Bicycle("Test Bike 1", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);
        boolean actual = testInventory.checkForDuplicateBicycles(testList, duplicateBike);
        if (actual){
            System.out.println("There is a duplicate bicycle object in the test list\n");
            System.out.println("Existing bicycle details:");
            testBike1.showSpecs();
            System.out.println();
            System.out.println("Duplicate bicycle details:");
            duplicateBike.showSpecs();
        }
        else System.out.println("No duplicate bicycle object was found.");
        Assert.assertTrue(actual);
        System.out.println("End Of Test Case...\n-------------------------------------------");
    }

    @Description("Test return the bicycle in the list that is found to be the same as the duplicate bicycle.")
    @Test
    public void returnBicycleInListThatIsSameAsDuplicate(){
        System.out.println("Running Test...\n-------------------------------------------");
        Bicycle duplicateBike = new Bicycle("Test Bike 1", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);
        Bicycle actual = testInventory.returnDuplicatedBicycle(testList, duplicateBike);
        System.out.println("Expected Name: Test Bike 1\nName found: "+ actual.getName());
        Assert.assertEquals(testBike1, actual);
        System.out.println("End Of Test Case...\n-------------------------------------------");
    }





}
