module com.example.askaquestion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.askaquestion to javafx.fxml;
    exports com.example.askaquestion;
}