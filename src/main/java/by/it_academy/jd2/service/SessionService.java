package by.it_academy.jd2.service;

import by.it_academy.jd2.service.api.ISessionService;
import by.it_academy.jd2.storage.api.ISessionsStorage;

public class SessionService implements ISessionService {

    private final ISessionsStorage sessionsStorage;

    public SessionService(ISessionsStorage sessionsStorage) {
        this.sessionsStorage = sessionsStorage;
    }

    @Override
    public void addSession() {
        sessionsStorage.addSession();
    }

    @Override
    public void removeSession() {
        sessionsStorage.removeSession();
    }
    @Override
    public long getActiveSessionsCount(){
       return sessionsStorage.getSessionsCount();
    }
}
