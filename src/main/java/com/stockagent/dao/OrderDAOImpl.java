package com.stockagent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Order;
import com.stockagent.util.JPAUtil;

public class OrderDAOImpl implements OrderDAO {

EntityManager manager = null;
	
	@Override
	public List<Order> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Order> namedQuery = manager.createNamedQuery("Order.findAll", Order.class);
			List<Order> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Order>();
	}

	@Override
	public Order get(long id) {
		Order order = null;
		try {
			manager = JPAUtil.getEntityManager();
			order = manager.find(Order.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public boolean save(Order order) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(order); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
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
			Order order = manager.find(Order.class, id);
			if (order != null) {
				manager.remove(order);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Order order) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(order); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
