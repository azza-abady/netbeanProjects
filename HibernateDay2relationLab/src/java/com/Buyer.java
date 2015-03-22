/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author azza
 */
public class Buyer {
   private int id;
   private String value;
   private User user;
private Set buyer_bid_product =new HashSet();
private Set buyer_buy_product=new HashSet();

   
public Buyer(){}
    public Set getBuyer_bid_product() {
        return buyer_bid_product;
    }

    public void setBuyer_bid_product(Set buyer_bid_product) {
        this.buyer_bid_product = buyer_bid_product;
    }

    public Set getBuyer_buy_product() {
        return buyer_buy_product;
    }

    public void setBuyer_buy_product(Set buyer_buy_product) {
        this.buyer_buy_product = buyer_buy_product;
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    
}
