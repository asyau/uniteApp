package mainpack.deneme;

public class User {

    String mail, password, name;
    public User(String mail, String password, String name) {
        this.mail = mail;
        setPassword(password);
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        if (password.length() >= 8 && password.length() <= 20) {
            this.password = password;
        }
    }
}
