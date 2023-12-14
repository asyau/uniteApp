module mainpack.deneme {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    opens mainpack.deneme to javafx.fxml;
    exports mainpack.deneme;

}