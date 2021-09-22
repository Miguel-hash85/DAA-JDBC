/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 2dam
 */
public class CustomerAccount {
    
    private int idCustomer;
    private int idAccount;

    public CustomerAccount() {
    }

    public CustomerAccount(int idCustomer, int idAccount) {
        this.idCustomer = idCustomer;
        this.idAccount = idAccount;
    }

    /**
     * @return the idCustomer
     */
    public int getIdCustomer() {
        return idCustomer;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * @return the idAccount
     */
    public int getIdAccount() {
        return idAccount;
    }

    /**
     * @param idAccount the idAccount to set
     */
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
    
    
    
    
}
