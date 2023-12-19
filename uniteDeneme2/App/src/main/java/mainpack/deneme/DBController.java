package mainpack.deneme;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DBController {
    public static void main(String[] args) {
        Calendar currentCalendar = Calendar.getInstance();
        System.out.println("Current Date and Time: " + currentCalendar.getTime());

        // Creating a Calendar instance for a specific date and time
        Calendar specificCalendar = Calendar.getInstance();
        specificCalendar.set(2023, Calendar.DECEMBER, 19, 12, 30);
        System.out.println("Specific Date and Time: " + specificCalendar.getTime());
        //ArrayList<Reply> rarr = new ArrayList<Reply>();
        ArrayList<Question> qarr = new ArrayList<Question>();
        DBController db = new DBController();
        User u = new User("erdjemmmmmeeermmttmm@ug.bilkent.edu.tr","erdemsif","ermdmemdme");
        db.InsertNewUser(u);
        Question q = new Question("erdemq","sssss",1,specificCalendar,u);
        db.InsertNewQuestion(q);
        db.createQuestionArr(qarr);
        Reply r = new Reply("soru",qarr.get(2).getOwner(),longToCalendar(111111),qarr.get(1));
        System.out.println(r.getQuestion());
        db.InsertNewReply(r,qarr.get(1));
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
            pstmt.setString(4, reply.getTimePassed());

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

    public  ArrayList<User> createUserArr(ArrayList<User> arr) {
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

    public void createQuestionArr(ArrayList<Question> arr) {
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
                User user= null;
                for (User u : Authenticator.userArr) {
                    if (u.getMail().equals(mail))
                        user = u;
                }
                Calendar cal = longToCalendar(Long.parseLong(rs.getString(4)));
                q = new Question(heading,rs.getString(2),rs.getInt(3),cal ,user);
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
    public void createReplyArr(ArrayList<Reply> arr) {
        Reply r;
        ArrayList<Question> qArr=new ArrayList<Question>();
        this.createQuestionArr(qArr);
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
                for (Question question :qArr ) {
                    if (question.getQuestionID()==rs.getInt(1))
                        q=question;
                }
                User user= null;
                for (User u : Authenticator.userArr) {
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
    }
}