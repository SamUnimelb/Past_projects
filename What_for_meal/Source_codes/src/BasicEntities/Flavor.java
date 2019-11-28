package BasicEntities;

public class Flavor {

    private int idFlavor;
    private String flavorName;
    private String flavorChineseName;

    public int getIdFlavor() {
        return this.idFlavor;
    }

    /**
     *
     * @param idFlavor
     */
    public void setIdFlavor(int idFlavor) {
        this.idFlavor = idFlavor;
    }

    public String getFlavorName() {
        return this.flavorName;
    }

    /**
     *
     * @param flavorName
     */
    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public String getFlavorChineseName() {
        return this.flavorChineseName;
    }

    /**
     *
     * @param flavorChineseName
     */
    public void setFlavorChineseName(String flavorChineseName) {
        this.flavorChineseName = flavorChineseName;
    }

}
