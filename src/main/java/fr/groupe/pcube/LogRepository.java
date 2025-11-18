package fr.groupe.pcube;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogRepository {
    public void save(Log log){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(log);
            tx.commit();
        }
    }

    public Log findById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Log.class, id);
        }
    }

    public List<Log> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Log", Log.class).list();
        }
    }

    public List<Log> findByType(TypeLog type){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Log l where l.type = :type", Log.class).setParameter("type", type).list();
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Log logDelete = session.get(Log.class, id);
            if(logDelete != null){
                session.remove(logDelete);
            }
            tx.commit();
        }
    }
}
