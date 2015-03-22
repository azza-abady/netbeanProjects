/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author azza
 */
public class test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                    .configure("/resources/hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
           
            Student s1=new Student();
            Teacher t1=new Teacher();
            s1.setFirstName("azzas");
            s1.setLastName("hamdy2");
            s1.setDepartment("EWD");
            t1.setFirstName("eman");
            t1.setLastName("hesham");
            t1.setHireDate(new Date());
       
            session.save(t1);
            session.save(s1);
            session.beginTransaction();
        
            session.persist(t1);
            session.persist(s1);
            session.getTransaction().commit();
            System.out.println("Insertion Done");
    }
}
