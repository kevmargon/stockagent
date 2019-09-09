package com.stockagent.dao;

import java.util.List;


import com.stockagent.model.Rol;

/*
* DAO for position operations
*/

public interface PositionDAO {

	List<Rol> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Rol get(long id);

	/**
	 * It saves a Position
	 * 
	 * @param position
	 * @return true if position is correctly saved or false if there is an error
	 */
	boolean save(Rol position);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	boolean update(Rol position);

}
