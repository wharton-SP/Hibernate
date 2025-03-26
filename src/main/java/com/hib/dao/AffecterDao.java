package com.hib.dao;

import com.hib.model.Affecter;
import com.hib.model.Employe;
import com.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AffecterDao {

    public void saveAffectation(Affecter affecter) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            if (affecter.getEmploye() == null || affecter.getLieu() == null) {
                throw new IllegalArgumentException("Employé et lieu ne peuvent pas être null !");
            }
            
            session.persist(affecter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Affecter getAffectationById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Affecter.class, id);
        }
    }

    public List<Affecter> getAllAffectations() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Affecter", Affecter.class).list();
        }
    }

    public void updateAffectation(Affecter affecter) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            Affecter existingAffecter = session.get(Affecter.class, affecter.getCodeaffecter());
            if (existingAffecter != null) {
                if (affecter.getEmploye() != null && affecter.getLieu() != null) {
                    existingAffecter.setEmploye(affecter.getEmploye());
                    existingAffecter.setLieu(affecter.getLieu());
                }
                existingAffecter.setDate(affecter.getDate());
                session.merge(existingAffecter);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAffectation(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Affecter affecter = session.get(Affecter.class, id);
            if (affecter != null) {
                session.remove(affecter);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Affecter> searchAffectations(String keyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Affecter a " +
                       "JOIN FETCH a.employe e " +
                       "JOIN FETCH a.lieu l " +
                       "WHERE e.codeemp LIKE :keyword OR " +
                       "e.nom LIKE :keyword OR " +
                       "e.prenom LIKE :keyword OR " +
                       "l.designation LIKE :keyword";
            
            Query<Affecter> query = session.createQuery(hql, Affecter.class);
            query.setParameter("keyword", "%" + keyword + "%");
            
            return query.list();
        }
    }
}