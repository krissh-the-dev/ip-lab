import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class catalog extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter pw = resp.getWriter();
            pw.println(
                    "<html><head><style>body {background-color: aquamarine;}input {padding: 5px;border-radius: 5%;}</style><body>");
            String title = req.getParameter("title");
            String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
            String mysqlUserName = "root";
            String mysqlPassword = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);
            Statement stmt = con.createStatement();
            String sqlstmt = "select * from Book_Info where title=\'" + title + "\'";
            ResultSet rs = stmt.executeQuery(sqlstmt);
            int flag = 0;
            while (rs.next()) {
                pw.println("<div align=\"center\">");
                pw.println("ISBN:" + rs.getString(1) + "<br>");
                pw.println("TITLE:" + rs.getString(2) + "<br>");
                pw.println("AUTHOR :" + rs.getString(3) + "<br>");
                pw.println("COUNTRY :" + rs.getString(4) + "<br>");
                pw.println("COVER :" + rs.getString(5) + "<br>");
                pw.println("PRICE:" + rs.getString(6) + "<br>");
                pw.println("</div>");
                flag = 1;
            }
            if (flag == 0) {
                pw.println("<br><br>SORRY INVALID TITLE TRY AGAIN <br><br>");
                pw.println("<a href=\"catalog.html\">press HERE to RETRY</a>");
            }
            pw.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
