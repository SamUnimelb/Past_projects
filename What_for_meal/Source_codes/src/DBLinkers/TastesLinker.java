/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinkers;

import BasicEntities.Flavor;
import BasicEntities.FoodDrink;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class TastesLinker {
    //Variables for database linking:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    //Variables for this table:
    private Flavor flavor;
    private FoodDrink foodDrink;
    private FlavorLinker flavorLinker;
    private RegisteredUserLinker rUserLinker;
    private LinkedList<Flavor> foodDrinkFlavorList;
    
    public TastesLinker(){
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end cons
    
    public LinkedList<Flavor> getFoodFlavorList(int foodDrinkID){
        //List recording the flavors one user prefers.
        foodDrinkFlavorList = new LinkedList<>();
        flavorLinker = new FlavorLinker();
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.tastes WHERE taste_food_id = ?;");
            preparedStatement.setInt(1, foodDrinkID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flavor f = new Flavor();
                //System.out.println(resultSet.getInt(2));
                f.setIdFlavor(resultSet.getInt(2));
                f = flavorLinker.readTheFlavorInfoFromDB(f.getIdFlavor());
                foodDrinkFlavorList.add(f);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return foodDrinkFlavorList;
    }//end method
    
    public boolean storeUserFlavorInfo(LinkedList<Flavor> foodFlavors, int foodDrinkID){
        //List recording the flavors one user prefers and his/her user id.
       foodDrinkFlavorList = foodFlavors;
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("DELETE FROM tastes WHERE taste_food_id = ?;");
            preparedStatement.setInt(1, foodDrinkID);
            preparedStatement.executeUpdate();
            
            for(Flavor flavor : foodDrinkFlavorList){
                preparedStatement = connect.prepareStatement("INSERT INTO tastes VALUES(?, ?);");
                preparedStatement.setInt(1, foodDrinkID);
                preparedStatement.setInt(2, flavor.getIdFlavor());                
                preparedStatement.executeUpdate();
            }//end loop
            
            connect.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error in Registered linker! Method: public boolean addDisease()");
            return false;
        }//end try-catch
        
    }//end method
}//end class
