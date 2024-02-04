package org.example.command.show;

import org.example.command.Command;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.example.Resources.PAGE_CHAT;

public class ShowChatPageCommand implements Command {
    List<Message> messages = new ArrayList<>();

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String message = request.getParameter("message");
        if (message != null && !message.isEmpty()) {
            User user = (User) request.getSession().getAttribute("user");
            if (user.isPermissionToSendMessage()) {
                messages.add(new Message(user, message));
            }
        }
        request.setAttribute("messages", messages);
        return new ForwardResult(PAGE_CHAT);
    }
}
