package Menageri;

import Menageri.GameLogic.Djur;
import Menageri.GameLogic.DjurList;

import java.util.ArrayList;

/**
 * Package: Menageri
 */
public class Tester {
    public static void main(String[] args) {
        DjurList list = new DjurList("djur.txt");
        System.out.println(Menageri.Helpers.GenerateID.Generate());
        ArrayList<Djur> djur = list.read();
        System.out.println(djur);
    }
}
