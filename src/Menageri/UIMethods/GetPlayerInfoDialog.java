package Menageri.UIMethods;

import Menageri.GameLogic.Djur;
import Menageri.GameLogic.SpelKort;
import Menageri.GameLogic.Spelare;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Package: Menageri.UIMethods
 */
public class GetPlayerInfoDialog {
    public static Spelare showDialog(int playernumber) {
        String name;
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Mata in spelarens namn!");
        dialog.setHeaderText("Spelare Info");
        dialog.setContentText("Mata in spelare nr." + playernumber +  " namn:");

        Optional<String> result = dialog.showAndWait();
        while (true) {
            if (result.isPresent()) {
                name = result.get();
                if (!name.equals("")) {
                    return Menageri.Helpers.GeneratePlayer.Generate(name);
                } else {
                    dialog.setHeaderText("Var god och mata in ett namn");
                    result = dialog.showAndWait();
                }
            } else {
                dialog.setHeaderText("Var god och mata in ett namn!");
                result = dialog.showAndWait();
            }
        }

    }
}
