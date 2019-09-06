package com.stockagent.dao;

import java.util.List;

import com.stockagent.model.Category;

public interface CategoryDAO {
	
	/**
	 * It returns a list of all categorys
	 * @return
	 */
	List<Category> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Category get(long id);
	
	/**
	 * It saves a Category
	 * @param category
	 * @return true if category is correctly saved or false if there is an error
	 */
	boolean save(Category category);
	
	/**
	 *
	 * @param id
	 * @return 
	 */
	boolean delete(long id);
	
	boolean update(Category category);

}
