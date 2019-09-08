package com.stockagent.dao;

import java.util.List;

import com.stockagent.model.Employee;

public interface EmployeeDAO {
	
	/**
	 * It returns a list of all employees
	 * @return
	 */
	List<Employee> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Employee get(int id);
	
	/**
	 * It saves a Employee
	 * @param employee
	 * @return true if employee is correctly saved or false if there is an error
	 */
	boolean save(Employee employee);
	
	/**
	 *
	 * @param id
	 * @return 
	 */
	boolean delete(int id);
	
	boolean update(Employee employee);

}
