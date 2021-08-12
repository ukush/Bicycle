package Bicycle;

import java.util.HashMap;

public class Customisation {
    /**
     * This class defines all the customisations that the user can choose from when they are creating their own bicycles
     * The price, weight and top speed of a new bike depends on the material of the bike and so these values will be mapped
     *
     */


    // Initialise hashmap which maps the customisation options to the price associated with each one
    private HashMap<Integer, Integer> customPrices = new HashMap<>();

    //declare all the customisable options that the users will choose from when creating their own bicycle
    private final String[] typeOfBikes = {"road", "mountain"};
    private final String[] materialsAvailable = {"aluminium", "steel", "titanium", "carbon fibre"};
    private final String[] coloursAvailable = {"racing red", "volt blue", "gunmetal grey", "silver", "matte black"};
    private final float[] roadTyreDiameters = {22f, 25f, 28f};
    private final float[] mountainTyreDiameters = {26f, 27.5f, 29f};
    private final int[] pricesForCustomisations = {119, 99, 129, 0, 179, 229, 35, 35, 50, 0, 50, 19, 0, 29, 29, 35, 39, 45, 55, 65, 85};
    private final int[] gearsAvailable = {7, 12, 16, 21};

    //define getters for each of these arrays. Copy the values of these into another array and access the copied values instead. This provides extra security for the options.
    public String[] getTypeOptions(){
        String[] copy = new String[this.typeOfBikes.length];
        System.arraycopy(this.typeOfBikes, 0, copy, 0, copy.length);
        return copy;
    }

    public String[] getMaterialOptions(){
        String[] copy = new String[this.materialsAvailable.length];
        System.arraycopy(this.materialsAvailable, 0, copy, 0, copy.length);
        return copy;
    }

    public String[] getColourOptions(){

        String[] copy = new String[this.coloursAvailable.length];
        System.arraycopy(this.coloursAvailable, 0, copy, 0, copy.length);
        return copy;
    }

    public float[] getRoadTyreDiameters(){
        float[] copy = new float[this.roadTyreDiameters.length];
        System.arraycopy(this.roadTyreDiameters, 0, copy, 0, copy.length);
        return copy;
    }

    public float[] getMountainTyreDiameters(){
        float[] copy = new float[this.mountainTyreDiameters.length];
        System.arraycopy(this.mountainTyreDiameters, 0, copy, 0, copy.length);
        return copy;
    }

    public int[] getGearsAvailable(){

        int[] copy = new int[this.gearsAvailable.length];
        System.arraycopy(this.gearsAvailable, 0, copy, 0, copy.length);
        return copy;
    }

    public void printTypes(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i] + " bike");
        }

    }

    public void printMaterials(int bikeType, String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". " + array[i]);

            if (bikeType == 1) {
                if (i == 3) {
                    System.out.println("(recommended)");
                } else {
                    System.out.println();
                }

            } else {
                if (i == 0) {
                    System.out.println("(recommended)");
                } else {
                    System.out.println();
                }
            }

        }
    }

    public void printColours(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". " + array[i]);
            System.out.println();
        }
    }

    public void printTyreDiameters(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". " + array[i] + "\"");
            System.out.println();
        }
    }


    public void printGears(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }

    }

    public void mapChoicesToPrices(){

        for (int i = 0; i < pricesForCustomisations.length; i++) {
            customPrices.put((i + 1), pricesForCustomisations[i]);
        }
    }

    public int getPrices(int userInput) {
        //make a copy of the hashmap
        HashMap<Integer, Integer> copyPrices = new HashMap<>(customPrices);
        return copyPrices.get(userInput); // return the copied value.
    }

    public int addPrices(int price1, int price2, int price3, int price4, int price5) {
        return price1 + price2 + price3 + price4 + price5;
    }


}
