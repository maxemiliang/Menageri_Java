package Menageri.Helpers;

import Menageri.GameLogic.SpelKort;

import java.util.ArrayList;

/**
 * Package: Menageri.Helpers
 */
public class GenerateCards {

    private static ArrayList<String> values = new ArrayList<>();

    // det finns högst antagligen ett bättre sätt men..
    private static void addValues() {
        values.add("A");
        values.add("2");
        values.add("3");
        values.add("4");
        values.add("5");
        values.add("6");
        values.add("7");
        values.add("8");
        values.add("9");
        values.add("10");
        values.add("J");
        values.add("Q");
        values.add("K");
    }

    public static ArrayList<SpelKort> generate() {
        addValues();
        ArrayList<SpelKort> cards = new ArrayList<>(52);
        for (int i = 1; i <=52; i++) {
            if (i > 0 && i < 14) {
                cards.add(new SpelKort("Hjärter", values.get(i-1)));
            } else if (i > 13 && i < 27) {
                cards.add(new SpelKort("Spader", values.get(i-14)));
            } else if (i > 26 && i < 40) {
                cards.add(new SpelKort("Ruter", values.get(i-27)));
            } else {
                cards.add(new SpelKort("Klöver", values.get(i-40)));
            }
        }
        return cards;
    }
}
