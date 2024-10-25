package by.it_academy.jd2.controller;


import by.it_academy.jd2.dto.UserDTO;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogInServlet", urlPatterns = "/api/login")
public class LogInServlet extends HttpServlet {

    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "psw";
    private final IUserService userService = ServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);

        try {
            UserDTO user = userService.getUserInfo(login, password);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/api/message");

        } catch (IllegalArgumentException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            req.setAttribute("error", e.getMessage());
            req.setAttribute("userLogin",login);

            req.getRequestDispatcher("/ui/login").forward(req,resp);


        }


    }
}
