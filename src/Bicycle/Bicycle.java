package Bicycle;

public class Bicycle {

    /**
     * Declare the states that bicycles of all types will share
     * Declare the accessor methods to these states
     * Declare a constructor method?
     * Write the methods that all bicycles will share
     */

    //physical characteristics of a bicycle

    private String name;
    private String type;
    private String material;
    private String colour;
    private float weight;
    private int tyreDiameter;

    //other attributes
    private int topSpeed;
    private int currentSpeed;
    private int totalGears;
    private int currentGear;
    private double price;


    //declare accessor methods
    public String getName(){ return name; }
    public void setName(String newName){ this.name = newName; }

    public String getType(){
        return type;
    }
    public void setType(String newType){
        this.type = newType;
    }

    public String getMaterial(){ return material; }
    public void setMaterial(String newMaterial){ this.material = newMaterial; }

    public String getColour(){
        return colour;
    }
    public void setColour(String newColour){
        this.colour = newColour;
    }

    public float getWeight(){
        return weight;
    }
    public void setWeight(float newWeight){
        this.weight = newWeight;
    }

    public int getTyreDiameter(){
        return tyreDiameter;
    }
    public void setTyreDiameter(int newDiameter){
        this.tyreDiameter = newDiameter;
    }

    public int getTopSpeed(){
        return topSpeed;
    }
    public void setTopSpeed(int newTopSpeed){
        this.topSpeed = newTopSpeed;
    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }
    public void setCurrentSpeed(int newSpeed){
        this.currentSpeed = newSpeed;
    }

    public int getTotalGears(){
        return totalGears;
    }
    public void setTotalGears(int newTotalGears){
        this.totalGears = newTotalGears;
    }

    public int getCurrentGear(){
        return currentGear;
    }
    public void setCurrentGear(int newGear){
        this.currentGear = newGear;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(int newPrice){
        this.price = newPrice;
    }


    // constructor method --> need a list of all

    public Bicycle(){}  //define empty constructor

    public Bicycle(String theName, String theType, String theMaterial, String theColour, float theWeight, int theTyreDiameter, int theTopSpeed, int theTotalGears, double thePrice){

        this.name = theName;
        this.type = theType;
        this.material = theMaterial;
        this.colour = theColour;
        this.weight = theWeight;
        this.tyreDiameter = theTyreDiameter;
        this.topSpeed = theTopSpeed;
        this.totalGears = theTotalGears;
        this.price = thePrice;
    }


    // Methods for all bike objects

    public int accelerate() {
        // will increase the speed by 5mph

        int speed = getCurrentSpeed();
        setCurrentSpeed(speed + 5);
        return currentSpeed;
    }

    public int slowDown(){
        // will decrease the speed by 5mph
        int speed = getCurrentSpeed();
        setCurrentSpeed(speed - 5);
        return currentSpeed;
    }

    public int gearUp() {
        // will shift one gear up (until you reach the highest gear which depends on the bike)
        // Mountain bikes have 7 gears and road bikes have 16 gears

        int gear = getCurrentGear();
        setCurrentGear(gear + 1);
        return currentGear;

    }

    public int gearDown() {
        // will shift one gear down (until you reach the lowest gear which is 1)

        int gear = getCurrentGear();
        setCurrentGear(gear - 1);
        return currentGear;
    }

    public void showSpecs(){
        System.out.println("Model Name: " + getName());
        System.out.println("Bicycle Type : " + getType());
        System.out.println("Material : " + getMaterial());
        System.out.println("Colour : " + getColour());
        System.out.println("Weight : " + getWeight() + "kg");
        System.out.println("Standard Tyre Diameter : " + getTyreDiameter() + "mm");
        System.out.println("Top Speed : " + getTopSpeed() + "mph");
        System.out.println("Number of Gears : " + getTotalGears());
    }



}
