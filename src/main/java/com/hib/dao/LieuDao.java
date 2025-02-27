package com.hib.dao;

import com.hib.model.Lieu;
import com.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LieuDao {

    public void saveLieu(Lieu lieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(lieu);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Lieu> getLieux() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Lieu", Lieu.class).list();
        }
    }

    public void updateLieu(Lieu lieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(lieu);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteLieu(Long codelieu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Lieu lieu = session.get(Lieu.class, codelieu);
            if (lieu != null) {
                session.remove(lieu);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Lieu getLieu(Long codelieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Lieu.class, codelieu);
        }
    }
}
