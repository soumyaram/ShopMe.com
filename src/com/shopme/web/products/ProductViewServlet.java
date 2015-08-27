package com.shopme.web.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopme.db.model.Product;
import com.shopme.db.service.ProductDBService;

/**
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDBService dbService = new ProductDBService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("pName").replace("PNI", "");
		Product product = dbService.getProduct(Integer.parseInt(productId));
		request.setAttribute("productName", product.getName());
		request.setAttribute("Product", product);
		request.getRequestDispatcher("/pages/product.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		String qty = request.getParameter("reqQty");
		Product product = dbService.getProduct(Integer.parseInt(productId));

		if (product.getQtyAvailable() < Integer.parseInt(qty)) {
			request.setAttribute("productId", productId);
			request.setAttribute("productName", product.getName());
			request.setAttribute("Message", "Sorry requested quantity of <i>"
					+ product.getName() + " </i> not available in stock");

			request.getRequestDispatcher("/pages/StockNotAvailable.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/Payment.jsp").forward(request, response);
		}
	}
}
