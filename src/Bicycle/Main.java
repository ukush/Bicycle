package Bicycle;

public class Main {
    public static void main(String[] args) {


        // make the pre-populated bikes with all attributes and allow user to pick from them

        Bicycle bike = new Bicycle("BMWi90x", "road", "carbon fibre", "matt black", 25, 250, 55, 16);

        bike.showSpecs();
    }
}
