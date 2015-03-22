/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.SaveOrUpdateEventListener;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;




/**
 *
 * @author azza
 */
public class AccountListener extends DefaultSaveOrUpdateEventListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent soue) throws HibernateException {
        System.out.println("Test");
        if(soue.getObject() instanceof com.Account){
           System.out.println("onSaveOrUpdateListener");
        }
    }
//    public void onSaveOrUpdate(SaveOrUpdateEvent event)throws HibernateException{
//        
//    }
}
