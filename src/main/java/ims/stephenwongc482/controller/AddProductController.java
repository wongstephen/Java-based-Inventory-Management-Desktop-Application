package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;
import static ims.stephenwongc482.model.Inventory.*;

public class AddProductController implements Initializable {

    public TableView allPartTable;
    public TableColumn allPartIdCol;
    public TableColumn allPartNameCol;
    public TableColumn allPartStockCol;
    public TableColumn allPartPriceCol;

    public TextField nameInput;
    public TextField stockInput;
    public TextField priceInput;
    public TextField minInput;
    public TextField maxInput;
    public Label exceptionLabel;

    private String exceptionName = "";
    private Boolean valid = true;

    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    private String exception = "";
    private String exceptionPrice = "";
    private String exceptionStock  = "";
    private String exceptionMin  = "";
    private String exceptionMax  = "";
    private String exceptionMinMax  = "";
    private String exceptionInvMinMax  = "";




    /**
     * cancels addition of new product and navigates back to main screen
     *
     * @param actionEvent - button on product screen
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    /**
     * adds selected part to associated parts table
     *
     * @param actionEvent - button on product screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allPartTable.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * Saves new product to inventory
     *
     * @param actionEvent - button on product screen
     */

    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {

        if(nameInput.getText().equals("")){ //checks if name is empty
            exceptionName = "Name cannot be empty\n";
            valid = false;
        } else {
            name = nameInput.getText();
            exceptionName = "";
        }
        try { //checks if stock is an integer
            stock = Integer.parseInt(stockInput.getText());
            exceptionStock = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for inventory\n");
            exceptionStock = "Inventory is not a integer\n";
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
        if (valid) { //if all fields are valid, adds part to inventory
            Product product = new Product(getProductIdCount(), name, price, stock, min, max);
            Inventory.addProduct(product);
            navigate(actionEvent, "mainScreen");
        } else {
            exception = "Exception: " + exceptionName + exceptionPrice + exceptionStock + exceptionMin + exceptionMax + exceptionInvMinMax;
            exceptionLabel.setText(exception);
            System.out.println(exception);
        }
        valid = true;


    }

}