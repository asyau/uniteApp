module com.example.contacts {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.contacts to javafx.fxml;
    exports com.example.contacts;
}