package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryUserRepo {
    private final List<User> users = new ArrayList<>();

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
