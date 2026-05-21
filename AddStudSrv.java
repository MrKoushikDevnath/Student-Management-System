

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

@WebServlet("/AddStudSrv")
public class AddStudSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("course");
		String marks=request.getParameter("marks");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/gim","root","sdkd");
			PreparedStatement ps=con.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, course);
			ps.setString(5, marks);
			int i=ps.executeUpdate();
			if(i>0) {
				out.println("<h1>Successfully Add student...</h1>"
						+"<h2>Click here to add again--> <a href='AddStud.jsp'>Add Student</a></h2>"
						+ "<h2>Goto--> <a href='Dashboard.jsp'>Dashboard</a></h2>");
			}
			else {
				out.println("Failed");
			}
			
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
