package org.example.command.show;

import org.example.command.Command;
import org.example.data.MemoryUserRepo;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Resources.PAGE_ADMIN;

public class ShowAdminPageCommand implements Command {
    private final MemoryUserRepo memoryUserRepo = new MemoryUserRepo();

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> usersAll = memoryUserRepo.findAllUsers();
        List<User> usersClient = usersAll.stream()
                .filter(user -> user.getUserType().equals(UserType.CLIENT))
                .collect(Collectors.toList());
        request.setAttribute("users", usersClient);
        return new ForwardResult(PAGE_ADMIN);
    }
}
