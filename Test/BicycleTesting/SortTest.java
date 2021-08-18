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
     *
     */

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

    @Description("The base case is to return a list that contains a single object")
    @Test
    public void returnListThatContainsASingleObject(){
        System.out.println("Running Return List Test Case...\n-------------------------------------------");
        ArrayList<Bicycle> expected = testList;
        ArrayList<Bicycle> actual = testInventory.returnCopyOfListWithSingleObject(testList);
        Assert.assertEquals(expected, actual);
        System.out.println("End Of Test Case...\n-------------------------------------------");
    }

    @Description("This method will swap the first and last elements of an arrayList by manually setting the indexes")
    @Test
    public void manuallySwapElementsTest(){
        System.out.println("Running Manual Swap Elements Test...\n-------------------------------------------");

        //create and add another object to the test list
        Bicycle testBike2 = new Bicycle("Test Bike 2", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45,21, 1250);
        testList.add(testBike2);
        System.out.println("Original Order: ");
        for (Bicycle bike: testList){
            System.out.println(bike.getName());
        }

        Assert.assertEquals(testList, testInventory.swapFirstAndLastElements(testList, 0, testList.size()-1));


        System.out.println("End Of Test Case...\n-------------------------------------------");

    }

    @Description("This method will swap the first and last elements of an arrayList using the Collections.swap()")
    @Test
    public void swapElementsSimple(){
        System.out.println("Running Simple Swap Elements Test...\n-------------------------------------------");

        //create and add another object to the test list
        Bicycle testBike2 = new Bicycle("Test Bike 2", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45,21, 1250);
        testList.add(testBike2);
        System.out.println("Original Order: ");
        for (Bicycle bike: testList){
            System.out.println(bike.getName());
        }

        Assert.assertEquals(testList, testInventory.swapFirstAndLastElements(testList, 0, testList.size()-1));


        System.out.println("End Of Test Case...\n-------------------------------------------");

    }

    @Description("This method will retrieve the last element from the original list and copy it into an empty list")
    @Test
    public void reverseListRecursively(){
        //create and add another object to the test list
        Bicycle testBike2 = new Bicycle("Test Bike 2", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45,21, 1250);
        testList.add(testBike2);

        //create and add another object to the test list
        Bicycle testBike3 = new Bicycle("Test Bike 3", "road", "carbon fibre", "gunmetal grey", 9f, 27.5f, 45,21, 1250);
        testList.add(testBike3);

        System.out.println("Running Reverse List Recursively Test...\nOriginal Order: ");
        for (Bicycle bike: testList){
            System.out.println(bike.getName());
        }

        ArrayList<Bicycle> actual = new ArrayList<>(testList); //create a copy of the test list

        testInventory.reverseListRecursively(actual, 0, testList.size()-1); //run the reverse list method
        Collections.reverse(testList); // reverse the test list to use for comparison

        System.out.println("Reversed Order: ");
        for (Bicycle bike: actual){
            System.out.println(bike.getName());
        }

        Assert.assertEquals(testList, actual); // compare the reversed list using Collections.reverse() and the reverseListRecursively()

        System.out.println("End Of Test Case...\n-------------------------------------------");
    }


}