package DBLinkers;

import BasicEntities.Disease;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Sam
 */
public class DiseaseLinker {
     //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //Variables for registered user information.
    private Disease disease;
    private LinkedList<Disease> diseaseList;

    //Initialize linking environment
    public DiseaseLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    public Disease getDisease(){ return disease; }
    
    public void setDisease(Disease disease){ this.disease = disease; }//end method
   
    //Read information according to information already known (such as primary key):
    public Disease readDiseaseInfoFromDB(int diseaseID) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            disease = new Disease();
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.disease WHERE iddisease = ?;");
            preparedStatement.setInt(1, diseaseID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                disease.setIdDisease(resultSet.getInt(1));
                disease.setDiseaseName(resultSet.getString(2));
                disease.setDiseaseChineseName(resultSet.getString(3));
                disease.setDiseaseDescription(resultSet.getString(4));
                disease.setDiseaseChineseDescrip(resultSet.getString(5));
                disease.setSeriousLevel(resultSet.getInt(6));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch

        return disease;
    }//end method
    
    public Disease readDiseaseInfoFromDB(String diseaseName, boolean isChinese) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            disease = new Disease();
            
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.disease WHERE disease_name = ?;");
            
            if(isChinese)
                preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.disease WHERE disease_chinese_name = ?;");
            
            preparedStatement.setString(1, diseaseName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                disease.setIdDisease(resultSet.getInt(1));
                disease.setDiseaseName(resultSet.getString(2));
                disease.setDiseaseChineseName(resultSet.getString(3));
                disease.setDiseaseDescription(resultSet.getString(4));
                disease.setDiseaseChineseDescrip(resultSet.getString(5));
                disease.setSeriousLevel(resultSet.getInt(6));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch

        return disease;
    }//end method
    
    /**Method of adding new disease information to database.
     * @return  */
    public boolean addDisease() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT iddisease FROM disease order by iddisease;");
            resultSet = preparedStatement.executeQuery();
            
            int maxNewdiseaseID = 1;
            
            while(resultSet.next()){
                if(resultSet.getInt(1) > maxNewdiseaseID)
                    maxNewdiseaseID = resultSet.getInt(1);
            }
             
            maxNewdiseaseID ++;
            disease.setIdDisease(maxNewdiseaseID);
            
            if(addToDB())
                return true;
            
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker! Method: public boolean addDisease()");
            return false;
        }//end try-catch
        
        return false;
    }//end method

    //Typical writing to database function
    private boolean addToDB() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.disease "
                    + "VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, disease.getIdDisease());
            preparedStatement.setString(2, disease.getDiseaseName());
            preparedStatement.setString(3, disease.getDiseaseChineseName());
            preparedStatement.setString(4, disease.getDiseaseDescription());
            preparedStatement.setString(5, disease.getDiseaseChineseDescrip());
            preparedStatement.setInt(6, disease.getSeriousLevel());
            
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
    public boolean updateDiseaseInfo() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("UPDATE what_to_eat.disease "
                    + "SET disease_name = ?, disease_chinese_name = ?, "
                    + "description = ?, description_chinese = ?, serious_level = ? "
                    + "WHERE iddisease = ?;");
            
            preparedStatement.setInt(6, disease.getIdDisease());
            preparedStatement.setString(1, disease.getDiseaseName());
            preparedStatement.setString(2, disease.getDiseaseChineseName());
            preparedStatement.setString(3, disease.getDiseaseDescription());
            preparedStatement.setString(4, disease.getDiseaseChineseDescrip());
            preparedStatement.setInt(5, disease.getSeriousLevel());
            
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
    
    //Waiting to be finished.
    public LinkedList<Disease> readAllDiseaseInfo(){
        diseaseList = new LinkedList<>();
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            disease = new Disease();
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.disease ORDER BY disease_name;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                disease = new Disease();
                disease.setIdDisease(resultSet.getInt(1));
                disease.setDiseaseName(resultSet.getString(2));
                disease.setDiseaseChineseName(resultSet.getString(3));
                disease.setDiseaseDescription(resultSet.getString(4));
                disease.setDiseaseChineseDescrip(resultSet.getString(5));
                disease.setSeriousLevel(resultSet.getInt(6));
                diseaseList.add(disease);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return diseaseList;
    }//end method
   
}//end class
