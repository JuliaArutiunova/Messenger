package by.it_academy.jd2.controller.listener;

import by.it_academy.jd2.service.api.ISessionService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class SessionCounterListener implements HttpSessionAttributeListener {
    private final ISessionService sessionService = ServiceFactory.sessionService;


    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

        if (se.getName().equals("user")) {
            sessionService.addSession();
            System.out.println("user added");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if (se.getName().equals("user")) {
            sessionService.removeSession();
            System.out.println("user removed");
        }

    }


}
