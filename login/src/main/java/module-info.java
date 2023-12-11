module com.example.deneme3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.deneme3 to javafx.fxml;
    exports com.example.deneme3;
}