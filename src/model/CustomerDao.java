/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Miguel Sánchez
 */
public interface CustomerDao {
    
    public void createCustomer (Customer customer) throws Exception;
    public Customer checkCustomer (int customerId)throws Exception;
    public void checkCustomerAccounts (int customerId)throws Exception;
    public ArrayList<Account> getAccounts(ArrayList<CustomerAccount> account)throws Exception;
    public ArrayList<Customer> getCustomers() throws Exception;
    
}
