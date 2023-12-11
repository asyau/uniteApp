module com.example.menu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.menu to javafx.fxml;
    exports com.example.menu;
}