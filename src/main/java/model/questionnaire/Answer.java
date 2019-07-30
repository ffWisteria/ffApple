package model.questionnaire;

import model.Default;

import java.util.ArrayList;

public class Answer extends Default {
    private int evaluation;
    private String comment;
    private String questionID;
    private String userID;

    public Answer(
           String id,
           int evaluation,
           String comment,
           String questionID,
           String userID
    ){
        super(id);
        this.evaluation = evaluation;
        this.comment = comment;
        this.questionID = questionID;
        this.userID = userID;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void createAnswer() {
        Repository.insertAnswer(this);
    }

    public static ArrayList<Answer> selectAnsｗersByQuestionID(String questionID){
        return Repository.selectAnswersByQuestionID(questionID);
    }
}
