package Menageri.Helpers;

import java.util.Random;

/**
 * Package: Menageri.Helpers
 */
public class GenerateID {
    public static String Generate () {
        String ID = "";
        char c;
        Random r = new Random();

        for (int i = 1; i <= 11; i++) {
            if (i <= 6) {
                c = (char)(r.nextInt(26) + 'A');
                ID += String.valueOf(c);
            } else if (i == 7){
                ID += "-";
            } else {
                ID += r.nextInt(9);
            }
        }

        return ID;
    }
}
