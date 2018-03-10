package com.veera.hibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final String JPA_PERSISTENCE_UNIT_NAME = "PERSISTENCE";

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(JPA_PERSISTENCE_UNIT_NAME);
        }

        return entityManagerFactory;
    }

    public static void JPAShutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
