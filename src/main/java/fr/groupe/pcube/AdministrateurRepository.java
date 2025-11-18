package fr.groupe.pcube;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdministrateurRepository {

    public void save(Administrateur administrateur){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(administrateur);
            tx.commit();
        }
    }

    public Administrateur findById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Administrateur.class, id);
        }
    }

    public Administrateur findByEmail(String email){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Administrateur a where a.email = :email", Administrateur.class).setParameter("email", email).uniqueResult();
        }
    }

    public List<Administrateur> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Administrateur", Administrateur.class).list();
        }
    }

    public Administrateur update(Administrateur administrateur){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Administrateur administrateurManaged = (Administrateur) session.merge(administrateur);
            tx.commit();
            return administrateurManaged;
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Administrateur administrateurDelete = session.get(Administrateur.class, id);
            if(administrateurDelete != null){
                session.remove(administrateurDelete);
            }
            tx.commit();
        }
    }
}
