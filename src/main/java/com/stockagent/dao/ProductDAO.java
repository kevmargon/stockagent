package com.stockagent.dao;

import java.util.List;


import com.stockagent.model.Product;

public interface ProductDAO {
	
	/**
	 * It returns a list of all products
	 * @return
	 */
	List<Product> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Product get(long id);
	
	/**
	 * It saves a Product
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	
	List<Product> getCat(long id);
	
	List<Product> getSearch(String id);
	
	boolean save(Product product);
	
	/**
	 *
	 * @param id
	 * @return 
	 */
	boolean delete(long id);
	
	boolean update(Product product);

}
