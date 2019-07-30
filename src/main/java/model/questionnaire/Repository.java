package model.questionnaire;

import lib.mysql.Client;
import model.user.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;


public class Repository extends Client {
    public static void insertQuestionnaire(Questionnaire questionnaire) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = createConnection();

            // --- Questionnaire 登録用 SQL ---
            String sql = "insert into questionnaires (name, user_id) values(?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            // SQL に値を代入
            preparedStatement.setString(1, questionnaire.getName());
            preparedStatement.setInt(2, Integer.parseInt(questionnaire.getUserID()));

            // SQL の実行
            preparedStatement.executeUpdate();

            // --- Questions 登録用 SQL ---
            sql = "insert into questions (number, content, questionnaire_id) values";
            for (int i = 0; i < questionnaire.getQuestions().size(); i++) {
                // 最後の部分だけセミコロンをなくす
                if (i + 1 != questionnaire.getQuestions().size()) {
                    sql = sql + " (?, ?, LAST_INSERT_ID()),";
                } else {
                    sql = sql + " (?, ?, LAST_INSERT_ID())";
                }
            }
            preparedStatement = connection.prepareStatement(sql);

            // SQL に値を代入
            for (int i = 0; i < questionnaire.getQuestions().size(); i++) {
                preparedStatement.setInt(i * 2 + 1, questionnaire.getQuestions().get(i).getNumber());
                preparedStatement.setString(i * 2 + 2, questionnaire.getQuestions().get(i).getContent());
            }

            // SQL の実行
            preparedStatement.executeUpdate();

            return;

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }finally {
            close(connection,preparedStatement,resultSet);
        }
    }

    public static void insertAnswer(Answer answer){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // SQL 文の用意
            String sql = "insert into answers " +
                    "(evaluation, free_text, question_id, user_id)" +
                    " values (?, ?, ?, ?)";

            // DB へのコネクションを作成する
            connection = createConnection();
            // user インスタンスの生成

            // セキュリティの一つ。
            // sql文を入力されてしまった時にデータが消えてしまうかもしれないから
            // 実行するSQL文とパラメータを指定する
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, answer.getEvaluation());//?1
            preparedStatement.setString(2, answer.getComment());//?2
            preparedStatement.setInt(3, Integer.parseInt(answer.getQuestionID()));// ?3
            preparedStatement.setInt(4, Integer.parseInt(answer.getUserID()));// ?3
            // SQL 文の実行
            preparedStatement.executeUpdate();
            return;

        } catch (SQLException e) {
            // 例外発生時の処理
            //ログを残す
            e.printStackTrace();
            return;

        } finally {
            // クローズ処理
            //ファイルを閉じる
            close(connection, preparedStatement, resultSet);
        }

    }

    public static ArrayList<Questionnaire> selectMyQuestionnairesByUserID(String userID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from questionnaires where user_id = ?";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);

            // SQL 文を実行し、結果を保存する
            resultSet = preparedStatement.executeQuery();

            ArrayList<Questionnaire> questionnaires = new ArrayList<>();
            while (resultSet.next()) {
                Questionnaire questionnaire = new Questionnaire(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("user_id"),
                        null
                );
                questionnaires.add(questionnaire);
            }
            return questionnaires;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Question> selectQuestionsByQuestionnaireID(String questionnaireID){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from questions where questionnaire_id = ?";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, questionnaireID);

            resultSet = preparedStatement.executeQuery();

            ArrayList<Question> questions = new ArrayList<>();
            while (resultSet.next()) {
                Question question = new Question(
                        resultSet.getString("id"),
                        resultSet.getInt("number"),
                        resultSet.getString("content"),
                        resultSet.getString("questionnaire_id"),
                        null
                );
                questions.add(question);
            }
            return questions;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Questionnaire> selectQuestionnairesByName(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from questionnaires where name = ?";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();
            ArrayList<Questionnaire> questionnaires = new ArrayList();
                while(resultSet.next()){
                    Questionnaire questionnaire = new Questionnaire(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        String.valueOf(resultSet.getInt("user_id")),
                            null);
                    questionnaires.add(questionnaire);
                }

            return questionnaires;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Questionnaire> selectQuestionnaires(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from questionnaires";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            ArrayList<Questionnaire> questionnaires = new ArrayList();
            while(resultSet.next()){
                Questionnaire questionnaire = new Questionnaire(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        String.valueOf(resultSet.getInt("user_id")),
                        null);
                questionnaires.add(questionnaire);
            }

            return questionnaires;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Questionnaire> selectQuestionnairesByUserName(String UserName){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT questionnaires.id AS questionnaire_id,\n" +
                    "  questionnaires.name AS questionnaire_name,\n" +
                    "  questionnaires.user_id AS user_id,\n" +
                    "  users.name AS user_name\n" +
                    "  FROM questionnaires \n" +
                    "  INNER JOIN users \n" +
                    "  ON questionnaires.user_id = users.id\n" +
                    "  WHERE users.name = ?";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,UserName);


            System.out.println("sql"+preparedStatement.toString());

            resultSet = preparedStatement.executeQuery();
            ArrayList<Questionnaire> questionnaires = new ArrayList();
            while(resultSet.next()){
                Questionnaire questionnaire = new Questionnaire(
                        resultSet.getString("questionnaire_id"),
                        resultSet.getString("questionnaire_name"),
                        String.valueOf(resultSet.getInt("user_id")),
                        null);
                questionnaires.add(questionnaire);
            }

            return questionnaires;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Questionnaire> selectQuestionnairesByNameAndUserName(String name,String UserName){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT \n" +
                    "  questionnaires.id AS questionnaire_id,\n" +
                    "  questionnaires.name AS questionnaire_name,\n" +
                    "  questionnaires.user_id AS user_id,\n" +
                    "  users.name AS user_name\n" +
                    "  FROM questionnaires \n" +
                    "  INNER JOIN users \n" +
                    "  ON questionnaires.user_id = users.id\n" +
                    "  WHERE users.name = ? AND questionnaires.name = ?";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,UserName);
            preparedStatement.setString(2,name);

            resultSet = preparedStatement.executeQuery();
            ArrayList<Questionnaire> questionnaires = new ArrayList();
            while(resultSet.next()){
                Questionnaire questionnaire = new Questionnaire(
                        resultSet.getString("questionnaire_id"),
                        resultSet.getString("questionnaire_name"),
                        String.valueOf(resultSet.getInt("user_id")),
                        null);
                questionnaires.add(questionnaire);
            }

            return questionnaires;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Answer> selectAnswersByQuestionID(String QuestionID){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from answers where question_id = ?";

            connection = createConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,QuestionID);

            resultSet = preparedStatement.executeQuery();
            ArrayList<Answer> answers = new ArrayList();
            while(resultSet.next()){
                Answer answer= new Answer(
                        resultSet.getString("id"),
                        resultSet.getInt("evaluation"),
                        resultSet.getString("free_text"),
                        QuestionID,
                        null);
                answers.add(answer);
            }

            return answers;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }
}

