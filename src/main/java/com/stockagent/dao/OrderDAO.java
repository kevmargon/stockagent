package com.stockagent.dao;

import java.util.List;


import com.stockagent.model.Order;

public interface OrderDAO {
	
	/**
	 * It returns a list of all orders
	 * @return
	 */
	List<Order> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Order get(long id);
	
	/**
	 * It saves a Order
	 * @param order
	 * @return true if order is correctly saved or false if there is an error
	 */
	boolean save(Order order);
	
	/**
	 *
	 * @param id
	 * @return 
	 */
	boolean delete(long id);
	
	boolean update(Order order);

}
