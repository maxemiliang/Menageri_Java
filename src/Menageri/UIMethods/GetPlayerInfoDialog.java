package Menageri.UIMethods;

import Menageri.GameLogic.Djur;
import Menageri.GameLogic.SpelKort;
import Menageri.GameLogic.Spelare;

import java.util.ArrayList;

/**
 * Package: Menageri.UIMethods
 */
public class GetPlayerInfoDialog {
    public static Spelare showDialog(int NumberOfPlayers) {
        return new Spelare("", "", new ArrayList<SpelKort>(), new ArrayList<SpelKort>(), true, 0);
    }
}
