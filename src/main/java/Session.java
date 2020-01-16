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

}
