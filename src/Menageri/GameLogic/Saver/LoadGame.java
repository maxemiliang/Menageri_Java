package Menageri.GameLogic.Saver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Package: Menageri.GameLogic.Saver
 */
public class LoadGame {
    public static ArrayList<Object> load(String s) {
        String fullPath = "saves/" + s;
        ArrayList<Object> arr;

        try {
            FileInputStream fin = new FileInputStream(fullPath);
            ObjectInputStream oin = new ObjectInputStream(fin);

            arr = (ArrayList<Object>) oin.readObject();
            oin.close();
            fin.close();
            return arr;

        } catch (java.io.IOException ignored) {
            return new ArrayList<>();
        } catch (ClassNotFoundException ignored) {
            return new ArrayList<>();
        }
    }
}
