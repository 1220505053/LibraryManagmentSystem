import java.util.ArrayList;
import java.util.List;

class UserManager<T extends User> {
    private List<T> users = new ArrayList<>();

    public void addUser(T user) {
        users.add(user);
    }

    public void removeUser(T user) {
        users.remove(user);
    }

    public List<T> getUsers() {
        return users;
    }

    public T findUser(String name) {
        for (T user : users) {
            if (user.name.equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}