package model.questionnaire;

import model.Default;

import java.util.ArrayList;

public class Questionnaire extends Default {
    private String name;
    private String userID;
    private ArrayList<Question> questions;

    public Questionnaire(
        String id,
        String name,
        String userID,
        ArrayList<Question> questions
    ){
        super(id);
        this.name = name;
        this.userID = userID;
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void createQuestionnaire() {
        Repository.insertQuestionnaire(this);
    }

    public static ArrayList<Questionnaire> selectMyQuestionnairesByUserID (String userID) {
        return Repository.selectMyQuestionnairesByUserID(userID);
    }

    public static ArrayList<Questionnaire> selectQuestionnairesByName(String name){
        return Repository.selectQuestionnairesByName(name);
    }

    public static ArrayList<Questionnaire> selectQuestionnairesByUserName(String userName){
        return Repository.selectQuestionnairesByUserName(userName);
    }

    public static ArrayList<Questionnaire> selectQuestionnairesByNameAndUserName(String name,String userName){
        return Repository.selectQuestionnairesByNameAndUserName(name,userName);
    }

    public static ArrayList<Questionnaire> selectQuestionnaire(){
        return Repository.selectQuestionnaires();
    }
}
