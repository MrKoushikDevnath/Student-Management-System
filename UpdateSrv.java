

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

@WebServlet("/UpdateSrv")
public class UpdateSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gim", "root", "sdkd");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM student");
			if(request.getParameter("update")!=null) {
				int d=Integer.valueOf(request.getParameter("d"));
				String n=request.getParameter("n");
				String e=request.getParameter("e");
				String c=request.getParameter("c");
				int m=Integer.valueOf(request.getParameter("m"));
				int u=Integer.valueOf(request.getParameter("update"));
				PreparedStatement ps=con.prepareStatement("UPDATE student SET id=?, name=?, email=?, course=?, marks=? WHERE id=?");
				ps.setInt(1,d);
				ps.setString(2, n);
				ps.setString(3, e);
				ps.setString(4, c);
				ps.setInt(5,m);
				ps.setInt(6, u);
				ps.executeUpdate();
				rs=stmt.executeQuery("SELECT * FROM student");
			}
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			if(rs.next() && request.getParameter("submit")==null) {
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
				out.println("<td><button type='submit' value="+rs.getInt(1)+" name='submit'>Update</button></td>");
				
				out.println("</tr>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getInt(5)+"</td>");
					out.println("<td><button type='submit' value="+rs.getInt(1)+" name='submit'>Update</button></td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</form>");
			}
			else if(request.getParameter("submit")!=null){
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
				int d=Integer.valueOf(request.getParameter("submit"));
				int d1=rs.getInt(1);
				if(d==d1) {
				out.println("<tr>");
				out.println("<td><input type='text' value="+rs.getInt(1)+" name='d'></td>");
				out.println("<td><input type='text' value="+rs.getString(2)+" name='n'></td>");
				out.println("<td><input type='text' value="+rs.getString(3)+" name='e'></td>");
				out.println("<td><input type='text' value="+rs.getString(4)+" name='c'></td>");
				out.println("<td><input type='text' value="+rs.getInt(5)+" name='m'></td>");
				out.println("<td><button type='submit' value="+rs.getInt(1)+" name='update'>Submit</button></td>");
				
				out.println("</tr>");
				}
				else {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getInt(5)+"</td>");
					out.println("<td><button type='submit' value="+rs.getInt(1)+" name='submit' disabled>Update</button></td>");
					
				}
				while(rs.next()) {
					d=Integer.valueOf(request.getParameter("submit"));
					d1=rs.getInt(1);
					if(d==d1) {
						out.println("<tr>");
						out.println("<td><input type='text' value="+rs.getInt(1)+" name='d'></td>");
						out.println("<td><input type='text' value="+rs.getString(2)+" name='n'></td>");
						out.println("<td><input type='text' value="+rs.getString(3)+" name='e'></td>");
						out.println("<td><input type='text' value="+rs.getString(4)+" name='c'></td>");
						out.println("<td><input type='text' value="+rs.getInt(5)+" name='m'></td>");
						out.println("<td><button type='submit' value="+rs.getInt(1)+" name='update'>Submit</button></td>");
						
						out.println("</tr>");
						}
					else {
						out.println("<tr>");
						out.println("<td>"+rs.getInt(1)+"</td>");
						out.println("<td>"+rs.getString(2)+"</td>");
						out.println("<td>"+rs.getString(3)+"</td>");
						out.println("<td>"+rs.getString(4)+"</td>");
						out.println("<td>"+rs.getInt(5)+"</td>");
						out.println("<td><button type='submit' value="+rs.getInt(1)+" name='submit' disabled>Update</button></td>");
						
					}
				}
				out.println("</table>");
				out.println("</form>");
			}
			else {
				out.println("<h1>No data!</h1>");
			}
			out.println("<h3>Goto Dashboard --><a href='Dashboard.jsp'>Click</a></h3>");
	}
		catch(Exception e) {}
	}

}
