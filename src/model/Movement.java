/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author 2dam
 */
public class Movement implements Serializable{
    
    private int id;
    private LocalDateTime timestamp;
    private float amount;
    private float balance;
    private String description;
    private int accountID;

    public Movement() {
    }

    public int getId() {
        return id;
    }
    public int getAccountID(){
        return accountID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    

    public float getAmount() {
        return amount;
    }

    public float getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setAccountID(int accountID){
        this.accountID=accountID;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   /**
    * 
    */ 
    
    
    
}
