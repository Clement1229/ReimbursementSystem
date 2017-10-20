package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.PendingRequest;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxManagerPendingViewServlet
 */
@WebServlet("/ajaxPendingRequestView")
public class AjaxManagerPendingViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxManagerPendingViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Loading AjaxManagerPendingViewServlet  -GET");
		Service service = new Service();
		List<PendingRequest> pr = service.viewPendingRequest();
//		ResultSet rs = service.viewPendingRequest();
		PrintWriter out = response.getWriter();
		out.print("<style>");
		out.print("table {");
		out.print(" font-family: arial, sans-serif;");
		out.print("border-collapse: collapse;");
		out.print("width: 100%;");
		out.print("	}");
		out.print("td, th {");
		out.print("border: 1px solid #dddddd;");
		out.print("text-align: left;");
		out.print("padding: 8px;");
		out.print("}");
		out.print("tr:nth-child(even) {");
		out.print("background-color: #dddddd;");
		out.print("}");
		out.print("</style>");
		
		
		
		out.print("<input name= \"test01\" type = \"submit\" />");
		out.println("</br>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Counter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"6\">");
		
		out.println("<tr>");
		 for (int i = 0; i < pr.size(); i++) {
		        //if (i>0 && i%5==0) {
		            out.println("</tr><tr>");
		        //}
		        out.println("<td>" + pr.get(i) + "</td>");
		    }
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}


}
