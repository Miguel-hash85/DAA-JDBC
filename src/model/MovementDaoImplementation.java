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
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author 2dam
 */
public class MovementDaoImplementation implements MovementDao {

    private Connection con;
    private PreparedStatement stmt;
    private DBConnection connection = new DBConnection();
/**
 * 
 * @param movement
 * @throws Exception 
 */
    @Override
    public void addMovement(Movement movement) throws Exception {
        String asignID = "SELECT id FROM bankDB.movement ORDER BY id DESC LIMIT 1";
        String insertMovement = "Insert into movement (id, ammount, balance, description, timestamp,account_id) values (?,?,?,?,?,?) ";
        ResultSet resultSet ;
        int movementID = 0;
       
            con = connection.openConnection();
            stmt = con.prepareStatement("SELECT id FROM movement where balance =200");
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                movementID = resultSet.getInt("id");
            }
            stmt = con.prepareStatement(insertMovement);
            stmt.setInt(1, movementID + 1);
            stmt.setDouble(2, movement.getAmount());
            stmt.setDouble(3, movement.getBalance());
            stmt.setString(4, movement.getDescription());
            stmt.setTimestamp(4, Timestamp.valueOf(movement.getTimestamp()));
            stmt.setLong(6, movement.getAccountID());
            stmt.executeUpdate();
            connection.closeConnection(stmt, con);
            resultSet.close();
        

    }

    @Override
    public ArrayList<Movement> listMovements() throws Exception {
        String searchMovements="Select * from movements where account_id=?";
        ResultSet resultSet ;
        Movement movement;

        ArrayList<Movement> movements = new ArrayList<Movement>();
        con = connection.openConnection();
            stmt=con.prepareStatement(searchMovements);
            resultSet=stmt.executeQuery();
            while(resultSet.next()){
                movement=new Movement();
                movement.setId(resultSet.getInt(1));
                movement.setAmount((float) resultSet.getDouble(2));
                movement.setBalance((float) resultSet.getDouble(3));
                movement.setDescription(resultSet.getString(4));
                movement.setTimestamp(resultSet.getTimestamp(5).toLocalDateTime());
                movement.setAccountID(resultSet.getLong(6));
                movements.add(movement);
            }
       
            connection.closeConnection(stmt, con);
            resultSet.close();
        return movements;
    }

}
