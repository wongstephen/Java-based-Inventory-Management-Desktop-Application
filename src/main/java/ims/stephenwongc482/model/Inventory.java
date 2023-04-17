package ims.stephenwongc482.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    public static int partIdCount = 0;
    public static int productIdCount = 0;
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Gets part ID count
     *
     * @return part ID count
     */
    public static int getPartIdCount() {
        partIdCount++;
        return partIdCount;
    }

    /**
     * Gets product ID count
     *
     * @return product ID count
     */
    public static int getProductIdCount() {
        productIdCount++;
        return productIdCount;
    }
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
     * Deletes part
     *
     * @param selectedPart - part to be deleted
     */
    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }
    /**
     * Deletes product
     *
     * @param selectedProduct - product be deleted
     */
    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
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
     * Gets all products
     *
     * @return all products
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }


}
