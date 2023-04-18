package hb04.bi_onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get student and dairy by Id using  get method

        Student04 student1 =  session.get(Student04.class,1001);
        System.out.println(student1);
        System.out.println("------------------------");
        Diary04 diary1 =  session.get(Diary04.class,101);
        System.out.println(diary1);

       // System.out.println("************** get diary object over student ***************");
      //  System.out.println(student1.getDiary());
      //  System.out.println("************** get student name through diary object*******");
      //  System.out.println(diary1.getStudent().getName());


       // System.out.println("************** get diary object over student ***************");
//        System.out.println(diary1.getStudent());

//        System.out.println("********** INNER JOIN **********");
//        String hql1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id = d.student.id";
//
//        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
//        resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));


//        System.out.println("********** LEFT JOIN **********");
//        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id = d.student.id";
//
//        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();
//        resultList2.forEach(obj-> System.out.println(Arrays.toString(obj)));


//        System.out.println("********** RIGHT JOIN **********");
//        String hql3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d ON s.id = d.student.id";
//
//        List<Object[]> resultList3 = session.createQuery(hql3).getResultList();
//        resultList3.forEach(obj-> System.out.println(Arrays.toString(obj)));

        System.out.println("********** FULL JOIN **********");
        String hql4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id = d.student.id";

        List<Object[]> resultList4 = session.createQuery(hql4).getResultList();
        resultList4.forEach(obj-> System.out.println(Arrays.toString(obj)));





        // continue for here !!!!!
        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
    }

