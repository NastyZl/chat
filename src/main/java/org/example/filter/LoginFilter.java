package org.example.filter;

import org.example.data.MemoryUserRepo;
import org.example.data.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.example.Resources.PAGE_LOGIN;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User userSession = (User) session.getAttribute("user");
        String login = req.getParameter("loginInput");

        @SuppressWarnings("unchecked") final AtomicReference<MemoryUserRepo> memoryUserRepo = (AtomicReference<MemoryUserRepo>)
                request.getServletContext().getAttribute("memoryUserRepo");
        Optional<User> user = memoryUserRepo.get().findByLogin(login);

        if (userSession == null && user.isEmpty()) {
            req.getRequestDispatcher(PAGE_LOGIN).forward(request, response);

        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
