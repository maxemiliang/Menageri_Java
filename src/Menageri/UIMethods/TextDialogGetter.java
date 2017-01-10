package Menageri.UIMethods;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Package: Menageri.UIMethods
 */
public class TextDialogGetter {
    public static String Show(String t, String h, String c) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(t);
        dialog.setHeaderText(h);
        dialog.setContentText(c);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return "";
        }
    }
}
