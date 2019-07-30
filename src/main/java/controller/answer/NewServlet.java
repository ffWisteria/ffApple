package controller.answer;

import model.questionnaire.Answer;
import model.questionnaire.Question;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/answers/new")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String[] freeTexts = request.getParameterValues("free_text");
        String questionnaireID = request.getParameter("id");

        // questions の取得
        ArrayList<Question> questions = Question.selectQuestionsByQuestionnaireID(questionnaireID);

        for (int i = 0; i < questions.size(); i++){
            String evaluation = request.getParameter("evaluation_" + (i + 1));
            Answer answer = new Answer(
                    null,
                    Integer.parseInt(evaluation),
                    freeTexts[i],
                    questions.get(i).getId(),
                    User.getCurrentUser(request).getId()
            );
            answer.createAnswer();
        }

        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionnaireID = request.getParameter("id");

        ArrayList<Question> questions = Question.selectQuestionsByQuestionnaireID(questionnaireID);

        request.setAttribute("questionnaireID", questionnaireID);
        request.setAttribute("questions", questions);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/answer/new.jsp");
        dispatcher.forward(request, response);
    }
}
