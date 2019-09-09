package com.stockagent.dao;

import java.util.List;


import com.stockagent.model.Supplier;

/*
 * DAO for supplier operations
 */

public interface SupplierDAO {

	List<Supplier> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Supplier get(long id);

	/**
	 * It saves a Supplier
	 * 
	 * @param supplier
	 * @return true if supplier is correctly saved or false if there is an error
	 */
	boolean save(Supplier supplier);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	boolean update(Supplier supplier);

}
