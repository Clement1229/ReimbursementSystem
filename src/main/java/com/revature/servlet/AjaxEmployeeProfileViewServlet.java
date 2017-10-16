package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;

/**
 * Servlet implementation class AjaxEmployeeProfileViewServlet
 */
@WebServlet("/ajaxProfileView")
public class AjaxEmployeeProfileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public AjaxEmployeeProfileViewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Loading ProfileView");
		request.getRequestDispatcher("employee/profile.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxEmployeeProfileViewServlet  -POST");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
	
	}

	

}
