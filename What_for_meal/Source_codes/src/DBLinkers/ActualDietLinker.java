package DBLinkers;

import BasicEntities.ActualDiet;
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
public class ActualDietLinker {
    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private ActualDiet actualDiet;
    private LinkedList<ActualDiet> userActualDiet;
    
        //Initialize linking environment    
    public ActualDietLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
        
    public LinkedList<ActualDiet> readActualDiet(int rUserID){
                
        try {
            // setup the connection with the DB.
            userActualDiet = new LinkedList<>();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.actual_diet WHERE act_uid = ?;");
            preparedStatement.setInt(1, rUserID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actualDiet = new ActualDiet();
                actualDiet.setUserID(rUserID);
                actualDiet.setFoodDrinkID(resultSet.getInt(2));
                Timestamp ts = resultSet.getTimestamp(3);
                Calendar cal = Calendar.getInstance();
                cal.setTime(ts);
                actualDiet.setTimeAte(cal);
                actualDiet.setUnitAmount(resultSet.getInt(4));
                actualDiet.setMeasurementID(resultSet.getInt(5));
                userActualDiet.add(actualDiet);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Actual Diet linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return userActualDiet;
    }

    public boolean writeUserActualDiet(int rUserID, ActualDiet userActualDiet) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");

            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.actual_diet "
                    + "VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, rUserID);
            preparedStatement.setInt(2, userActualDiet.getFoodDrinkID());
            Calendar cal = Calendar.getInstance();
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(cal.getTimeInMillis()));
            preparedStatement.setDouble(4, userActualDiet.getUnitAmount());
            preparedStatement.setInt(5, userActualDiet.getMeasurementID());
            preparedStatement.executeUpdate();

            connect.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
            return false;
        }//end try-catch
    }//end method
    
}//end class
