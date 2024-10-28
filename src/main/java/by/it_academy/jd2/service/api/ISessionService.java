package by.it_academy.jd2.service.api;

public interface ISessionService {

    void addSession();

    void removeSession();

    long getActiveSessionsCount();
}
