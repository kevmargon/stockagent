package com.stockagent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Product;
import com.stockagent.util.JPAUtil;

public class ProductDAOImpl implements ProductDAO {

EntityManager manager = null;
	
	@Override
	public List<Product> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Product> namedQuery = manager.createNamedQuery("Product.findAll", Product.class);
			List<Product> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Product>();
	}

	@Override
	public Product get(long id) {
		Product product = null;
		try {
			manager = JPAUtil.getEntityManager();
			product = manager.find(Product.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean save(Product product) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(product); 
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
			Product product = manager.find(Product.class, id);
			if (product != null) {
				manager.remove(product);
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
	public boolean update(Product product) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(product); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
