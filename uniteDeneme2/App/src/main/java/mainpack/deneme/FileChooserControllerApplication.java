package mainpack.deneme;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class FileChooserControllerApplication  extends javafx.application.Application{


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/profilePicUploadPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        stage.setTitle("Upload Profile Picture");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        FileChooserControllerApplication.launch();
    }

}
