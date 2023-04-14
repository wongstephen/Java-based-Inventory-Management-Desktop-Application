package ims.stephenwongc482.model;
/**
 * Part class
 * */
public class Outsourced extends Part{
    private String companyName;
    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param companyName
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
    }
    /**
     * Gets company name
     *
     * @return company name
     */
    public String getCompanyName() {
        return companyName;
    }
    /**
     * Sets company name
     *
     * @param companyName - company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
