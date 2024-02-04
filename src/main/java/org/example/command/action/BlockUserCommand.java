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
import java.util.concurrent.atomic.AtomicReference;

import static org.example.Resources.COMMAND_SHOW_ADMIN_PAGE;

public class BlockUserCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        @SuppressWarnings("unchecked") final AtomicReference<MemoryUserRepo> memoryUserRepo = (AtomicReference<MemoryUserRepo>)
                request.getServletContext().getAttribute("memoryUserRepo");

        String login = request.getParameter("loginInput");
        String permission = request.getParameter("permission");
        Optional<User> user = memoryUserRepo.get().findByLogin(login);
        if (user.isPresent()) {
            if (permission.equals("true")) {
                user.get().setPermissionToSendMessage(false);
                memoryUserRepo.get().findByLogin(login).get().setPermissionToSendMessage(false);
            } else {
                user.get().setPermissionToSendMessage(true);
                memoryUserRepo.get().findByLogin(login).get().setPermissionToSendMessage(true);
            }
        }
        return new RedirectResult(COMMAND_SHOW_ADMIN_PAGE);
    }
}
