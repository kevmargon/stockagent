package com.stockagent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stockagent.dao.EmployeeDAO;
import com.stockagent.util.LogInMethods;

/**
 * Servlet implementation class ServletConsulta
 */
@WebServlet("/LogInEmployeeServ")
public class LogInEmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	EmployeeDAO employeeDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInEmployeeServ() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//////////////////

		/*dispatcher = request.getRequestDispatcher("/views/employee-login-form.jsp");
		dispatcher.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("contra");

		boolean isError = false;
		if (usuario == null || usuario.length() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletError");
			dispatcher.forward(request, response);
			// out.println("<b>Nombre</b> iválido");
			isError = true;
			return;

		}
		if (contra == null || contra.length() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletError");
			dispatcher.forward(request, response);
			// out.println("<br><b>Apellido</b> iválido");
			isError = true;
			return;

		}
		if (!isError) {
			try {
				boolean res = Metodos.validaCampos(usuario, contra);
				if (res) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletSuccUser");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletErrUser");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String user = request.getParameter("user");
	        String pass = request.getParameter("pass");

	        try {
	        	boolean result = LogInMethods.conexionusuario(LogInMethods.encriptarsha1(user), LogInMethods.encriptarsha1(pass));
	        	//boolean result = LogInMethods.conexionusuario(user, pass);
	        	if(result == false) {
	        		dispatcher = request.getRequestDispatcher("views/employee-login-form.jsp");
	        		
	        		dispatcher.forward(request, response);
	        	}else if(result){
	        		
	        		response.sendRedirect("AdminCategoryServ?action=LIST");

	        	}
	        }catch(Exception ex) {
	        		ex.printStackTrace();
	        	}
	}


}
