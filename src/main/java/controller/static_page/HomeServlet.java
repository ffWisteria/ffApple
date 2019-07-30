package controller.static_page;

import model.questionnaire.Questionnaire;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = User.getCurrentUser(request).getId();
        ArrayList<Questionnaire> myQuestionnaires = Questionnaire.selectMyQuestionnairesByUserID(userID);

        // リクエストスコープに保存
        request.setAttribute("myQuestionnaires", myQuestionnaires);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static_page/home.jsp");
        dispatcher.forward(request, response);
    }
}
