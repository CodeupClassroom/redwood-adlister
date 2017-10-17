import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(
        HttpServletRequest request, //input
        HttpServletResponse response // output
    ) throws IOException {
        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            response.getWriter().print("<h1>Hello, world!</h1>");
        } else {
            response.getWriter().print("<h1>Hello, " + name + "!</h1>");
        }
    }
}
