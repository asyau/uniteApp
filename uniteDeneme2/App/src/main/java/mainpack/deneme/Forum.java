package mainpack.deneme;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

public class Forum {
    private static ArrayList<Question> questions;
    private static ArrayList<Reply> replies;

    public Forum(ArrayList<Question> questions) {
        this.questions = questions;
        DBController dbc = new DBController();
        this.replies = dbc.createReplyArr();
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static ArrayList<Reply> getReplies() {
        return replies;
    }

    public void addQuestion(String heading, String info, int tag, User owner) {
        questions.add(new Question(heading, info, tag, Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")), owner));
    }
    public ArrayList<Question> sort(int tag) {
        ArrayList<Question> result = new ArrayList<>();
        for (Question q : questions) {
            if (q.getTag() == tag)
                result.add(q);
        }
        return result;
    }

    public ArrayList<Question> filter(String text) {
        Scanner scan = new Scanner(text);
        ArrayList<Question> result = new ArrayList<>();
        for (Question q : questions) {
            if (q.getHeading().contains(text) || q.getInfo().contains(text) || q.getOwner().getName().contains(text))
                result.add(q);
        }

        return result;
    }
}
