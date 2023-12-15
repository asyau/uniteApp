package mainpack.deneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBController {
    private Connection connect() {
        String url = "jdbc:sqlite:./MyData.db";
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

}
