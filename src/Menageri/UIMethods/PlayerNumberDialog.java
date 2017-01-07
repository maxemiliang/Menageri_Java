package Menageri.UIMethods;

import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Package: Menageri.UIMethods
 */
public class PlayerNumberDialog {

    public static Integer ShowDialog() {
        ArrayList<Integer> choices = new ArrayList<>();
        for (int i = 4; i < 11; i++) {
            choices.add(i);
        }
        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(4, choices);
        dialog.setTitle("Hur många spelare?");
        dialog.setHeaderText("Välj hur många spelare det skall finnas");
        dialog.setContentText("Välj:");

        Optional<Integer> result = dialog.showAndWait();

        if (result.isPresent()) {
            return result.get();
        } else {
            return 4;
        }

    }

}
