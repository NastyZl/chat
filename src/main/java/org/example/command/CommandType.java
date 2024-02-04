package org.example.command;

import org.example.command.action.BlockUserCommand;
import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.show.ShowAdminPageCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    BLOCK(new BlockUserCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SHOW_ADMIN_PAGE(new ShowAdminPageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
