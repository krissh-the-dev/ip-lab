import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetName extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			out.print("Welcome " + n);

			// creating form that have invisible textfield
			out.print("<form action='./hello'>");
			out.print("<input type='hidden' name='hiddenfield' value='" + n + "'>");
			out.print("<input type='submit' value='Submit'>");
			out.print("</form>");
			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
