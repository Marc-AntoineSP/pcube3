#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class VinRepository {
    public void save(Vin vin){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(vin);
            tx.commit();
        }
    }

    public Vin findById(UUID id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Vin.class, id);
        }
    }

    public List<Vin> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Vin", Vin.class).list();
        }
    }

    public Vin update(Vin vin){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Vin vinManaged = (Vin) session.merge(vin);
            tx.commit();
            return vinManaged;
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Vin vin = session.get(Vin.class, id);
            if(vin != null){
                session.remove(vin);
            }
            tx.commit();
        }
    }
}
