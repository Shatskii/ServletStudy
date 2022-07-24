import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF8");
        PrintWriter writer = resp.getWriter();
        Cookie countCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("count")) {
                    countCookie = c;
                    break;
                }
            }
        }
        if (countCookie == null) {
            countCookie = new Cookie("count", "1");
            resp.addCookie(countCookie);
            writer.println("Your count to visit page : " + 1);
        } else {
            int number = Integer.parseInt(countCookie.getValue());
            countCookie.setValue(String.valueOf(++number));
            resp.addCookie(countCookie);
            writer.println("Your count to visit page : " + countCookie.getValue());
        }
        writer.close();
    }
}
