package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.InHouse;
import ims.stephenwongc482.model.Inventory;
import ims.stephenwongc482.model.Part;
import ims.stephenwongc482.model.Product;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;

public class MainController implements Initializable {


    public TableView allPartTable;
    public TableColumn partIdCol;
    public TableColumn partNameCol;
    public TableColumn partStockCol;
    public TableColumn partPriceCol;
    public TableView allProductTable;
    public TableColumn prodIdCol;
    public TableColumn prodNameCol;
    public TableColumn prodStockCol;
    public TableColumn prodPriceCol;
    private boolean firstTime = true;

    void initialData() {
        Part part = new InHouse(1, "Part 1", 1.00, 1, 1, 1, 1);
        Part part2 = new InHouse(2, "Part 2", 2.00, 2, 2, 2, 2);
        Part part3 = new InHouse(3, "Part 3", 3.00, 3, 3, 3, 3);
        Part part4 = new InHouse(4, "Part 4", 4.00, 4, 4, 4, 4);
        Inventory.addPart(part);
        Inventory.addPart(part2);
        Inventory.addPart(part3);
        Inventory.addPart(part4);
        Product product = new Product(1, "Product 1", 1.00, 1, 1, 1);
        Product product2 = new Product(2, "Product 2", 2.00, 2, 2, 2);
        Product product3 = new Product(3, "Product 3", 3.00, 3, 3, 3);
        Product product4 = new Product(4, "Product 4", 4.00, 4, 4, 4);
        Inventory.addProduct(product);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);
        Inventory.addProduct(product4);
        allPartTable.setItems(Inventory.getAllParts());
        allProductTable.setItems(Inventory.getAllProducts());
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
    }

    /**
     * initalizes app
     *
     * @param url - url
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main Screen Loaded");
        if (firstTime) {
            initialData();
            firstTime = false;

        }

    }

    /**
     * TODO Part Search
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchPartSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
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
     * TODO Product Search
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchProductSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
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
