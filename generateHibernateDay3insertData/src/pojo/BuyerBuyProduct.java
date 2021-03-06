package pojo;
// Generated Mar 11, 2015 1:49:52 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * BuyerBuyProduct generated by hbm2java
 */
public class BuyerBuyProduct  implements java.io.Serializable {


     private BuyerBuyProductId id;
     private Product product;
     private Buyer buyer;
     private Date paymentDate;
     private float amount;
     private int quantity;

    public BuyerBuyProduct() {
    }

    public BuyerBuyProduct(BuyerBuyProductId id, Product product, Buyer buyer, Date paymentDate, float amount, int quantity) {
       this.id = id;
       this.product = product;
       this.buyer = buyer;
       this.paymentDate = paymentDate;
       this.amount = amount;
       this.quantity = quantity;
    }
   
    public BuyerBuyProductId getId() {
        return this.id;
    }
    
    public void setId(BuyerBuyProductId id) {
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
    public Date getPaymentDate() {
        return this.paymentDate;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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


