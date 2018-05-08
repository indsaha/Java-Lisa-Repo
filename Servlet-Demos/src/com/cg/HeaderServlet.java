package com.cg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");

		
		out.println("<h2>");
		String encodedURL = response.encodeURL("index.jsp");
		System.out.println(encodedURL);
		
		out.println("<a href=\"" + encodedURL +"\">HOME</a>");
		out.println("</h2>");

		
		out.println("<table border=\"1\">");
		
		while(headerNames.hasMoreElements()){
			
			out.println("<tr>");
			
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			
			out.println("</tr>");
			
		}
		
		
		out.println("</table>");
		
		
		
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
