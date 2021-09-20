/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import clases.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dam
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PreparedStatement stmt=null;
        ResultSet resultSet=null;
        DBConnection con=new DBConnection();
        Connection conector = null;
        
        String select="select id from account where type='true'";
        
        try {
            conector=con.openConnection();
            stmt = conector.prepareStatement(select);
            resultSet=stmt.executeQuery();
            if(resultSet.next()){
                System.out.println(resultSet.getString("id"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.closeConnection(stmt,conector);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        System.out.println(select);
        
    }
    
}
