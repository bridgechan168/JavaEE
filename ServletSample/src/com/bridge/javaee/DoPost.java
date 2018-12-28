package com.bridge.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoPost
 */

public class DoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		String[] hobbies = request.getParameterValues("hobbies");
		String[] address = request.getParameterValues("address");
		
		String description = request.getParameter("textarea");
		String hiddenValue = request.getParameter("aaa");
		
		PrintWriter out = response.getWriter();
		out.println("Form posted:<br>");
		out.println(username);
		out.println(password);
		out.println(gender);
		
		for(int i=0; i<hobbies.length; i++) {
			out.println(hobbies[i]);
		}
		for(int i=0; i<address.length; i++) {
			out.println(address[i]);
		}
		out.println(description);
		out.println(hiddenValue);
	}

}
