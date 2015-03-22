/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author azza
 */
public class insert {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                    .configure("/resources/hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            Buyer br=new Buyer();
            Seller sl=new Seller();
            User user =new User();
            Product proud=new Product();
            //Product proud1=new Product();
            Category cate=new Category();
            Buyer_bid_Product BuyerbidProduct=new Buyer_bid_Product();
            Buyer_buy_Product BuyerbuyProuduct=new Buyer_buy_Product();
            
            
            user.setUserName("radwa");
            user.setFullName("radwa hamdy");
            user.setBirthDate(new Date());
            user.setAddress("suez");
            user.setPhone("123456789");
            user.setEmail("radwa@mail.com");
            user.setRegistrationDate(new Date());
            user.setPassword("4815162342");
            user.setMobile("01025012646");
            
            
            br.setUser(user);
            br.setValue("Tea");
            
            sl.setUser(user);
            sl.setValue("teaaa");
            
            proud.setName("product1");
            proud.setQuantity(5);
            proud.setExpirationDate(new Date());
            proud.setDescription("firstproduct insert");
            proud.setFinishDate(new Date());
            proud.setManufacturingName("Hibernare");
            proud.setOfferedDate(new Date());
            proud.setManufacturingDate(new Date());
            proud.setSeller(sl);
            
            Product proud2=new Product();
            
            proud2.setName("product10");
            proud2.setQuantity(5);
            proud2.setExpirationDate(new Date());
            proud2.setDescription("firstproduct insert");
            proud2.setFinishDate(new Date());
            proud2.setManufacturingName("Hibernare");
            proud2.setOfferedDate(new Date());
            proud2.setManufacturingDate(new Date());
            proud2.setSeller(sl);
            
            cate.setValue("cate2");
            cate.setDescription("blala");
            cate.getProducts().add(proud2);
            
            
            BuyerbidProduct.setBuyer(br);
            BuyerbidProduct.setProduct(proud2);
            BuyerbidProduct.setDate(new Date());
            BuyerbidProduct.setAmount(4f);
            BuyerbidProduct.setQuantity(2);
            
            BuyerbuyProuduct.setBuyer(br);
            BuyerbuyProuduct.setProduct(proud);
            BuyerbuyProuduct.setPaymentDate(new Date());
            BuyerbuyProuduct.setQuantity(4);
            BuyerbuyProuduct.setAmount(3f);
            
            session.save(user);
            session.save(sl);
            session.save(br);
            session.save(proud);
//            session.save(proud1);
            session.save(proud2);
           
            session.save(cate);
           BuyerBidProductId bidID=  new BuyerBidProductId();
           bidID.setBuyer_Id(br.getId());
           bidID.setProduct_id(proud2.getId());
            BuyerbidProduct.setId(bidID);
            session.save(BuyerbidProduct);
            BuyerBuyProductId buyId=new BuyerBuyProductId();
            buyId.setBuyer_id(br.getId());
            buyId.setProduct_id(proud.getId());
            BuyerbuyProuduct.setId(buyId);
            session.save(BuyerbuyProuduct);
            
            session.beginTransaction();
            
            session.persist(br);
            session.persist(sl);
           
            session.persist(BuyerbidProduct);
            session.persist(BuyerbuyProuduct);
            
            session.getTransaction().commit();
            session.close();
            System.out.println("Insertion Done");
    }
}
