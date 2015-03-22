/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQL;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.Buyer;
import pojo.BuyerBidProduct;
import pojo.BuyerBidProductId;
import pojo.BuyerBuyProduct;
import pojo.Category;
import pojo.Product;
import pojo.User;
import pojo.UserView;

/**
 *
 * @author azza
 */
public class HQLquries {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("/resources/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        //query1
        String quryS1 = "from Product p where(select s.value from p.categories s)like 'cate2'";
        Query qury1 = session.createQuery(quryS1);
        List res = qury1.list();
        for (Object o : res) {
            Product product = (Product) o;
            String name = product.getName();
            System.out.println(name);
        }
        ///query2
        String quryS2 = "from Product p, BuyerBidProduct bid where p.name='product4'";
        Query qury2 = session.createQuery(quryS2);
        Iterator res2 = qury2.list().iterator();
        while (res2.hasNext()) {
            Object[] o = (Object[]) res2.next();
            Product p = (Product) o[0];
            String pName = p.getName();
            BuyerBidProduct bid = (BuyerBidProduct) o[1];
            Buyer b = bid.getBuyer();
            String name = b.getUser().getUserName();
            System.out.println("name of Buyers bid on the " + pName + " is " + name);
        }
        //query3
        String quryS3 = "select p.name , SUM(buy.amount*buy.quantity)from BuyerBuyProduct buy,Product p where p.name='product10'";
        Query qury3 = session.createQuery(quryS3);
        Iterator res3 = qury3.list().iterator();
        while (res3.hasNext()) {
            Object[] o = (Object[]) res3.next();
            String p = (String) o[0];
            double buy = (double) o[1];
            System.out.println("Product name " + p + " price " + buy);
        }
        ////stored procedure
        Query query = session.getNamedQuery("callUserStoreProcedure")
                .setParameter("userId", "25");
        List result = query.list();
        for (int i = 0; i < result.size(); i++) {
            User user = (User) result.get(i);
            System.out.println(user.getFullName());
        }
        ///view
       String view="from UserView";
       Query quView=session.createQuery(view);
       List resView = quView.list();
        for (Object o : resView) {
            UserView username = (UserView) o;
            String name = username.getUser_name();
            System.out.println(name);
        }
    }
}
