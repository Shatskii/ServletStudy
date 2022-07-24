import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        if (session == null) {
            session = req.getSession();
            session.setAttribute("count", new AtomicInteger(1));
            writer.println("Your count to visit page : " + 1);
        } else {
            AtomicInteger count = (AtomicInteger) session.getAttribute("count");
            count.incrementAndGet();
            session.setAttribute("count", count);
            writer.println("Your count to visit page : " + count);
        }
        writer.close();
    }
}
