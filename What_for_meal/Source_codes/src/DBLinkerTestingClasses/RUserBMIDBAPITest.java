package DBLinkerTestingClasses;

import BasicEntities.RegisteredUserBMI;
import DBLinkers.RUserBMILinker;

/**
 *
 * @author Administrator
 */
public final class RUserBMIDBAPITest {
    private final RUserBMILinker rBMILinker;
    private RegisteredUserBMI rBMI;

    public RUserBMIDBAPITest() {
        rBMILinker = new RUserBMILinker();
        testRead();
        testAddBMIRecord();
        testClean();
    }//end cons

    public void testRead() {
        rBMI = rBMILinker.readAvgRUserBMIFromDB(1);
        System.out.println("User1, height: " + rBMI.getHeight());
        System.out.println("User1, weight: " + rBMI.getWeight());
        System.out.println("User1, BMI: " + rBMI.getWeight() / Math.pow(rBMI.getHeight(), 2));

        rBMI = rBMILinker.readAvgRUserBMIFromDB(2);
        System.out.println("User2, height: " + rBMI.getHeight());
        System.out.println("User2, weight: " + rBMI.getWeight());
        System.out.println("User2, BMI: " + rBMI.getWeight() / Math.pow(rBMI.getHeight(), 2));
    }//end method
    
    public void testAddBMIRecord(){
        rBMI = new RegisteredUserBMI();
        rBMI.setRUserID(3);
        rBMI.setHeight(1.83);
        rBMI.setWeight(62.5);
        rBMILinker.setRUserBMI(rBMI);
        System.out.println(rBMILinker.addUserBMIToDB());
    }
    
    public void testClean(){
        rBMI = new RegisteredUserBMI();
        rBMI.setRUserID(3);
        System.out.println(rBMILinker.cleanUserBMIInfo());
    }//end method

}//end class
