package Users;

public class User {
    public String email;
    public String username;
    public String password;
    public String type;

    public User() {
        super();
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.password = username;
        this.password = password;
    }

    public User(String email, String username, String password, String type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public String getEmail() { return this.email; }
}
