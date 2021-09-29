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
    private double amount;
    private double balance;
    private String description;
<<<<<<< HEAD
    private Long accountID;
=======
    private long accountID;
>>>>>>> 2cd54c186c930960a878c2bf695874f91efbed5f

    public Movement() {
    }

    public int getId() {
        return id;
    }
<<<<<<< HEAD
    public Long getAccountID(){
=======
    public long getAccountID(){
>>>>>>> 2cd54c186c930960a878c2bf695874f91efbed5f
        return accountID;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    public void setAccountID(Long accountID){
=======
    public void setAccountID(long accountID){
>>>>>>> 2cd54c186c930960a878c2bf695874f91efbed5f
        this.accountID=accountID;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
