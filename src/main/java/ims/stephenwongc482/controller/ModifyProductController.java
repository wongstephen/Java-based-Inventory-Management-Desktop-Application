package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.Inventory;
import ims.stephenwongc482.model.Part;
import ims.stephenwongc482.model.Product;
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
 * ModifyProductController class is used to modify a product.
 */
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

    public TableView assPartTable;
    public TableColumn assPartId;
    public TableColumn assPartName;
    public TableColumn assPartStock;
    public TableColumn assPartPrice;
    public TextField partSearchInput;

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

        assPartTable.setItems(productToModify.getAllAssociatedParts());
        assPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        assPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        assPartStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        assPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        allPartTable.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
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
            for (Part part : productToModify.getAllAssociatedParts()) {
                product.deleteAssociatedPart(part);
            }
            for (Object part : assPartTable.getItems()) {
                product.addAssociatedPart((Part)part);
            }
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

    /**
     * adds associated part to product
     * @param actionEvent
     */
    @FXML
    void handleAddAssPartBtn(ActionEvent actionEvent) {
        productToModify.addAssociatedPart((Part)allPartTable.getSelectionModel().getSelectedItem());
    }

    /**
     * removes associated part from product
     * @param actionEvent
     */
    @FXML
    void handleRemoveAssPart(ActionEvent actionEvent) {
        Alert alertConf = new Alert(Alert.AlertType.CONFIRMATION);
        alertConf.setTitle("Associated Part");
        alertConf.setHeaderText("Remove");
        alertConf.setContentText("Are you sure you want to remove this part?");
        Optional<ButtonType> result = alertConf.showAndWait();
        if (result.get() != ButtonType.OK) {
            return;
        }
        productToModify.deleteAssociatedPart((Part)assPartTable.getSelectionModel().getSelectedItem());
    }


}

