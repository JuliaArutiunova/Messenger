package by.it_academy.jd2.storage.api;

public interface ISessionsStorage {
    long getSessionsCount();

    void addSession();

    void removeSession();
}
