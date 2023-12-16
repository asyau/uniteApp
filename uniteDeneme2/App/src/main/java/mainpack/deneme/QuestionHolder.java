package mainpack.deneme;

import java.util.ArrayList;

public class QuestionHolder {
    private ArrayList<Question> questions;


    public QuestionHolder(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question q) {
        if (!questions.contains(q))
            questions.add(q);
        //Save to database.
    }
}
