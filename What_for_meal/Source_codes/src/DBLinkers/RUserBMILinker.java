package DBLinkers;

import BasicEntities.RegisteredUserBMI;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Administrator
 */
public class RUserBMILinker {
     //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    
    //Variables for registered user information.
    private RegisteredUserBMI rUserBMI;

    //Initialize linking environment
    public RUserBMILinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    public void setRUserBMI(RegisteredUserBMI rUserBMI){ this.rUserBMI = rUserBMI; }//end method
   
    //Read information according to information already known (such as primary key):
    public RegisteredUserBMI readAvgRUserBMIFromDB(int userID) {
        List<RegisteredUserBMI> rUserBMIList = new ArrayList<>();
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");            
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.registered_user_bmi WHERE BMI_uid = ? "
                    + "ORDER BY Measured_time DESC;");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            
            int numOfRecords = 0;

            //Only calculate BMI for recent 7 times.
            while (resultSet.next()  && numOfRecords < 7) {
                rUserBMI = new RegisteredUserBMI();
                rUserBMI.setHeight(resultSet.getFloat(3));
                rUserBMI.setWeight(resultSet.getFloat(4));
                rUserBMIList.add(rUserBMI);
                numOfRecords ++;
            }//end loop
            
            if(numOfRecords == 0)
                return null;

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
        
        double sumHeight = 0, avgHeight = 0, sumWeight = 0, avgWeight = 0;
        
        for(RegisteredUserBMI eachUBMI : rUserBMIList){
            sumHeight += eachUBMI.getHeight();
            sumWeight += eachUBMI.getWeight();
        }//end loop
        
        avgHeight = sumHeight * 1.0 / rUserBMIList.size();
        avgWeight = sumWeight * 1.0 / rUserBMIList.size();
        rUserBMI.setRUserID(userID);
        Calendar cal = Calendar.getInstance();
        rUserBMI.setMeasuredTime(cal);
        rUserBMI.setHeight(avgHeight);
        rUserBMI.setWeight(avgWeight);
        
        return rUserBMI;
    }//end method
  
    /**Method of adding new user BMI information to database. 
     * Typical writing to database functio
     * @return n*/
    public boolean addUserBMIToDB() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.registered_user_bmi "
                    + "VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, rUserBMI.getRUserID());
            Calendar cal = Calendar.getInstance();
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(cal.getTimeInMillis()));
            preparedStatement.setFloat(3, (float)rUserBMI.getHeight());
            preparedStatement.setFloat(4, (float)rUserBMI.getWeight());            
            preparedStatement.executeUpdate();
            
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //ex.printStackTrace();
            System.err.println("Duplicated keys might be added! Error: FoodDrinkLinker.java->private void addToDB()");
            return false;
        } catch (SQLException ex) {
            System.err.println("Error in FoodDrinkLinker! Method: private boolean addToDB()");
            return false;
        }//end try-catch
        
        return true;
    }//end method
    
    //Typical updating function.
    public boolean cleanUserBMIInfo() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("DELETE FROM what_to_eat.registered_user_bmi "
                  + "WHERE BMI_uid = ?;");
            
            preparedStatement.setInt(1, rUserBMI.getRUserID());
            preparedStatement.executeUpdate();
            connect.close();
            resultSet.close();
            return true;
        } catch (MySQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            System.err.println("Duplicated keys might be added! Error: RegisteredUserLinker.java-> public boolean updateFoodDrink() ");
            return false;
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker! Method: public boolean updateFoodDrink() ");
            ex.printStackTrace();
            return false;
        }//end try-catch        
    }//end method    
   
}//end class
