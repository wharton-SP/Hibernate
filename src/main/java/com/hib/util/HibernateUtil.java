package com.hib.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hib.model.*;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    @SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	        try {
	            System.out.println("Initialisation de Hibernate...");
	            Configuration configuration = new Configuration();
	            Properties settings = new Properties();
	            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/demo?useSSL=false&allowPublicKeyRetrieval=true");
	            settings.put(Environment.USER, "root");
	            settings.put(Environment.PASS, "xeon");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
	            settings.put(Environment.SHOW_SQL, "true");
	            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	            settings.put(Environment.HBM2DDL_AUTO, "update");

	            configuration.setProperties(settings);
	            configuration.addAnnotatedClass(Employe.class);
	            configuration.addAnnotatedClass(Lieu.class);
	            configuration.addAnnotatedClass(Affecter.class);

	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	            System.out.println("Création de SessionFactory...");
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            System.out.println("Hibernate initialisé avec succès.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("Erreur Hibernate : " + e.getMessage());
	        }
	    }
	    return sessionFactory;
	}


    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
