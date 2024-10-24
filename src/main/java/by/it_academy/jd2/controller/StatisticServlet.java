package by.it_academy.jd2.controller;

import by.it_academy.jd2.controller.listener.SessionCounterListener;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "StatisticServlet", urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {


    private final IMessageService messageService = ServiceFactory.getMessageService();
    private final IUserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("userCount", userService.getUsersCount());
        req.setAttribute("messagesCount", messageService.getMessageCount());
        req.setAttribute("activeSessionsCount", SessionCounterListener.getSessionCount());

        req.getRequestDispatcher("/ui/admin/statistic").forward(req, resp);


    }
}
