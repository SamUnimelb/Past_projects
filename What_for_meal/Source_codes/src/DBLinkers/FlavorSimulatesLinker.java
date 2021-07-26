package DBLinkers;

import BasicEntities.Disease;
import BasicEntities.FlavorSimulates;
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
public class FlavorSimulatesLinker {
    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private FlavorSimulates flavorSimulate;
    private LinkedList<Disease> flavorSimulatesDiseaseList;
    private DiseaseLinker diseaseLinker;

    //Initialize linking environment
    public FlavorSimulatesLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor

    //Read information according to information already known (such as primary key):
    public FlavorSimulates getFlavorSimulates(int flavorID, int diseaseID) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            flavorSimulate = new FlavorSimulates();
            flavorSimulate.setFlavorID(flavorID);
            flavorSimulate.setDiseaseID(diseaseID);
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor_stimulates WHERE fs_flavor = ?"
                    + " and fs_disease_id = ?;");
            preparedStatement.setInt(1, flavorID);
            preparedStatement.setInt(2, diseaseID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flavorSimulate.setReason(resultSet.getString(3));
                flavorSimulate.setResonChinese(resultSet.getString(4));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch

        return flavorSimulate;
    }//end method

    //Read information according to information already known (such as primary key):
    public boolean setFlavorSimulates(FlavorSimulates f) {

        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");

            preparedStatement = connect.prepareStatement("DELETE FROM what_to_eat.flavor_stimulates " +
                "WHERE fs_flavor = ? AND fs_disease_id = ?;");
            preparedStatement.setInt(1, f.getFlavorID());
            preparedStatement.setInt(2, f.getDiseaseID());
            preparedStatement.executeUpdate();

            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.flavor_stimulates "
                    + "VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, f.getFlavorID());
            preparedStatement.setInt(2, f.getDiseaseID());
            preparedStatement.setString(3, f.getReason());
            preparedStatement.setString(4, f.getResonChinese());
            preparedStatement.executeUpdate();

            connect.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
            return false;
        }//end try-catch

    }//end method
    
    /*Return all the potential diseases simulated by a certain flavor.*/
    public LinkedList<Disease> flavorSimulatesDisease(int flavorID){
        flavorSimulatesDiseaseList = new LinkedList<>();
        
         try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor_stimulates WHERE fs_flavor = ?;");
            preparedStatement.setInt(1, flavorID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                diseaseLinker = new DiseaseLinker();
                Disease d = diseaseLinker.readDiseaseInfoFromDB(resultSet.getInt(2));
                flavorSimulatesDiseaseList.add(d);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return flavorSimulatesDiseaseList;
    }//end method

}//end class
