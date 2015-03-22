/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author azza
 */
@Entity
@Table(name = "buyer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buyer.findAll", query = "SELECT b FROM Buyer b"),
    @NamedQuery(name = "Buyer.findById", query = "SELECT b FROM Buyer b WHERE b.id = :id"),
    @NamedQuery(name = "Buyer.findByValue", query = "SELECT b FROM Buyer b WHERE b.value = :value")})
public class Buyer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private Collection<BuyerBidProduct> buyerBidProductCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private Collection<BuyerBuyProduct> buyerBuyProductCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private User userId;

    public Buyer() {
    }

    public Buyer(Integer id) {
        this.id = id;
    }

    public Buyer(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlTransient
    public Collection<BuyerBidProduct> getBuyerBidProductCollection() {
        return buyerBidProductCollection;
    }

    public void setBuyerBidProductCollection(Collection<BuyerBidProduct> buyerBidProductCollection) {
        this.buyerBidProductCollection = buyerBidProductCollection;
    }

    @XmlTransient
    public Collection<BuyerBuyProduct> getBuyerBuyProductCollection() {
        return buyerBuyProductCollection;
    }

    public void setBuyerBuyProductCollection(Collection<BuyerBuyProduct> buyerBuyProductCollection) {
        this.buyerBuyProductCollection = buyerBuyProductCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buyer)) {
            return false;
        }
        Buyer other = (Buyer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Buyer[ id=" + id + " ]";
    }
    
}
