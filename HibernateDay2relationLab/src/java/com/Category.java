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
public class Category {
    private int id;
    private String value;
    private String description;
    private Set products=new HashSet();
public Category(){}
    public Set getProducts() {
        return products;
    }

    public void setProducts(Set products) {
        this.products = products;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
