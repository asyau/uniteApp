package mainpack.deneme;

import java.util.ArrayList;

public class Authenticator {

    ArrayList<User> users;
    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User login(String mail, String password) {
        for(User u : users){
            if (mail.equals(u.getMail()) && password.equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public User signIn(String mail, String password, String name) {
        if (isBilkentMail(mail) && !alreadyHasSameUser(mail) && isValidPassword(password)){
            User user = new User(mail, password, name);
            saveUserToDatabase(user);
            return user;
        }
        return null;
    }

    private boolean isBilkentMail(String mail) {
        int atIndex = mail.indexOf('@');
        if (atIndex == -1)
            return false;
        String afterAt = mail.substring(atIndex + 1);
        return afterAt.contains("bilkent.edu.tr");
    }
    private boolean alreadyHasSameUser(String mail) {
        for (User u : users) {
            if (u.getMail().equals(mail))
                return true;
        }
        return false;
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 20;
    }
    private void saveUserToDatabase(User user) {
        users.add(user);
        //Save user to database.
    }
}
