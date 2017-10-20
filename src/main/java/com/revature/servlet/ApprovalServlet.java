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
 * Servlet implementation class ApprovalServlet
 */
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ApprovalServlet  -POST");
		int rid = Integer.parseInt(request.getParameter("rid"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int mngId = user.getErsId();
		Service service = new Service();
		service.approveRequestByRid(mngId, rid);
		
		request.getRequestDispatcher("mng_home.html").forward(request, response);
	}

}
