package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.MainController.searchAlert;
import static ims.stephenwongc482.controller.NavController.navigate;
import static ims.stephenwongc482.model.Inventory.*;

/**
 * AddProductController class is used to add a product.
 */
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

    public TableView associatedPartTable;
    public TableColumn assPartId;
    public TableColumn assPartName;
    public TableColumn assPartStock;
    public TableColumn assPartPrice;
    public TextField partSearchInput;

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
     * RUNTIME ERROR: I was trying to search for a product but it would not populate in the allParts table. I realized that I had copied the product search from another module and had not changed the reference names so it was giving errors at RUNTIME but not during prod.
     */
    /**
     * cancels addition of new product and navigates back to main screen
     *
     * @param actionEvent - button on product screen
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allPartTable.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        assPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        assPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        assPartStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        assPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    /**
     * creates a list of parts that match the search criteria
     *
     * @param partialName - partial name
     */
    private ObservableList<Part> searchPartByName(String partialName) {
        if (partialName == null || partialName.isEmpty()) {
            return Inventory.getAllParts();
        } else {
            ObservableList<Part> searchResults = FXCollections.observableArrayList();
            for (Part part : Inventory.getAllParts()) {
                if (part.getName().contains(partialName)) {
                    searchResults.add(part);
                }
            }
            return searchResults;
        }
    }
    /**
     * handles search input on main screen and searches for part by name or id
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchPartSubmit(ActionEvent actionEvent) {
        allPartTable.setItems(getAllParts());
        String searchInputText = partSearchInput.getText();
        try {
            if (Integer.parseInt(searchInputText) > 0 && Integer.parseInt(searchInputText) < getAllProducts().size() + 1) {
                allPartTable.getSelectionModel().select(Integer.parseInt(searchInputText)-1);
                return;
            } else {
                allPartTable.getSelectionModel().clearSelection();
                allPartTable.setItems(searchPartByName(searchInputText));
            }
        } catch (NumberFormatException e) {
            allPartTable.getSelectionModel().clearSelection();
            allPartTable.setItems(searchPartByName(searchInputText));
        }
        if (allPartTable.getItems().size() == 0) {
            searchAlert("Part");
        }
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
            if (associatedPartTable.getItems().size() > 0) {
                for (int i = 0; i < associatedPartTable.getItems().size(); i++) {
                    Part part = (Part) associatedPartTable.getItems().get(i);
                    product.addAssociatedPart(part);
                }
            }
            Inventory.addProduct(product);
            navigate(actionEvent, "mainScreen");
        } else {
            exception = "Exception: " + exceptionName + exceptionPrice + exceptionStock + exceptionMin + exceptionMax + exceptionInvMinMax;
            exceptionLabel.setText(exception);
            System.out.println(exception);
        }
        valid = true;
            }

    public void handleAddAssPartBtn(ActionEvent actionEvent) {
        Part part = (Part) allPartTable.getSelectionModel().getSelectedItem();
        associatedPartTable.getItems().add(part);

    }

    /**
     * removes associated part from product
     * @param actionEvent
     */
    @FXML
    public void handleRemoveAssPart(ActionEvent actionEvent) {
        Alert alertConf = new Alert(Alert.AlertType.CONFIRMATION);
        alertConf.setTitle("Associated Part");
        alertConf.setHeaderText("Remove");
        alertConf.setContentText("Are you sure you want to remove this part?");
        Optional<ButtonType> result = alertConf.showAndWait();
        if (result.get() != ButtonType.OK) {
            return;
        }
        associatedPartTable.getItems().remove(associatedPartTable.getSelectionModel().getSelectedItem());
    }

}