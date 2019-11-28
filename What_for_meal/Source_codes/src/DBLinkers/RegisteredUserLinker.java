package DBLinkers;

import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import BasicEntities.RegisteredUser;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Sam Yan
 */
public class RegisteredUserLinker {

    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    
    //Variables for registered user information.
    private RegisteredUser ruser;

    //Initialize linking environment
    public RegisteredUserLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    public RegisteredUser getRegisteredUser(){
        return ruser;
    }
    
    public void setRegisteredUser(RegisteredUser ruser){
        this.ruser = ruser;
    }//end method
    
    public boolean verifySingleUser(String username, String plainPassword) {

        String strPass = DigestUtils.sha1Hex(plainPassword);

        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            ruser = new RegisteredUser();

            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.registered_user WHERE user_name = ?"
                    + " AND password = ?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, strPass);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ruser.setUserid(resultSet.getInt("iduser"));
                ruser.setUsername(resultSet.getString("user_name"));
                ruser.setPassword(resultSet.getString("password"));
                ruser.setEmail(resultSet.getString("email"));
                Date regDate = resultSet.getDate("registered_date");
                Calendar cal = Calendar.getInstance();
                cal.setTime(regDate);
                ruser.setRegisteredTime(cal);
            }//end loop

            resultSet.close();
            connect.close();

            if(ruser.getUserid() != 0)
                return true;
            else
                return false;
            
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            System.out.println("Password might be wrong!");
            ex.printStackTrace();
            return false;
        }//end try-catch
    }//end method

    //Read information according to information already known (such as primary key):
    public RegisteredUser readSingleUserFromDB(int userID) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");            
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.registered_user WHERE iduser = ?;");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();

            ruser = new RegisteredUser();
            while (resultSet.next()) {
                ruser.setUserid(resultSet.getInt("iduser"));
                ruser.setUsername(resultSet.getString("user_name"));
                ruser.setPassword(resultSet.getString("password"));
                ruser.setEmail(resultSet.getString("email"));
                Date regDate = resultSet.getDate("registered_date");
                Calendar cal = Calendar.getInstance();
                cal.setTime(regDate);
                ruser.setRegisteredTime(cal);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch

        return ruser;
    }//end method
    
    /*Method of registering user to database. Including reading his/her id
    and write his/her information into database. 
    In this case, it is a special method being written in the interface*/
    public void registerUser() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT iduser FROM registered_user order by iduser;");
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData = resultSet.getMetaData();
            
            int maxNewUserID = 1;
            
            while(resultSet.next()){
                if(resultSet.getInt(1) > maxNewUserID)
                    maxNewUserID = resultSet.getInt(1);
            }//end loop
            
            maxNewUserID ++;
            ruser.setUserid(maxNewUserID);
            
            addToDB();
            
            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker! Method: private void registerUser()");
            ex.printStackTrace();
        }//end try-catch

    }//end method

    //Typical writing to database function
    private void addToDB() {
        try {
            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.registered_user "
                    + "VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, ruser.getUserid());
            preparedStatement.setString(2, ruser.getUsername());
            preparedStatement.setString(3, ruser.getPassword());
            preparedStatement.setString(4, ruser.getEmail());
            //Date should be changed from its super class
            Calendar cal = Calendar.getInstance();
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(cal.getTimeInMillis()));
            preparedStatement.executeUpdate();
        } catch(MySQLIntegrityConstraintViolationException ex){
            ex.printStackTrace();
            System.err.println("Duplicated keys might be added! Error: RegisteredUserLinker.java->private void addToDB()");
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker! Method: private void addToDB()");
            ex.printStackTrace();
        }//end try-catch
    }//end method
    
    //Typical updating function.
    public void updateDB() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            String statement = "UPDATE what_to_eat.registered_user "
                        + "SET user_name = ?, password = ?, email = ? "
                        + "WHERE iduser = ?;";                 
            preparedStatement = connect.prepareStatement(statement);                
            preparedStatement.setString(1, ruser.getUsername());
            preparedStatement.setString(2, ruser.getPassword());
            preparedStatement.setString(3, ruser.getEmail());
            preparedStatement.setInt(4, ruser.getUserid());
            preparedStatement.executeUpdate();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
    }//end method    
}//end class
