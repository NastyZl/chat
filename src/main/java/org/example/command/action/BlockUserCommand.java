package org.example.command.action;

import org.example.command.Command;
import org.example.data.MemoryUserRepo;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_ADMIN_PAGE;

public class BlockUserCommand implements Command {

    private final MemoryUserRepo memoryUserRepo = new MemoryUserRepo();

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String permission = request.getParameter("permission");
        String login = request.getParameter("loginInput");
        Optional<User> user = memoryUserRepo.findByLogin(login);
        if (user.isPresent()) {
            user.get().setPermissionToSendMessage(!Objects.equals(permission, "on"));
        }
        return new RedirectResult(COMMAND_SHOW_ADMIN_PAGE);
    }
}
