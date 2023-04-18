package hb03.uni_onetoone;

import hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

    public static void main(String[] args) {
        // create some Object.
        Student03 student01= new Student03();
        student01.setId(1001);
        student01.setName("cem");
        student01.setGrade(90);

        Student03 student02= new Student03();
        student02.setId(1002);
        student02.setName("yusuf");
        student02.setGrade(91);

        Student03 student03= new Student03();
        student03.setId(1003);
        student03.setName("burak");
        student03.setGrade(95);

        //create dairy Object

        Diary dairy1  = new Diary();
        dairy1.setId(101);
        dairy1.setName("cem's dairy");
        dairy1.setStudent(student01);

        Diary dairy2  = new Diary();
        dairy2.setId(102);
        dairy2.setName("yusuf's dairy");
        dairy2.setStudent(student02);

        Diary dairy3  = new Diary();
        dairy3.setId(103);
        dairy3.setName("burak's dairy");
        dairy3.setStudent(student03);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(dairy1);
        session.save(dairy2);
        session.save(dairy3);

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();




    }
}