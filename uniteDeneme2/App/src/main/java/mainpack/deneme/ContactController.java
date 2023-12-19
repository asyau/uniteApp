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
        ImageView aykanat = new ImageView("aykanat.jpg");
        ImageView shervin = new ImageView("shervin.jpg");
        ImageView ayhan = new ImageView("ayhan.jpg");
        ImageView erdal = new ImageView("erdal.jpg");
        ImageView tolga = new ImageView("tolga.jpg");
        ImageView mehmet = new ImageView("mehmet.jpg");
        ImageView burcu = new ImageView("burcu.jpg");
        ImageView selen = new ImageView("selen.jpg");
        ImageView bulent = new ImageView("bulent.jpg");
        ImageView luca = new ImageView("luca.jpg");
        ImageView yegan = new ImageView("yegan.jpg");
        ImageView onur = new ImageView("onur.jpg");
        ImageView ali = new ImageView("ali.jpg");
        ImageView ilker = new ImageView("ilker.jpg");
        ImageView akturk = new ImageView("akturk.jpg");
        ImageView ulku = new ImageView("ulku.jpg");
        ImageView ozlem = new ImageView("ozlem.jpg");
        ImageView yigit = new ImageView("yigit.jpg");


        ArrayList<StaffContact> staffs = new ArrayList<>();
        staffs.add(new StaffContact("Uğur Güdükbay", "EA", "Prof", "CS", "ug@bilkent.edu.tr", ugurGudukbay));
        staffs.add(new StaffContact("Lori Russel Dağ", "EA", "Instructor", "CS", "lrd@bilkent.edu.tr", loriDag));
        staffs.add(new StaffContact("Uğur Doğrusöz", "EA", "Prof", "CS", "ud@bilkent.edu.tr", ugurDogrusoz));
        staffs.add(new StaffContact("Can Alkan", "EA", "Assoc", "CS", "ca@bilkent.edu.tr", calkan));
        staffs.add(new StaffContact("Selim Aksoy", "EA", "Doc", "CS", "saksoy@bilkent.edu.tr", saksoy));
        staffs.add(new StaffContact("Cevdet Aykanat", "EA", "Prof", "CS", "aykanat@cs.bilkent.edu.tr", aykanat));
        staffs.add(new StaffContact("Shervin R. Arashloo", "EA", "Prof", "CS", "s.rahimzadeh@cs.bilkent.edu.tr", shervin));
        staffs.add(new StaffContact("Ayhan Altıntaş", "EA", "Prof", "EEE", "altintas@ee.bilkent.edu.tr", ayhan));
        staffs.add(new StaffContact("Erdal Arıkan", "EE", "Doc", "EEE", "arikan@ee.bilkent.edu.tr", erdal));
        staffs.add(new StaffContact("Tolga Çukur", "EE", "Prof", "EEE", "cukur@ee.bilkent.edu.tr", tolga));
        staffs.add(new StaffContact("Mehmet Alper Kutay", "EE", "Doc", "EEE", "kutay@ee.bilkent.edu.tr", mehmet));
        staffs.add(new StaffContact("Burcu Şenyapılı Özcan", "FF", "Prof", "Arch", "burcu@bilkent.edu.tr", burcu));
        staffs.add(new StaffContact("Özge Selen Duran", "FF", "Doc", "Arch", "selen.duran@bilkent.edu.tr", selen));
        staffs.add(new StaffContact("Bülent Batuman", "FA", "Prof", "Arch", "batuman@bilkent.edu.tr", bulent));
        staffs.add(new StaffContact("Luca Biancofiore", "EA", "Prof", "ME", "luca@bilkent.edu.tr", luca));
        staffs.add(new StaffContact("Yegan Erdem", "EA", "Doc", "ME", "yeganerdem@bilkent.edu.tr", yegan));
        staffs.add(new StaffContact("Onur Ozcan", "EA", "Doc", "ME", "onurozcan@bilkent.edu.tr", onur));
        staffs.add(new StaffContact("Ali Javili", "EA", "Doc", "ME", "ajavili@bilkent.edu.tr", ali));
        staffs.add(new StaffContact("İlker Temizer", "EA", "Prof", "ME", "temizer@bilkent.edu.tr", ilker));
        staffs.add(new StaffContact("Selim Aktürk", "EA", "Prof", "IE", "akturk@bilkent.edu.tr", akturk));
        staffs.add(new StaffContact("Ulku Gürler", "EA", "Prof", "IE", "ulku@bilkent.edu.tr", ulku));
        staffs.add(new StaffContact("Ozlem Karsu", "EA", "Doc", "IE", "ozlemkarsu@bilkent.edu.tr", ozlem));
        staffs.add(new StaffContact("Yigit Karpat", "EA", "Doc", "IE", "ykarpat@bilkent.edu.tr", yigit));


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