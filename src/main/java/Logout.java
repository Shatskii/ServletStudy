import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req, resp);
        Cookie cookie = new Cookie("name", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        writer.println("You successfully logout!");
        writer.close();
    }
}
