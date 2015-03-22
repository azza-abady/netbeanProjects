/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author azza
 */
@Entity
@Table(name = "buyer_bid_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuyerBidProduct.findAll", query = "SELECT b FROM BuyerBidProduct b"),
    @NamedQuery(name = "BuyerBidProduct.findByBuyerId", query = "SELECT b FROM BuyerBidProduct b WHERE b.buyerBidProductPK.buyerId = :buyerId"),
    @NamedQuery(name = "BuyerBidProduct.findByProductId", query = "SELECT b FROM BuyerBidProduct b WHERE b.buyerBidProductPK.productId = :productId"),
    @NamedQuery(name = "BuyerBidProduct.findByDate", query = "SELECT b FROM BuyerBidProduct b WHERE b.date = :date"),
    @NamedQuery(name = "BuyerBidProduct.findByAmount", query = "SELECT b FROM BuyerBidProduct b WHERE b.amount = :amount"),
    @NamedQuery(name = "BuyerBidProduct.findByQuantity", query = "SELECT b FROM BuyerBidProduct b WHERE b.quantity = :quantity")})
public class BuyerBidProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuyerBidProductPK buyerBidProductPK;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "buyer_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Buyer buyer;

    public BuyerBidProduct() {
    }

    public BuyerBidProduct(BuyerBidProductPK buyerBidProductPK) {
        this.buyerBidProductPK = buyerBidProductPK;
    }

    public BuyerBidProduct(BuyerBidProductPK buyerBidProductPK, Date date, float amount, int quantity) {
        this.buyerBidProductPK = buyerBidProductPK;
        this.date = date;
        this.amount = amount;
        this.quantity = quantity;
    }

    public BuyerBidProduct(int buyerId, int productId) {
        this.buyerBidProductPK = new BuyerBidProductPK(buyerId, productId);
    }

    public BuyerBidProductPK getBuyerBidProductPK() {
        return buyerBidProductPK;
    }

    public void setBuyerBidProductPK(BuyerBidProductPK buyerBidProductPK) {
        this.buyerBidProductPK = buyerBidProductPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buyerBidProductPK != null ? buyerBidProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyerBidProduct)) {
            return false;
        }
        BuyerBidProduct other = (BuyerBidProduct) object;
        if ((this.buyerBidProductPK == null && other.buyerBidProductPK != null) || (this.buyerBidProductPK != null && !this.buyerBidProductPK.equals(other.buyerBidProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.BuyerBidProduct[ buyerBidProductPK=" + buyerBidProductPK + " ]";
    }
    
}
