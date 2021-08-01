import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet()
public class FeedbackRouteHandler extends HttpServlet {
	GetFeedback getFeedback = new GetFeedback();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/xml");
			PrintWriter writer = response.getWriter();
			writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			writer.println("<feedback>");
			writer.println("<message>");
			writer.println("<![CDATA[");
			writer.println("<p>" + getFeedback.getAllFeedbacks() + "</p>");
			writer.println("]]>");
			writer.println("</message>");
			writer.println("</feedback>");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
