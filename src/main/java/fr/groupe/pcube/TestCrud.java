package fr.groupe.pcube;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestCrud {
    public static void main(String[] args) {

        // CREATE
        UUID idCree;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        TestEntity e = new TestEntity(42, 123456789L, "test");
        session.persist(e); //INSERT apparement

        tx.commit(); //On envoi
        session.close();

        idCree = e.getId();
        System.out.println("CREATED -> "+e);

        // READ

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        TestEntity e2 = session2.get(TestEntity.class, idCree); // SELECT ... WHERE id=?
        System.out.println("READ -> "+e2);

        session2.getTransaction().commit();
        session2.close();

        // UPDATE

        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = session3.beginTransaction();
        TestEntity e3 = session3.get(TestEntity.class, idCree);
        e3.setIntValue(32);
        e3.setLongValue(46L);
        e3.setTextValue("cacaprout");
        tx3.commit();
        session3.close();

        // VERIFIER

        Session session4 = HibernateUtil.getSessionFactory().openSession();
        session4.beginTransaction();
        TestEntity e4 = session4.get(TestEntity.class, idCree);
        System.out.println("AFTER -> "+e4);
        session4.getTransaction().commit();
        session4.close();

        // DELETE

        Session session5 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx5 = session5.beginTransaction();
        TestEntity e5 = session5.get(TestEntity.class, idCree);
        session5.remove(e5);
        tx5.commit();
        session5.close();

        // VERIFIER

        Session session6 = HibernateUtil.getSessionFactory().openSession();
        session6.beginTransaction();
        TestEntity e6 = session6.get(TestEntity.class, idCree);
        System.out.println("AFTER -> "+e6);

        // LISTER TOUT

        List<TestEntity> restant = session6.createQuery("from TestEntity", TestEntity.class).list();
        System.out.println(restant.size()+" lignes.");
        session6.getTransaction().commit();
        session6.close();

        HibernateUtil.shutdown();
    }
}
