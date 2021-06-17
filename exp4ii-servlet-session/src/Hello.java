import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// Getting the value from the hidden field
			String n = request.getParameter("hiddenfield");
			out.print("Hello " + n);

			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
