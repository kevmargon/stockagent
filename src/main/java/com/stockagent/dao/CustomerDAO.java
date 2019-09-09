package com.stockagent.dao;

import java.util.List;

import com.stockagent.model.Customer;

public interface CustomerDAO {
	
	/**
	 * It returns a list of all customers
	 * @return
	 */
	List<Customer> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Customer get(long id);
	
	/**
	 * It saves a Customer
	 * @param customer
	 * @return true if customer is correctly saved or false if there is an error
	 */
	boolean save(Customer customer);
	
	/**
	 *
	 * @param id
	 * @return 
	 */
	boolean delete(long id);
	
	boolean update(Customer customer);

}
