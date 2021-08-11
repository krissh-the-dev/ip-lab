import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter pw = resp.getWriter();
            pw.println(
                    "<html><head><style>body {background-color: aquamarine;}input {padding: 5px;border-radius: 5%;}</style><body>");
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
            String mysqlUserName = "root";
            String mysqlPassword = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);
            Statement stmt = con.createStatement();
            String sqlstmt = "select id,pwd from login";
            ResultSet rs = stmt.executeQuery(sqlstmt);
            int flag = 0;
            while (rs.next()) {
                if (id.equals(rs.getString(1)) && pwd.equals(rs.getString(2))) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                pw.println("<br><br>SORRY INVALID ID TRY AGAIN ID<br><br>");
                pw.println("<a href=\"login.html\">press LOGIN to RETRY</a>");
            } else {
                pw.println("<br><br>VALID LOGIN ID<br><br>");
                pw.println("<h3><ul>");
                pw.println("<li><a href=\"profile.html\"><fontcolor=\"black\">USER PROFILE</font> </a></li><br><br>");
                pw.println("<li><a href=\"catalog.html\"><fontcolor=\"black\">BOOKS CATALOG</font></a></li><br><br>");
                pw.println(
                        "<li><a href=\"order.html\"><fontcolor=\"black\">ORDER CONFIRMATION</font> </a></li></ul><br><br>");
            }
            pw.println("</body></html>");
        } catch (Exception e) {
        }
    }
}
