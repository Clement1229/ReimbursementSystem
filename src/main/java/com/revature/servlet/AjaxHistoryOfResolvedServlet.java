package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.PendingHistory;
import com.revature.domain.ResolvedHistory;
import com.revature.domain.User;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxHistoryOfResolvedServlet
 */
@WebServlet("/ajaxHistoryOfResolvedView")
public class AjaxHistoryOfResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxHistoryOfResolvedServlet() {
        // TODO Auto-enerated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Loading Resolved View  -GET");
		Service service = new Service();
		HttpSession session = request.getSession();
		User employee = (User) session.getAttribute("user");
		List<ResolvedHistory> ls = service.viewResolvedHistory(employee.getErsId());
		PrintWriter out = response.getWriter();
		//System.out.println(ls);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Counter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"6\">");
		
//		out.println("<tr>");
//		
//		out.println("<th>");
//		out.println("Type");
//		out.println("</th>");
//		out.println("<th>");
//		out.println("Amount");
//		out.println("</th>");
//		out.println("<th>");
//		out.println("Status");
//		out.println("</th>");
//		out.println("<th>");
//		out.println("Time");
//		out.println("</th>");
		
		out.println("<tr>");
		 for (int i = 0; i < ls.size(); i++) {
		        //if (i>0 && i%5==0) {
		            out.println("</tr><tr>");
		        //}
		        out.println("<td>" + ls.get(i) + "</td>");
		    }
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
