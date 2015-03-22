/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generatehibernate;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.User;

/**
 *
 * @author azza
 */
public class Test {
    public static void main(String[] args) {
         Configuration cfg=new Configuration()
                 .configure("/resources/hibernate.cfg.xml");
       cfg.setInterceptor(new UserInterceptor());
       SessionFactory sessionFactory = cfg.buildSessionFactory();
     
            Session session = sessionFactory.openSession();
            User user =new User(); 
            user.setUserName("Test interceptor");
            user.setFullName("azza hamdy");
            user.setDateOfBirth(new Date());
            user.setAddress("suez");
            user.setPhone("123456789");
            user.setEmail("test@mail.com");
            user.setRegistrationDate(new Date());
            user.setPassword("4815162342");
            user.setMobile("01025012646");
            session.save(user);
            session.persist(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("Insertion Done");
    }
}
