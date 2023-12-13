import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBContorller {

   
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
       
    public void InsertnewQuestion(Question question) {
        String sql = "INSERT INTO Question(QID,QContent,QTitle,QuestionMail,QuestionTime) VALUES(?,?,?,?,?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, question.getQID());
            pstmt.setString(2, question.getQContent());
            pstmt.setString(3, question.getQTitle());
            pstmt.setString(4, question.getQuestionMail());
            pstmt.setString(5, question.getQuestionTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {

        DBContorller app = new DBContorller();
        Question q =new Question(6, "erdem says murat", "erdemmm", "john@gmail.com","1702483961684");
        app.InsertnewQuestion(q);
        
    }

    
}