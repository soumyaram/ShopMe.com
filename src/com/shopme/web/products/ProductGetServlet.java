package com.shopme.web.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopme.db.service.ProductDBService;

/**
 * Servlet implementation class ProductGetServlet
 */
@WebServlet("/ProductGetServlet")
public class ProductGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDBService dbService = new ProductDBService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ProductList", dbService.getProducts());
		request.getRequestDispatcher("/pages/home.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ProductList", dbService.getProducts());
		request.getRequestDispatcher("/home.jsp").forward(request,
				response);
	}

}
