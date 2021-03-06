package lk.ijse.dep.orm;

import lk.ijse.dep.orm.entity.Customer;
import lk.ijse.dep.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            Customer nuwan = session.get(Customer.class, 2);
            nuwan.setAddress("Kalaniya");
            System.out.println(nuwan);
            session.refresh(nuwan);
            System.out.println(nuwan);

            session.getTransaction().commit();
        }
    }
}
