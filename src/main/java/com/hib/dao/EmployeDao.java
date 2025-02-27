package com.hib.dao;

import com.hib.model.Employe;
import com.hib.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeDao {

    public void saveEmploye(Employe employe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(employe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employe> getEmployes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employe", Employe.class).list();
        }
    }

    public void updateEmploye(Employe employe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(employe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEmploye(Long employeId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employe employe = session.get(Employe.class, employeId);
            if (employe != null) {
                session.remove(employe);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employe getEmploye(Long employeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employe.class, employeId);
        }
    }
    
    public List<Employe> searchEmployes(String keyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Vérification si le keyword peut être converti en Long (codeemp)
            Long codeemp = null;
            boolean isNumeric = false;

            // Tentative de conversion en Long
            try {
                codeemp = Long.valueOf(keyword);
                isNumeric = true; // Si la conversion réussit, on marque comme étant un nombre
            } catch (NumberFormatException e) {
                // Si l'exception est levée, alors le keyword est une chaîne de caractères
            }

            String hql;
            // Si keyword est un nombre, rechercher par codeemp, sinon rechercher par nom, prénom ou poste
            if (isNumeric) {
                hql = "FROM Employe e WHERE e.codeemp = :keyword";
            } else {
                hql = "FROM Employe e WHERE e.nom LIKE :keyword OR e.prenom LIKE :keyword OR e.poste LIKE :keyword";
            }

            // Requête préparée
            Query<Employe> query = session.createQuery(hql, Employe.class);

            // Paramètre pour le keyword (codeemp ou texte)
            query.setParameter("keyword", isNumeric ? codeemp : "%" + keyword + "%");

            return query.list();
        }

    }



}

