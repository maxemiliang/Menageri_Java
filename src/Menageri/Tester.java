package Menageri;

import Menageri.GameLogic.Djur;
import Menageri.GameLogic.DjurList;
import Menageri.GameLogic.Saver.LoadGame;
import Menageri.GameLogic.Saver.SaveGame;

import java.util.ArrayList;

/**
 * Package: Menageri
 */
public class Tester {
    public static void main(String[] args) {
        ArrayList<Object> s = new ArrayList<>();
        s.add(new Djur("meme", "meme"));
        if (SaveGame.Save(s, "test")) {
            System.out.println(LoadGame.load("test").get(0));
        }
    }
}
