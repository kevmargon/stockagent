//package com.stockagent.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//
//import com.stockagent.model.Employee;
//import com.stockagent.util.JPAUtil;
//
//public class EmployeeDAOImpl implements EmployeeDAO {
//	
//EntityManager manager = null;
//	
//	@Override
//	public List<Employee> get() {
//				
//		try {
//			manager = JPAUtil.getEntityManager();
//			TypedQuery<Employee> namedQuery = manager.createNamedQuery("Employee.findAll", Employee.class);
//			List<Employee> results = namedQuery.getResultList();
//			manager.close();
//			return results;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return new ArrayList<Employee>();
//	}
//
//	@Override
//	public Employee get(int id) {
//		Employee employee = null;
//		try {
//			manager = JPAUtil.getEntityManager();
//			employee = manager.find(Employee.class, id);
//			manager.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return employee;
//	}
//
//	@Override
//	public boolean save(Employee employee) {
//		boolean flag = false;
//		try {
//			manager = JPAUtil.getEntityManager();
//			manager.getTransaction().begin();   
//			manager.persist(employee); 
//			manager.getTransaction().commit(); 
//			manager.close();
//			flag = true;
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return flag;
//	}
//
//	@Override
//	public boolean delete(int id) {
//		boolean flag = false;
//		try {
//			manager = JPAUtil.getEntityManager();
//			manager.getTransaction().begin();   
//			Employee employee = manager.find(Employee.class, id);
//			if (employee != null) {
//				manager.remove(employee);
//				manager.getTransaction().commit(); 
//				flag = true;
//			}
//			manager.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//
//	@Override
//	public boolean update(Employee employee) {
//		boolean flag = false;
//		try {
//			manager = JPAUtil.getEntityManager();
//			manager.getTransaction().begin();   
//			manager.merge(employee); 
//			manager.getTransaction().commit(); 
//			manager.close();
//			flag = true;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//
//}
