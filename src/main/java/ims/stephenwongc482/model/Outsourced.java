package ims.stephenwongc482.model;
/**
 * Outsourced class
 * */
public class Outsourced extends Part{
    private String companyName;
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
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
