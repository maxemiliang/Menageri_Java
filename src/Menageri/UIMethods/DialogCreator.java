package Menageri.UIMethods;

import javafx.scene.control.Alert;

/**
 * Package: Menageri.UIMethods
 */
public class DialogCreator {
    public static void Show(String t, String h, String c) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(t);
        alert.setHeaderText(h);
        alert.setContentText(c);

        alert.showAndWait();
    }
}
