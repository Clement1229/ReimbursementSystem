package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
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
		request.getRequestDispatcher("login.html").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// System.out.println(username + " " + password);
		//int rtid = service.getRtidByUsernamePassword(username, password);
		//System.out.println("test getUserByUsernamePassword");
		User user = service.getUserByUsernamePassword(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//System.out.println(service.getUserByUsernamePassword(username, password));
		//System.out.println("role type: " + rtid);
		if (user.getRtId() == 1) // If user is a manager
			request.getRequestDispatcher("mng_home.html").forward(request, response);  // path will be changed later
		else if (user.getRtId() == 2) //If user is an employee
			request.getRequestDispatcher("emp_home.html").forward(request, response);
		else
			response.sendRedirect("login.html");
	}

}
