/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author azza
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       int count=(int) se.getSession().getServletContext().getAttribute("online");
       count++;
        se.getSession().getServletContext().setAttribute("online", count);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int count=(int)se.getSession().getServletContext().getAttribute("online");
        count--;
        se.getSession().getServletContext().setAttribute("online", count);//To change body of generated methods, choose Tools | Templates.
    }
}
