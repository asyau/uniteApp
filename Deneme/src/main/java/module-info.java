module com.example.deneme {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.deneme to javafx.fxml;
    exports com.example.deneme;
}