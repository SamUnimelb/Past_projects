package DBLinkerTestingClasses;

import BasicEntities.Disease;
import DBLinkers.SuffersLinker;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class SuffersLinkerTest {
    private SuffersLinker suffersLinker;
    private LinkedList<Disease> diseaseList;
    
    public SuffersLinkerTest() {
        suffersLinker = new SuffersLinker();
        testRead();
        testUpdate();
    }//end cons

    public void testRead() {
        // Testing reading from registered user db link:
        diseaseList = suffersLinker.getUserDiseaseList(3);
        diseaseList.forEach((d) -> {
            System.out.println(d.getDiseaseChineseName());
        });
        
    }//end method test read

    public void testUpdate() {
        //Testing register user to db link:
        int uID = 3;
        suffersLinker = new SuffersLinker();
        diseaseList = new LinkedList<>();
        
        for(int i = 1; i <= 4; i++){
            Disease d = new Disease();
            d.setIdDisease(i);
            diseaseList.add(d);
        }//end loop
        
        System.out.println(suffersLinker.setUserSuffersInfo(uID, diseaseList));
    }//end method test write

}//end class
