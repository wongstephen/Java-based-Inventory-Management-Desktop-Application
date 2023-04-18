package ims.stephenwongc482.model;

/**
 * Part class
 *
 * @author Stephen Wong
 */
public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Gets part ID
     *
     * @return part ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets part ID
     *
     * @param id - part ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets part name
     *
     * @return part name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets part name
     *
     * @param name - part name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets part price
     *
     * @return part price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets part price
     *
     * @param price - part price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets part stock
     *
     * @return part stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets part stock
     *
     * @param stock - part stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets part min
     *
     * @return part min
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets part min
     *
     * @param min - part min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Gets part max
     *
     * @return part max
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets part max
     *
     * @param max - part max
     */
    public void setMax(int max) {
        this.max = max;
    }
}
