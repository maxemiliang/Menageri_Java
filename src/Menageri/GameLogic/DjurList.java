package Menageri.GameLogic;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Package: Menageri.GameLogic
 */
public class DjurList {
    private String filename;
    private static ArrayList<String> AllAnimals = new ArrayList<>();

    public DjurList(String path) {
        this.filename = "gamedata/" + path;
    }

    public ArrayList<Djur> read() {
        ArrayList<Djur> list = new ArrayList<>();


        Path file = Paths.get(this.filename);

        Charset charset = Charset.defaultCharset();

        try (BufferedReader reader = Files.newBufferedReader(file, charset)){
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");

                if (!AllAnimals.contains(temp[0].toLowerCase())) {
                    Djur djur = new Djur(temp[0], temp[1]);
                    AddAnimalToAllAnimals(temp[0].toLowerCase());
                    list.add(djur);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void AddAnimalToAllAnimals(String animal) {
        AllAnimals.add(animal);
    }

    public static ArrayList<String> GetAllAnimals() {
        return AllAnimals;
    }

}
