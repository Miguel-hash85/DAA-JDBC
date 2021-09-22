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


    
public class Account implements Serializable {

    private int id;
    private String description;
    private double balance;
    private double creditLine;
    private double beginBalance;
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


    public void setDescription(String description) {
        this.description = description;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public double getCreditLine() {
        return creditLine;
    }


    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }


    public double getBeginBalance() {
        return beginBalance;
    }


    public void setBeginBalance(double beginBalance) {
        this.beginBalance = beginBalance;
    }


    public LocalDateTime getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }


    public void setBeginBalanceTimestamp(LocalDateTime beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }
    

}
