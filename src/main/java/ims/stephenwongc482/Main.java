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


public class Main extends Application {

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

    }
}