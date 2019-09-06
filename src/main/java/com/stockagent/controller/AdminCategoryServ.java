package com.stockagent.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stockagent.dao.*;
import com.stockagent.model.Category;


@WebServlet("/AdminCategoryServ")
public class AdminCategoryServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	CategoryDAO categoryDAO = null;
	
	public AdminCategoryServ() {
		categoryDAO = new CategoryDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listCategory(request, response);
				break;
				
			case "EDIT":
				getSingleCategory(request, response);
				break;
				
			case "DELETE":
				deleteCategory(request, response);
				break;
				
			default:
				listCategory(request, response);
				break;
				
		}
		
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(categoryDAO.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Category Deleted Successfully!");
		}
		
		listCategory(request, response);
	}

	private void getSingleCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Category theCategory = categoryDAO.get(Long.parseLong(id));
		
		request.setAttribute("category", theCategory);
		
		dispatcher = request.getRequestDispatcher("/views/admin-category-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> theList = categoryDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/admin-category-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Category category = new Category();
		category.setName(request.getParameter("name"));
		
		if(id.isEmpty() || id == null) {
			
			if(categoryDAO.save(category)) {
				request.setAttribute("NOTIFICATION", "Category Saved Successfully!");
			}	
		}else {	
			category.setId(Long.parseLong(id));
			if(categoryDAO.update(category)) {
				request.setAttribute("NOTIFICATION", "Category Updated Successfully!");
			}	
		}
		listCategory(request, response);
	}

}
