/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static antlr.MismatchedCharException.SET;
import static antlr.MismatchedTokenException.SET;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static org.hibernate.hql.antlr.HqlSqlTokenTypes.SET;
import static org.hibernate.hql.antlr.HqlTokenTypes.SET;
import static org.hibernate.hql.antlr.SqlTokenTypes.SET;

/**
 *
 * @author azza
 */
public class Test {

    public static void main(String[] args) throws IOException, SQLException {
        FileInputStream fileInputStream = null;
        try {
            Configuration cfg=new Configuration();
           // cfg.setListener("save-update", new AccountListener());
            cfg.setNamingStrategy(new NameingStrategy());
            SessionFactory sessionFactory = cfg
                    .configure("/resources/hibernate.cfg.xml").buildSessionFactory();
           
         
            Session session = sessionFactory.openSession();
            Account account = new Account();
            account.setUserName("account10223");
            account.setAddress("smart-iiti");
            account.setPhone("0623661626");
            account.setBirthday(new Date());
            account.setFullName("azza hamdy");
            account.setPassword("4815162342");
            File pic = new File("C:\\Users\\azza\\Documents\\NetBeansProjects\\HibernateDay1\\src\\java\\com\\image.jpg");
            byte[] bFile = new byte[(int) pic.length()];
            fileInputStream = new FileInputStream(pic);
            fileInputStream.read(bFile);
            account.setImage(bFile);
            
            File file = new File("C:\\Users\\azza\\Documents\\NetBeansProjects\\HibernateDay1\\src\\java\\com\\DotNetBookZero11.pdf");
            FileInputStream inputStream = new FileInputStream(file);
            Blob blob = (Blob) Hibernate.getLobCreator(session)
                    .createBlob(inputStream, file.length());
            account.setPic(blob);
            session.saveOrUpdate(account);
            blob.free();
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
            System.out.println("Insertion Done");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileInputStream.close();

            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
