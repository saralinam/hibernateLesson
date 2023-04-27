package hb09.fetchtypes;
/*
   Lazy - we use when we need (only important data which you request )
   Eager - bring all data in one fetch
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //get student1 using get
       Student09 student = session.get(Student09.class, 1001);
      //  System.out.println(student1);


//        Book09 book = session.get(Book09.class, 101);
//        for(Book09 book: student.getBookList()){
//            System.out.println(book);
//        }




        tx.commit();
        session.close();

        //since we set fetch type to Eager, in our RAM student object will store all info about book...
        //so when we to get book info after session close we can get it

        for(Book09 book: student.getBookList()){
            System.out.println(book);
        }
        sf.close();
    }
}
