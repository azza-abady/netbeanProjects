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
public class Buyer_buy_Product {
  private BuyerBuyProductId id;
   private Date paymentDate;
   private float amount;
   private int quantity;
   private Buyer buyer;
   private Product product;

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

    

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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

    public BuyerBuyProductId getId() {
        return id;
    }

    public void setId(BuyerBuyProductId id) {
        this.id = id;
    }
    
    public Buyer_buy_Product(){}
}
