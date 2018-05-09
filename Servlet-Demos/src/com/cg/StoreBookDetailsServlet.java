package com.cg;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/storeDetails")
public class StoreBookDetailsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] names = request.getParameterValues("bookName");
		
		Set<String> books = new HashSet<>();
		
		for(String name : names){
			
			books.add(name);
		}
		
		HttpSession session = request.getSession(false);
		
		if(session == null){
			System.out.println("No session available for client");
			return;
		}
		
		
		session.setAttribute("setOfBooks", books);
		
//		request.setAttribute("setOfBooks", books);
		
		
		
		
		response.sendRedirect("displayDetails");
	
/*		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayDetails");
		dispatcher.forward(request, response);
*/		
	}
}
