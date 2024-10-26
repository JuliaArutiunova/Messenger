package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.RegistrationDTO;
import by.it_academy.jd2.dto.UserInfoDTO;
import by.it_academy.jd2.exception.RegistrationException;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private static final String USER_NAME_PARAMETER = "userName";
    private static final String BIRTHDAY_PARAMETER = "bday";
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "psw";
    private static final String CONFIRM_PASSWORD_PARAMETER = "confirmPsw";

    private final IUserService userService = ServiceFactory.getUserService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter(USER_NAME_PARAMETER);
        String birthDate = req.getParameter(BIRTHDAY_PARAMETER);
        String login = req.getParameter(LOGIN_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        String confirmPsw = req.getParameter(CONFIRM_PASSWORD_PARAMETER);


        try {
            userService.create(RegistrationDTO.builder()
                    .login(login)
                    .password(password)
                    .confirmPsw(confirmPsw)
                    .userName(userName)
                    .birthDate(LocalDate.parse(birthDate))
                    .build());

            UserInfoDTO user = userService.getUserInfo(login, password);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/api/message");

        } catch (RegistrationException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            req.setAttribute("errors", e.getErrors());
            req.getRequestDispatcher("/ui/signUp").forward(req, resp);
        }

    }


}
