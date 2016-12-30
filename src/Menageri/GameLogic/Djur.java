package Menageri.GameLogic;

/**
 * Package: Menageri.GameLogic
 */
public class Djur {

    private String Djur;
    private String Sound;

    /**
     * @param Djur Namnet på djuret
     * @param Sound Lätet som djuret gör
     */
    // Konstruktor
    public Djur(String Djur, String Sound) {
        this.Djur = Djur;
        this.Sound = Sound;
    }

    /**
     * @return String
     */
    public String skrivUt() {
        return this.Djur + " - " + this.Sound;
    }

}
