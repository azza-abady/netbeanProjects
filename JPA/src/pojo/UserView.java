/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author azza
 */
@Entity
@Table(name = "user_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserView.findAll", query = "SELECT u FROM UserView u"),
    @NamedQuery(name = "UserView.findById", query = "SELECT u FROM UserView u WHERE u.id = :id"),
    @NamedQuery(name = "UserView.findByUserName", query = "SELECT u FROM UserView u WHERE u.userName = :userName")})
public class UserView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;

    public UserView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
