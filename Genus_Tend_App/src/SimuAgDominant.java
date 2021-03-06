public class SimuAgDominant {
    private int recentGeneration;
    private int nthGen;
    private int totalCapn, resCapn, domCapn;
    private double fAAn, fAan, faan, fAn, fan, fRate, changeRate;
    private String simuInfo;
    
    SimuAgDominant(int nthGen, double fA0, double fa0, double fitRate, int totalCapn, double changeRate){
        fRate = fitRate;
        recentGeneration = 1;
        this.nthGen = nthGen;
        this.changeRate = changeRate;
        this.totalCapn = totalCapn;
        
        fAn = fA0;
        fan = fa0;
        fRate = fitRate;
        fAAn = fA0 * fA0;
	fAan = 2 * fA0 * fa0;
	faan = fa0 * fa0;
        resCapn = (int)(totalCapn * faan);
        domCapn = totalCapn - resCapn;
        
        simuInfo = String.format("Generation    Frequency of genetype AA   Frequency of genetype Aa   \nFrequency of genetype aa"
                + "Frequency of allele A    Frequency of allele a\n"
                + "Number of total population at the beginning\n"
                + "Number of dominant population at the begining\n"
                + "Number of recessive population at the begining\nP0 %2.6f %2.6f %2.6f %2.6f %2.6f %d %d %d\n", 
                fAAn, fAan, faan, fAn, fan, totalCapn, domCapn, resCapn);

    }//end cons

    public void runSimulation() {
        while (recentGeneration <= nthGen) {
            /*
             fAn and fan are still representing allele frequencies of last
             generation here in this case: **/
            double totalFreq = (fAn * fAn * fRate + fAn * fan * (fRate + 1.0) + fan * fan);
            fAAn = (fAn * fAn * fRate) / totalFreq;
            fAan = (fAn * fan * (fRate + 1.0)) / totalFreq;
            faan = (fan * fan) / totalFreq;

            resCapn = (int) (totalCapn * faan);
            domCapn = totalCapn - resCapn;
            totalCapn = (int) (totalCapn * changeRate);

            System.out.println(totalCapn + " " + domCapn + " " + resCapn);
                        
            //Calculate new value of fAn and fan for this generation: 
            fAn = (2.0 * fAAn + fAan) / (2.0 * (fAAn + fAan + faan));
            fan = 1.0 - fAn;

            simuInfo += String.format("F%d %2.6f %2.6f %2.6f %2.6f %2.6f %d %d %d\n", recentGeneration, fAAn, fAan, faan, fAn, fan,
                    totalCapn, domCapn, resCapn);
            recentGeneration++;
        }//end loop
    }//end method: Keep running the simulating

    public String getSimuResult() {
        return simuInfo;
    }//end method
    
}//end class
