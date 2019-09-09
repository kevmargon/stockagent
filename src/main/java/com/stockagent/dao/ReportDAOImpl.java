package com.stockagent.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.stockagent.model.Report;
import com.stockagent.util.JPAUtil;

public class ReportDAOImpl implements ReportDAO {

	EntityManager manager = null;

	@Override
	public List<Report> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Report> namedQuery = manager.createNamedQuery("Report.findAll", Report.class);
			List<Report> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Report>();
	}

	@Override
	public Report get(long id) {
		Report report = null;
		try {
			manager = JPAUtil.getEntityManager();
			report = manager.find(Report.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

	@Override
	public boolean save(Report report) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(report);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			Report report = manager.find(Report.class, id);
			if (report != null) {
				manager.remove(report);
				manager.getTransaction().commit();
				flag = true;
			}
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Report report) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(report);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
