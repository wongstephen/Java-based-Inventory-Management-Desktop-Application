package ims.stephenwongc482.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
//    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();


    /**
     * Adds part
     *
     * @param part - part to be added
     */
    public static void addPart(Part part) {
        allParts.add(part);
    }

    /**
     * Gets all parts
     *
     * @return all parts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }



}
