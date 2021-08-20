package Bicycle;

import javax.print.attribute.standard.OrientationRequested;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BicycleInventory {
    /**
     * This class will define methods for the following:
     * Addition and removal of bicycle objects to/from inventory list
     * Searching for bikes in inventory list
     * Sorting bikes in reverse order
     */

    // create an empty java collection (arrayList). Keep this private so that other classes do not direct access to this list
    private ArrayList<Bicycle> bikes = new ArrayList<>();

    // Use a getter method in order to retrieve the list from other classes without having access to the actual list itself
    public ArrayList<Bicycle> getList() {
        return bikes;
    }

    public void addBicyclesToList(Bicycle bikeToAdd) {
        this.bikes.add(bikeToAdd);
    }

    public void removeBicycleFromList(Bicycle bikeToRemove) {
        this.bikes.remove(bikeToRemove);
    }

    public int searchList(String nameOfBike) {
        for (int i = 0; i < this.bikes.size(); i++) {
            if (this.bikes.get(i).getName().equals(nameOfBike)) return i; // return the index of bike that matches
        }
        return -1;
    }


        //--------------------------------------Test Methods-----------------------------------------------------------------------//

        public ArrayList<Bicycle> returnCopyOfListWithSingleObject(ArrayList<Bicycle> originalList) {

            // print out the original List
            System.out.println("Returned List: ");
            for (Bicycle bicycle : originalList) {
                System.out.print(bicycle.getName());
            }
            System.out.println();

            return originalList;
        }

        public ArrayList<Bicycle> swapFirstAndLastElements (ArrayList < Bicycle > copiedList,int startIndex,
        int endIndex){

            Bicycle temp = copiedList.get(startIndex); // save the first object
            copiedList.set(startIndex, copiedList.get(endIndex)); //set the start index to the object at the last index
            copiedList.set(endIndex, temp); // set the object at last index to saved first object


            System.out.println("Swapped Order: ");
            for (Bicycle bike : copiedList) {
                System.out.println(bike.getName());
            }

            return copiedList;
        }
        public ArrayList<Bicycle> swapFirstAndLastElements2 (ArrayList < Bicycle > copiedList,int startIndex,
        int endIndex){

            Collections.swap(copiedList, startIndex, endIndex);

            System.out.println("Swapped Order: ");
            for (Bicycle bike : copiedList) {
                System.out.println(bike.getName());
            }

            return copiedList;
        }

        public void reverseListRecursively (ArrayList < Bicycle > copiedList,int startIndex, int endIndex){

            if (startIndex >= endIndex) { //base case
                return;
            }

            Collections.swap(copiedList, startIndex, endIndex);

            reverseListRecursively(copiedList, startIndex + 1, endIndex - 1);

        }

    public boolean checkForDuplicateBicycles(ArrayList<Bicycle> arrList, Bicycle createdBike){
        for (Bicycle bike: arrList){
            if (bike.equals(createdBike)) return true;
        }
        return false;
    }

    public boolean nameCheck(ArrayList<Bicycle> arrList, String nameToCheck) {
        for (Bicycle bike:arrList) {
            if (bike.getName().equals(nameToCheck)) return true;
        }
        return false;
    }

    public Bicycle returnDuplicatedBicycle(ArrayList<Bicycle> arrList, Bicycle duplicateBike) {
        for (Bicycle bike:arrList) {
            if (bike.equals(duplicateBike)) return bike;
        }
        return duplicateBike;
    }
}


