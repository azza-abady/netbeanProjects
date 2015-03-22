/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author azza
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByManufacturingName", query = "SELECT p FROM Product p WHERE p.manufacturingName = :manufacturingName"),
    @NamedQuery(name = "Product.findByManufacturingDate", query = "SELECT p FROM Product p WHERE p.manufacturingDate = :manufacturingDate"),
    @NamedQuery(name = "Product.findByExpirationDate", query = "SELECT p FROM Product p WHERE p.expirationDate = :expirationDate"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findByOfferedDate", query = "SELECT p FROM Product p WHERE p.offeredDate = :offeredDate"),
    @NamedQuery(name = "Product.findByFinishDate", query = "SELECT p FROM Product p WHERE p.finishDate = :finishDate")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "manufacturing_name")
    private String manufacturingName;
    @Basic(optional = false)
    @Column(name = "manufacturing_date")
    @Temporal(TemporalType.DATE)
    private Date manufacturingDate;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "offered_date")
    @Temporal(TemporalType.DATE)
    private Date offeredDate;
    @Basic(optional = false)
    @Column(name = "finish_date")
    @Temporal(TemporalType.DATE)
    private Date finishDate;
    @ManyToMany(mappedBy = "productCollection")
    private Collection<Category> categoryCollection;
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne
    private Seller sellerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<BuyerBidProduct> buyerBidProductCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<BuyerBuyProduct> buyerBuyProductCollection;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, String manufacturingName, Date manufacturingDate, int quantity, Date offeredDate, Date finishDate) {
        this.id = id;
        this.name = name;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.quantity = quantity;
        this.offeredDate = offeredDate;
        this.finishDate = finishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Seller getSellerId() {
        return sellerId;
    }

    public void setSellerId(Seller sellerId) {
        this.sellerId = sellerId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Product[ id=" + id + " ]";
    }
    
}
