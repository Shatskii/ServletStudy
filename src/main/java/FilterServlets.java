import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter(value = {"/add", "/delete", "/update", "/get"})
public class FilterServlets implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ServletContext context = request.getServletContext();
        Object o = context.getAttribute("users");
        if (o == null) {
            throw new IllegalArgumentException("Invalid object type userMap!");
        } else {
            System.out.println("Filter!");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
