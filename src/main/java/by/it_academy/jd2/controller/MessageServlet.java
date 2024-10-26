package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.MessageDTO;
import by.it_academy.jd2.dto.ShowMessageDTO;
import by.it_academy.jd2.dto.UserInfoDTO;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private static final String TO_PARAMETER = "to";
    private static final String TEXT_PARAMETER = "text";

    public final IMessageService messageService = ServiceFactory.getMessageService();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy,  HH:mm");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserInfoDTO user = (UserInfoDTO) session.getAttribute("user");

        List<ShowMessageDTO> incomingMessages = messageService.getIncomingMessages(user.getLogin());
        req.setAttribute("userName", user.getName());

        req.setAttribute("formatter", formatter);
        req.setAttribute("messages", incomingMessages);

        req.getRequestDispatcher("/ui/message").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserInfoDTO user = (UserInfoDTO) session.getAttribute("user");

        String to = req.getParameter(TO_PARAMETER);

        try {
            messageService.create(MessageDTO.builder()
                    .from(user.getLogin())
                    .to(to)
                    .text(req.getParameter(TEXT_PARAMETER))
                    .time(LocalDateTime.now())
                    .build());
            req.setAttribute("report", "Сообщение для " + to + " успешно отправлено");
            doGet(req, resp);
        } catch (IllegalArgumentException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
        }
    }
}
