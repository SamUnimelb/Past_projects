package DBLinkers;

import BasicEntities.Peforms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author SamY
 */
public class PerformsLinker {
    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public PerformsLinker(){
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end cons
    
    public boolean addPerformRecord(Peforms perform){
         try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");

            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.performs "
                    + "VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, perform.getRUserID());
            preparedStatement.setInt(2, perform.getActivityID());            
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(perform.getStartTime().getTimeInMillis()));
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(perform.getEndTime().getTimeInMillis()));
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
