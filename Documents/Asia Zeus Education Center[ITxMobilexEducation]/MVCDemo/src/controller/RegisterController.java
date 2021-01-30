package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserEntity;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/register.jsp");
	    dispatcher.forward(request, response);
	  }

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		response.setContentType("text/html");
		//request.getRequestDispatcher("register.jsp").include(request, response);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/register.jsp");
		dispatcher.include(request, response);
		PrintWriter out = response.getWriter();

		UserEntity user = new UserEntity(name, email, password, phone, gender);
		boolean saveResult = this.save(user);
		if (saveResult) {
			out.println("Registration process is complete successfully!!!");
		} else {
			out.println("Registration process fail,try again.");
		}
		out.close();
	}

	

	public Connection getDbConnection() {
		Connection con = null;	
		ServletContext ctx = getServletContext();	
		String dbuser = ctx.getInitParameter("dbuser");
		String dbpassword = ctx.getInitParameter("dbpassword");
		String url = ctx.getInitParameter("dburl");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("jdbc driver fial to register ");
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url,dbuser,dbpassword);
			if (con != null) {
				return con;
			}
		} catch (Exception e) {
			System.out.println("connetion fail to the database!");
		}
		return con;
	}// end of getDbConnection

	private boolean save(UserEntity entity) {
		Connection con = this.getDbConnection();
		String sql = "insert into users(name,email,password,gender,phone) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getEmail());
			pstmt.setString(3, entity.getPassword());
			pstmt.setString(4, entity.getGender());
			pstmt.setString(5, entity.getPhone());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error occur when saving data to the database");
		}
		return false;
	}

}
