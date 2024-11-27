import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private FileHandler fileHandler;

    public UserManager(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.users = new ArrayList<>();
        loadUsers();
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void removeUser(User user) {
        users.remove(user);
        saveUsers();
    }

    public User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    private void loadUsers() {
        List<User> loadedUsers = fileHandler.loadUsers();
        if (loadedUsers != null) {
            users = loadedUsers;
        }
    }

    private void saveUsers() {
        fileHandler.saveUsers(users);
    }
}