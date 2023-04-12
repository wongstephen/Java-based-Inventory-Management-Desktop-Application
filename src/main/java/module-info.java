module ims.inventorymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens ims.inventorymanagementsystem to javafx.fxml;
    exports ims.inventorymanagementsystem;
    exports ims.inventorymanagementsystem.Model;
    opens ims.inventorymanagementsystem.Model to javafx.fxml;
}