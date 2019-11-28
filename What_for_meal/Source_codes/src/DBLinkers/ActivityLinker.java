package DBLinkers;

import BasicEntities.Activity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author SamY
 */
public class ActivityLinker {
     //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private Activity activity;
    private LinkedList<Activity> activityList;
    
        //Initialize linking environment    
    public ActivityLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    public Activity getActivity(int activityID){
        
        try {
            // setup the connection with the DB.            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.activity WHERE idactivity = ?;");
            preparedStatement.setInt(1, activityID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                activity = new Activity();
                activity.setActivityID(activityID);
                activity.setActivityName(resultSet.getString(2));
                activity.setActivityChineseName(resultSet.getString(3));
                activity.setKcalPerUnit(resultSet.getDouble(4));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Actual Diet linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return activity;
    }//end method
    
    public LinkedList<Activity> getAllActivities(){
        activityList = new LinkedList<>();
        
        try {
            // setup the connection with the DB.            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.activity ORDER BY items;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                activity = new Activity();
                activity.setActivityID(resultSet.getInt(1));
                activity.setActivityName(resultSet.getString(2));
                activity.setActivityChineseName(resultSet.getString(3));
                activity.setKcalPerUnit(resultSet.getDouble(4));
                activityList.add(activity);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Actual Diet linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return activityList;
    }//end method    
    
    public boolean addActivity(Activity activity){
        try {
            // setup the connection with the DB.            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT idactivity FROM what_to_eat.activity ORDER BY idactivity DESC;");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            int newActID = resultSet.getInt(1) + 1;
            
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.activity VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, newActID);
            preparedStatement.setString(2, activity.getActivityName());
            preparedStatement.setString(3, activity.getActivityChineseName());
            preparedStatement.setDouble(4, activity.getKcalPerUnit());
            preparedStatement.executeUpdate();
            
            resultSet.close();
            connect.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error in Actual Diet linker!");
            ex.printStackTrace();
            return false;
        }//end try-catch      
        
    }//end method
    
}//end class
