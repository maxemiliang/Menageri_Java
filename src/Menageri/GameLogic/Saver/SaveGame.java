package Menageri.GameLogic.Saver;

import java.io.*;
import java.util.ArrayList;

/**
 * Package: Menageri.GameLogic.Saver
 */
public class SaveGame {
    public static boolean Save(ArrayList<Object> s, String saveFile) {
        String fullPath = "saves/" + saveFile;
        try {

            FileOutputStream fout = new FileOutputStream(fullPath);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(s);
            oout.close();
            fout.close();
            return true;

        } catch (IOException e) {

            e.printStackTrace();

            return false;

        }
    }
}
