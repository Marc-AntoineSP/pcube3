#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class FournisseurRepository {

    public void save(Fournisseur fournisseur){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(fournisseur);
            tx.commit();
        }
    }

    public Fournisseur findById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Fournisseur.class, id);
        }
    }

    public Fournisseur findByEmail(String email){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Fournisseur f where f.email = :email", Fournisseur.class).setParameter("email", email).uniqueResult();
        }
    }

    public List<Fournisseur> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Fournisseur", Fournisseur.class).list();
        }
    }

    public Fournisseur update(Fournisseur fournisseur){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Fournisseur fournisseurManaged = (Fournisseur) session.merge(fournisseur);
            tx.commit();
            return fournisseurManaged;
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Fournisseur fournisseurDelete = session.get(Fournisseur.class, id);
            if(fournisseurDelete != null){
                session.remove(fournisseurDelete);
            }
            tx.commit();
        }
    }
}
