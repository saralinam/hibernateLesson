package hb13.get_load_methods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {
    public static void main(String[] args) {


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        System.out.println("******* get methods starts ********");
//        Student13 student1 = session.get(Student13.class, 1L);
//        System.out.println("******* get methods ends ********");
//
//        System.out.println(student1.getId());
//        System.out.println(student1.getName());


//        System.out.println("******* load methods starts ********");
//        Student13 student2 = session.load(Student13.class, 1L);
//        System.out.println("******* load methods ends ********");
//        System.out.println("Get Id: " +student2.getId());
//        System.out.println("Get Name: " +student2.getName());

//        System.out.println("******* get methods starts for data which doesn't exist ********");
//        Student13 student3 = session.get(Student13.class, 10L);
//        //student3 = null
//         if(student3!=null){
//             System.out.println(student3.getName());
//         }
//        System.out.println(student3.getGrade());   //returns NullPointException
//        System.out.println("******* get methods ends ********");



        System.out.println("******* load methods starts for data which doesn't exist in DB ********");
        Student13 student4 = session.load(Student13.class, 4L);  //returns fake/proxy object
        //student4 is not null and it's a fake object whose id is 4
        if(student4!=null){
            System.out.println(student4.getName());
        }
        //System.out.println(student4.getGrade());   //returns ObjectNotFoundException
        System.out.println("******* load methods ends ********");

        //if you are sure that object is in your DB, and if you are not going to use any field (lazy loading),
        //then you can use load method, because it will not fetch data from database, and you will save some time

        tx.commit();
        session.close();
        sf.close();
    }
}
