package DBLinkers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodImageLinker {

    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private InputStream input;
    
    /**
     * Linking to the data base stores foodDrinkID and image as mediumblob.
     */
    public FoodImageLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end cons
    
    public boolean storePicture(String imgPath, int picID){
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
            preparedStatement = connect.prepareStatement("SELECT image FROM food_image WHERE id_food_drink_img = ?;");
            preparedStatement.setInt(1, picID);
            resultSet = preparedStatement.executeQuery();
            
            input = new FileInputStream(imgPath);
            
            if(resultSet.next()){                 
                preparedStatement = connect.prepareStatement("UPDATE food_image SET image = ? WHERE id_food_drink_img = ?;");
                preparedStatement.setInt(2, picID);
                preparedStatement.setBinaryStream(1, input, input.available());       
            }else{            
                preparedStatement =connect.prepareStatement("insert into food_image values(?,?)");
                preparedStatement.setInt(1, picID);
                preparedStatement.setBinaryStream(2, input, input.available());            
            }//end if-else
            
            preparedStatement.executeUpdate();
            input.close();
            preparedStatement.close();
            resultSet.close();
            connect.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }//end try-catch
        
        return false;
    }//end method

    public String readPicToMemory(int picID) throws SQLException{
        String loadingPath = "temp" + picID + ".jpg";
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "12345");
                   preparedStatement = connect.prepareStatement("SELECT image FROM food_image WHERE id_food_drink_img = ?;");
            preparedStatement.setInt(1, picID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next(); //将光标指向第一行
            input = resultSet.getBinaryStream(1);
            byte[] dataBlock = new byte[input.available()]; //新建保存图片数据的byte数组
            input.read(dataBlock);           
            
            OutputStream output = new FileOutputStream(loadingPath);
            output.write(dataBlock);
            output.flush();
            
            output.close();
            resultSet.close();
            preparedStatement.close();
            connect.close();        
        }  catch (IOException ex) {
            ex.printStackTrace();
        }

        return loadingPath;
    }//end method
    
}//end class