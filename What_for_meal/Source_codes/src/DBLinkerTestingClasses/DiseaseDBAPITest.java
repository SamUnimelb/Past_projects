package DBLinkerTestingClasses;

import BasicEntities.Disease;
import DBLinkers.DiseaseLinker;

public class DiseaseDBAPITest {

    private DiseaseLinker diseaseLinker;
    private Disease disease;

    public static void main(String[] args) {
        DiseaseDBAPITest dt = new DiseaseDBAPITest();
        dt.diseaseLinker = new DiseaseLinker();
        //foodDrinkLinker.calculateAllWaterAmount();
        dt.testRead();
        dt.testAddDisease();
        dt.testUpdateDisease();
    }//end cons

    public void testRead() {
        disease = diseaseLinker.readDiseaseInfoFromDB(1);
        System.out.print(disease.getDiseaseChineseName() + " ");
        System.out.println(disease.getDiseaseDescription() + " ");

        disease = diseaseLinker.readDiseaseInfoFromDB("high blood pressure", false);
        System.out.print(disease.getIdDisease() + " ");
        System.out.println(disease.getDiseaseChineseDescrip() + " ");

        disease = diseaseLinker.readDiseaseInfoFromDB("中风", true);
        System.out.print(disease.getIdDisease() + " ");
        System.out.println(disease.getDiseaseName() + " ");
    }//end method

    public void testAddDisease() {
        disease = new Disease();
        disease.setDiseaseName("gout");
        disease.setDiseaseChineseName("痛风");
        disease.setDiseaseDescription("A disease which makes users painful, espeically in their bone conjunctions.");
        disease.setDiseaseDescription("痛起来求生不能，求死不得。");
        disease.setSeriousLevel(2);

        diseaseLinker.setDisease(disease);
        System.out.println(diseaseLinker.addDisease());
    }//end method

    public void testUpdateDisease() {
        disease = new Disease();
        int diseaseID = diseaseLinker.readDiseaseInfoFromDB("痛风", true).getIdDisease();
        System.out.println("Disease ID: " + diseaseID);
        disease.setIdDisease(diseaseID);
        disease.setDiseaseName("gout");
        disease.setDiseaseChineseName("痛风");
        disease.setDiseaseDescription("A disease which makes users painful, espeically in their bone conjunctions.");
        disease.setDiseaseChineseDescrip("痛起来求生不能，求死不得。");
        disease.setSeriousLevel(2);

        diseaseLinker.setDisease(disease);
        System.out.println(diseaseLinker.updateDiseaseInfo());
    }//end method
    
}//end class
