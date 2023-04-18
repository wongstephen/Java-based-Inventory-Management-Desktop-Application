package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.Inventory;
import ims.stephenwongc482.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;
import static ims.stephenwongc482.model.Inventory.getAllProducts;
import static ims.stephenwongc482.model.Inventory.getProductIdCount;

public class ModifyProductController implements Initializable {
    public static Product productToModify = null;
    public TextField modifyProductIdInput;
    public TextField modifyProductNameInput;
    public TextField modifyProductStockInput;
    public TextField modifyProductPrice;
    public TextField modifyProductMax;
    public TextField modifyProductMin;
    public TableView allPartsTable;

    // Associated part controls
    public Button addAssPart;
    public Button removeAssPart;
    public TableView allPartTable;
    public TableColumn allPartIdCol;
    public TableColumn allPartNameCol;
    public TableColumn allPartStockCol;
    public TableColumn allPartPriceCol;

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

    private String exceptionName = "";
    private Boolean valid = true;
    public Label exceptionLabel;


    public static void setProductToModify(Product product) {
        productToModify = product;
    }


    /**
     * initalizes app
     *
     * @param url - url
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifyProductIdInput.setText(String.valueOf(productToModify.getId()));
        modifyProductNameInput.setText(productToModify.getName());
        modifyProductStockInput.setText(String.valueOf(productToModify.getStock()));
        modifyProductPrice.setText(String.valueOf(productToModify.getPrice()));
        modifyProductMax.setText(String.valueOf(productToModify.getMax()));
        modifyProductMin.setText(String.valueOf(productToModify.getMin()));

        allPartTable.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        if(modifyProductNameInput.getText().equals("")){ //checks if name is empty
            exceptionName = "Name cannot be empty\n";
            valid = false;
        } else {
            name = modifyProductNameInput.getText();
            exceptionName = "";
        }
        try { //checks if stock is an integer
            stock = Integer.parseInt(modifyProductStockInput.getText());
            exceptionStock = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for inventory\n");
            exceptionStock = "Inventory is not a integer\n";
            valid = false;
        }
        try { //checks if price is a double
            price = Double.parseDouble(modifyProductPrice.getText());
            exceptionPrice = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for price");
            exceptionPrice = "Price is not a double\n";
            valid = false;
        }
        try { //checks if max is an integer
            max = Integer.parseInt(modifyProductMax.getText());
            exceptionMax = "";
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for max");
            exceptionMax = "Max is not a integer\n";
            valid = false;
        }
        try { //checks if min is an integer
            min = Integer.parseInt(modifyProductMin.getText());
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
        if (valid) { //if all fields are valid, mod part in inventory
            Product product = new Product(getProductIdCount(), name, price, stock, min, max);
            Inventory.updateProduct(getAllProducts().indexOf(productToModify), product);
            navigate(actionEvent, "mainScreen");
        } else {
            exception = "Exception: " + exceptionName + exceptionPrice + exceptionStock + exceptionMin + exceptionMax + exceptionInvMinMax;
            exceptionLabel.setText(exception);
        }
        valid = true;

    }

    /**
     * discards inputs in text fields then navigates to main screen
     *
     * @param actionEvent - action event
     * @throws IOException - io exception
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    @FXML
    void handleAddAssPart(ActionEvent actionEvent) {

    }

    @FXML
    void handleRemoveAssPart(ActionEvent actionEvent) {

    }


}

