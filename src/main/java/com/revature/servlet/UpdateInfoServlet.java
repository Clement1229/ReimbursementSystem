package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.service.Service;

/**
 * Servlet implementation class UpdateInfoServlet
 */
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UpdateInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateInfo Servlet -GET");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateInfo Servlet -POST");
		String newFirstName = request.getParameter("editFirstName");
		String newPassword = request.getParameter("editPassword");
		String newEmail = request.getParameter("editEmail");

		Service service = new Service();
		
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		service.updateFirstNamePasswordEmail(newFirstName, newPassword, newEmail, user.getErsId());
		user.setFirstName(newFirstName);
		user.setPassword(newPassword);
		user.setEmail(newEmail);
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("emp_home.html").forward(request, response);

	}

}
