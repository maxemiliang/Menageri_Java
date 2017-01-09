package Menageri.GameLogic;

/**
 * Package: Menageri.GameLogic
 */
public class Djur {

    private String Djur;
    private String Sound;

    // Konstruktor
    public Djur(String Djur, String Sound) {
        this.Djur = Djur;
        this.Sound = Sound;
    }

    public String getDjur() {
        return this.Djur;
    }

    public String getSound() {
        return this.Sound;
    }

    public String skrivUt() {
        return this.Djur + " - " + this.Sound;
    }

}
