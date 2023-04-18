package hb03.uni_onetoone;
import hb02.embeddable.Student02;
import hb04.bi_onetoone.Diary04;
import hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RunnerFetch03 {
    public static void main(String[] args) {
        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("************** using get() fetch Students*************");
        Student03 student1=  session.get(Student03.class,1001);
        System.out.println(student1);

        System.out.println("************** using get() fetch diary*************");
        Diary diary1 = session.get(Diary.class, 101);
        System.out.println(diary1);

        System.out.println("************** using get() fetch student from diary*************");
        System.out.println(diary1.getStudent());


        // get student and dairy by Id using  get method

        Student04 student01 = session.get(Student04.class, 1001);
        System.out.println(student01);

        System.out.println("----------------------------------");

        Diary04 diary=session.get(Diary04.class, 101);
        System.out.println(diary1);

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}