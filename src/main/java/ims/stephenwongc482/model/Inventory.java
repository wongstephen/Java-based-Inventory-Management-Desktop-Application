package ims.stephenwongc482.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    public static int partIdCount = 1;
    public static int productIdCount = 1;
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

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

    /**
     * Adds product
     *
     * @param product - product to be added
     */
    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    /**
     * Gets all Parts
     *
     * @return all products
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }


}
