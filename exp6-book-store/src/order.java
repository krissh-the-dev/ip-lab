import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class order extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int count;
            PrintWriter pw = resp.getWriter();
            pw.println(
                    "<html><head><style>body {background-color: aquamarine;}input {padding: 5px;border-radius: 5%;}</style><body>");
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            String title = req.getParameter("title");
            String count1 = req.getParameter("no");
            // String date = req.getParameter("date");
            String cno = req.getParameter("cno");
            count = Integer.parseInt(count1);
            String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
            String mysqlUserName = "root";
            String mysqlPassword = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);
            Statement stmt = con.createStatement();
            String sqlstmt = "select id,pwd from login";
            ResultSet rs = stmt.executeQuery(sqlstmt);
            int flag = 0, amount, x;
            while (rs.next()) {
                if (id.equals(rs.getString(1)) && pwd.equals(rs.getString(2))) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                pw.println("<br><br>SORRY INVALID ID TRY AGAIN ID<br><br>");
                pw.println("<a href= \" order.html \" >press HERE to RETRY</a>");
            } else {
                Statement stmt2 = con.createStatement();
                String s = "select Price from Book_Info where title=\'" + title + "\'";
                ResultSet rs1 = stmt2.executeQuery(s);
                int flag1 = 0;
                while (rs1.next()) {
                    flag1 = 1;
                    x = Integer.parseInt(rs1.getString(1));
                    amount = count * x;
                    pw.println("<br><br>AMOUNT :" + amount + "<br><br><br><br>");
                    Statement stmt1 = con.createStatement();
                    stmt1.executeUpdate(
                            "insert into details values('" + id + "','" + title + "'," + amount + ",'" + cno + "');");
                    pw.println("<br>YOUR ORDER has taken<br>");
                }
                if (flag1 == 0) {
                    pw.println("<br><br><br>SORRY INVALID ID TRY AGAIN ID<br><br>");
                    pw.println("<a href=\"order.html\">press HERE to RETRY</a>");
                }
            }
            pw.println("</body></html>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
