package by.it_academy.jd2.controller.filter;

import by.it_academy.jd2.dto.UserDTO;
import by.it_academy.jd2.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static by.it_academy.jd2.controller.StatisticServlet.STATISTIC_JSP;

public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();

        if ((session != null) && (session.getAttribute("user") != null)) {
            UserDTO user = (UserDTO) session.getAttribute("user");
            if (user.getRole().equals(UserRole.ADMIN)) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(contextPath + "/api/login");
            }
        }

        }
}
