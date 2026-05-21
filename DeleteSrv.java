

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/DeleteSrv")
public class DeleteSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gim", "root", "sdkd");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM student");
			if(request.getParameter("submit")!=null) {
				int u=Integer.valueOf(request.getParameter("submit"));
				PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE id=?");
				ps.setInt(1, u);
				ps.executeUpdate();
				rs=stmt.executeQuery("SELECT * FROM student");
			}
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			if(rs.next()) {
				out.println("<form action='' method='post'>");
				out.println("<h1>Student Details:</h1>");
				out.println("<table border=2>");
				out.println("<tr>");
				out.println("<th>id</th>");
				out.println("<th>name</th>");
				out.println("<th>email</th>");
				out.println("<th>course</th>");
				out.println("<th>marks</th>");
				out.println("<th>Click</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("<td><button type='submit' value="+rs.getInt(1)+" name='submit'>Delete</button></td>");
				out.println("</tr>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getInt(5)+"</td>");
					out.println("<td><button type='submit' value="+rs.getInt(1)+" name='submit'>Delete</button></td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</form>");
			}
				else{
				out.println("<h1>No data!</h1>");
			}
			out.println("<h3>Goto Dashboard --><a href='Dashboard.jsp'>Click</a></h3>");
	}
		catch(Exception e) {}
	}

}
