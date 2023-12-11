module com.example.deneme3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.deneme3 to javafx.fxml;
    exports com.example.deneme3;
}