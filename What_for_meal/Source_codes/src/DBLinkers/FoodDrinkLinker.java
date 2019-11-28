package DBLinkers;

import BasicEntities.FoodDrink;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class FoodDrinkLinker {
    //Variables for linking database:
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    
    //Variables for registered user information.
    private FoodDrink foodDrink;
    private LinkedList<FoodDrink> foodDrinkList;

    //Initialize linking environment
    public FoodDrinkLinker() {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }//end try-catch
    }//end constructor
    
    public FoodDrink getFoodDrink(){
        return foodDrink;
    }
    
    public void setFoodDrink(FoodDrink foodDrink){
        this.foodDrink = foodDrink;
    }//end method
   
    //Read information according to information already known (such as primary key):
    public FoodDrink readTheFoodDrinkInfoFromDB(int foodDrinkID) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            foodDrink = new FoodDrink();
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.food_drinks WHERE idFood_Drinks = ?;");
            preparedStatement.setInt(1, foodDrinkID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                foodDrink.setFoodDrinkID(resultSet.getInt(1));
                foodDrink.setFoodDrinkName(resultSet.getString(2));
                foodDrink.setFoodDrinkChinesename(resultSet.getString(3));
                foodDrink.setCalorie(resultSet.getFloat(4));
                foodDrink.setCarbohydrate(resultSet.getFloat(5));
                foodDrink.setFat(resultSet.getFloat(6));
                foodDrink.setProtein(resultSet.getFloat(7));
                foodDrink.setVitamin(resultSet.getFloat(8));
                foodDrink.setMineral(resultSet.getFloat(9));
                foodDrink.setWater(resultSet.getFloat(10));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch

        return foodDrink;
    }//end method
    
     //Read information according to information already known (such as primary key):
    public FoodDrink readTheFoodDrinkInfoFromDB(String foodDrinkName, boolean isChinese) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            foodDrink = new FoodDrink();                    
            
            if(isChinese)
                preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.food_drinks WHERE Food_Drinks_Chinese_Name = ?;");
            else{
                preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.food_drinks WHERE Food_DrinksName = ?;");
                System.err.println("Using English name may get multiple results, returnning is the last one. ");
            }//end if-else
                
            
            preparedStatement.setString(1, foodDrinkName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                foodDrink.setFoodDrinkID(resultSet.getInt(1));
                foodDrink.setFoodDrinkName(resultSet.getString(2));
                foodDrink.setFoodDrinkChinesename(resultSet.getString(3));
                foodDrink.setCalorie(resultSet.getFloat(4));
                foodDrink.setCarbohydrate(resultSet.getFloat(5));
                foodDrink.setFat(resultSet.getFloat(6));
                foodDrink.setProtein(resultSet.getFloat(7));
                foodDrink.setVitamin(resultSet.getFloat(8));
                foodDrink.setMineral(resultSet.getFloat(9));
                foodDrink.setWater(resultSet.getFloat(10));
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch

        return foodDrink;
    }//end method
    
    /**Method of registering new food to database. Including reading food id
    and write food information into database. 
    In this case, it is a special method being written in the interfac
     * @return e*/
    public boolean addFoodDrink() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT idFood_Drinks FROM food_drinks order by idFood_Drinks;");
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData = resultSet.getMetaData();
            
            int maxNewFoodDrinkID = 1;
            
            while(resultSet.next()){
                if(resultSet.getInt(1) > maxNewFoodDrinkID)
                    maxNewFoodDrinkID = resultSet.getInt(1);
            }
             
            maxNewFoodDrinkID ++;
            foodDrink.setFoodDrinkID(maxNewFoodDrinkID);
            
            if(addToDB())
                return true;
            
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker! Method: private void registerUser()");
            ex.printStackTrace();
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
            preparedStatement = connect.prepareStatement("INSERT INTO what_to_eat.food_drinks "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, foodDrink.getFoodDrinkID());
            preparedStatement.setString(2, foodDrink.getFoodDrinkName());
            preparedStatement.setString(3, foodDrink.getFoodDrinkChinesename());
            preparedStatement.setFloat(4, (float) foodDrink.getCalorie());
            preparedStatement.setFloat(5, (float) foodDrink.getCarbohydrate());
            preparedStatement.setFloat(6, (float) foodDrink.getFat());
            preparedStatement.setFloat(7, (float) foodDrink.getProtein());
            preparedStatement.setFloat(8, (float) foodDrink.getVitamin());
            preparedStatement.setFloat(9, (float) foodDrink.getMineral());
            
            if(foodDrink.getWater() != 0)
                preparedStatement.setFloat(10, (float) foodDrink.getWater());
            else{
                 float waterAmount = (float)(100.0 - foodDrink.getCarbohydrate() - foodDrink.getFat()
                        - foodDrink.getProtein() - foodDrink.getVitamin() - foodDrink.getMineral());
                 preparedStatement.setFloat(10, waterAmount);
            }//end if-else
            
            preparedStatement.executeUpdate();
            
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //ex.printStackTrace();
            ex.printStackTrace();
            System.err.println("Duplicated keys might be added! Error: FoodDrinkLinker.java->private void addToDB()");
            return false;
        } catch (SQLException ex) {
            System.err.println("Error in FoodDrinkLinker! Method: private void addToDB()");
            return false;
        }//end try-catch
        
        return true;
    }//end method
    
    //Typical updating function.
    public boolean updateFoodDrink() {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            //Line doing encryption, should be used with execute update.
            preparedStatement = connect.prepareStatement("UPDATE what_to_eat.food_drinks "
                    + "SET Food_DrinksName = ?, Food_Drinks_Chinese_Name = ?, Calorie = ?, "
                    + "Carbohydrates = ?, Fats = ?, Proteins = ?, Vitamins = ?, Minerals = ?, "
                    + "Water = ? "
                    + "WHERE idFood_Drinks = ?;");

            preparedStatement.setString(1, foodDrink.getFoodDrinkName());
            preparedStatement.setString(2, foodDrink.getFoodDrinkChinesename());
            preparedStatement.setFloat(3, (float) foodDrink.getCalorie());
            preparedStatement.setFloat(4, (float) foodDrink.getCarbohydrate());
            preparedStatement.setFloat(5, (float) foodDrink.getFat());
            preparedStatement.setFloat(6, (float) foodDrink.getProtein());
            preparedStatement.setFloat(7, (float) foodDrink.getVitamin());
            preparedStatement.setFloat(8, (float) foodDrink.getMineral());

            if (foodDrink.getWater() != 0) {
                preparedStatement.setFloat(9, (float) foodDrink.getWater());
            } else {
                float waterAmount = (float) (100.0 - foodDrink.getCarbohydrate() - foodDrink.getFat()
                        - foodDrink.getProtein() - foodDrink.getVitamin() - foodDrink.getMineral());
                preparedStatement.setFloat(9, waterAmount);
            }//end if-else

            preparedStatement.setInt(10, foodDrink.getFoodDrinkID());

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
    
    public void calculateAllWaterAmount(){
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");            
            
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.food_drinks;");
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData = resultSet.getMetaData();
            foodDrink = new FoodDrink();
            
            while (resultSet.next()) {
                foodDrink.setFoodDrinkID(resultSet.getInt(1));
                foodDrink.setFoodDrinkName(resultSet.getString(2));
                foodDrink.setFoodDrinkChinesename(resultSet.getString(3));
                foodDrink.setCalorie(resultSet.getFloat(4));
                foodDrink.setCarbohydrate(resultSet.getFloat(5));
                foodDrink.setFat(resultSet.getFloat(6));
                foodDrink.setProtein(resultSet.getFloat(7));
                foodDrink.setVitamin(resultSet.getFloat(8));
                foodDrink.setMineral(resultSet.getFloat(9));

                /*Testing codes:
                System.out.print(foodDrink.getFoodDrinkID() + " ");
                System.out.print(foodDrink.getFoodDrinkName() + " ");
                System.out.print(foodDrink.getFoodDrinkChinesename() + " ");
                System.out.print(foodDrink.getCalorie() + " ");
                System.out.print(foodDrink.getCarbohydrate() + " ");
                System.out.print(foodDrink.getFat() + " ");
                System.out.print(foodDrink.getVitamin() + " ");
                System.out.println(foodDrink.getMineral() + " ");*/

                float waterAmount = (float)(100.0 - foodDrink.getCarbohydrate() - foodDrink.getFat()
                        - foodDrink.getProtein() - foodDrink.getVitamin() - foodDrink.getMineral());
                
                 String statement = "UPDATE what_to_eat.food_drinks "
                        + "SET Water = ? "
                        + "WHERE idFood_Drinks = ?;";                 
                preparedStatement = connect.prepareStatement(statement);                
                preparedStatement.setFloat(1, waterAmount);
                preparedStatement.setInt(2, foodDrink.getFoodDrinkID());
                preparedStatement.executeUpdate();            
            }//end loop
            
            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
    }//end method
    
    //Read information according to information already known (such as primary key):
    public boolean deleteFoodDrinkInfoFromDB(int foodDrinkID) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            foodDrink = new FoodDrink();
            preparedStatement = connect.prepareStatement("DELETE FROM what_to_eat.food_drinks WHERE idFood_Drinks = ?;");
            preparedStatement.setInt(1, foodDrinkID);
            preparedStatement.executeUpdate();
            resultSet.close();
            connect.close();
            
            return true;
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
            return false;
        }//end try-catch
        
    }//end method
    
     //Read information according to information already known (such as primary key):
    public boolean deleteFoodDrinkInfoFromDB(String foodDrinkName, boolean isChinese) {
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            foodDrink = new FoodDrink();                    
            
            if(isChinese)
                preparedStatement = connect.prepareStatement("DELETE FROM what_to_eat.food_drinks WHERE Food_Drinks_Chinese_Name = ?;");
            else{
                preparedStatement = connect.prepareStatement("DELETE FROM what_to_eat.food_drinks WHERE Food_DrinksName = ?;");
                System.err.println("Using English name may get multiple results, returnning is the last one. ");
            }//end if-else                
            
            preparedStatement.setString(1, foodDrinkName);
            preparedStatement.executeUpdate();

            resultSet.close();
            connect.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
            return false;
        }//end try-catch

    }//end method
    
    public LinkedList<FoodDrink> getAllFoodDrink(){
        foodDrinkList = new LinkedList<>();
        
        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/what_to_eat", "root", "123456");
            preparedStatement = connect.prepareStatement("SELECT * FROM what_to_eat.food_drinks ORDER BY Food_DrinksName;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                foodDrink = new FoodDrink();
                foodDrink.setFoodDrinkID(resultSet.getInt(1));
                foodDrink.setFoodDrinkName(resultSet.getString(2));
                foodDrink.setFoodDrinkChinesename(resultSet.getString(3));
                foodDrink.setCalorie(resultSet.getFloat(4));
                foodDrink.setCarbohydrate(resultSet.getFloat(5));
                foodDrink.setFat(resultSet.getFloat(6));
                foodDrink.setProtein(resultSet.getFloat(7));
                foodDrink.setVitamin(resultSet.getFloat(8));
                foodDrink.setMineral(resultSet.getFloat(9));
                foodDrink.setWater(resultSet.getFloat(10));
                foodDrinkList.add(foodDrink);
            }//end loop

            resultSet.close();
            connect.close();
        } catch (SQLException ex) {
            System.err.println("Error in Registered linker!");
            ex.printStackTrace();
        }//end try-catch
        
        return foodDrinkList;
    }//end method
    
    public LinkedList<FoodDrink> get20FoodDrink(){
        getAllFoodDrink();
        Collections.shuffle(foodDrinkList);
        
        //This won't run into problem even if sample size
        //Less than 20.
        while(foodDrinkList.size() > 20)
            foodDrinkList.removeLast();
        return foodDrinkList;
    }//end loop
    
}//end class
