import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        HttpSession session;
        if (isValidate(name, password)) {
            session = req.getSession();
            session.setAttribute("name", name);
            writer.println("Welcome to page " + name);
        } else {
            writer.println("Error! Try again");
            req.getRequestDispatcher("login.html").include(req, resp);
        }
        writer.close();
    }

    private boolean isValidate(String name, String password) {
        if (name != null && password != null && name.equals("admin") && password.equals("123")) {
            return true;
        } else {
            return false;
        }
    }
}
