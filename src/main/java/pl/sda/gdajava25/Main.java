package pl.sda.gdajava25;

import org.hibernate.*;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getOurSessionFactory();
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(new Student(null, "Paweł", 25, 3.4, true));
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
