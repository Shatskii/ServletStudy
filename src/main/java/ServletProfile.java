import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req, resp);
        HttpSession session = req.getSession(false);
        if (session == null) {
            writer.println("Login first!");
            req.getRequestDispatcher("login.html").include(req, resp);
        } else {
            String name = (String) session.getAttribute("name");
            writer.println("Hello, mister " + name);
        }
        writer.close();

    }
}
