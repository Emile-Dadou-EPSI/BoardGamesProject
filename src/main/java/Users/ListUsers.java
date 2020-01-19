package Users;

import java.util.ArrayList;
import java.util.List;

public class ListUsers {
    private List<User> users = new ArrayList<>();

    public ListUsers() {
        super();
    }

    public ListUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public List<User> GetUsers() {
        return users;
    }

    public void remove(User user) {
        users.remove(user);
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.username.equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getGetUsers() {
        return users;
    }
}
