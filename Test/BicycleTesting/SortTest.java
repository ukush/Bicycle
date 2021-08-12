package BicycleTesting;

import Bicycle.BicycleInventory;
import Bicycle.Bicycle;
import jdk.jfr.Description;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {

    /**
     * Steps in order to reverse the list
     *
     * In order to display a reversed list of bicycles, we will be displaying a copy of it. Each time the method is called,
     the last element on the original list is added to the new copied list.
     *
     *
     * 1. Copy
     */


    public static ArrayList<Bicycle> testList = new ArrayList<>(); // create testing list
    public static BicycleInventory testInventory = new BicycleInventory(); // create instance of the Inventory Class
    public static Bicycle testBike1 = new Bicycle("Test Bike 1", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);


    @Description("Initially set up the list by adding a single object")
    @BeforeClass
    public static void OneTimeSetUp() throws Exception{
        System.out.println("Initializing Test list...");
        testList.add(testBike1); // The test list now has one bicycle object in it
    }

    @Description("Sets up the list by adding the objects")
    @After
    public void tearDown() throws Exception{
        System.out.println("Removing Objects From Test List...");
        testList.remove(testBike1); // remove objects from the list
    }


    @Description("Sets up the list by adding the objects")
    @Before
    public void setUp() throws Exception{
        System.out.println("Adding Objects to Test List...");
        // add another bike to the list
        Bicycle testBike2 = new Bicycle("Test Bike 2", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45, 21, 1250);
        testList.add(testBike2); // Now the list has two bicycle objects
    }

    @Description("Sets up the list by adding the objects")
    @AfterClass
    public static void OneTimeTearDown() throws Exception{
        System.out.println("Clear Test List...");
        testList.clear(); // remove all objects from the list
    }

    @Description("The base case is to reverse a list that contains a single object")
    @Test
    public void failTest() throws AssertionError{
        System.out.println("Running Fail Test Case...");
        Assert.fail();
    }


    @Description("The base case is to reverse a list that contains a single object")
    @Test
    public void copyOriginalList(){
        // The reverse of a list containing a single object is just the same as returning the list
        System.out.println("Running Copy list Test Case...");
        System.out.println();
        ArrayList<Bicycle> expected = testList;
        ArrayList<Bicycle> actual = testInventory.copyList(testList);
        Assert.assertEquals(expected, actual);
    }

    @Description("")
    @Test
    public void returnListWithTwoObjects(){
        ArrayList<Bicycle> expected = new ArrayList<>(testList); // create a new arraylist and copy the test list values
        Assert.assertEquals(expected, testInventory.copyListWithTwoObjects(testList));
    }

    @Description("")
    @Test
    public void returnReversedListWithoutRecursion(){
        ArrayList<Bicycle> expected = new ArrayList<>(testList); // create a new arraylist and copy the test list values
        Collections.reverse(expected); // reverse the order using the Collections.reverse() method
        Assert.assertEquals(expected, testInventory.ReverseListWithoutRecursion(testList));
    }

    @Description("")
    @Test
    public void returnReversedListWithTwoObjects(){
        ArrayList<Bicycle> expected = new ArrayList<>(testList); // create a new arraylist and copy the test list values
        Collections.reverse(expected); // reverse the order using the Collections.reverse() method
        Assert.assertEquals(expected, testInventory.ReverseListWithTwoObjectsUsingTempObject(testList));
    }

    @Description("")
    @Test
    public void returnReversedListUsingRecursion(){
        ArrayList<Bicycle> expected = new ArrayList<>(testList); // create a new arraylist and copy the test list values
        Collections.reverse(expected); // reverse the order using the Collections.reverse() method
        Assert.assertEquals(expected, testInventory.ReverseListUsingRecursion(testList));
    }




}