package com.WT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import sun.management.jdp.JdpBroadcaster;


@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String driver = getServletContext().getInitParameter("JDBCDriver");
		String url = getServletContext().getInitParameter("JDBCUrl");
		String user = getServletContext().getInitParameter("JDBCUser");
		String password = getServletContext().getInitParameter("JDBCPassword");
		User u = new User();
		// TODO Auto-generated method stub
		boolean dbResult = false;
		boolean login = false;
		try {
			dbResult = JDBConnection.myConnection(driver,url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dbResult) {
			String username = request.getParameter("username");
			String psswrd = request.getParameter("password");

			try {
				
				login = Login.getResultSet(url,user,password,username, psswrd,u);
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (login) {
			request.setAttribute("name", u.getFullname());
			request.setAttribute("email", u.getEmail());
			request.getRequestDispatcher("Login.jsp").forward(request, response);
//			PrintWriter out = response.getWriter();
//			out.println("<html> <head></head><body>");
//			out.println("<h2> Log-In Successful </h1>");
//			out.println("<p>"+u.getFullname()+"</p>");
//			out.println("<p>"+u.getEmail()+"</p>");
//			out.println("</body></html>");
			//response.getWriter().append();
		} else {
			response.getWriter().append("Please enter valid credentials");
		}

//		String email = request.getParameter("email");
//		String msg = request.getParameter("msg");
//		String emailResult = null;
//		response.getWriter().append(dbResult + " \n Username = " + username + "\n");
//		MailUtil.sendMail(email,msg);
//		doGet(request, response);
	}

}
