package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.Service;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Service service = new Service();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet -GET");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.html").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// System.out.println(username + " " + password);
		int rtid = service.getRtidByUsernamePassword(username, password);
		System.out.println("role type: " + rtid);
		if (rtid == 1)
			request.getRequestDispatcher("manager/mng_home.html").forward(request, response);
		else if (rtid == 2)
			request.getRequestDispatcher("employee/emp_home.html").forward(request, response);
		else
			response.sendRedirect("login.html");
	}

}
