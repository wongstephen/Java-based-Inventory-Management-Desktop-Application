package ims.stephenwongc482.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();
    public static int partIdCount = 0;
    public static int productIdCount = 0;

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
     * Adds product
     *
     * @param product - product to be added
     */
    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    /**
     * Looks up part
     *
     * @param partId - part ID to be looked up
     * @return part
     */
    public static Part lookupPart(int partId) {
        for (Part part : allParts) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    /**
     * Looks up product
     *
     * @param productId - product ID to be looked up
     * @return product
     */
    public static Product lookupProduct(int productId) {
        for (Product product : allProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /**
     * Looks up part
     *
     * @param partName - part name to be looked up
     * @return part
     */
    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> parts = FXCollections.observableArrayList();
        for (Part part : allParts) {
            if (part.getName().contains(partName)) {
                parts.add(part);
            }
        }
        return parts;
    }

    /**
     * Looks up product
     *
     * @param productName - product name to be looked up
     * @return product
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> products = FXCollections.observableArrayList();
        for (Product product : allProducts) {
            if (product.getName().contains(productName)) {
                products.add(product);
            }
        }
        return products;
    }

    /**
     * Updates part
     *
     * @param index - index of part to be updated
     * @param selectedPart - part to be updated
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    /**
     * Updates product
     *
     * @param index - index of product to be updated
     * @param selectedProduct - product to be updated
     */
    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
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
     * Gets all products
     *
     * @return all products
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }


}
