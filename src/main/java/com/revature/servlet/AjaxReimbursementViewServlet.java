package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxReimbursementViewServlet
 */
@WebServlet("/ajaxReimbursementView")
public class AjaxReimbursementViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReimbursementViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxReimbursementViewServlet -GET");
		request.getRequestDispatcher("employee/submit-reimbursement.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxReimbursementViewServlet -POST");
		String amount = request.getParameter("amount"); //int result=Integer.parseInt(n1)+Integer.parseInt(n2); 
		String dcpt = request.getParameter("description");
		String type = request.getParameter("reimbursementType");
		HttpSession session = request.getSession();
		//User employee = (User)session.getAttribute("user");
		System.out.println(type);
		//Reimbursement reim = new Reimbursement(employee.getErsId(), 1, Double.parseDouble(amount), dcpt, Integer.parseInt(type));
		//System.out.println(reim);
		/*session.setAttribute("reimbursement", reim);
		
		Service service = new Service();
		service.submitReimbursement(employee, reim);*/
		request.getRequestDispatcher("employee/history-reimbursement.html").forward(request, response);
	}
/*	public static void main(String[] args) {
		Reimbursement reim = new Reimbursement( 1, 1, 500, "hi" , 1);
		System.out.println(reim);
	}*/

}
