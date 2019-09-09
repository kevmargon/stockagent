package com.stockagent.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stockagent.model.Employee;
import com.stockagent.util.JPAUtil;

public class LogInMethods {

	static EntityManager manager;

		
	public static boolean conexionusuario(String user, String pass) {
		// Creation entity manager
		manager = JPAUtil.getEntityManager();

		String jpql = "SELECT e FROM Employee e WHERE e.pass = ?1 AND e.user LIKE ?2";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, pass);
		query.setParameter(2, user);
		List<Employee> resultados = query.getResultList();
		for (Employee e : resultados) {
			System.out.print(e.getId() + " === ");
			System.out.print(e.getUser() + " === ");
			System.out.println(e.getPass() + " === ");
		}
		if (resultados.size() == 0) {
			manager.close();
			return false;
		} else {
			manager.close();
			return true;
		}
	}

	public static String encriptarsha1(String var) {
		try {
			// getInstance() method is called with algorithm SHA-1
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(var.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			// return the HashText
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}


	
}
