package Bicycle;

import java.util.ArrayList;

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
    public ArrayList<Bicycle> getList(){ return bikes; }

    public void addBicyclesToList(Bicycle bikeToAdd) {
        this.bikes.add(bikeToAdd);
    }

    public void removeBicycleFromList(Bicycle bikeToRemove){
        this.bikes.remove(bikeToRemove);
    }

    public int SearchList(String nameOfBike){
        for (int i = 0; i < this.bikes.size(); i++) {
            if (this.bikes.get(i).getName().equals(nameOfBike)) return i; // return the index of bike that matches
        }
        return -1;
    }


    public ArrayList<Bicycle> copyList(ArrayList<Bicycle> originalList) {
        // create a new list that is the same as the original list
        ArrayList<Bicycle> copiedList  = new ArrayList<>(originalList);
        System.out.println("Original List: " + originalList.get(0).getName());
        System.out.println("Copied List: " + copiedList.get(0).getName());
        return copiedList;
    }

    public ArrayList<Bicycle> ReverseTwoObjects(ArrayList<Bicycle> originalList) {
        // create a new list that is the same as the original list
        ArrayList<Bicycle> copiedList  = new ArrayList<>(originalList);

        // print out the original List
        System.out.println("Original List: ");
        for (Bicycle bicycle : originalList) {
            System.out.print(bicycle.getName() + ", ");
        }
        System.out.println();


        // reverse the list


        // print out the copied List
        System.out.println("Copied List: ");
        for (Bicycle bicycle : copiedList) {
            System.out.print(bicycle.getName() + ", ");
        }
        System.out.println();


        return copiedList;
    }



}
