package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.User;
import com.revature.service.Service;

/**
 * Servlet implementation class AjaxErsUserInfoServlet
 */
@WebServlet("/ajaxGetErsUserInfo")
public class AjaxErsUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxErsUserInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ajaxErsUserInfoServlet  -GET");
		HttpSession session = request.getSession();
		User employee = (User) session.getAttribute("user");

		if (employee != null) {

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(employee);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}else {
			response.setStatus(418);
		}
	}

}
