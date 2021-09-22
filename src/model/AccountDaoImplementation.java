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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dam
 */
public class AccountDaoImplementation implements AccountDao {

    private Connection con;
    private PreparedStatement stmt;
    private DBConnection connection = new DBConnection();

    @Override
    public void createAccount(Account account) throws Exception {
        con = connection.openConnection();
        try {
            stmt = con.prepareStatement("insert into bankdb.account values(?,?,?,?,?,?,?)");
            stmt.setInt(1, account.getId());
            stmt.setDouble(2, account.getBalance());
            stmt.setDouble(3, account.getBeginBalance());
            stmt.setTimestamp(4, Timestamp.valueOf(account.getBeginBalanceTimestamp()));
            stmt.setDouble(5, account.getCreditLine());
            stmt.setString(6, account.getDescription());
            stmt.setInt(7, account.getType());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, con);
        }
    }
    /**
     * 
     * @param idAccount
     * @return
     * @throws Exception 
     */
    @Override
    public Account consultAccountDetails(int idAccount) throws Exception {
        ResultSet rs;
        Account account = null;
        con = connection.openConnection();
        stmt = con.prepareStatement("select * from bankdb.account where id=?");
        stmt.setInt(1, idAccount);
        rs = stmt.executeQuery();
        if (rs.next()) {
            account = new Account();
            account.setId(idAccount);
            account.setBalance(rs.getDouble("Balance"));
            account.setBeginBalance(rs.getDouble("BeginBalance"));
            account.setBeginBalanceTimestamp(rs.getTimestamp("BeginBalanceTimestamp").toLocalDateTime());
            account.setCreditLine(rs.getDouble("CreditLine"));
            account.setDescription(rs.getString("Description"));
            account.setType(rs.getInt("Type"));
        }
        rs.close();
        connection.closeConnection(stmt, con);
        return account;
    }
    /**
     * 
     * @param idClient
     * @param idAccount
     * @throws Exception 
     */
    @Override
    public void addCustomerToAccount(int idClient, int idAccount) throws Exception {
         con=connection.openConnection();
         stmt=con.prepareStatement("insert into bankdb.customer_account values(?,?)");
         stmt.setInt(1,idClient);
         stmt.setInt(2,idAccount);
         stmt.executeUpdate();
         connection.closeConnection(stmt, con);
    }
    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public Set listAccountsId() throws Exception {
        ResultSet rs; 
        Set<Integer>accountsId=new HashSet<>();
        con = connection.openConnection();
        stmt = con.prepareStatement("select id from bankdb.account");
        rs = stmt.executeQuery();
        while (rs.next()) {
            accountsId.add(rs.getInt(1));
        }
        rs.close();
        connection.closeConnection(stmt, con);
        return accountsId;
    }
    /**
     * 
     * @param accountId
     * @return
     * @throws Exception 
     */
    @Override
    public boolean searchAccountId(int accountId) throws Exception {
        ResultSet rs;
        boolean is=false;
        con = connection.openConnection();
        stmt = con.prepareStatement("select id from bankdb.account");
        rs = stmt.executeQuery();
        while (rs.next()) {
            if(rs.getInt(1)==accountId)
                is=true;
        }
        rs.close();
        connection.closeConnection(stmt, con);
        return is;
    }

}
