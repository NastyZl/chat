package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryUserRepo {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "1", "Олег", UserType.ADMIN));
        users.add(new User("client1", "1", "Настя", UserType.CLIENT));
        users.add(new User("client2", "1", "Liza", UserType.CLIENT));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public Optional<User> findByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

    public boolean addUser(User user) {

        for (User u : users) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return users.add(user);
    }

    public boolean userExist(String login, String password) {
        return users.stream()
                .anyMatch(u -> u.getLogin().equals(login) && u.getPassword().equals(password));
    }
}
