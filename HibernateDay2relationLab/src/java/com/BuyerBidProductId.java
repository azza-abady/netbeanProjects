/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.io.Serializable;

/**
 *
 * @author azza
 */
public class BuyerBidProductId implements Serializable{
    private int buyer_Id;
    private int product_id;

    public BuyerBidProductId(){}
    public int getBuyer_Id() {
        return buyer_Id;
    }

    public void setBuyer_Id(int buyer_Id) {
        this.buyer_Id = buyer_Id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    
}
