import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class profile extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter pw = resp.getWriter();
            pw.println(
                    "<html><head><style>body {background-color: aquamarine;}input {padding: 5px;border-radius: 5%;}</style><body>");
            String id = req.getParameter("id");
            String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
            String mysqlUserName = "root";
            String mysqlPassword = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);
            Statement stmt = con.createStatement();
            String sqlstmt = "select * from login where id=" + id + "";
            ResultSet rs = stmt.executeQuery(sqlstmt);
            int flag = 0;
            pw.println("<br><br><br>");
            while (rs.next()) {
                pw.println("<div align=\"center\">");
                pw.println("NAME :" + rs.getString(1) + "<br>");
                pw.println("ADDRESS :" + rs.getString(2) + "<br>");
                pw.println("PHONE NO :" + rs.getString(3) + "<br>");
                pw.println("</div>");
                flag = 1;
            }
            if (flag == 0) {
                pw.println("<br><br>SORRY INVALID ID TRY AGAIN ID<br><br>");
                pw.println("<a href=\"profile.html\">press HERE to RETRY</a>");
            }
            pw.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
