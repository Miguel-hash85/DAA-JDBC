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
    
<<<<<<< HEAD
    private Long idCustomer;
    private Long idAccount;
=======
    private long idCustomer;
    private long idAccount;
>>>>>>> 2cd54c186c930960a878c2bf695874f91efbed5f

    public CustomerAccount() {
    }

    public CustomerAccount(long idCustomer, long idAccount) {
        this.idCustomer = idCustomer;
        this.idAccount = idAccount;
    }

    /**
     * @return the idCustomer
     */
    public long getIdCustomer() {
        return idCustomer;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * @return the idAccount
     */
    public long getIdAccount() {
        return idAccount;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" + "idCustomer=" + idCustomer + ", idAccount=" + idAccount + '}';
    }

    /**
     * @param idAccount the idAccount to set
     */
    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }
    
    
    
    
}
