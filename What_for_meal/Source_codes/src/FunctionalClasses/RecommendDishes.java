package FunctionalClasses;

import BasicEntities.*;
import DBLinkers.*;
import java.util.Collections;
import java.util.LinkedList;


/**
 *
 * @author Administrator
 */
public class RecommendDishes {

    private FoodDrinkLinker foodDrinkLinker;
    private UserFlavorLinker userFlavorLinker;
    private TastesLinker tastesLinker;
    
    private LinkedList<FoodDrink> pickedFoodDrinks;
    private LinkedList<Flavor> userFlavorList;
    //Waiting to be future implemented if FoodDrink simulates Disease information available.
    private LinkedList<Disease> userDiseaseList;
    private LinkedList<FoodDrink> finalRecommendFoodDrinkList;
    private LinkedList<Flavor> tastesList;
    private final int NUM_OF_DISHES = 5;

    public RecommendDishes(int rUserID) {
        foodDrinkLinker = new FoodDrinkLinker();
        userFlavorLinker = new UserFlavorLinker();
        pickedFoodDrinks = foodDrinkLinker.get20FoodDrink();
        Collections.shuffle(pickedFoodDrinks);
        userFlavorList = userFlavorLinker.getUserFlavorList(rUserID);
        finalRecommendFoodDrinkList = new LinkedList<>();
        consiserFlavorFactors();
        considerOtherFactors();
    }//end cons
    
    private void consiserFlavorFactors(){
        //Try to satisfy all user flavors:
        for(Flavor f : userFlavorList){
            //Search all the picked food which satisfy:
            for(FoodDrink fd : pickedFoodDrinks){
                tastesLinker = new TastesLinker();
                tastesList = tastesLinker.getFoodFlavorList(fd.getFoodDrinkID());
                for(Flavor eachTaste : tastesList){
                    //Remain 2 dishes to help improving diet diversity.
                    if( (eachTaste.getFlavorName().equals(f.getFlavorName())) && 
                            (finalRecommendFoodDrinkList.size() < NUM_OF_DISHES - 2) )
                        finalRecommendFoodDrinkList.add(fd);
                }//end 3rd-level for: Search all the tastes to match
            }//end inner for
        }//end outter for        
    }//end method
    
    private void considerOtherFactors() {
        //while recommended number is not enough for this meal:        
        while (finalRecommendFoodDrinkList.size() < NUM_OF_DISHES) {
            boolean duplicateFd = false;
            int randDishNum = (int)(Math.random() * pickedFoodDrinks.size());
            FoodDrink otherFd = pickedFoodDrinks.get(randDishNum);
            //Randomly pick-up other food that is not in the list:
            for(FoodDrink fd : finalRecommendFoodDrinkList){
                if(fd.getFoodDrinkName().equals(otherFd.getFoodDrinkName()))
                    duplicateFd = true;
            }//end loop
            
            if(!duplicateFd)
                finalRecommendFoodDrinkList.add(otherFd);
        }//end loop

    }//eend method

    ;//end method
    
    public LinkedList<FoodDrink> getRecommendFoodListForMeal(){
        /*Testing code:
        for(FoodDrink fd : finalRecommendFoodDrinkList)
            System.out.println(fd.getFoodDrinkName() + "-" + fd.getFoodDrinkChinesename());
        
        System.out.println();*/
        return finalRecommendFoodDrinkList;
    }//end method
    
}//end class
