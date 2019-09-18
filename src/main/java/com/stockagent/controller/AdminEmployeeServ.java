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

import com.stockagent.model.Employee;
import com.stockagent.model.Role;
import com.stockagent.model.Direction;
import com.stockagent.dao.*;


@WebServlet("/AdminEmployeeServ")
public class AdminEmployeeServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	EmployeeDAO employeeDAO = null;
	DirectionDAO directionDAO = null;
	RoleDAO roleDAO = null;
	
	public AdminEmployeeServ() {
		employeeDAO = new EmployeeDAOImpl();
		directionDAO = new DirectionDAOImpl();
		roleDAO = new RoleDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
			request.setAttribute("IDNAME", "none");
		}
		
		switch(action) {
			
			case "LIST":
				listEmployee(request, response);
				request.setAttribute("IDNAME", "none");
				break;
			
			case "EDIT":
				getSingleEmployee(request, response);
				break;
				
			case "DELETE":
				deleteEmployee(request, response);
				break;
				
			case "DETAIL":
				employeeDetail(request, response);
				break;
				
			default:
				listEmployee(request, response);
				break;
				
		}
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(employeeDAO.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
			request.setAttribute("IDNAME", "delete");
		}else {
			request.setAttribute("IDNAME", "error");
		}
		
		listEmployee(request, response);
	}

	private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		
		Employee theEmployee = employeeDAO.get(Long.parseLong(id));
		
		request.setAttribute("employee", theEmployee);
		request.setAttribute("IDNAME", "none");
		
		dispatcher = request.getRequestDispatcher("/views/admin-employee-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void employeeDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Employee theEmployee = employeeDAO.get(Long.parseLong(id));
		
		request.setAttribute("employee", theEmployee);
		
		dispatcher = request.getRequestDispatcher("/views/employee-details.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<Category> theListC = categoryDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Employee> theListP = employeeDAO.get();
		
		request.setAttribute("listP", theListP);

		dispatcher = request.getRequestDispatcher("/views/admin-employee-list.jsp");
		
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Employee employee = new Employee();
		employee.setName(request.getParameter("name"));
		employee.setSurname1(request.getParameter("surname1"));
		employee.setSurname2(request.getParameter("surname2"));
		employee.setDni(request.getParameter("dni"));
		employee.setPhoneNumber(request.getParameter("phoneNumber"));
		String nameuser= request.getParameter("name");
		//User-pass generation password
		
		employee.setUser(UserNameMethod(nameuser));
		//comprobar con la base de datos que no esta
		
		employee.setPasword(UserPassMethod());
		
		
		Direction direction = new Direction();
		//(String address, int houseNumber, int zipCode, String city, String province, String country)
		
		
		if(id.isEmpty() || id == null) {
			
			if(employeeDAO.save(employee)) {
				request.setAttribute("NOTIFICATION", "Employee Saved Successfully!");
				request.setAttribute("IDNAME", "save");
			}else {
				request.setAttribute("IDNAME", "error");
			}
		}else {	
			employee.setId(Long.parseLong(id));
			if(employeeDAO.update(employee)) {
				request.setAttribute("NOTIFICATION", "Employee Updated Successfully!");
				request.setAttribute("IDNAME", "update");
			}else {
				request.setAttribute("IDNAME", "error");
			}
		}
		listEmployee(request, response);
	}

}
