package Menageri.UIMethods;

import Menageri.GameLogic.Djur;
import Menageri.GameLogic.DjurList;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Package: Menageri.UIMethods
 */
public class AddAnimalsDialog {


    public static ArrayList<Djur> ShowDialog(ArrayList<Djur> DjurArray) {

        TextInputDialog dialog = new TextInputDialog("djur,läte");
        dialog.setTitle("Lägg till ett djur");
        dialog.setHeaderText("Lägg till ett djur och ett läte separerat med ett kommatecken");
        dialog.setContentText("Lägg till här:");
        Optional<String> result = dialog.showAndWait();

        while (true) {
            if (result.isPresent()) {
                String newAnimal = result.get();
                String[] animalData = newAnimal.split(",");
                if (animalData.length > 1) {
                    if (!DjurList.GetAllAnimals().contains(animalData[0].toLowerCase())) {
                        DjurList.AddAnimalToAllAnimals(animalData[0].toLowerCase());
                        DjurArray.add(new Djur(animalData[0], animalData[1]));
                        return DjurArray;
                    } else {
                        dialog.setHeaderText("Djuret finns redan!");
                        result = dialog.showAndWait();
                    }
                } else {
                    dialog.setHeaderText("Du matade in det fel!");
                    result = dialog.showAndWait();
                }
            } else {
                break;
            }
        }

        return DjurArray;

    }

}

