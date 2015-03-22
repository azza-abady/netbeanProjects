/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.util.Date;

/**
 *
 * @author azza
 */
public class Buyer_bid_Product {

    
   private BuyerBidProductId id;
    private Date Date;
   private float amount;
   private int quantity;
private Buyer buyer;
private Product product;
public Buyer_bid_Product(){}
public BuyerBidProductId getId() {
        return id;
    }

    public void setId(BuyerBidProductId id) {
        this.id = id;
    }
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
   
}
