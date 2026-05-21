

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

@WebServlet("/RegisterSrv")
public class RegisterSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/gim","root","sdkd");
			PreparedStatement ps=con.prepareStatement("INSERT INTO user1 VALUES(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, username);
			ps.setString(4, password);
			int i =ps.executeUpdate();
			if(i>0) {
				out.println("<h1>Registered Successfully!</h1>"
						+ "<h2>Click here---><a href='Login.jsp'>Login<a> </h2>");
			}
			else {
				out.println("<h1>Registered Failed</h1>");
			}
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
