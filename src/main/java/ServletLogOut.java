import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletLogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req, resp);
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            writer.println("You successfully logout!");
        } else {
            writer.println("You didnt login to site! Your session doesnt exist. ");
        }
        writer.close();
    }
}
