/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 * 
 */
import java.util.ArrayList;

/**
 *
 * @author 2dam
 */
public interface MovementDao {

    /**
     *
     * @param movement
     * @throws Exception
     */
    public void addMovement(Movement movement) throws Exception;
    public ArrayList<Movement> listMovements(long idAccount) throws Exception;
}
