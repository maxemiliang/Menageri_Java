package Menageri.Helpers;

import Menageri.GameLogic.SpelKort;
import Menageri.GameLogic.Spelare;

import java.util.ArrayList;

/**
 * Package: Menageri.Helpers
 */
public class GeneratePlayer {
    public static Spelare Generate(String name) {
        String id = GenerateID.Generate();

        return new Spelare(id, name, new ArrayList<SpelKort>(), new ArrayList<SpelKort>(), true);
    }
}
