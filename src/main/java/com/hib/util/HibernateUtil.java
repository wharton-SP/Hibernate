package com.hib.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                System.out.println("Initialisation de Hibernate à partir de hibernate.cfg.xml...");
                
                // Crée le registre de services à partir du fichier hibernate.cfg.xml
                registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // Charge la configuration depuis le fichier XML
                    .build();
                
                // Crée la SessionFactory
                sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
                
                System.out.println("Hibernate initialisé avec succès.");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Erreur Hibernate : " + e.getMessage());
                // Assurez-vous que le registre est détruit en cas d'échec
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}