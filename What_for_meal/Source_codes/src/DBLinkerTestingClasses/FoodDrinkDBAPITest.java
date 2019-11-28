package DBLinkerTestingClasses;

import BasicEntities.FoodDrink;
import DBLinkers.FoodDrinkLinker;

/**
 *
 * @author Administrator
 */
public final class FoodDrinkDBAPITest {
    private final FoodDrinkLinker foodDrinkLinker;
    private FoodDrink foodDrink;

    public FoodDrinkDBAPITest() {
        foodDrinkLinker = new FoodDrinkLinker();
        //foodDrinkLinker.calculateAllWaterAmount();
        testRead();
        //testAddFoodDrink();
        //testUpdateFoodDrink();
        testDeleteFoodDrink();
    }//end cons
    
    public void testRead() {
        foodDrink = foodDrinkLinker.readTheFoodDrinkInfoFromDB(2);
        System.out.print(foodDrink.getFoodDrinkID() + " ");
        System.out.print(foodDrink.getFoodDrinkName() + " ");
        System.out.print(foodDrink.getFoodDrinkChinesename() + " ");
        System.out.print(foodDrink.getCalorie() + " ");
        System.out.print(foodDrink.getCarbohydrate() + " ");
        System.out.print(foodDrink.getFat() + " ");
        System.out.print(foodDrink.getVitamin() + " ");
        System.out.print(foodDrink.getMineral() + " "); 
        System.out.println(foodDrink.getWater() + " "); 
        
        foodDrink = foodDrinkLinker.readTheFoodDrinkInfoFromDB("sweet potato", false);
        System.out.println("Food name: " + foodDrink.getFoodDrinkChinesename() + " ");
        
        foodDrink = foodDrinkLinker.readTheFoodDrinkInfoFromDB("甘薯", true);
        System.out.println("Food name: " + foodDrink.getFoodDrinkName() + " ");
    }//end method

    public void testAddFoodDrink(){
        foodDrink = new FoodDrink();
        foodDrink.setCalorie(127);
        foodDrink.setCarbohydrate(29);
        foodDrink.setFat(0.2);
        foodDrink.setFoodDrinkChinesename("甘薯");
        foodDrink.setFoodDrinkName("Sweet potato");
        foodDrink.setMineral(38.4 / 1000);
        foodDrink.setProtein(2.3);
        foodDrink.setVitamin(0.9);
        foodDrinkLinker.setFoodDrink(foodDrink);
        System.out.println(foodDrinkLinker.addFoodDrink());
    }//end method
    
    public void testUpdateFoodDrink(){
        foodDrink = new FoodDrink();
        foodDrink.setFoodDrinkID(8);
        foodDrink.setCalorie(127);
        foodDrink.setCarbohydrate(29);
        foodDrink.setFat(0.2);
        foodDrink.setFoodDrinkChinesename("红薯");
        foodDrink.setFoodDrinkName("Sweet potato");
        foodDrink.setMineral(38.4 / 1000);
        foodDrink.setProtein(2.3);
        foodDrink.setVitamin(0.9);
        foodDrinkLinker.setFoodDrink(foodDrink);
        System.out.println("Update result: " + foodDrinkLinker.updateFoodDrink());
    }//end method
    
    public void testDeleteFoodDrink(){
//        foodDrink = new FoodDrink();
//        foodDrink.setFoodDrinkID(9);
//        foodDrinkLinker.setFoodDrink(foodDrink);
//        System.out.println(foodDrinkLinker.deleteFoodDrinkInfoFromDB(foodDrink.getFoodDrinkID()));
        
        foodDrink = foodDrinkLinker.readTheFoodDrinkInfoFromDB("Sweet potato", false);
        foodDrinkLinker.setFoodDrink(foodDrink);
        System.out.println(foodDrinkLinker.deleteFoodDrinkInfoFromDB(foodDrink.getFoodDrinkName(), false));
        
    }//end method
}//end class
