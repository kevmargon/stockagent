package com.stockagent.util;

import javax.persistence.*;

/**
 * Utility Class for manage JPA connections
 */

public class JPAUtil {

	private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("stockagent");

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

}
