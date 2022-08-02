import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ServletContext context = req.getServletContext();
        Map<Integer, User> users = (ConcurrentHashMap<Integer, User>) context.getAttribute("users");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = users.get(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ServletContext context = req.getServletContext();
        Map<Integer, User> users = (ConcurrentHashMap<Integer, User>) context.getAttribute("users");
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = users.get(id);
        user.setName(name);
        users.put(id, user);
        context.setAttribute("users", users);
        resp.sendRedirect("/get");
    }
}
