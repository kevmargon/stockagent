package com.stockagent.dao;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.stockagent.model.Direction;
import com.stockagent.util.JPAUtil;

public class DirectionDAOImpl implements DirectionDAO {

	EntityManager manager = null;

	@Override
	public List<Direction> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Direction> namedQuery = manager.createNamedQuery("Direction.findAll", Direction.class);
			List<Direction> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Direction>();
	}

	@Override
	public Direction get(long id) {
		Direction direction = null;
		try {
			manager = JPAUtil.getEntityManager();
			direction = manager.find(Direction.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return direction;
	}

	@Override
	public boolean save(Direction direction) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(direction);
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
			Direction direction = manager.find(Direction.class, id);
			if (direction != null) {
				manager.remove(direction);
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
	public boolean update(Direction direction) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(direction);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
