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
@Table(name = "buyer_buy_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuyerBuyProduct.findAll", query = "SELECT b FROM BuyerBuyProduct b"),
    @NamedQuery(name = "BuyerBuyProduct.findByBuyerId", query = "SELECT b FROM BuyerBuyProduct b WHERE b.buyerBuyProductPK.buyerId = :buyerId"),
    @NamedQuery(name = "BuyerBuyProduct.findByProductId", query = "SELECT b FROM BuyerBuyProduct b WHERE b.buyerBuyProductPK.productId = :productId"),
    @NamedQuery(name = "BuyerBuyProduct.findByPaymentDate", query = "SELECT b FROM BuyerBuyProduct b WHERE b.paymentDate = :paymentDate"),
    @NamedQuery(name = "BuyerBuyProduct.findByAmount", query = "SELECT b FROM BuyerBuyProduct b WHERE b.amount = :amount"),
    @NamedQuery(name = "BuyerBuyProduct.findByQuantity", query = "SELECT b FROM BuyerBuyProduct b WHERE b.quantity = :quantity")})
public class BuyerBuyProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuyerBuyProductPK buyerBuyProductPK;
    @Basic(optional = false)
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
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

    public BuyerBuyProduct() {
    }

    public BuyerBuyProduct(BuyerBuyProductPK buyerBuyProductPK) {
        this.buyerBuyProductPK = buyerBuyProductPK;
    }

    public BuyerBuyProduct(BuyerBuyProductPK buyerBuyProductPK, Date paymentDate, float amount, int quantity) {
        this.buyerBuyProductPK = buyerBuyProductPK;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.quantity = quantity;
    }

    public BuyerBuyProduct(int buyerId, int productId) {
        this.buyerBuyProductPK = new BuyerBuyProductPK(buyerId, productId);
    }

    public BuyerBuyProductPK getBuyerBuyProductPK() {
        return buyerBuyProductPK;
    }

    public void setBuyerBuyProductPK(BuyerBuyProductPK buyerBuyProductPK) {
        this.buyerBuyProductPK = buyerBuyProductPK;
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
        hash += (buyerBuyProductPK != null ? buyerBuyProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyerBuyProduct)) {
            return false;
        }
        BuyerBuyProduct other = (BuyerBuyProduct) object;
        if ((this.buyerBuyProductPK == null && other.buyerBuyProductPK != null) || (this.buyerBuyProductPK != null && !this.buyerBuyProductPK.equals(other.buyerBuyProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.BuyerBuyProduct[ buyerBuyProductPK=" + buyerBuyProductPK + " ]";
    }
    
}
