import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Map<Integer, User> users = (ConcurrentHashMap<Integer, User>) getServletContext().getAttribute("users");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        AtomicInteger id = new AtomicInteger(users.size());
        User user = new User(name, age, id.incrementAndGet());
        users.put(user.getId(), user);
        resp.sendRedirect("/get");

    }
}
