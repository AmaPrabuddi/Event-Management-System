package com.portfolio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/portfolioInsert")
public class portfolioInsert extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String category = request.getParameter("category");
	        String name = request.getParameter("name");
	        String venue = request.getParameter("venue");
	        String date = request.getParameter("date");
	        String introduction = request.getParameter("introduction");
	        String image1 = request.getParameter("image1");
	        String image2 = request.getParameter("image2");
	        String image3 = request.getParameter("image3");

	        boolean isTrue;
	        isTrue = PortfolioDBUtil.insertPortfolio(category, name, venue, date, introduction, image1, image2, image3);

	        if (isTrue) {
	            RequestDispatcher dis = request.getRequestDispatcher("fetchPortfolio.jsp");
	            dis.forward(request, response);
	        } else {
	            RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
	            dis2.forward(request, response);
	        }
	    }

}
