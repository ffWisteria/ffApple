package controller.session;

//ログインページに飛ぶ

import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sessions/new")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(
                null,
                null,
                email,
                password
        );

        if (user.authenticateUser(request)) {
            response.sendRedirect("/home");
        } else {
            //フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/session/new.jsp");
            dispatcher.forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/session/new.jsp");
        dispatcher.forward(request, response);
    }
}
