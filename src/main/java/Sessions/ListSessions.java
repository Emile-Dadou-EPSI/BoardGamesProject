package Sessions;

import java.util.ArrayList;
import java.util.List;

public class ListSessions {
    private List<Session> sessions = new ArrayList<>();

    public ListSessions() {
        super();
    }

    public ListSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void add(Session session) {
        sessions.add(session);
    }

    public List<Session> getGetSessions() {
        return sessions;
    }

    public void remove(Session session) {
        sessions.remove(session);
    }

    public Session getSessionByName(String name) {
        for (Session session : sessions) {
            if (session.name.equals(name)) {
                return session;
            }
        }
        return null;
    }
}
