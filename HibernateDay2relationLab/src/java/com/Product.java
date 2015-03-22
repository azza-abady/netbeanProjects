/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author azza
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private String manufacturingName;
    private Date manufacturingDate;
    private Date expirationDate;
    private int quantity;
    private Date finishDate;
    private Date offeredDate;
    private Seller seller;
    private Set categories =new HashSet();
    private Set buyer_bid_product =new HashSet();
    private Set buyer_buy_product=new HashSet();
    
    public Set getCategories() {
        return categories;
    }
public Product(){}
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

    

    public void setCategories(Set categories) {
        this.categories = categories;
    }

    
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturingName() {
        return manufacturingName;
    }

    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOfferedDate() {
        return offeredDate;
    }

    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    
   
}
