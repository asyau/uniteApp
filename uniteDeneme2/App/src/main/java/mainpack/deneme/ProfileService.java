package mainpack.deneme;

import javafx.scene.image.Image;

public class ProfileService {
    private static Image profileImage;

    public static void setProfileImage(Image image) {
        profileImage = image;
    }
    public static Image getProfileImage() {
        return profileImage;
    }
}
