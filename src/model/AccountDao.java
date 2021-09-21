/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;

/**
 *
 * @author 2dam
 */
public interface AccountDao {
    public void addCustomerToAccount(int idClient,int idAccount) throws Exception;
    public void createAccount(Account account) throws Exception;
    public Account consultAccountDetails(int idAccount) throws Exception;
    public void listAccountsId() throws Exception;
}
