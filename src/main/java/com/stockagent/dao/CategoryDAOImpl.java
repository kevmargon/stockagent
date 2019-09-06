package com.stockagent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Category;
import com.stockagent.util.JPAUtil;

public class CategoryDAOImpl implements CategoryDAO {

EntityManager manager = null;
	
	@Override
	public List<Category> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Category> namedQuery = manager.createNamedQuery("Category.findAll", Category.class);
			List<Category> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Category>();
	}

	@Override
	public Category get(long id) {
		Category category = null;
		try {
			manager = JPAUtil.getEntityManager();
			category = manager.find(Category.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public boolean save(Category category) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(category); 
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
			Category category = manager.find(Category.class, id);
			if (category != null) {
				manager.remove(category);
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
	public boolean update(Category category) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(category); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
