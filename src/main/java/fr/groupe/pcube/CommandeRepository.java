package fr.groupe.pcube;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommandeRepository {
    public void save(Commande commande){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(commande);
            tx.commit();
        }
    }

    public Commande findById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Commande.class, id);
        }
    }

    public List<Commande> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Commande", Commande.class).list();
        }
    }

    public List<Commande> findByFournisseur(Fournisseur fournisseur){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Commande c where c.fournisseur = :fournisseur", Commande.class).setParameter("fournisseur", fournisseur).list();
        }
    }

    public Commande update(Commande commande){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Commande commandeManaged = (Commande) session.merge(commande);
            tx.commit();
            return commandeManaged;
        }
    }

    public void deleteById(UUID id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Commande commandeDelete = session.get(Commande.class, id);
            if(commandeDelete != null){
                session.remove(commandeDelete);
            }
            tx.commit();
        }
    }
}
