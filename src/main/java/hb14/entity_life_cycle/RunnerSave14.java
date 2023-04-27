package hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Student14 student1 = new Student14();  // transient state    -->     Hibernate has no responsibility over this object.
        student1.setName("AAA");
        student1.setGrade(90);

        Student14 student2 = new Student14();
        student2.setName("BBB");
        student2.setGrade(90);

        Student14 student3 = new Student14();
        student3.setName("CCC");
        student3.setGrade(90);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);     // Persisting the object        --> Persisted.
        student1.setName("BBB");    //name of object will be BBB, because it is in persistent state & it's checked

        //persistent obj is taken to detached... this will not be tracked, changes to obj will not be stored to DB.
        //It is like rollback
        session.evict(student1);        // Removing student1        --> Detached State.
        session.clear();        // Clearing the session cache
        student1.setName("CCC");        //obj is still in detached state

        session.update(student1);   //detached obj will be taken into persistent state

        session.merge(student1);

        tx.commit();
        session.close();
        sf.close();
    }
}
