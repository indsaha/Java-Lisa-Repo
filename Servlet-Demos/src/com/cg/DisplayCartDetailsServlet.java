package com.cg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//	TODO:1 Make DisplayCartDetailsServlet as a HttpServlet

@WebServlet("/displayDetails")
public class DisplayCartDetailsServlet extends HttpServlet {

	// TODO:2 Provide call-back method (called by web container)
	// for HTTP request made using HTTP GET method

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO:3 This method should read products selected by web-client from
		// bookCatelogue.html and
		// display them in tabular format as html response to the web client.

		// String[] names = request.getParameterValues("bookName");

//		Set<String> books = (Set<String>) request.getAttribute("setOfBooks");

		HttpSession session = request.getSession(false);
		
		Set<String> books = (Set<String>) session.getAttribute("setOfBooks");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		out.println("<table>");

		out.println("<th>BookName</th>");

		for (String name : books) {
			out.println("<tr>");
			out.println("<td>" + name + "</td>");
			out.println("</tr>");
		}

		/*
		 * for (int i = 0; i < names.length; i++) { out.println("<tr>");
		 * 
		 * out.println("<td>" + names[i] + "</td>");
		 * 
		 * out.println("</tr>");
		 * 
		 * }
		 */
		out.println("</table>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		this.doGet(request, response);
	}

}
