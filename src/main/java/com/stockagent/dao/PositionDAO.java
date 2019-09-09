package com.stockagent.dao;

import java.util.List;


import com.stockagent.model.Role;

/*
* DAO for position operations
*/

public interface PositionDAO {

	List<Role> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Role get(long id);

	/**
	 * It saves a Position
	 * 
	 * @param position
	 * @return true if position is correctly saved or false if there is an error
	 */
	boolean save(Role position);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	boolean update(Role position);

}
