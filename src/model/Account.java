/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author 2dam
 */
public class Account {
    
    private int id;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    private LocalDateTime beginBalanceTimestamp;
    private char type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public LocalDateTime getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(LocalDateTime beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    
}
