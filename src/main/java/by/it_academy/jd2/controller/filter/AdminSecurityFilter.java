package by.it_academy.jd2.controller.filter;

import by.it_academy.jd2.dto.UserInfoDTO;
import by.it_academy.jd2.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(filterName = "AdminSecurityFilter", urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if ((session != null) && (session.getAttribute("user") != null)) {
            UserInfoDTO user = (UserInfoDTO) session.getAttribute("user");
            if (user.getRole().equals(UserRole.ADMIN)) {
                chain.doFilter(request, response);
            } else {
                redirect(req, resp);
            }
        } else {
            redirect(req, resp);
        }

    }

    public void redirect(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        req.setAttribute("message",
                "Для получения доступа к этой странице небходимо войти как администратор");
        req.getRequestDispatcher("/ui/login").forward(req, resp);
    }

}
