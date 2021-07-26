package DBLinkers;

import BasicEntities.UserFlavor;
import BasicEntities.Flavor;
import BasicEntities.RegisteredUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserFlavorLinker {
    //Variables for database linking:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private UserFlavor userFlavor;
    
    //Variables for this table:
    private Flavor flavor;
    private RegisteredUser rUser;
    private FlavorLinker flavorLinker;
    private RegisteredUserLinker rUserLinker;
    private List<UserFlavor> userFlavorList;
    
    public UserFlavorLinker(){
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end cons
    
    public LinkedList<Flavor> getUserFlavorList(int rUserID){
        //List recording the flavors one user prefers.
        LinkedList<Flavor> userFlavors = new LinkedList<>();
        flavorLinker = new FlavorLinker();
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.flavor_profile WHERE flavor_uid = ?;");
            preparedStatement.setInt(1, rUserID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flavor f = new Flavor();
                //System.out.println(resultSet.getInt(2));
                f.setIdFlavor(resultSet.getInt(2));
                f = flavorLinker.readTheFlavorInfoFromDB(f.getIdFlavor());
                userFlavors.add(f);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return userFlavors;
    }//end method
    
    public boolean storeUserFlavorInfo(LinkedList<Flavor> userFlavors, int rUserID){
        //List recording the flavors one user prefers and his/her user id.
        userFlavorList = new LinkedList<>();
        
        for(Flavor f : userFlavors){
            userFlavor = new UserFlavor();
            userFlavor.setRUserID(rUserID);
            userFlavor.setFalvorID(f.getIdFlavor());
            userFlavorList.add(userFlavor);
            //System.out.println("Flavor: " + f.getIdFlavor());
        }//end loop
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("DELETE FROM flavor_profile WHERE flavor_uid = ?;");
            preparedStatement.setInt(1, rUserID);
            preparedStatement.executeUpdate();
            
            for(UserFlavor uflavor : userFlavorList){
                preparedStatement = connect.prepareStatement("INSERT INTO flavor_profile VALUES(?, ?);");
                preparedStatement.setInt(1, rUserID);
                preparedStatement.setInt(2, uflavor.getFalvorID());                
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
