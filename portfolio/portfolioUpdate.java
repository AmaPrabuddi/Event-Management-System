package com.portfolio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class portfolioUpdate
 */
@WebServlet("/portfolioUpdate")
public class portfolioUpdate extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int portfolioId = Integer.parseInt(request.getParameter("id"));
	        String category = request.getParameter("category");
	        String name = request.getParameter("name");
	        String venue = request.getParameter("venue");
	        String date = request.getParameter("date");
	        String introduction = request.getParameter("introduction");
	        String image1 = request.getParameter("image1");
	        String image2 = request.getParameter("image2");
	        String image3 = request.getParameter("image3");

	        Portfolio portfolio = new Portfolio(portfolioId, category, name, venue, date, introduction, image1, image2, image3);

	        boolean isSuccess = PortfolioDBUtil.updatePortfolio(portfolio);

	        if (isSuccess) {
	            response.sendRedirect("fetchPortfolio.jsp");
	        } else {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<script type='text/javascript'>");
	            out.println("alert('Updation Unsuccessful. Please Try Again Later');");
	            out.println("window.location.href='portfolio.jsp';");
	            out.println("</script>");
	        }
	    }

}
