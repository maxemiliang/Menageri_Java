package Menageri.GameLogic;

import Menageri.Structure.SpelKortGränssnitt;

import java.io.Serializable;

/**
 * Package: Menageri.GameLogic
 */
public class SpelKort implements SpelKortGränssnitt,Serializable {
    private String color;
    private String value;
    private boolean isTurned;

    public SpelKort(String color, String value) {
        this.color = color;
        this.value = value;
        this.isTurned = false;
    }

    public String getColor() {
        return this.color;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isTurned() {
        return this.isTurned;
    }

    public String skrivUt() {
        return this.color + " " + this.value;
    }
}
