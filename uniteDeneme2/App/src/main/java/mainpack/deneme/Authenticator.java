package mainpack.deneme;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Authenticator {

    static ArrayList<User> users;
    static User currentUser;

    public static boolean login(String mail, String password) {
        boolean output = false;
        for(User u : users){
            if (mail.equals(u.getMail()) && password.equals(u.getPassword())) {
                currentUser = u;
                output = true;
            }
        }
        return output;
    }

    public static boolean signUp(String mail, String password, String name) {
        DBController dbc = new DBController();

        if (isBilkentMail(mail) && !alreadyHasSameUser(mail) && isValidPassword(password)){
            User user = new User(mail, password, name);
            dbc.InsertNewUser(user);
            currentUser = user;
            System.out.println("valid");
            return true;
        } else if (alreadyHasSameUser(mail)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("User already exists please login!");

            alert.showAndWait();
        } else if (!isBilkentMail(mail)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Enter a Bilkent mail!");

            alert.showAndWait();
        } else if (!isValidPassword(password)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Enter a valid password!");

            alert.showAndWait();
        }
        return false;
    }

    public static boolean isBilkentMail(String mail) {
        int atIndex = mail.indexOf('@');
        if (atIndex == -1)
            return false;
        String afterAt = mail.substring(atIndex + 1);
        return afterAt.contains("bilkent.edu.tr");
    }
    public static boolean alreadyHasSameUser(String mail) {
        for (User u : users) {
            if (u.getMail().equals(mail))
                return true;
        }
        return false;
    }
    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 20;
    }
    private static void saveUserToDatabase(User user) {
        users.add(user);
        //Save user to database.
    }
    public static void saveUsers() {
        DBController dbc = new DBController();
        users = dbc.createUserArr();
    }
}
