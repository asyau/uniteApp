package mainpack.deneme;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DBController {

    public static Calendar longToCalendar(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
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
        String sql = "INSERT INTO Question(QID,QContent,QTitle,QuestionMail,QuestionTime) VALUES(?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(3, question.getTag());
            pstmt.setString(2, question.getInfo());
            pstmt.setString(1, question.getHeading());
            pstmt.setString(5, question.getOwner().getMail());
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
        String sql = "INSERT INTO Replies(relatedQID,relatedMail,replyContent) VALUES(?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,question.getQuestionID());
            pstmt.setString(3, reply.getContent());
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

    public void createUserArr(ArrayList<User> arr) {
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
    }

    public void createQuestionArr(ArrayList<Question> arr) {
        Question q;
        Connection conn = null;
        String url="jdbc:sqlite:/Questions/erdemugurlu/Desktop/testDB/MyData.db";
        try{
            conn=DriverManager.getConnection(url);
            String sql = "SELECT * FROM Questions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //(String heading, String info, int tag, Calendar postDate, ArrayList<Reply> replies, User owner)
            while (rs.next()){
                String heading = rs.getString(1);
                String mail = rs.getString(4);
                User user= null;
                for (User u : Authenticator.users) {
                    if (u.getMail().equals(mail))
                        user = u;
                }
                Calendar cal = longToCalendar(Long.parseLong(rs.getString(4)));
                q = new Question(rs.getString(1),rs.getString(2),rs.getInt(3),cal ,user);
                arr.add(q);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertNewProfilImage(String url,String currentUserMail){
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
    public void insertNewMenuImage(String url,String currentUserMail){
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
}