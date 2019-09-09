package com.stockagent.dao;

import java.util.List;



import com.stockagent.model.Report;

/*
 * DAO for report operations
 */

public interface ReportDAO {

	List<Report> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Report get(long id);

	/**
	 * It saves a Report
	 * 
	 * @param report
	 * @return true if report is correctly saved or false if there is an error
	 */
	boolean save(Report report);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	boolean update(Report report);

}
