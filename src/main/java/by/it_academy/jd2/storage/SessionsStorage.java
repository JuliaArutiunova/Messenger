package by.it_academy.jd2.storage;

import by.it_academy.jd2.storage.api.ISessionsStorage;

public class SessionsStorage implements ISessionsStorage {

    private long usersCount = 0;


    public void addSession(){
        usersCount++;
    }

    public void removeSession(){
        usersCount--;
    }

    public long getSessionsCount() {
        return usersCount;
    }
}
