package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Employee;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxManagerViewEmployeeServlet
 */
@WebServlet("/ajaxEmployeeListView")
public class AjaxManagerViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxManagerViewEmployeeServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxManagerViewEmployeeServlet    -GET");
		Service service = new Service();
		List<Employee> empls = service.viewEmployeeList();
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
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Counter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"6\">");
		
		out.println("<tr>");
		 for (int i = 0; i < empls.size(); i++) {
		       // if (i>0 && i%4==0) {
		            out.println("</tr><tr>");
		        	
		       // }
		        out.println("<td>" + empls.get(i) + "</td>");
		    }
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
