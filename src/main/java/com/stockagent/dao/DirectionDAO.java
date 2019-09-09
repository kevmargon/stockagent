package com.stockagent.dao;

import java.util.List;
import com.stockagent.model.Direction;


/*
 * DAO for direction operations
 */

public interface DirectionDAO {

	List<Direction> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Direction get(long id);

	/**
	 * It saves a Direction
	 * 
	 * @param direction
	 * @return true if direction is correctly saved or false if there is an error
	 */
	boolean save(Direction direction);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	boolean update(Direction direction);
}