import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.*;

public class RequestParameters extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 6817436016831853256L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String firstName = config.getInitParameter("firstName");
		String lastName = config.getInitParameter("lastName");

		out.println("<h1>Hi, " + firstName + " " + lastName + ".</h1>");
		out.close();
	}
}
