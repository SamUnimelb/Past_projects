package ProjectTestingPackage;

/**
 *
 * @author Administrator
 */

import DBLinkerTestingClasses.*;
import ProjectFrameTestingClasses.*;
import ProjectFrames.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import DBLinkerTestingClasses.SuffersLinkerTest;

public class What_To_Take {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Database API testing classes:
        //RUserDBAPITest rUserDBAPITest = new RUserDBAPITest();  
        /*FoodDrinkDBAPITest foodDrinkDBAPITest = new FoodDrinkDBAPITest();
        FlavorDBAPITest flavorAPITest = new FlavorDBAPITest();
        DiseaseDBAPITest diseaseAPITest = new DiseaseDBAPITest();
        RUserBMIDBAPITest rBMIAPITest = new RUserBMIDBAPITest();
        SuffersLinkerTest sTest = new SuffersLinkerTest(); 
        ActualDietLinkerTesting aTest = new ActualDietLinkerTesting();*/
        
        
        //Frame work testing classes: 
        /*UserBMIFrameTesting userBMIFrame = new UserBMIFrameTesting();
        FoodDrinkFrameTesting foodDrinkFrame = new FoodDrinkFrameTesting();
        DiseaseFrameTesting diseaseFrame = new DiseaseFrameTesting();
       
        ExecutorService threads = Executors.newCachedThreadPool();
        threads.execute(rUserFrame);
        threads.shutdown();
        UserFlavorFrame uFlavorFrame = new UserFlavorFrame(2);     
        UserBMIFrameTesting userBMIFrame = new UserBMIFrameTesting();*/

        /*FoodDrinkFrameTesting foodDrinkFrame = new FoodDrinkFrameTesting();*/
         RegisteredUserFrame rUserFrame = new RegisteredUserFrame(3);
         ExecutorService threads = Executors.newCachedThreadPool();
         threads.execute(rUserFrame);
         threads.shutdown();
    }//end main
    
}//end class
