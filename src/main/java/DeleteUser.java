import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeleteUser extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ServletContext context = req.getServletContext();
        int id = Integer.parseInt(req.getParameter("id"));
        Map<Integer, User> users = (ConcurrentHashMap<Integer, User>) context.getAttribute("users");
        users.remove(id);
        context.setAttribute("users", users);
        resp.sendRedirect("/get");
    }
}
