package BicycleTesting;

import jdk.jfr.Description;
import org.junit.*;

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

    @Description("")
    @BeforeClass
    public static void oneTimeSetUp(){

    }

    @Description("")
    @Before
    public void setUp(){

    }

    @Description("")
    @After
    public void tearDown(){

    }

    @Description("")
    @AfterClass
    public static void oneTimeTearDown(){

    }





}
