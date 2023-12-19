package mainpack.deneme;
import javafx.scene.image.Image;
public class MenuService {
    private static Image menuImage;
    public static void setMenuImage(Image image) {
        menuImage = image;
    }
    public static Image getMenuImage() {
        return menuImage;
    }
}
