/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HQL;

import static java.sql.Types.INTEGER;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.*;
import static org.hibernate.type.StandardBasicTypes.INTEGER;
import pojo.Buyer;
import pojo.BuyerBidProduct;
import pojo.BuyerBuyProduct;
import pojo.Product;

/**
 *
 * @author azza
 */
public class CriteriaQuery {
    public static void main(String[] args) {
         SessionFactory sessionFactory = new Configuration()
                    .configure("/resources/hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            ///query1
            Criteria Criteria1=session.createCriteria(pojo.Product.class).createAlias("categories", "c")
                    .add(Restrictions.eq("c.value","cate2"));
             List res=Criteria1.list();
           for(Object o:res ){
                Product product=(Product)o;
                String name= product.getName();
                System.out.println(name);
            }
           ///query2
            Criteria Criteria2=session.createCriteria(pojo.BuyerBidProduct.class).createCriteria("product","p").add(Restrictions.eq("p.name","product4"));
            Iterator res2=Criteria2.list().iterator();
             while(res2.hasNext()){
             Object o=(Object)res2.next();
          //Product p=(Product)o[0];
          //String pName=p.getName();
            BuyerBidProduct bid=(BuyerBidProduct) o;
            Buyer b=bid.getBuyer();
            String pName =bid.getProduct().getName();
            String name= b.getUser().getUserName();
                System.out.println("name of Buyers " +name+" who bid on  "+pName);
            }
            ///query3 
//           Type[] type={StandardBasicTypes.DOUBLE};
//           List<Double> criteria3=session.createCriteria(pojo.BuyerBuyProduct.class)
//                      .setProjection(Projections.projectionList()
//                     .add(Projections.sqlProjection("sum(amount * quantity) as total",new String[]{"total"}, type))).list();
//           Iterator res3=criteria3.iterator();
//           while(res3.hasNext()){
//           Double o=(Double)res3.next();
//               System.out.println( " price of product "+o );
//             }        
        
    }
}
