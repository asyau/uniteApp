module com.example.deneme4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.deneme4 to javafx.fxml;
    exports com.example.deneme4;
}