package com.bridge.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastVisitCookie
 */
public class LastVisitCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastVisitCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strLastVisitTime = "";
		String strCurrent = URLEncoder.encode(dtFormat.format(new Date()),"UTF-8");
		
		PrintWriter out = response.getWriter();
		//get cookie lastVisit
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				//out.println(cookie.getName() + "-->" + cookie.getValue());
				if(cookie.getName().equals("lastVisit")) {
					strLastVisitTime = cookie.getValue();
					strLastVisitTime = URLDecoder.decode(strLastVisitTime, "UTF-8");
					//set current time
					cookie.setValue(strCurrent);
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		if(strLastVisitTime.length() > 0) {
			out.println("Your last visit time:" + strLastVisitTime);
		}else {
			out.println("This is your first visit");
			//save now
			//out.println(strCurrent);
			Cookie newCookie = new Cookie("lastVisit",strCurrent);
			//out.println(newCookie.getName() + "-->" + newCookie.getValue());
			response.addCookie(newCookie);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
