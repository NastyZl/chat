package org.example.data;

public class User {

    private final String login;
    private final String password;
    private final String name;
    private final UserType userType;
    private boolean online = false;
    private boolean permissionToSendMessage = true;

    @Override
    public String toString() {
        return "User{"
                + "login='" + login + '\''
                + ", password='" + password + '\''
                + ", name='" + name + '\''
                + ", userType=" + userType
                + ", online=" + online
                + '}';
    }

    public User(String login, String password, String name, UserType userType) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isPermissionToSendMessage() {
        return permissionToSendMessage;
    }

    public void setPermissionToSendMessage(boolean permissionToSendMessage) {
        this.permissionToSendMessage = permissionToSendMessage;
    }
}
