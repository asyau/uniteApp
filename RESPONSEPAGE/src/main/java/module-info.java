module com.example.responsepage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.responsepage to javafx.fxml;
    exports com.example.responsepage;
}