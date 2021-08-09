<!DOCTYPE HTML
	PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*" %>
	<%@ page import="java.io.*" %>

		<html>

		<head>
			<title>Exam result</title>
			<style>
				table,
				th,
				td {
					border: 1px solid black;
					border-collapse: collapse;
				}
			</style>
		</head>
		
		<body bgColor="wheat">
		<h2>Result </h2>
		<%@ include file="header.html" %>
	
		<% String seatNo, name;
			String[] answers = new String[5];
			int score = 0;

			Connection connection;
			String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
			String mysqlUserName = "root";
			String mysqlPassword = "";

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);

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

			PrintWriter out2 = response.getWriter();

			out2.println("<div style=\"height: 100vh; display: flex; align-items: center; justify-content: center;\"><table border=5>");

			statement = connection.createStatement();
			String query = "SELECT * FROM Exam";
			ResultSet resultSet = statement.executeQuery(query);

			// send the response to the client
			out2.println("<th>Seat Number</th>");
			out2.println("<th>Name</th>");
			out2.println("<th>Score</th>");
			while (resultSet.next()) {
				out2.println("<tr>");
				out2.println("<td>" + resultSet.getInt(1) + "</td>");
				out2.println("<td>" + resultSet.getString(2) + "</td>");
				out2.println("<td>" + resultSet.getInt(3) + "</td>");
				out2.println("</tr>");
			}
			out2.println("</div></table>");
			out2.println("</body></html>");

			// cleanup
			out2.close();
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
	%>
