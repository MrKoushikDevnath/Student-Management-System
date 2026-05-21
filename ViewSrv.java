

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/ViewSrv")
public class ViewSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/gim","root","sdkd");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM student");
			response.setContentType("text/html");
			if(rs.next()) {
				out.println("<h1>Student Details:</h1>");
				out.println("<table border=2>");
				out.println("<tr>");
				out.println("<th>id</th>");
				out.println("<th>name</th>");
				out.println("<th>email</th>");
				out.println("<th>course</th>");
				out.println("<th>marks</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("</tr>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getInt(5)+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<h2>Goto ---><a href='Dashboard.jsp'>Dashboard</a></h2>");
			}
			else {
				out.println("No data found!!!");
				out.println("<h2>Goto ---><a href='Dashboard.jsp'>Dashboard</a></h2>");
			}
		}
		catch(Exception e) {}
	}

}
