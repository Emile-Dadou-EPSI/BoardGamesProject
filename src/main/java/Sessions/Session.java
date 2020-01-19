package Sessions;

import Users.User;

import java.util.Date;
import java.util.List;

public class Session {
    String name;
    List<User> users;
    Date date;
    String hD;
    String hF;

    public Session() {
        super();
    }

    public Session(String name, Date date, String hD, String hF) {
        this.name = name;
        this.date = date;
        this.hD = hD;
        this.hF = hF;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.date;
    }

    public String gethD() {
        return this.hD;
    }

    public String gethF() {
        return this.hF;
    }

    public String getGetName() {
        return name;
    }
}
