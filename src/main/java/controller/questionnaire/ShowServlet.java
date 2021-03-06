package controller.questionnaire;

import model.questionnaire.Question;
import model.questionnaire.Questionnaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/questionnaires/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionnaireID = request.getParameter("id");

        ArrayList<Question> questions = Question.selectQuestionsByQuestionnaireID(questionnaireID);

        request.setAttribute("questionnaireID", questionnaireID);
        request.setAttribute("questions", questions);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/questionnaire/show.jsp");
        dispatcher.forward(request, response);
    }
}
