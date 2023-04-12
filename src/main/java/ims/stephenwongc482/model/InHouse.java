package ims.stephenwongc482.model;

/**
 * Part class
 */

public class InHouse extends Part{
    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param machineId
     */

    private int machineId;

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
    /**
     * Gets machine ID
     *
     * @return machine ID
     */
    public int getMachineId() {
        return machineId;
    }
    /**
     * Sets machine ID
     *
     * @param machineId - machine ID
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}
