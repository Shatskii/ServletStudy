import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, User> users = (ConcurrentHashMap<Integer, User>) req.getServletContext().getAttribute("users");
        req.setAttribute("users", users.values());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
