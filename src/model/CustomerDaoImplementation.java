/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Miguel Sánchez
 */
public class CustomerDaoImplementation implements CustomerDao{
    
    private Connection con;
    private final DBConnection conection=new DBConnection();
    private PreparedStatement stmt=null;
    private Customer customer;
    private CustomerAccount account;
    private ArrayList<CustomerAccount> accounts;
    private ArrayList<Account> accountsDetail;
    private ArrayList<Customer> customers;
    private ResultSet rs=null;
    private Account cuenta;
    
    final String createCustomer="Insert into customer values(?,?,?,?,?,?,?,?,?,?)";
    
    final String selectCustomer="Select * from customer where id=?";
    final String selectAllCustomers="Select id, firstName from customer";
    final String selectAccounts="Select * from customer_account where customers_id=?";
    final String selectAccount="Select * from account where id=?";

    @Override
    public void createCustomer(Customer customer) throws Exception {
        con=conection.openConnection();
        stmt = con.prepareStatement(createCustomer);
        stmt.setLong(1, customer.getId());
        stmt.setString(2, customer.getCity());
        stmt.setString(3, customer.getEmail());
        stmt.setString(4, customer.getFirstName());
        stmt.setString(5, customer.getLastName());
        stmt.setString(6, customer.getMiddleInitial());
        stmt.setLong(7, customer.getPhone());
        stmt.setString(8, customer.getState());
        stmt.setString(9, customer.getStreet());
        stmt.setInt(10, customer.getZip());
        stmt.executeUpdate();
        conection.closeConnection(stmt, con);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public Customer checkCustomer(long customerId) throws Exception {
        customer=new Customer();
        con=conection.openConnection();
        stmt = con.prepareStatement(selectCustomer);
        stmt.setLong(1, customerId);
        rs = stmt.executeQuery();
        if(rs.next()){
            customer.setId(rs.getLong("id"));
            customer.setCity(rs.getString("city"));
            customer.setEmail(rs.getString("email"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setMiddleInitial(rs.getString("middleInitial"));
            customer.setPhone(rs.getLong("phone"));
            customer.setState(rs.getString("state"));
            customer.setStreet(rs.getString("street"));
            customer.setZip(rs.getInt("zip"));
        }
        if(rs != null)
			rs.close();
        conection.closeConnection(stmt, con);
        return customer;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    /*@Override
    public ArrayList<Account> getAccounts(ArrayList<CustomerAccount> accounts)throws Exception{
        accountsDetail=new ArrayList<>();
        con=conection.openConnection();
        for(int i=0;i<accounts.size();i++){
            stmt = con.prepareStatement(selectAccounts);
            stmt.setLong(1, accounts.get(i).getIdAccount());
            rs = stmt.executeQuery();
            if(rs.next()){
                cuenta=new Account();
                cuenta.setId(rs.getInt("id"));
                cuenta.setDescription(rs.getString("description"));
                cuenta.setBalance(rs.getInt("balance"));
                cuenta.setCreditLine(rs.getInt("creditLine"));
                cuenta.setBeginBalance(rs.getInt("beginBalance"));
                cuenta.setBeginBalanceTimestamp(rs.getTimestamp("beginBalanceTimestamp").toLocalDateTime());
                cuenta.setType(rs.getInt("type"));
                accountsDetail.add(cuenta);
            }
            rs.close();
        }
        conection.closeConnection(stmt, con);
        return accountsDetail;
    }*/

    @Override
    public ArrayList<Customer> getCustomers() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        customers=new ArrayList<>();
        con=conection.openConnection();
        stmt = con.prepareStatement(selectAllCustomers);
        rs=stmt.executeQuery();
        while(rs.next()){
            customer=new Customer();
            customer.setId(rs.getLong("id"));
            customer.setFirstName(rs.getString("firstName"));
            customers.add(customer);
        }
        rs.close();
        conection.closeConnection(stmt, con);
        return customers;
    }

    @Override
    public ArrayList<CustomerAccount> checkCustomerAccounts(long customerId) throws Exception {
        
        accounts=new ArrayList<>();
        con=conection.openConnection();
        stmt = con.prepareStatement(selectAccounts);
        stmt.setLong(1,customerId);
        rs = stmt.executeQuery();
        while(rs.next()){
            account=new CustomerAccount();
            account.setIdCustomer(rs.getLong("customers_id"));
            account.setIdAccount(rs.getLong("accounts_id"));
            accounts.add(account);
        }
        rs.close();
        conection.closeConnection(stmt, con);
        return accounts;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
    
}
