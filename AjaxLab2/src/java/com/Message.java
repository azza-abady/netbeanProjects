/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.util.Date;

/**
 *
 * @author azza
 */
public class Message {
    private String userName;
    private int id;
    private String msg;
    private Date msgDate;

    public Message(String userName, int id, String msg, Date msgDate) {
        this.userName = userName;
        this.id = id;
        this.msg = msg;
        this.msgDate = msgDate;
    }
public Message(){}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }
    
}
