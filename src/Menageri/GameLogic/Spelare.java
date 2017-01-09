package Menageri.GameLogic;

import Menageri.Structure.Person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Package: Menageri.GameLogic
 */
public class Spelare extends Person implements Serializable {
    private ArrayList<SpelKort> turnedCards;
    private ArrayList<SpelKort> notTurnedCards;
    private Djur playingAs;
    private boolean isPlaying;

    public Spelare(String ID, String name, ArrayList<SpelKort> turnedCards, ArrayList<SpelKort> notTurnedCards, boolean isPlaying) {
        super(name, ID);
        this.turnedCards = turnedCards;
        this.notTurnedCards = notTurnedCards;
        this.isPlaying = isPlaying;
    }

    public ArrayList<SpelKort> getTurnedCards() {
        return this.turnedCards;
    }

    public void setTurnedCards(ArrayList<SpelKort> turnedCards) {
        this.turnedCards = turnedCards;
    }

    public void addTurnedCards(SpelKort card) {
        this.turnedCards.add(card);
    }

    public void removeTurnedCards() {
        this.turnedCards.clear();
    }

    public ArrayList<SpelKort> getNotTurnedCards() {
        return this.notTurnedCards;
    }

    public void setNotTurnedCards(ArrayList<SpelKort> notTurnedCards) {
        this.notTurnedCards = notTurnedCards;
    }

    public void addNotTurnedCards(SpelKort card) {
        this.notTurnedCards.add(card);
    }

    public void addNotTurnedCardsFromArray(ArrayList<SpelKort> s) {
        int i = this.notTurnedCards.size();
        if (i != 0) {
            i -= 1;
        }
        this.notTurnedCards.addAll(i, s);
    }

    public Djur getPlayingAs() {
        return playingAs;
    }

    public String printPlayerInfo() {
        return this.getName() + ", " + this.playingAs + "\n" + "Vända kort: " + this.turnedCards + "\n" + "Ovända kort: " + this.notTurnedCards;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void setPlayingAs(Djur playingAs) {
        this.playingAs = playingAs;
    }
}
