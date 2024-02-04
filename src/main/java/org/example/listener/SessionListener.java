package org.example.listener;

import org.example.data.MemoryUserRepo;
import org.example.data.User;
import org.example.data.UserType;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class SessionListener implements HttpSessionListener {
    private AtomicReference<MemoryUserRepo> memoryUserRepo;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        memoryUserRepo = new AtomicReference<>(new MemoryUserRepo());

        memoryUserRepo.get().addUser(new User("admin", "1", "Олег", UserType.ADMIN));
        memoryUserRepo.get().addUser(new User("client1", "1", "Настя", UserType.CLIENT));
        memoryUserRepo.get().addUser(new User("client2", "1", "Liza", UserType.CLIENT));

        ServletContext servletContext = event.getSession().getServletContext();
        servletContext.setAttribute("memoryUserRepo", memoryUserRepo);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        User sessionUser = (User) event.getSession().getAttribute("user");
        System.out.println(sessionUser);
        if (sessionUser != null) {
            sessionUser.setOnline(false);
            System.out.println("Были очищены данные сессии для клиента - " + sessionUser.getName());
        }
    }
}
