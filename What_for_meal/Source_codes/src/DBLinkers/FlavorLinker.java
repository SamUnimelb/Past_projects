package DBLinkers;

import BasicEntities.Flavor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Sam
 */
public class FlavorLinker {
    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    
    //Variables for registered user information.
    private Flavor flavor;
    private LinkedList<Flavor> flavorList;

    //Initialize linking environment
    public FlavorLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    public Flavor getFoodDrink(){
        return flavor;
    }
    
    public void setFoodDrink(Flavor flavor){
        this.flavor = flavor;
    }//end method
   
    //Read information according to information already known (such as primary key):
    public Flavor readTheFlavorInfoFromDB(int flavorID) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            flavor = new Flavor();
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor WHERE idflavor = ?;");
            preparedStatement.setInt(1, flavorID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flavor.setIdFlavor(resultSet.getInt(1));
                flavor.setFlavorName(resultSet.getString(2));
                flavor.setFlavorChineseName(resultSet.getString(3));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in readTheFlavorInfoFromDB()!");
        }//end try-catch

        return flavor;
    }//end method
    
     //Read information according to information already known (such as primary key):
    public Flavor readTheFlavorInfoFromDB(String flavorName, boolean isChinese) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            flavor = new Flavor();
            
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor WHERE flavor_name = ?;");            
            
            if(isChinese)
                preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor WHERE flavor_chinese_name = ?;");

            
            preparedStatement.setString(1, flavorName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flavor.setIdFlavor(resultSet.getInt(1));
                flavor.setFlavorName(resultSet.getString(2));
                flavor.setFlavorChineseName(resultSet.getString(3));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in readTheFlavorInfoFromDB()!");
        }//end try-catch

        return flavor;
    }//end method

    public LinkedList<Flavor> getAllFlavors() {
        flavorList = new LinkedList<>();

        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");  
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flavor = new Flavor();
                flavor.setIdFlavor(resultSet.getInt(1));
                flavor.setFlavorName(resultSet.getString(2));
                flavor.setFlavorChineseName(resultSet.getString(3));
                flavorList.add(flavor);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in readTheFlavorInfoFromDB()!");
        }//end try-catch

        return flavorList;
    }//end method
    
}//end class
