package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.StatisticDTO;
import by.it_academy.jd2.service.api.IStatisticService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StatisticServlet", urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {

    private final IStatisticService statisticService = ServiceFactory.getStatisticService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatisticDTO statisticDTO = statisticService.getStatistic();

        req.setAttribute("userCount", statisticDTO.getUsersCount());
        req.setAttribute("messagesCount", statisticDTO.getMessagesCount());
        req.setAttribute("activeSessionsCount", statisticDTO.getActiveSessionsCount());

        req.getRequestDispatcher("/ui/admin/statistic").forward(req, resp);


    }
}
