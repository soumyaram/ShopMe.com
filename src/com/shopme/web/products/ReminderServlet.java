package com.shopme.web.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopme.db.service.ProductDBService;

/**
 * Servlet implementation class ReminderServlet
 */
@WebServlet("/ReminderServlet")
public class ReminderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDBService dbService = new ProductDBService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReminderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		dbService.addReminder(email, productId);
		//request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
