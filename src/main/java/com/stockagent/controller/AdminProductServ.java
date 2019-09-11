package com.stockagent.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stockagent.model.Category;
import com.stockagent.model.Product;
import com.stockagent.dao.*;


@WebServlet("/AdminProductServ")
public class AdminProductServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	ProductDAO productDAO = null;
	CategoryDAO categoryDAO = null;
	
	public AdminProductServ() {
		productDAO = new ProductDAOImpl();
		categoryDAO = new CategoryDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
			request.setAttribute("IDNAME", "none");
		}
		
		switch(action) {
			
			case "LIST":
				listProduct(request, response);
				request.setAttribute("IDNAME", "none");
				break;
			
			case "LISTCAT":
				listProductByCat(request, response);
				break;
				
			case "EDIT":
				getSingleProduct(request, response);
				break;
				
			case "DELETE":
				deleteProduct(request, response);
				break;
				
			case "DETAIL":
				productDetail(request, response);
				break;
				
			default:
				listProduct(request, response);
				break;
				
		}
		
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(productDAO.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Product Deleted Successfully!");
			request.setAttribute("IDNAME", "delete");
		}else {
			request.setAttribute("IDNAME", "error");
		}
		
		listProduct(request, response);
	}

	private void getSingleProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		
		Product theProduct = productDAO.get(Long.parseLong(id));
		
		request.setAttribute("product", theProduct);
		request.setAttribute("IDNAME", "none");
		
		dispatcher = request.getRequestDispatcher("/views/admin-product-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void productDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Product theProduct = productDAO.get(Long.parseLong(id));
		
		request.setAttribute("product", theProduct);
		
		dispatcher = request.getRequestDispatcher("/views/product-details.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<Category> theListC = categoryDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Product> theListP = productDAO.get();
		
		request.setAttribute("listP", theListP);

		dispatcher = request.getRequestDispatcher("/views/admin-product-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void listProductByCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String id = request.getParameter("id");
		  Category theCategory = categoryDAO.get(Long.parseLong(id));
		  
		  List<Product> theListP = theCategory.getProducts();
		  
//		  List<Product> theListP = productDAO.getCat(Long.parseLong(id)); 
		 
		  request.setAttribute("listP", theListP);

		  dispatcher = request.getRequestDispatcher("/views/admin-product-list.jsp");
		  
		  dispatcher.forward(request, response);
		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(new BigDecimal (request.getParameter("price")));
		product.setAmount(Integer.parseInt(request.getParameter("amount")));
		product.setManufacturer(request.getParameter("manufacturer"));
		product.setCategory(categoryDAO.get(Integer.parseInt(request.getParameter("category"))));
		
		if(id.isEmpty() || id == null) {
			
			if(productDAO.save(product)) {
				request.setAttribute("NOTIFICATION", "Product Saved Successfully!");
				request.setAttribute("IDNAME", "save");
			}else {
				request.setAttribute("IDNAME", "error");
			}
		}else {	
			product.setId(Long.parseLong(id));
			if(productDAO.update(product)) {
				request.setAttribute("NOTIFICATION", "Product Updated Successfully!");
				request.setAttribute("IDNAME", "update");
			}else {
				request.setAttribute("IDNAME", "error");
			}
		}
		listProduct(request, response);
	}

}
