package controller.user;

//ユーザ登録

import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/new")
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int flag = 0;

        if(name.length() > 64){flag = 1;}
        if(email.length() > 128){flag = 1;}
        if(password.length() > 64){flag = 1;}
         User oldUser = User.selectUserByEmail(email);
         if(oldUser != null){flag = 1;}

        if(flag == 1){
            System.out.println(flag);
            response.sendRedirect("/newError");
        } else {
            //userインスタンスの作成
            System.out.println("きてはだめ");
            User user = new User(
                    null,
                    name,
                    email,
                    password
            );

            user.createUser();

            request.setAttribute("user", user);

            response.sendRedirect("/sessions/new");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/new.jsp");
        dispatcher.forward(request, response);
    }
}
