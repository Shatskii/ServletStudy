import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (isValidate(name, password)) {
            writer.println("Hello " + name);
            Cookie cookie = new Cookie("name", name);
            resp.addCookie(cookie);
        } else {
            writer.println("Error, try again!");
            req.getRequestDispatcher("login.html").include(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private boolean isValidate(String name, String password) {
        if (name != null && password != null && name.equals("admin") && password.equals("123")) {
            return true;
        } else {
            return false;
        }
    }
}
