import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(
        HttpServletRequest request, //input
        HttpServletResponse response // output
    ) throws IOException {
        String name = request.getParameter("name");

        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>");
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"");
        writer.print("</head>");
        writer.print("<body>");

        if (name == null || name.trim().isEmpty()) {
            writer.print("<h1>Hello, world!</h1>");
        } else {
            writer.print("<h1>Hello, " + name + "!</h1>");
        }

        writer.print("<script\n" +
            "  src=\"https://code.jquery.com/jquery-3.2.1.min.js\"\n" +
            "  integrity=\"sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=\"\n" +
            "  crossorigin=\"anonymous\"></script>");
        writer.print("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
