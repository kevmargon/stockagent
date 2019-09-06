package com.stockagent.util;

import javax.persistence.*;

public class JPAUtil {

	private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("stockagent");

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

}
