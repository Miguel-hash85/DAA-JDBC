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
    private DBConnection conection = new DBConnection();

  

    @Override
    public void createAccount(Account account) throws Exception{
       con=conection.openConnection();
        try {    
            stmt=con.prepareStatement("insert into bankdb.account values(?,?,?,?,?,?,?)");
            stmt.setInt(1,account.getId());
            stmt.setDouble(2,account.getBalance());
            stmt.setDouble(3,account.getBeginBalance());
            stmt.setTimestamp(4,Timestamp.valueOf(account.getBeginBalanceTimestamp()));
            stmt.setDouble(5,account.getCreditLine());
            stmt.setString(6,account.getDescription());
            stmt.setInt(7,account.getType());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                conection.closeConnection(stmt, con);
        }
    }

    @Override
    public Account consultAccountDetails(int idAccount) throws Exception{
        ResultSet rs = null;
        con=conection.openConnection();
        stmt=con.prepareStatement("select * from bankdb.account where id=?");
        stmt.setInt(1, idAccount);
        rs=stmt.executeQuery();
        if(rs.next()){
            
        }
        return null;
    }

    @Override
    public void addCustomerToAccount(String idClient) throws Exception{
        
    }

}
