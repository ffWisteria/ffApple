package model.questionnaire;

import model.Default;

import java.util.ArrayList;

public class Question extends Default {
    private int number;
    private String content;
    private String questionnaireID;
    private ArrayList<Answer> answers;

    public Question(
        String id,
        int number,
        String content,
        String questionnaireID,
        ArrayList<Answer> answers
    ) {
        super(id);
        this.number = number;
        this.content = content;
        this.questionnaireID = questionnaireID;
        this.answers = answers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(String questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public static ArrayList<Question>selectQuestionsByQuestionnaireID(String questionnaireID){
        return Repository.selectQuestionsByQuestionnaireID(questionnaireID);
    }
}
