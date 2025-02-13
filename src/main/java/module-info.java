module org.example.mitchell_csc311_module3hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mitchell_csc311_module3hw to javafx.fxml;
    exports org.example.mitchell_csc311_module3hw;
}