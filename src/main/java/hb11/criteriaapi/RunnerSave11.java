package hb10.idgeneration;

import hb09.fetchtypes.Book09;
import hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {
        Student10 student1 = new Student10();
        student1.setName("AAA");
        student1.setGrade(98);
        Student10 student2 = new Student10();
        student2.setName("BBB");
        student2.setGrade(98);
        Student10 student3 = new Student10();
        student3.setName("CCC");
        student3.setGrade(98);

        //create 5 book object
        Book09 book1 = new Book09();
        book1.setId(101);
        book1.setName("Math Book");
        Book09 book2 = new Book09();
        book2.setId(102);
        book2.setName("Phys Book");
        Book09 book3 = new Book09();
        book3.setId(103);
        book3.setName("Chemistry Book");
        Book09 book4 = new Book09();
        book4.setId(104);
        book4.setName("Art Book");
        Book09 book5 = new Book09();
        book5.setId(105);
        book5.setName("Hibernate Book");


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //save students
        session.save(student1);
        session.save(student2);
        session.save(student3);



        tx.commit();
        session.close();
        sf.close();
    }
}
