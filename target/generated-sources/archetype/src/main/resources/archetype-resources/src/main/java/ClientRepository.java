#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientRepository {
    public void save(Client client){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }

    public Client findById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Client.class, id);
        }
    }

    public Client findByEmail(String email){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Client c where c.email = :email", Client.class).setParameter("email", email).uniqueResult();
        }
    }

    public List<Client> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Client", Client.class).list();
        }
    }

    public Client update(Client client){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Client clientManaged = (Client) session.merge(client);
            tx.commit();
            return clientManaged;
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Client clientDelete = session.get(Client.class, id);
            if(clientDelete != null){
                session.remove(clientDelete);
            }
            tx.commit();
        }
    }
}
