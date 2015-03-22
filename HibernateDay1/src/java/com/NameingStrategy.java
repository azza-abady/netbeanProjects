/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 *
 * @author azza
 */
public class NameingStrategy extends DefaultNamingStrategy{
    public String ClassToTableName (String className){
    if(className.equals("com.Account"))
        return ("account");
    else
        return ("Empty");
    }
}
