package by.it_academy.jd2.controller.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;
@WebListener
public class SessionCounterListener implements HttpSessionAttributeListener {

    private static int sessionCount = 0;

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if(se.getName().equals("user")){
            sessionCount++;
            System.out.println("user added");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if(se.getName().equals("user")){
            sessionCount--;
            System.out.println("user removed");
        }

    }

    public static int getSessionCount() {
        return sessionCount;
    }
}
