import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.DriverManager;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OnlineExam extends HttpServlet {
	String seatNo, name;
	String[] answers = new String[5];
	int score = 0;

	Connection connection;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
			String mysqlUserName = "root";
			String mysqlPassword = "";

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		seatNo = request.getParameter("seat");
		name = request.getParameter("name");

		for (int i = 0; i < 5; i++) {
			answers[i] = request.getParameter("answer" + (i + 1));
			score += (answers[i].equals("True") ? 20 : 0);
		}

		response.setContentType("text/html");

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT into Exam (SeatNo, Name, Score) VALUES ( " + seatNo + ", '" + name + "', " + score + " );");
			statement.close();

			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<body><main style=\"max-width:800px; margin: 40px auto;\"");
			out.println("<h1> Your response has been Submitted! </h1>\n");
			out.println("<br><br>");
			out.println("<em>Mark Sheet</em>");
			out.println("<table border=5>");

			statement = connection.createStatement();
			String query = "SELECT * FROM Exam";
			ResultSet resultSet = statement.executeQuery(query);

			// send the response to the client
			out.println("<th>Seat Number</th>");
			out.println("<th>Name</th>");
			out.println("<th>Score</th>");
			while (resultSet.next()) {
				out.println("<tr>");
				out.println("<td>" + resultSet.getInt(1) + "</td>");
				out.println("<td>" + resultSet.getString(2) + "</td>");
				out.println("<td>" + resultSet.getInt(3) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<h1 style=\"text-align: center;\">Thanks!</h1>\n");
			out.println("</main></body></html>");

			// cleanup
			out.close();
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
