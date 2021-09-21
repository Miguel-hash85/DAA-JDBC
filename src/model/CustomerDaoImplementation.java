/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Miguel Sánchez
 */
public class CustomerDaoImplementation implements CustomerDao{
    
    private Connection con;
    private PreparedStatement stmt;
    private Customer customer;
    private ArrayList<Account> accounts;
    
    final String createCustomer="Insert into customer "
                               + "(id, city, email, firstName, lastName, middleInitial, phone, state, street, zip)"
                               + " values (?,?,?,?,?,?,?,?,?,?)";
    
    final String selectCustomer="Select * from customer where id=?";
    final String selectAccounts="Select * from customer_account where id=?";

    @Override
    public void createCustomer(Customer customer) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer checkCustomer(String customerId) throws Exception {
        return customer;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Account> checkCustomerAccounts(String customerId) throws Exception {
        return accounts;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
    
}
