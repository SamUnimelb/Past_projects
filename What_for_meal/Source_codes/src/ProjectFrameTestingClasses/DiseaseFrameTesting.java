/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectFrameTestingClasses;

import ProjectFrames.DiseaseFrame;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Administrator
 */
public class DiseaseFrameTesting {
    public DiseaseFrameTesting(){
        DiseaseFrame foodDrinkFrame = new DiseaseFrame();
        foodDrinkFrame.displayFrame();
    }    
}
