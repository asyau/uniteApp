package mainpack.deneme;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DBController {

    public static void main(String[] args) {
        DBController dbc = new DBController();

        Authenticator.saveUsers();
        Calendar cal = Calendar.getInstance();
        Question q = new Question("H", "testing dbc", 1, cal, Authenticator.users.get(0));
        dbc.InsertNewQuestion(q);
    }

    public static Calendar longToCalendar(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        System.out.println(calendar);
        return calendar;
    }
    private Connection connect() {
        String url = "jdbc:sqlite:/Users/erdemugurlu/Desktop/testDB/MyData.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void InsertNewQuestion(Question question) {
        String sql = "INSERT INTO Questions(QTitle,QContent,QuestionTag,QuestionTime,QuestionMail,QID) VALUES(?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(3, question.getTag());
            pstmt.setString(2, question.getInfo());
            pstmt.setString(1, question.getHeading());
            pstmt.setString(5, question.getOwner().getMail());
            pstmt.setInt(6, question.getQuestionID());
            if(question.getPostDate()!=null)
                pstmt.setString(4, ""+question.getPostDate().getTimeInMillis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void InsertNewUser(User user) {
        String sql = "INSERT INTO Users(mail,password,name) VALUES(?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(3, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(1, user.getMail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void InsertNewReply(Reply reply, Question question) {
        String sql = "INSERT INTO Replies(relatedQID,relatedMail,replyContent,time) VALUES(?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,question.getQuestionID());
            pstmt.setString(3, reply.getContent());
            String time = "" + reply.getReplyDate().getTimeInMillis();
            pstmt.setString(4, time);

            if (reply.getOwner()!=null)
                pstmt.setString(2, reply.getOwner().getMail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void InsertNewG250Event(Announcement ans) {
        String sql = "INSERT INTO GE250EVENTS(organizerClub,eventContent,time) VALUES(?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,ans.getOrganizer());
            pstmt.setString(2, ans.getEventInformation());
            pstmt.setString(3, ""+ans.getTime().getTimeInMillis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  ArrayList<User> createUserArr() {
        ArrayList<User> arr = new ArrayList<>();
        User u;
        Connection conn = null;
        String url="jdbc:sqlite:/Users/erdemugurlu/Desktop/testDB/MyData.db";
        try{
            conn=DriverManager.getConnection(url);
            String sql = "SELECT * FROM Users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                u = new User(rs.getString(1),rs.getString(2),rs.getString(3));
                arr.add(u);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

    public ArrayList<Question> createQuestionArr() {
        ArrayList<Question> arr = new ArrayList<>();
        Question q;
        Connection conn = null;
        String url="jdbc:sqlite:/Users/erdemugurlu/Desktop/testDB/MyData.db";
        try{
            conn=DriverManager.getConnection(url);
            String sql = "SELECT * FROM Questions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //(String heading, String info, int tag, Calendar postDate, ArrayList<Reply> replies, User owner)
            while (rs.next()){
                String heading = rs.getString(1);
                String mail = rs.getString(5);
                System.out.println("current mail: " + mail );
                User user= null;
                for (User u : Authenticator.users) {
                    System.out.println("user mail: " + u.getMail() );
                    if (u.getMail().equals(mail))
                        user = u;
                }
                Calendar cal = longToCalendar(Long.parseLong(rs.getString(4)));
                q = new Question(heading,rs.getString(2),rs.getInt(3),cal, user);
                arr.add(q);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }
    public void insertNewProfilImage(String url,String currentUserMail){
        System.out.println(url);
        String sql = "UPDATE Profilimages SET photoUrl = ? WHERE photoMail = ?";
        try (Connection conn = this.connect();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, url);
            pst.setString(2, currentUserMail);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertNewMenuImage(String url,String currentUserMail){
        String sql = "UPDATE MenuImages SET menuPhotoUrl = ? WHERE menuPhotoMail = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,url);
            pstmt.setString(2,currentUserMail);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addNewProfilImage(String url,String currentUserMail){
        String sql = "INSERT INTO ProfilImages(photoUrl,photoMail) VALUES(?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,url);
            pstmt.setString(2,currentUserMail);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addNewMenuImage(String url,String currentUserMail){
        String sql = "INSERT INTO MenuImages(menuPhotoUrl,menuPhotoMail) VALUES(?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,url);
            pstmt.setString(2,currentUserMail);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Reply> createReplyArr() {
        ArrayList<Reply> arr = new ArrayList<>();
        Reply r;
        Connection conn = null;
        String url="jdbc:sqlite:/Users/erdemugurlu/Desktop/testDB/MyData.db";
        try{
            conn=DriverManager.getConnection(url);
            String sql = "SELECT * FROM Replies";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int relatedQID = rs.getInt(1);
                String mail = rs.getString(2);
                Question q = null;
                for (Question question : Forum.getQuestions() ) {
                    if (question.getQuestionID()==rs.getInt(1))
                        q=question;
                }
                User user= null;
                for (User u : Authenticator.users) {
                    if (u.getMail().equals(mail))
                        user = u;
                }
                Calendar cal=null;
                if (rs.getString(4)!=null)
                    cal = longToCalendar(Long.parseLong(rs.getString(4)));
                r = new Reply(rs.getString(3),user,cal,q);
                arr.add(r);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }
    public String getProfilUrl(User u){
        Connection conn = null;
        String url="jdbc:sqlite:/Users/erdemugurlu/Desktop/testDB/MyData.db";
        String pUrl =null;
        try{
            conn=DriverManager.getConnection(url);
            String sql = "SELECT * FROM Profilimages";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()){
                if (rs.getString(2).equals(u.getMail()))
                    pUrl = rs.getString(1);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pUrl;
    }
    public String getMenuUrl(){
        Connection conn = null;
        String url="jdbc:sqlite:/Users/erdemugurlu/Desktop/testDB/MyData.db";
        String pUrl =null;
        try{
            conn=DriverManager.getConnection(url);
            String sql = "SELECT * FROM MenuImages";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()){
                if (rs.getString(2).equals(Authenticator.currentUser.getMail()))
                    pUrl = rs.getString(1);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pUrl;
    }
}