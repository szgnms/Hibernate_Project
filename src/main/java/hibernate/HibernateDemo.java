package hibernate;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

import java.util.List;


public class HibernateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
              configure("cfg.xml").
               addAnnotatedClass(Patient.class).
                buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            Patient patient = new Patient(1000,"alis","velis","delis",1111);

          session.save(patient);
            List<Patient> plist= session.createQuery("from Patient").list();
            for (Patient p:plist) {
                System.out.println(p);
            }



 tx.commit();
        } finally {
            session.close();
        }
    }
}


