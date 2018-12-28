package com.bridge.javaee;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(
		urlPatterns = { "/TestServlet" }, 
		initParams = { 
				@WebInitParam(name = "name", value = "peter")
		})
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException{
    	super.init();
    	System.out.println("calling on startup");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");;
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("method unsupported");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		ServletConfig config = this.getServletConfig();
		ServletContext context = this.getServletContext();
		
		String strContextMyName = (String) context.getAttribute("myName");
		String strConfigName = config.getInitParameter("name");
		String strName = request.getParameter("name");
		String strInitName = this.getInitParameter("name");
		String strGlobalName = context.getInitParameter("globalName");
		
		String url = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		String pathInfo = request.getPathInfo();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		
		int remotePort = request.getRemotePort();
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String localName = request.getLocalName();
		String referer = request.getHeader("Referer");
		
		String fileData = "";
		

		try {
			InputStream in = context.getResourceAsStream("files/a.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			while(reader.ready()) {
				fileData += reader.readLine();
			}
			in.close();
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("name: " + strName + ", config name:" + strConfigName + ",init param:" + strInitName + ",context my name:" + strContextMyName + ", global name:" + strGlobalName + ",file data:" + fileData);
		out.println("url:" + url + ", queryString:" + queryString + ",pathinfo:" + pathInfo + ",remote addr:" + remoteAddr + ", remotehost:" + remoteHost + ",remote port" + remotePort);
		out.println("local addr:" + localAddr + ", local name:" + localName + ", local port:" + localPort);
		out.println("referer:" + referer);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
