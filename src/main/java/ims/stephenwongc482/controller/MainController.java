package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.Inventory;

import ims.stephenwongc482.model.Part;
import ims.stephenwongc482.model.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;

public class MainController implements Initializable {


    public TableColumn prodIdCol;
    public TableColumn prodNameCol;
    public TableColumn prodStockCol;
    public TableColumn prodPriceCol;

    public TableColumn partIdCol;
    public TableColumn partNameCol;
    public TableColumn partStockCol;
    public TableColumn partPriceCol;

    public TableView allProductTable;
    public TableView allPartTable;
    public TextField partSearchInput;
    public TextField productSearchInput;

    /**
     * initalizes app
     *
     * @param url - url
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * RUNTIME ERROR: java.lang.NullPointerException
         *
         * Fixed by adding exports to module-info.java for model and controller
         */
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        allProductTable.setItems(Inventory.getAllProducts());
        allPartTable.setItems(Inventory.getAllParts());
    }


    /**
     * creates a list of parts that match the search criteria
     *
     * @param partialName - partial name or id of part
     */
    private ObservableList<Part> searchPartByNameOrID(String partialName) {
        if (partialName == null || partialName.isEmpty()) {
            return Inventory.getAllParts();
        } else {
            ObservableList<Part> searchResults = FXCollections.observableArrayList();
            for (Part part : Inventory.getAllParts()) {
                if (part.getName().contains(partialName) || Integer.toString(part.getId()).contains(partialName)) {
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
        String partialName = partSearchInput.getText();
        allPartTable.setItems(searchPartByNameOrID(partialName));
    }
    /**
     * creates a list of parts that match the search criteria
     *
     * @param partialName - partial name or id of part
     */
    private ObservableList<Product> searchProductByNameOrID(String partialName) {
        if (partialName == null || partialName.isEmpty()) {
            return Inventory.getAllProducts();
        } else {
            ObservableList<Product> searchResults = FXCollections.observableArrayList();
            for (Product product : Inventory.getAllProducts()) {
                if (product.getName().contains(partialName) || Integer.toString(product.getId()).contains(partialName)) {
                    searchResults.add(product);
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
    void handleMainSearchProductSubmit(ActionEvent actionEvent) {
        String partialName = productSearchInput.getText();
        allProductTable.setItems(searchProductByNameOrID(partialName));
    }
    /**
     * handles add part button on main screen click and navigates to add part screen
     *
     * @param actionEvent - add part button on main screen
     */
    @FXML
    void handleMainAddPartBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "addPart");
    }

    /**
     * handles modify part button on main screen click and navigates to add part screen
     *
     * @param actionEvent - modify part button on main screen
     */
    @FXML
    void handleMainModifyPartBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "modifyPart");
    }

    @FXML
    void handleMainDeletePartBtn(ActionEvent actionEvent) {
        System.out.println("Main Delete Clicked");
    }

    /**
     * handles add product button on main screen click and navigates to add product screen
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainAddProductBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "addProduct");
    }

    /**
     * handles modify product button on main screen click and navigates to modify product screen
     *
     * @param actionEvent - modify product button on main screen
     */
    @FXML
    void handleMainModifyProductBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "modifyProduct");
    }

    /**
     * handles exit button on main screen click and exits app
     *
     * @param actionEvent - exit button on main screen
     */
    @FXML
    void handleExitBtn(ActionEvent actionEvent) {
        Platform.exit();
    }


}
