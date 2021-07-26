/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinkers;

import BasicEntities.AmountUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author SamY
 */
public class AmountMeasurementLinker {
    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    
    private AmountUnit amountUnit;
    private LinkedList<AmountUnit> amountUnitList;
    
        //Initialize linking environment    
    public AmountMeasurementLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
        
    public AmountUnit readActualDiet(int amountUnitID){
                
        try {
            // setup the connection with the DB.
            amountUnit = new AmountUnit();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.amount_measurement WHERE act_uid = ?;");
            preparedStatement.setInt(1, amountUnitID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                amountUnit.setMeasurementID(amountUnitID);
                amountUnit.setMeasurementName(resultSet.getString(2));
                amountUnit.setMeasurementChineseName(resultSet.getString(3));
                amountUnit.setMeasureAmount(resultSet.getDouble(4));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Actual Diet linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return amountUnit;
    }
    
    public LinkedList<AmountUnit> getAllMeasurements(){
         try {
            // setup the connection with the DB.
            amountUnitList = new LinkedList<>();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.amount_measurement ORDER BY measurement_name;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                amountUnit = new AmountUnit();
                amountUnit.setMeasurementID(resultSet.getInt(1));
                amountUnit.setMeasurementName(resultSet.getString(2));
                amountUnit.setMeasurementChineseName(resultSet.getString(3));
                amountUnit.setMeasureAmount(resultSet.getDouble(4));
                amountUnitList.add(amountUnit);
            }//end loop
            
            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch          
        return amountUnitList;
    }//end method
    
}//end class
