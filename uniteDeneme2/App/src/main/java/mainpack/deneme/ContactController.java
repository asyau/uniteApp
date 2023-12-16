package mainpack.deneme;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContactController implements Initializable {
    @FXML
    private ListView<bilkentNumbers> numbersListView;
    @FXML
    private Button backButton;
    @FXML
    private VBox phoneNumbersLayout;
    @FXML
    private TableView<StaffContact> table;
    @FXML
    private TableColumn<StaffContact, String> photoColumn;
    @FXML
    private TableColumn<StaffContact, String> nameColumn;
    @FXML
    private TableColumn<StaffContact, String> officeColumn;
    @FXML
    private TableColumn<StaffContact, String> titleColumn;
    @FXML
    private TableColumn<StaffContact, String> departmentColumn;
    @FXML
    private TableColumn<StaffContact, String> emailColumn;
    @FXML
    private TextField keywordField;

    ObservableList<StaffContact> obs;
    @FXML
    public void onBackButtonClick() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/menu-view.fxml"));
            primaryStage.setTitle("Contact Information");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView ugurGudukbay = new ImageView("gudukbay.jpg");
        ImageView loriDag = new ImageView("loridag.jpg");
        ImageView ugurDogrusoz = new ImageView("dogrusoz.jpg");
        ImageView calkan = new ImageView("calkan.jpg");
        ImageView saksoy = new ImageView("saksoy.jpg");

        ArrayList<StaffContact> staffs = new ArrayList<>();
        staffs.add(new StaffContact("Uğur Güdükbay", "EA", "Prof", "CS", "ug@bilkent.edu.tr", ugurGudukbay));
        staffs.add(new StaffContact("Lori Russel Dağ", "EA", "Instructor", "CS", "lrd@bilkent.edu.tr", loriDag));
        staffs.add(new StaffContact("Uğur Doğrusöz", "EA", "Prof", "CS", "ud@bilkent.edu.tr", ugurDogrusoz));
        staffs.add(new StaffContact("Can Alkan", "EA", "Assoc", "CS", "ca@bilkent.edu.tr", calkan));
        staffs.add(new StaffContact("Selim Aksoy", "EA", "Doc", "CS", "saksoy@bilkent.edu.tr", saksoy));

        ContactHolder h = new ContactHolder(staffs);

        obs = FXCollections.observableArrayList(h.getStaff());

        photoColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        officeColumn.setCellValueFactory(new PropertyValueFactory<>("office"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        
        table.setItems(obs);

        keywordField.textProperty().addListener((observable, oldValue, newValue) -> {
            obs = FXCollections.observableArrayList(h.filterStaff(newValue));
            table.setItems(obs);
        } );



    }



}