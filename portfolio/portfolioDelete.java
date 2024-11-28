package com.portfolio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class portfolioDelete
 */
@WebServlet("/portfolioDelete")
public class portfolioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the portfolio id parameter from the request
        int portfolioId = Integer.parseInt(request.getParameter("id"));

        // Call the method to delete the portfolio from the database
        boolean isDeleted = PortfolioDBUtil.deletePortfolio(portfolioId);

        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        // Check if the portfolio was successfully deleted
        if (isDeleted) {
            // Redirect to a success page or display a success message
            response.sendRedirect("fetchPortfolio.jsp");
        } else {
            // Display an error message if the deletion failed
            out.println("<script type='text/javascript'>");
            out.println("alert('Failed to delete portfolio. Please try again later.');");
            out.println("window.location.href='fetchPortfolio.jsp';");
            out.println("</script>");
        }
    }

}
