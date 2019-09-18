package com.stockagent.dao;

import java.util.List;


import com.stockagent.model.Role;

/*
* DAO for role operations
*/

public interface RoleDAO {

	List<Role> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Role get(long id);

	/**
	 * It saves a Role
	 * 
	 * @param role
	 * @return true if role is correctly saved or false if there is an error
	 */
	boolean save(Role role);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	boolean update(Role role);

}
