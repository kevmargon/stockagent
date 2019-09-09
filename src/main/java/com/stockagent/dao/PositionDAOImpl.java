package com.stockagent.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.stockagent.model.Rol;
import com.stockagent.util.JPAUtil;

public class PositionDAOImpl implements PositionDAO {

	EntityManager manager = null;

	@Override
	public List<Rol> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Rol> namedQuery = manager.createNamedQuery("Position.findAll", Rol.class);
			List<Rol> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Rol>();
	}

	@Override
	public Rol get(long id) {
		Rol position = null;
		try {
			manager = JPAUtil.getEntityManager();
			position = manager.find(Rol.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return position;
	}

	@Override
	public boolean save(Rol position) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(position);
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
			Rol position = manager.find(Rol.class, id);
			if (position != null) {
				manager.remove(position);
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
	public boolean update(Rol position) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(position);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
