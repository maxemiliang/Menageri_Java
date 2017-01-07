package Menageri.GameLogic;

import Menageri.Structure.Person;

import java.util.ArrayList;

/**
 * Package: Menageri.GameLogic
 */
public class Spelare extends Person {
    private ArrayList<SpelKort> turnedCards;
    private ArrayList<SpelKort> notTurnedCards;
    private Djur playingAs;
    private boolean isPlaying;
    private int Tur;

    public Spelare(String name, String ID, ArrayList<SpelKort> turnedCards, ArrayList<SpelKort> notTurnedCards, boolean isPlaying, int Tur) {
        super(name, ID);
        this.turnedCards = turnedCards;
        this.notTurnedCards = notTurnedCards;
        this.isPlaying = isPlaying;
        this.Tur = Tur;
    }

    public ArrayList<SpelKort> getTurnedCards() {
        return this.turnedCards;
    }

    public void setTurnedCards(ArrayList<SpelKort> turnedCards) {
        this.turnedCards = turnedCards;
    }

    public ArrayList<SpelKort> getNotTurnedCards() {
        return this.notTurnedCards;
    }

    public void setNotTurnedCards(ArrayList<SpelKort> notTurnedCards) {
        this.notTurnedCards = notTurnedCards;
    }

    public Djur getPlayingAs() {
        return playingAs;
    }

    public String printPlayerInfo() {
        return this.getName() + ", " + this.playingAs + "\n" + "Vända kort: " + this.turnedCards + "\n" + "Ovända kort: " + this.notTurnedCards;
    }

    public int getTur() {
        return Tur;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlayingAs(Djur playingAs) {
        this.playingAs = playingAs;
    }
}
