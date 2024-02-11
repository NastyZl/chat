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
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class LoginCommand implements Command {
    private final MemoryUserRepo memoryUserRepo = new MemoryUserRepo();

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        Optional<User> user = memoryUserRepo.findByLogin(login);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            memoryUserRepo.findByLogin(login).get().setOnline(true);
            user.get().setOnline(true);
            request.getSession(true).setAttribute("user", user.get());
        } else {
            request.getSession(true).setAttribute("errorLoginMessage", "Неверный логин и/или пароль");
        }
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
