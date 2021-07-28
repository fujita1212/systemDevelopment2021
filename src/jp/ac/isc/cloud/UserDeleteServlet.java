package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
			 try {
			 Connection users = null;
			 try {
			 request.setCharacterEncoding("utf-8");
			 Class.forName("com.mysql.jdbc.Driver");
			 users = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/servlet_db"
			,"root","");
			 String id = request.getParameter("deleteId");
			 Statement state = (Statement) users.createStatement();
			 state.executeUpdate("DELETE FROM user_table WHERE id='" + id + "'");
			 state.close();
			 users.close();
			 response.sendRedirect("/select"); //UserSelectServletを呼び出す
			 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 }
			 }catch(SQLException e){
			 e.printStackTrace();
			 }
			 }
}
