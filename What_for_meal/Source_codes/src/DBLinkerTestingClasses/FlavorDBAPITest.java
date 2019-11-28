/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinkerTestingClasses;

import DBLinkers.FlavorLinker;
import BasicEntities.Flavor;

/**
 *
 * @author Administrator
 */
public class FlavorDBAPITest {

    private FlavorLinker flavorLinker;

    public FlavorDBAPITest() {
        flavorLinker = new FlavorLinker();
        //foodDrinkLinker.calculateAllWaterAmount();
        testRead();
    }//end cons

    public void testRead() {
        Flavor flavor = flavorLinker.readTheFlavorInfoFromDB(2);
        System.out.print(flavor.getIdFlavor() + " ");
        System.out.print(flavor.getFlavorName() + " ");
        System.out.println(flavor.getFlavorChineseName());

        flavor = flavorLinker.readTheFlavorInfoFromDB("sweet", false);
        System.out.print(flavor.getIdFlavor() + " ");
        System.out.print(flavor.getFlavorName() + " ");
        System.out.println(flavor.getFlavorChineseName());

        flavor = flavorLinker.readTheFlavorInfoFromDB("甜", true);
        System.out.print(flavor.getIdFlavor() + " ");
        System.out.print(flavor.getFlavorName() + " ");
        System.out.println(flavor.getFlavorChineseName());
    }//end method

}//end class
