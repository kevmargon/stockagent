package com.stockagent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Customer;
import com.stockagent.util.JPAUtil;

public class CustomerDAOImpl implements CustomerDAO {

EntityManager manager = null;
	
	@Override
	public List<Customer> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Customer> namedQuery = manager.createNamedQuery("Customer.findAll", Customer.class);
			List<Customer> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Customer>();
	}

	@Override
	public Customer get(long id) {
		Customer customer = null;
		try {
			manager = JPAUtil.getEntityManager();
			customer = manager.find(Customer.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean save(Customer customer) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(customer); 
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
			Customer customer = manager.find(Customer.class, id);
			if (customer != null) {
				manager.remove(customer);
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
	public boolean update(Customer customer) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(customer); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
