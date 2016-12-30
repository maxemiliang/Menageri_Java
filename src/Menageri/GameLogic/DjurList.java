package Menageri.GameLogic;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Package: Menageri.GameLogic
 */
public class DjurList {
    private String filename;

    DjurList(String path) {
        this.filename = "saves/" + path;
    }

    public ArrayList<Djur> read() {
        ArrayList<Djur> list = new ArrayList<>();

        Path file = Paths.get(this.filename);

        Charset charset = Charset.defaultCharset();

        try (BufferedReader reader = Files.newBufferedReader(file, charset)){
            String line = null;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
