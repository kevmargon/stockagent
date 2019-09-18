package com.stockagent.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.stockagent.model.Role;
import com.stockagent.util.JPAUtil;

public class RoleDAOImpl implements RoleDAO {

	EntityManager manager = null;

	@Override
	public List<Role> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Role> namedQuery = manager.createNamedQuery("Role.findAll", Role.class);
			List<Role> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Role>();
	}

	@Override
	public Role get(long id) {
		Role role = null;
		try {
			manager = JPAUtil.getEntityManager();
			role = manager.find(Role.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public boolean save(Role role) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(role);
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
			Role role = manager.find(Role.class, id);
			if (role != null) {
				manager.remove(role);
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
	public boolean update(Role role) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(role);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
