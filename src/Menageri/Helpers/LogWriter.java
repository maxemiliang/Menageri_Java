package Menageri.Helpers;

import java.io.*;
import java.nio.charset.Charset;


/**
 * Package: Menageri.Helpers
 */
public class LogWriter {

    private static String logFile = "logs/log.txt";

    public static void clear() {
        try {
            PrintWriter w = new PrintWriter(logFile);
            w.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(s, 0, s.length());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        String lines = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
