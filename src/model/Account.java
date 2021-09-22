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
public class Account implements Serializable{
    
    private int id;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    private LocalDateTime beginBalanceTimestamp;
    private int type;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getBalance() {
        return balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public LocalDateTime getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public void setBeginBalanceTimestamp(LocalDateTime beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    
}
