module com.example.announcement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.announcement to javafx.fxml;
    exports com.example.announcement;
}