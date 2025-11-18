package fr.groupe.pcube;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderRepository {
    public void save(Order order){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
        }
    }

    public Order findById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Order.class, id);
        }
    }

    public List<Order> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Order", Order.class).list();
        }
    }

    public List<Order> findByClient(Client client){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Order o where o.client = :client", Order.class).setParameter("client", client).list();
        }
    }

    public Order update(Order order){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Order orderManaged = (Order) session.merge(order);
            tx.commit();
            return orderManaged;
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Order orderDelete = session.get(Order.class, id);
            if(orderDelete != null){
                session.remove(orderDelete);
            }
            tx.commit();
        }
    }
}
