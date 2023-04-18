package ims.stephenwongc482;

import ims.stephenwongc482.model.InHouse;
import ims.stephenwongc482.model.Inventory;
import ims.stephenwongc482.model.Part;
import ims.stephenwongc482.model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static ims.stephenwongc482.model.Inventory.*;

/**
 *
 * @author Stephen Wong
 * @version 1.0
 *
 * studentid: 011031716
 * 4/18/2023
 *
 */


public class Main extends Application {
    /**
     * FUTURE ENHANCEMENTS
     *
     * Add CSS styling to the application to make it more visually appealing.
     * Connect it to a database to persist data.
     * Refactor redundant code to utils folder.
     *
     */

    public static void main(String[] args) {
        initialData();
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/mainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 480);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void initialData() {
        //init parts data
        Part part = new InHouse(getPartIdCount(), "Brakes", 12.99, 15, 1, 20, 1);
        Part part2 = new InHouse(getPartIdCount(), "Tire", 14.99, 15, 1, 20, 2);
        Part part3 = new InHouse(getPartIdCount(), "Rim", 56.99, 15, 1, 20, 3);
        Inventory.addPart(part);
        Inventory.addPart(part2);
        Inventory.addPart(part3);
        //init products data
        Product product = new Product(getProductIdCount(), "Giant Bicycle", 299.99, 15, 1, 20);
        Product product2 = new Product(getProductIdCount(), "Scott Bicycle", 199.99, 15, 1, 20);
        Product product3 = new Product(getProductIdCount(), "GT Bike", 99.99, 15, 1, 20);
        product3.addAssociatedPart(Inventory.lookupPart(1));
        Inventory.addProduct(product);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);
    }
}