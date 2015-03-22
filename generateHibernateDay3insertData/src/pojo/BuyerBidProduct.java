package pojo;
// Generated Mar 11, 2015 1:49:52 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * BuyerBidProduct generated by hbm2java
 */
public class BuyerBidProduct  implements java.io.Serializable {


     private BuyerBidProductId id;
     private Product product;
     private Buyer buyer;
     private Date date;
     private float amount;
     private int quantity;

    public BuyerBidProduct() {
    }

    public BuyerBidProduct(BuyerBidProductId id, Product product, Buyer buyer, Date date, float amount, int quantity) {
       this.id = id;
       this.product = product;
       this.buyer = buyer;
       this.date = date;
       this.amount = amount;
       this.quantity = quantity;
    }
   
    public BuyerBidProductId getId() {
        return this.id;
    }
    
    public void setId(BuyerBidProductId id) {
        this.id = id;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Buyer getBuyer() {
        return this.buyer;
    }
    
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public float getAmount() {
        return this.amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


