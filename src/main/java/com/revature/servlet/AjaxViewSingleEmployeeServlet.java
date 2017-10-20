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

import com.revature.domain.PendingRequest;
import com.revature.domain.User;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxViewSingleEmployeeServlet
 */
@WebServlet("/ajaxSingleEmployeeView")
public class AjaxViewSingleEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxViewSingleEmployeeServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxViewSingleEmployeeServlet -GET");
		//request.getRequestDispatcher("manager/singleEmployeeRequest.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxViewSingleEmployeeServlet -POST");
		
//		String id  = request.getParameter("ersId");
		int ersid =  Integer.parseInt(request.getParameter("ersId"));
		Service service = new Service();
		List<PendingRequest> pr = service.viewSingleEmployeePendingRequest(ersid);
		
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
		
		out.print("<form method=\"POST\" action=\"approve\">");
		out.println("<input type=\"text\" name=\"rid\" placeholder=\"input rid\"/>");
		out.println("<input type = \"submit\" value=\"APPROVE\" />");
		out.println("</form>");
		
		out.print("<form method=\"POST\" action=\"deny\">");
		out.println("<input type=\"text\" name=\"drid\" placeholder=\"input rid\"/>");
		out.println("<input type = \"submit\" value=\"DENY\" />");
		out.println("</form>");
		
		
		
//		out.print("<input name= \"test01\" type = \"submit\" />");
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
