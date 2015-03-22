/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author azza
 */
@Embeddable
public class BuyerBidProductPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "buyer_id")
    private int buyerId;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;

    public BuyerBidProductPK() {
    }

    public BuyerBidProductPK(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) buyerId;
        hash += (int) productId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyerBidProductPK)) {
            return false;
        }
        BuyerBidProductPK other = (BuyerBidProductPK) object;
        if (this.buyerId != other.buyerId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.BuyerBidProductPK[ buyerId=" + buyerId + ", productId=" + productId + " ]";
    }
    
}
