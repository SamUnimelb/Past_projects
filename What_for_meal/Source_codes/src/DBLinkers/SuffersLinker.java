package DBLinkers;

import BasicEntities.Suffers;
import BasicEntities.Disease;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class SuffersLinker {
     //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    
    //Variables for registered user information.
    private Suffers suffers;
    private LinkedList<Disease> diseaseList;
    private DiseaseLinker diseaseLinker;    
    private Disease disease;

    //Initialize linking environment
    public SuffersLinker() {
        
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    /**
     *
     * @param uID
     * @return user's specific diseases.
     */
    public LinkedList<Disease> getUserDiseaseList(int uID) {
        diseaseLinker = new DiseaseLinker();
        diseaseList = new LinkedList<>();
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");

            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.suffers WHERE suffer_uid = ?;");
            preparedStatement.setInt(1, uID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                disease = diseaseLinker.readDiseaseInfoFromDB(resultSet.getInt(2));
                diseaseList.add(disease);
            }//end loop

            resultSet.close();
            connect.close();

        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            System.out.println("Password might be wrong!");
            ex.printStackTrace();
        }//end try-catch

        return diseaseList;
    }//end method

    //Read information according to information already known (such as primary key):
    public boolean setUserSuffersInfo(int userID, LinkedList<Disease> diseaseList) {
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            
            preparedStatement = connect.prepareStatement("DELETE FROM what_to_eat.suffers WHERE suffer_uid = ?;");
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();

            for (Disease disease : diseaseList) {
                //Line doing encryption, should be used with execute update.
                preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.suffers "
                        + "VALUES(?, ?, ?);");
                preparedStatement.setInt(1, userID);
                preparedStatement.setInt(2, disease.getIdDisease());
                Calendar cal = Calendar.getInstance();
                preparedStatement.setTimestamp(3, new java.sql.Timestamp(cal.getTimeInMillis()));
                preparedStatement.executeUpdate();
            }//end loop
        
            connect.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
            return false;
        }//end try-catch
        
    }//end method

}//end class
