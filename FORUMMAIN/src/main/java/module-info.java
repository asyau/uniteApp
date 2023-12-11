module com.example.forummain {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.forummain to javafx.fxml;
    exports com.example.forummain;
}