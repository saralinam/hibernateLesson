package hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        //student07 obj using parameter
        Student07 student1= new Student07(1001,"Sara",89);

        //student obj using empty constructor
        Student07 student2= new Student07();
        student2.setId(1002);
        student2.setName("Marian");
        student2.setGrade(90);



        //book object using empty constructor
        Book07 book1= new Book07();
        book1.setId(101);
        book1.setName("Chemistry Book");

        Book07 book2= new Book07();
        book2.setId(102);
        book2.setName("Math Book");

        Book07 book3= new Book07();
        book3.setId(103);
        book3.setName("Physics Book");

        Book07 book4= new Book07();
        book3.setId(104);
        book3.setName("Art Book");

//        student1.getBookList().add(book1);    // our column will be created inside book table
//        student1.getBookList().add(book2);    //  That is why we should a signed students to object
        // otherwise table shows null value
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);




        Configuration con= new Configuration().
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class).
                configure("hibernate.cfg.xml");
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();


        session.save(student1);
        session.save(student2);

        session.save(book1);
        session.save(book2);
        session.save(book3);


        tx.commit();
        sf.close();
        session.close();

    }
}









