import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class MyListener implements ServletContextListener {
    private Map<Integer, User> users;

    @Override

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        users = new ConcurrentHashMap<>();
        context.setAttribute("users", users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        users = null;
    }
}
