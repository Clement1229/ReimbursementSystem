package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.PendingHistory;
import com.revature.domain.User;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxHistoryOfPendingServlet
 */
@WebServlet("/ajaxHistoryOfPendingView")
public class AjaxHistoryOfPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxHistoryOfPendingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Loading Pending View  -GET");
		Service service = new Service();
		HttpSession session = request.getSession();
		User employee = (User) session.getAttribute("user");
		List<PendingHistory> ls = service.viewPendingHistory(employee.getErsId());
		PrintWriter out = response.getWriter();
		System.out.println(ls);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Counter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"6\">");
		out.println("<tr>");
		 for (int i = 0; i < ls.size(); i++) {
		       // if (i>0 && i%4==0) {
		            out.println("</tr><tr>");
		        	
		        //}
		        out.println("<td>" + ls.get(i) + "</td>");
		    }
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		// request.getRequestDispatcher("employee/history-pending.html").forward(request,
		// response);
	}

}
