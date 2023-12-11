import javax.swing.text.html.ImageView;

public class StaffContact {

    private String name;
    private String office;
    private String title;
    private String department;
    private String mail;
    private ImageView photo;

    public StaffContact(String name, String office, String title, String department, String mail, ImageView photo){
        this.name = name;
        this.office = office;
        this.title = title;
        this.department = department;
        this.mail = mail;
        this.photo = photo;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public String getMail() {
        return mail;
    }
    
    public String getName() {
        return name;
    }

    public String getOffice() {
        return office;
    }

    public ImageView getPhoto() {
        return photo;
    }
    
    public String getTitle() {
        return title;
    }
}