import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req, resp);
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("name") && c.getValue().equals("admin")) {
                    cookie = c;
                    break;
                }
            }
        }
        if (cookie == null) {
            writer.println("Error, try again <a href='/login'>login</a>");
        } else {
            writer.println("Hello from profile " + cookie.getValue());
        }
        writer.close();
    }
}
