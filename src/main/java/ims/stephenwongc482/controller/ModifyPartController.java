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
import static ims.stephenwongc482.model.Inventory.getAllParts;
import static ims.stephenwongc482.model.Inventory.getPartIdCount;

public class ModifyPartController implements Initializable {

    public static Part partToModify = null;
    public Label sourceLabel;
    public TextField modifyIdInput;
    public TextField modifyNameInput;
    public TextField modifyStockInput;
    public TextField modifyPriceInput;
    public TextField modifyMaxInput;
    public TextField modifySourceInput;
    public TextField modifyMinInput;
    public RadioButton inHouseRadio;
    public RadioButton outsourcedRadio;
    public Label exceptionLabel;

    boolean inHouse;
    String exceptionName;
    String name;
    double price;
    boolean valid = true;
    int stock;
    int min;
    int max;
    String exceptionPrice;
    String exceptionStock;
    String exceptionMinMax;
    String exceptionInvMinMax;
    int machineId;
    String exceptionMachineId;
    String companyName;
    String exception = "";
    String exceptionMin = "";
    String exceptionMax = "";

    public static void setPartToModify(Part part) {
        partToModify = part;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifyIdInput.setText(String.valueOf(partToModify.getId()));
        modifyNameInput.setText(partToModify.getName());
        modifyStockInput.setText(String.valueOf(partToModify.getStock()));
        modifyPriceInput.setText(String.valueOf(partToModify.getPrice()));
        modifyMaxInput.setText(String.valueOf(partToModify.getMax()));
        modifyMinInput.setText(String.valueOf(partToModify.getMin()));
        if (partToModify instanceof InHouse) {
            modifySourceInput.setText(String.valueOf(((InHouse) partToModify).getMachineId()));
            inHouseRadio.setSelected(true);
        } else {
            modifySourceInput.setText(((Outsourced) partToModify).getCompanyName());
            outsourcedRadio.setSelected(true);
        }
    }

    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    public void onInHouse(ActionEvent actionEvent) {
        sourceLabel.setText("Machine ID");
    }

    public void onOutsourced(ActionEvent actionEvent) {
        sourceLabel.setText("Company Name");
    }

    /**
     * Saves new part to inventory when save button is clicked
     *
     * @param actionEvent - save button on add screen
     */

    /** RUNTIME ERROR: I was getting errors when saving a modified part. I realized I had to use the builtin method .indexOf instead of the method I created in the Inventory class, lookup **/

    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        inHouse = inHouseRadio.isSelected();
        if (modifyNameInput.getText().equals("")) { //checks if name is empty
            exceptionName = "Name cannot be empty\n";
            valid = false;
        } else {
            name = modifyNameInput.getText();
            exceptionName = "";
        }

        try { //checks if stock is an integer
            stock = Integer.parseInt(modifyStockInput.getText());
            exceptionStock = "";
        } catch (NumberFormatException e) {
            exceptionStock = "Inventory is not a integer\n";
            valid = false;
        }

        try { //checks if price is a double
            price = Double.parseDouble(modifyPriceInput.getText());
            exceptionPrice = "";
        } catch (NumberFormatException e) {
            exceptionPrice = "Price is not a double\n";
            valid = false;
        }

        try { //checks if max is an integer
            max = Integer.parseInt(modifyMaxInput.getText());
            exceptionMax = "";
        } catch (NumberFormatException e) {
            exceptionMax = "Max is not a integer\n";
            valid = false;
        }

        try { //checks if min is an integer
            min = Integer.parseInt(modifyMinInput.getText());
            exceptionMin = "";
        } catch (NumberFormatException e) {
            exceptionMin = "Min is not a integer\n";
            valid = false;
        }

        if (min > max) { //checks if min is greater than max
            valid = false;
            exceptionMinMax = "Min cannot be greater than max\n";
        } else {
            exceptionMinMax = "";
        }

        if (stock > max || stock < min) { //checks if inventory is between min and max
            valid = false;
            exceptionInvMinMax = "Inventory must be between min and max\n";
        } else {
            exceptionInvMinMax = "";
        }

        if (inHouse) {
            try { //checks if machine ID is an integer
                machineId = Integer.parseInt(modifySourceInput.getText());
                exceptionMachineId = "";
            } catch (NumberFormatException e) {
                exceptionMachineId = "Machine ID is not a integer\n";
                valid = false;
            }
        } else {
            companyName = modifySourceInput.getText();
        }
        if (valid) { //if all fields are valid, adds part to inventory
            if (inHouse) { //checks if part is in house or outsourced
                Part part = new InHouse(getPartIdCount(), name, price, stock, min, max, machineId);
                Inventory.updatePart(getAllParts().indexOf(partToModify), part);
            } else {
                companyName = modifySourceInput.getText();
                Part part = new Outsourced(getPartIdCount(), name, price, stock, min, max, companyName);
                Inventory.updatePart(getAllParts().indexOf(partToModify), part);

            }
            navigate(actionEvent, "mainScreen");
        } else {
            exception = "Exception: " + exceptionName + exceptionPrice + exceptionStock + exceptionMin + exceptionMax + exceptionMachineId + exceptionMinMax + exceptionInvMinMax;
            exceptionLabel.setText(exception);

        }
        valid = true;


    }
}
