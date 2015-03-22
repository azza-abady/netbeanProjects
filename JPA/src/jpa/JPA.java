/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.User;

/**
 *
 * @author azza
 */
public class JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAPU" );
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction().begin();

      User user = new User(); 
     
   user.setUserName("JPA");
            user.setFullName("Standard JPA");
            user.setDateOfBirth(new Date());
            user.setAddress("iti");
            user.setPhone("123456789");
            user.setEmail("JPA@mail.com");
            user.setRegistrationDate(new Date());
            user.setPassword("4815162342");
            user.setMobile("01025012646");
      
      entitymanager.persist(user);
      entitymanager.getTransaction().commit();

      entitymanager.close();
      emfactory.close();
        System.out.println("insertion Done");
    }
    
}
