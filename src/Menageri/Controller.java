package Menageri;

import Menageri.GameLogic.Spelare;
import Menageri.UIMethods.PlayerNumberDialog;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Controller {

    private Integer numberOfPlayers;
    private ArrayList<Spelare> players;
    

    public void StartGame(ActionEvent actionEvent) {
        this.numberOfPlayers = PlayerNumberDialog.ShowDialog();

    }

}
