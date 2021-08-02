package Bicycle;

public class Bicycle {

    //physical characteristics of a bicycle

    private String name;
    private String type;
    private String material;
    private String colour;
    private float weight;
    private float tyreDiameter;

    //other attributes
    private int topSpeed;
    private int totalGears;
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

    public float getTyreDiameter(){
        return tyreDiameter;
    }
    public void setTyreDiameter(float newDiameter){
        this.tyreDiameter = newDiameter;
    }


    public int getTopSpeed(){
        return topSpeed;
    }
    public void setTopSpeed(int newTopSpeed){
        this.topSpeed = newTopSpeed;
    }

    public int getTotalGears(){
        return totalGears;
    }
    public void setTotalGears(int newTotalGears){
        this.totalGears = newTotalGears;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(int newPrice){
        this.price = newPrice;
    }


    // constructor method --> need a list of all

    public Bicycle(){}  //define empty constructor

    public Bicycle(String theName, String theType, String theMaterial, String theColour, float theWeight, float theTyreDiameter, int theTopSpeed, int theTotalGears, double thePrice){

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

    public void showSpecs(){
        System.out.println();
        System.out.println("Model Name: " + getName());
        System.out.println("Bicycle Type : " + getType());
        System.out.println("Material : " + getMaterial());
        System.out.println("Colour : " + getColour());
        System.out.println("Weight : " + getWeight() + "kg");
        System.out.println("Tyre Diameter : " + getTyreDiameter() + "\"");
        System.out.println("Top Speed : " + getTopSpeed() + "mph");
        System.out.println("Number of Gears : " + getTotalGears());
        System.out.println("Price: £" + getPrice());
    }



}
