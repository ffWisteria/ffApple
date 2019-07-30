package controller.questionnaire;

import model.questionnaire.Question;
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

@WebServlet("/questionnaires/new")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String[] contents = request.getParameterValues("content");
        int flag = 0;

        for(int j=0; j < contents.length; j++){
            if(contents[j].length()> 45){
                flag = 1;
            }
        }
        if (name.length() > 45 ) {
            flag = 1;
        }
        if(flag == 1){
            response.sendRedirect("/error");
        } else {

            ArrayList<Question> questions = new ArrayList<>();
            for (int i = 0; i < contents.length; i++) {
                Question question = new Question(
                        null,
                        i + 1,
                        contents[i],
                        null,
                        null
                );
                //questionsというリストにデータを追加する
                questions.add(question);
            }

            Questionnaire questionnaire = new Questionnaire(
                    null,
                    name,
                    User.getCurrentUser(request).getId(),
                    questions
            );

            questionnaire.createQuestionnaire();

            response.sendRedirect("/home");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String number = request.getParameter("number");
        request.setAttribute("number", number);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/questionnaire/new.jsp");
        dispatcher.forward(request, response);
    }
}
