package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.InHouse;
import ims.stephenwongc482.model.Inventory;
import ims.stephenwongc482.model.Outsourced;
import ims.stephenwongc482.model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;
import static ims.stephenwongc482.model.Inventory.getPartIdCount;

public class AddPartController implements Initializable {
    public TextField nameInput;
    public TextField stockInput;
    public TextField priceInput;
    public TextField minInput;
    public TextField maxInput;
    public TextField sourceInput;
    public RadioButton inHouseRadio;
    public RadioButton outsourcedRadio;
    public Label sourceLabel;
    public Label exceptionLabel;

    public int stock;
    public double price;
    public int min;
    public int max;
    public String name;
    public Boolean inHouse;
    public int machineId;
    public String companyName;
    public boolean valid = true;

    public String exception = "";
    public String exceptionName = "";
    public String exceptionPrice = "";
    public String exceptionStock = "";
    public String exceptionMin = "";
    public String exceptionMax = "";
    public String exceptionMachineId = "";
    public String exceptionMinMax = "";
    public String exceptionInvMinMax = "";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Saves new part to inventory when save button is clicked
     *
     * @param actionEvent - save button on add screen
     */
    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        inHouse = inHouseRadio.isSelected();
        if (nameInput.getText().equals("")) { //checks if name is empty
            exceptionName = "Name cannot be empty\n";
            valid = false;
        } else {
            name = nameInput.getText();
            exceptionName = "";
        }
        try { //checks if stock is an integer
            stock = Integer.parseInt(stockInput.getText());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for inventory\n");
            valid = false;
        }
        try { //checks if price is a double
            price = Double.parseDouble(priceInput.getText());
            exceptionPrice = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for price");
            exceptionPrice = "Price is not a double\n";
            valid = false;
        }
        try { //checks if max is an integer
            max = Integer.parseInt(maxInput.getText());
            exceptionMax = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for max");
            exceptionMax = "Max is not a integer\n";
            valid = false;
        }
        try { //checks if min is an integer
            min = Integer.parseInt(minInput.getText());
            exceptionMin = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for min");
            exceptionMin = "Min is not a integer\n";
            valid = false;
        }
        if (min > max) { //checks if min is greater than max
            System.out.println("Min cannot be greater than max");
            valid = false;
            exceptionMinMax = "Min cannot be greater than max\n";
        } else {
            exceptionMinMax = "";
        }
        if (stock > max || stock < min) { //checks if inventory is between min and max
            System.out.println("Inventory must be between min and max");
            valid = false;
            exceptionInvMinMax = "Inventory must be between min and max\n";
        } else {
            exceptionInvMinMax = "";
        }
        if (inHouse) {
            try { //checks if machine ID is an integer
                machineId = Integer.parseInt(sourceInput.getText());
                exceptionMachineId = "";
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer for machine ID");
                exceptionMachineId = "Machine ID is not a integer\n";
                valid = false;
            }
        } else {
            companyName = sourceInput.getText();
        }
        if (valid) { //if all fields are valid, adds part to inventory
            if (inHouse) { //checks if part is in house or outsourced
                Part part = new InHouse(getPartIdCount(), name, price, stock, min, max, machineId);
                Inventory.addPart(part);
            } else {
                companyName = sourceInput.getText();
                Part part = new Outsourced(getPartIdCount(), name, price, stock, min, max, companyName);
                Inventory.addPart(part);
            }
            navigate(actionEvent, "mainScreen");
        } else {
            exception = "Exception: " + exceptionName + exceptionPrice + exceptionStock + exceptionMin + exceptionMax + exceptionMachineId + exceptionMinMax + exceptionInvMinMax;
            exceptionLabel.setText(exception);
            System.out.println(exception);
        }
        valid = true;
    }

    /**
     * cancels addition of new part and navigates back to main screen
     *
     * @param actionEvent - button on add screen
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    /**
     * changes label to machine ID when in house is selected
     *
     * @param actionEvent - radio button
     */
    public void onInHouse(ActionEvent actionEvent) {
        sourceLabel.setText("Machine ID");
    }

    /**
     * changes label to company name when outsourced is selected
     *
     * @param actionEvent - radio button
     */
    public void onOutsourced(ActionEvent actionEvent) {
        sourceLabel.setText("Company Name");
    }


}
