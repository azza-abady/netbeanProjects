/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generateday4hibernate;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.Buyer;
import pojo.BuyerBidProduct;
import pojo.BuyerBidProductId;
import pojo.BuyerBuyProduct;
import pojo.BuyerBuyProductId;
import pojo.Category;
import pojo.Product;
import pojo.Seller;
import pojo.User;

/**
 *
 * @author azza
 */
public class GenerateDay4Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       SessionFactory sessionFactory = new Configuration()
                    .configure("/resources/hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            Buyer br=new Buyer();
            Seller sl=new Seller();
            User user =new User();
            Product proud=new Product();
            //Product proud1=new Product();
            Category cate=new Category();
            BuyerBidProduct BuyerbidProduct=new BuyerBidProduct();
            BuyerBuyProduct BuyerbuyProuduct=new BuyerBuyProduct();
            
            
            user.setUserName("anotation");
            user.setFullName("azza hamdy");
            user.setDateOfBirth(new Date());
            user.setAddress("suez");
            user.setPhone("123456789");
            user.setEmail("azza@mail.com");
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
            
            proud2.setName("product3");
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
             
            BuyerbidProduct.setId(new BuyerBidProductId(br.getId(),proud2.getId()));
            session.save(BuyerbidProduct);
            BuyerbuyProuduct.setId(new BuyerBuyProductId(br.getId(), proud.getId()));
            session.save(BuyerbuyProuduct);
            
            session.beginTransaction();
            
            //session.persist(br);
            //session.persist(sl);
           
            session.persist(BuyerbidProduct);
            session.persist(BuyerbuyProuduct);
            
            session.getTransaction().commit();
            session.close();
            System.out.println("Insertion Done");
    }
    
}
