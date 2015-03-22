/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generatehibernate;

import java.io.Serializable;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import pojo.User;

/**
 *
 * @author azza
 */
public class UserInterceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(Object entity,
               Serializable id,
               Object[] state,
               String[] propertyNames,
               Type[] types)
               throws CallbackException{
    if ( entity instanceof User ) {
          System.out.println("Create Operation");      
 }
    return true;
    }
}