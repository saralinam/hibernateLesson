package hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Transient;
import java.util.Arrays;
import java.util.List;

//his class is used to read data
public class RunnerFetch01 {
    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);



       SessionFactory sf= con.buildSessionFactory();

      Session session = sf.openSession();

      Transaction tx= session.beginTransaction();

    /*
        Inorder to fetch data from DB, there are 3 ways
                1. get();
                2. SQL query
                3. HQL query

     */

        //============  1st way: get()  ==============
//       Student01 student1 = session.get(Student01.class, 1001);
//        Student01 student2 = session.get(Student01.class, 1002);
//        Student01 student3 = session.get(Student01.class, 1003);
//
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
        //get method will run select query. If you want to fetch different student each time
        //select query will run

        //============  2st way: SQL query  ==============

//       String sqlQuery = "SELECT * FROM t_student01";
//
//       List<Object[]> resultList=session.createSQLQuery(sqlQuery).getResultList();
//
//       for(Object[] std: resultList){
//           System.out.println(Arrays.toString(std));
//       }




        //============  3st way: HQL query  ==============

//        String hqlQuery1 = "FROM Student01";                  //Student01 is class name
//        List<Student01>resultList2=session.createQuery(hqlQuery1, Student01.class).getResultList();
//
//        for(Student01 std: resultList2) {
//            System.out.println(std);
//        }

        //If you want to fetch some unique data using hql
//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE std_name = 'Cigdem'";
//         Object[]studentCigdem= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(studentCigdem));
//

        //If you want to fetch some unique data using sql
        //System.out.println(studentCigdem[0]+" "+ studentCigdem[1] + " "+ studentCigdem[2]);

        //If you want to fetch some unique data using hql

//        String hqlQuery2 = "FROM Student01 WHERE name = 'Marian'";
//        Student01 std = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(std);
//
         //If you want to fetch more object  based on condition 
        //If you want to fetch students whose id is less than 1003 using hql

//        String hqlQuery3 = "SELECT s.name FROM Student01 s WHERE  s.id = 1002";
//       List<Object[]>resultList =  session.createQuery(hqlQuery3).getResultList();
//       for(Object[] obj: resultList){
//           System.out.println(Arrays.toString(obj));
//       }

       String hqlQuery3 = "SELECT s.name FROM Student01 s WHERE s.id<=1003";
       List<String> resultList = session.createQuery(hqlQuery3).getResultList();
       resultList.forEach(x-> System.out.println(x));



        tx.commit();
      session.close();
      sf.close();

    }
}
