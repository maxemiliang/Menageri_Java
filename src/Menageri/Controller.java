package Menageri;

import Menageri.GameLogic.Djur;
import Menageri.GameLogic.DjurList;
import Menageri.GameLogic.SpelKort;
import Menageri.GameLogic.Spelare;
import Menageri.Helpers.GenerateCards;
import Menageri.Helpers.LogWriter;
import Menageri.UIMethods.AddAnimalsDialog;
import Menageri.UIMethods.DialogCreator;
import Menageri.UIMethods.GetPlayerInfoDialog;
import Menageri.UIMethods.PlayerNumberDialog;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Controller {

    // FX:IDn
    public TextArea LogViewer;
    public Button Starta;
    public Button next;
    public Button save;
    public ScrollPane scrollPane;

    private boolean started;
    private HashMap<String, Spelare> lastTurnedColor = null;
    private int currentPlayer;
    private Integer numberOfPlayers;
    private HashMap<Integer, Spelare> players;
    private ArrayList<Djur> sounds;


    public void StartGame(ActionEvent actionEvent) {
        Spelare temp;
        DjurList listOfAnimals = new DjurList("djur.txt");
        sounds = listOfAnimals.read();
        players = new HashMap<>();
        currentPlayer = 1;
        numberOfPlayers = PlayerNumberDialog.ShowDialog();
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            temp = GetPlayerInfoDialog.showDialog(i);
            players.put(i, temp);
        }
        LogWriter.clear();
        InitializeAnimals();
    }

    private void InitializeAnimals() {
        while (sounds.size() < players.size()) {
            sounds = AddAnimalsDialog.ShowDialog(sounds);
        }
        for (int i = 1; i <= players.size(); i++) {
            Random r = new Random();
            int index = r.nextInt(sounds.size());
            Djur d = sounds.get(index);
            Spelare s = players.get(i);
            s.setPlayingAs(d);
            sounds.remove(index);
        }
        InitalizePlayingCards();
    }

    private void InitalizePlayingCards() {
        Spelare temp;
        ArrayList<SpelKort> tempArr;
        Random r = new Random();
        ArrayList<SpelKort> playingCards = GenerateCards.generate();
        int curr = 1;
        for (int i = 0; i < 52; i++) {

            if (curr > numberOfPlayers) {
                curr = 1;
            }
            temp = players.get(curr);
            curr++;

            int index = r.nextInt(playingCards.size());
            SpelKort tempCard = playingCards.get(index);

            tempArr = temp.getNotTurnedCards();
            tempArr.add(tempCard);
            temp.setNotTurnedCards(tempArr);

            playingCards.remove(index);

        }
        started = true;
        Starta.setDisable(true);
        next.setDisable(false);
        save.setDisable(false);
    }

    public void NextRound(ActionEvent actionEvent) {
        ArrayList<Spelare> winner;
        if (started) {
            if (currentPlayer > numberOfPlayers) {
                currentPlayer = 1;
            }
            Spelare spelare = players.get(currentPlayer);
            currentPlayer++;
            checkIfWeHaveAWinner();
            if (spelare.getNotTurnedCards().size() == 0 && spelare.getTurnedCards().size() == 0) {
                spelare.setPlaying(false);
                LogWriter.write(spelare.getID() + " Namn: " + spelare.getName() + " Är ute ur spelet");
            } else if (spelare.getNotTurnedCards().size() == 0 && spelare.getTurnedCards().size() > 0) {
                ArrayList<SpelKort> arrayOfCards = spelare.getTurnedCards();
                spelare.removeTurnedCards();
                spelare.addNotTurnedCardsFromArray(arrayOfCards);
            } else if (spelare.isPlaying()) {
                SpelKort nextCard = spelare.getNotTurnedCards().get(0);
                spelare.getNotTurnedCards().remove(0);


                LogWriter.write("ID: " + spelare.getID() + " Namn: " + spelare.getName() + " Valör: " + nextCard.getColor() + " Värde: " + nextCard.getValue());

                if (lastTurnedColor != null) {
                    if (lastTurnedColor.containsKey(nextCard.getColor())) {
                        if (!lastTurnedColor.get(nextCard.getColor()).equals(spelare)) {
                            winner = determineWinner(lastTurnedColor.get(nextCard.getColor()), spelare);
                            ArrayList<SpelKort> tempKortArr = winner.get(1).getTurnedCards();
                            Collections.reverse(tempKortArr);
                            winner.get(0).addNotTurnedCardsFromArray(tempKortArr);
                            winner.get(1).removeTurnedCards();
                            LogWriter.write("ID: " + winner.get(0).getID() + " Namn: " + winner.get(0).getName() + " Läte: " + winner.get(1).getPlayingAs().getSound());
                            LogWriter.write("ID: " + winner.get(1).getID() + " Namn: " + winner.get(1).getName() + " Läte: " + winner.get(0).getPlayingAs().getSound());
                            Spelare loser = winner.get(1);
                            for (int i : players.keySet()) {
                                if (players.get(i).equals(loser)) {
                                    currentPlayer = i;
                                }
                            }
                        }
                    }
                    lastTurnedColor.clear();
                    lastTurnedColor.put(nextCard.getColor(), spelare);
                } else {
                    lastTurnedColor = new HashMap<>();
                    lastTurnedColor.put(nextCard.getColor(), spelare);
                }


                spelare.addTurnedCards(nextCard);
                // lägger till det kort som vänts
                String textToShow = LogWriter.read();
                LogViewer.setText(textToShow);
                scrollPane.vvalueProperty().bind(LogViewer.heightProperty());
            } else {
                System.out.println(spelare.getName());
            }

        } else {
            DialogCreator.Show("Fel", "Spelet är inte startat ännu!", null);
        }
    }

    private void checkIfWeHaveAWinner() {
        ArrayList<String> play = new ArrayList<>(numberOfPlayers-1);
        for (int i = 1; i <= numberOfPlayers; i++) {
            if (players.get(i).isPlaying()) {
                play.add("1");
            } else {
                play.add("0");
            }
        }
        if (Collections.frequency(play, "1") == 1) {
            int w = play.indexOf("1") + 1;
            Spelare winner = players.get(w);
            DialogCreator.Show("Vinnare!", "Vinnaren är: " + winner.getName() + "!", "Med IDn: " + winner.getID());
            next.setDisable(true);
            save.setDisable(true);
            Starta.setDisable(false);
        }
    }

    private ArrayList<Spelare> determineWinner(Spelare last, Spelare current) {
        ArrayList<Spelare> temp = new ArrayList<>(2);
        if (new Random().nextInt(1) == 0) {
            temp.add(last);
            temp.add(current);
        } else {
            temp.add(current);
            temp.add(last);
        }
        return temp;
    }

    public void SaveGame(ActionEvent actionEvent) {
        if (started) {

        } else {
            DialogCreator.Show("Fel", "Spelet är inte startat ännu!", null);
        }
    }

    public void LoadGame(ActionEvent actionEvent) {
        if (started) {

        } else {
            DialogCreator.Show("Fel", "Spelet är inte startat ännu!", null);
        }
    }
}
