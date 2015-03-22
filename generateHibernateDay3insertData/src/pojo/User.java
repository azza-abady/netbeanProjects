package pojo;
// Generated Mar 11, 2015 1:49:52 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer id;
     private String email;
     private String address;
     private String phone;
     private String mobile;
     private Date dateOfBirth;
     private Date registrationDate;
     private String userName;
     private String password;
     private String fullName;
     private Set buyers = new HashSet(0);
     private Seller seller;

    public User() {
    }

	
    public User(String email, String address, Date registrationDate, String userName, String password) {
        this.email = email;
        this.address = address;
        this.registrationDate = registrationDate;
        this.userName = userName;
        this.password = password;
    }
    public User(String email, String address, String phone, String mobile, Date dateOfBirth, Date registrationDate, String userName, String password, String fullName, Set buyers, Seller seller) {
       this.email = email;
       this.address = address;
       this.phone = phone;
       this.mobile = mobile;
       this.dateOfBirth = dateOfBirth;
       this.registrationDate = registrationDate;
       this.userName = userName;
       this.password = password;
       this.fullName = fullName;
       this.buyers = buyers;
       this.seller = seller;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getRegistrationDate() {
        return this.registrationDate;
    }
    
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Set getBuyers() {
        return this.buyers;
    }
    
    public void setBuyers(Set buyers) {
        this.buyers = buyers;
    }
    public Seller getSeller() {
        return this.seller;
    }
    
    public void setSeller(Seller seller) {
        this.seller = seller;
    }




}


