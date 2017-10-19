package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.ResolvedHistory;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxManagerResolvedViewServlet
 */
@WebServlet("/ajaxManagerResolvedView")
public class AjaxManagerResolvedViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxManagerResolvedViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxManagerResolvedViewServlet  -GET");
		
		Service service = new Service();
		List<ResolvedHistory> ls = service.viewAllResolvedHistory();
		PrintWriter out = response.getWriter();
		
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
		        	
		       // }
		        out.println("<td>" + ls.get(i) + "</td>");
		    }
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	
}
