package controller.answer;

import model.questionnaire.Answer;
import model.questionnaire.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/answers")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionnaireID = request.getParameter("id");

        ArrayList<Question> questions = Question.selectQuestionsByQuestionnaireID(questionnaireID);
        ArrayList<Answer> answers = new ArrayList();
        for(int i = 0; i < questions.size(); i++){
            String questionID = questions.get(i).getId();
            answers = Answer.selectAnsｗersByQuestionID(questionID);
            System.out.println(answers);
        }

        request.setAttribute("questions",questions);
        request.setAttribute("answers",answers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/answer/index.jsp");
        dispatcher.forward(request, response);
    }
}
