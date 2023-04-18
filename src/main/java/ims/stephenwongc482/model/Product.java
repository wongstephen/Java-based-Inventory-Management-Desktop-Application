package ims.stephenwongc482.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * Product class
 *
 * @author Stephen Wong
 */
public class Product {
    private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Gets product ID
     *
     * @return product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets product ID
     *
     * @param id - product ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets product name
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets product name
     *
     * @param name - product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets product price
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets product price
     *
     * @param price - product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets product stock
     *
     * @return product stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets product stock
     *
     * @param stock - product stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets product min
     *
     * @return product min
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets product min
     *
     * @param min - product min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Gets product max
     *
     * @return product max
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets product max
     *
     * @param max - product max
     */
    public void setMax(int max) {
        this.max = max;
    }

    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    public void deleteAssociatedPart(Part part) {
        associatedParts.remove(part);
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
}
