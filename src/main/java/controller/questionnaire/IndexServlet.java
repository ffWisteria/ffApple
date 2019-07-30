package controller.questionnaire;

import model.questionnaire.Questionnaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/questionnaires")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String userName = request.getParameter("user_name");

        ArrayList<Questionnaire> questionnaires = new ArrayList<>();

        if(title.equals("")  && userName.equals("")) {
            questionnaires = null;
        } else if (!title.equals("") && userName.equals("")) {
            questionnaires = Questionnaire.selectQuestionnairesByName(title);
        } else if (title.equals("") && !userName.equals("")) {
            questionnaires = Questionnaire.selectQuestionnairesByUserName(userName);
        } else {
            questionnaires = Questionnaire.selectQuestionnairesByNameAndUserName(title, userName);
            System.out.println(title);
            System.out.println(userName);
        }

        // リクエストスコープに保存
        request.setAttribute("questionnaires",questionnaires);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/questionnaire/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Questionnaire> questionnaires = Questionnaire.selectQuestionnaire();

        //リクエストスコープに保存
        request.setAttribute("questionnaires",questionnaires);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/questionnaire/index.jsp");
        dispatcher.forward(request, response);
    }
}
