package ProjectFrameTestingClasses;

/**
 *
 * @author SamY
 */

import BasicEntities.ActualDiet;
import DBLinkers.ActualDietLinker;
import java.text.DateFormat;
import java.util.LinkedList;

public class ActualDietLinkerTesting {
    private ActualDietLinker actualDietLinker;
    private ActualDiet actualDiet;
    private LinkedList<ActualDiet> actualDietList;
    
    public ActualDietLinkerTesting(){        
        testRead();
    }
    
    public void testRead(){
        actualDietLinker = new ActualDietLinker();
        actualDietList = actualDietLinker.readActualDiet(1);
        
        for(ActualDiet d : actualDietList){
            System.out.println(d.getFoodDrinkID());
            DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);  
            System.out.println(mediumFormat.format(d.getTimeAte().getTime()));
            System.out.println(d.getMeasurementID());
            System.out.println(d.getUnitAmount());
        }//end loop
    }//end method
    
}//end class
