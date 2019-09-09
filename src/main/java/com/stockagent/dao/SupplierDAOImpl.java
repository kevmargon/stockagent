package com.stockagent.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.stockagent.model.Supplier;
import com.stockagent.util.JPAUtil;

public class SupplierDAOImpl implements SupplierDAO {

	EntityManager manager = null;

	@Override
	public List<Supplier> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Supplier> namedQuery = manager.createNamedQuery("Supplier.findAll", Supplier.class);
			List<Supplier> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Supplier>();
	}

	@Override
	public Supplier get(long id) {
		Supplier supplier = null;
		try {
			manager = JPAUtil.getEntityManager();
			supplier = manager.find(Supplier.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}

	@Override
	public boolean save(Supplier supplier) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(supplier);
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
			Supplier supplier = manager.find(Supplier.class, id);
			if (supplier != null) {
				manager.remove(supplier);
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
	public boolean update(Supplier supplier) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(supplier);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
