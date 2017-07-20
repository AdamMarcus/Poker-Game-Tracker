package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will be used to run the app and contains the Main function.
 */
public class MainStory extends Application {

    static Stage mainStage;
    static Scene mainScene, newGameScene;
    static ListView<String> playerList = new ListView<>();
    static ListView<String> newGamePlayerList = new ListView<>();
    static ListView<String> recuringGameList = new ListView<>();
    static ListView<String> playersInRecuringGame = new ListView<>();


    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 450;
    static final double EDGE_OFFSET = 10;

    static final int NUM_ROWS = 5;
    static final int NUM_COLMNS = 4;

    static List<Player> allPlayers = new LinkedList<Player>(Arrays.asList(new Player("Adam"), new Player("Sarah"), new Player("Claire"), new Player("Sam"), new Player("Jenn")));
    static List<Player> newGamePlayers = new LinkedList<Player>();
    static List<RecurringGame> recuringGames = new LinkedList<RecurringGame>();




    public static void main(String[] args) {
        Player[] playerSet1 = new Player[]{allPlayers.get(0), allPlayers.get(1)};
        Player[] playerSet2 = {allPlayers.get(2), allPlayers.get(3), allPlayers.get(4)};
        recuringGames.add(new RecurringGame("2 players", playerSet1));
        recuringGames.add(new RecurringGame("3 players", playerSet2));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;

        // Make the main scene
        Button playGameButton = new Button("Play Selected Game");
        playGameButton.setOnAction(e -> AllertBox.displayAlert("Window is not implemented", "I am sorry, but the window you are trying to access is not yet implemented."));

        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> {
            mainStage.setScene(newGameScene);
            refreshPlayerList();
            refreshNewGamePlayerList();

        });


        GridPane mainScenePane = new GridPane();
//        mainScenePane.setGridLinesVisible(true);
        mainScenePane.setPadding(new Insets(EDGE_OFFSET, EDGE_OFFSET, EDGE_OFFSET, EDGE_OFFSET));
        mainScenePane.setVgap(EDGE_OFFSET);
        mainScenePane.setHgap(EDGE_OFFSET);

        Label recuringGameListLabel = new Label("Existing Game Series");

        recuringGameList.setOnMousePressed(e -> {
            String name = recuringGameList.getSelectionModel().getSelectedItem();
            Player[] playersInGame = {};
            for (int i = 0; i < recuringGames.size(); i++) {
                if (name.compareTo(recuringGames.get(i).getName()) == 0) {
                    playersInGame = recuringGames.get(i).getPlayers();
                    break;
                }
            }
            updatePlayersInRecurringGame(playersInGame);
        });

        Label playersInRecuringGameLabel = new Label("Players in Game:");

        mainScenePane.add(playGameButton, 0, NUM_ROWS);
        mainScenePane.add(recuringGameListLabel, 0, 0);
        mainScenePane.add(recuringGameList, 0, 1);
        mainScenePane.add(playersInRecuringGameLabel, NUM_COLMNS, 0);
        mainScenePane.add(playersInRecuringGame, NUM_COLMNS, 1);
        mainScenePane.add(newGameButton, NUM_COLMNS, NUM_ROWS);
        mainScene = new Scene(mainScenePane);


        // Make the New Game scene
        Label playerListLabel = new Label("Existing Players");
        Label newGamePlayerListLabel = new Label("Players in New Game");
        Label newGameNameLabel = new Label("Name For New Game:");
        Label insertNameLabel = new Label("New Players Name:");

        //Set up a place to enter a new player name.
        TextField insertNameTextField = new TextField();
        insertNameTextField.setEditable(true);
        insertNameTextField.setPromptText("Player Name");

        TextField insertNewGameName = new TextField();
        insertNewGameName.setEditable(true);
        insertNewGameName.setPromptText("Game Name");

        playerList.setOnMousePressed(e -> {
            String name = playerList.getSelectionModel().getSelectedItem();
            for (int i = 0; i < allPlayers.size(); i++) {
                if (name.compareTo(allPlayers.get(i).getName()) == 0 && !isInNewGamePlayerList(allPlayers.get(i))) {
                    newGamePlayers.add(allPlayers.get(i));
                    break;
                }
            }
            refreshNewGamePlayerList();
        });

        newGamePlayerList.setOnMousePressed(e -> {
            String name = newGamePlayerList.getSelectionModel().getSelectedItem();
            for (int i = 0; i < newGamePlayers.size(); i++) {
                if (name.compareTo(newGamePlayers.get(i).getName()) == 0) {
                    newGamePlayers.remove(newGamePlayers.get(i));
                    break;
                }
            }
            refreshNewGamePlayerList();
        });

        Button addNewPlayerButton = new Button("Add New Player");
        addNewPlayerButton.setOnAction(e -> {
            String newName = insertNameTextField.getText();
            if (newName.compareTo("") == 0) {
                AllertBox.displayAlert("No Name", "You must enter a name for a new player.");
            } else if (isInPlayerList(new Player(newName))) {
                AllertBox.displayAlert("Players Exists", "A player with this name already exists. Pick a different name for your new player.");
            } else if (DescisionPropmterAlert.displayAlert("", "Would you like to add a new player named \"" + newName + "\"?")) {
                Player newPlayer = new Player(newName);
                allPlayers.add(newPlayer);
                refreshPlayerList();
            }
            insertNameTextField.clear();
        });

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setOnAction(e -> {
            mainStage.setScene(mainScene);
            newGamePlayers.clear();
            refreshRecurringGameList();
            insertNewGameName.clear();
            insertNameTextField.clear();
        });

        Button clearNewPlayers = new Button("Clear New Players List");
        clearNewPlayers.setOnAction(e -> {
            newGamePlayers.clear();
            refreshNewGamePlayerList();
        });

        Button createNewGame = new Button("Create New Game");
        createNewGame.setOnAction(e -> {
            if (insertNewGameName.getText().compareTo("") == 0) {
                AllertBox.displayAlert("No New Game Name", "You must enter a name for your new game.");
                insertNewGameName.clear();
            }
            else if (isInRecuringGamesList(new RecurringGame(insertNewGameName.getText()))) {
                AllertBox.displayAlert("Game Name Taken", "A game with this name already exists.\n Please pick a different name for your game.");
                insertNewGameName.clear();
            }
            else {
                Player[] playersInNewGame = new Player[newGamePlayerList.getItems().size()];
                for (int i = 0; i < playersInNewGame.length; i++) {
                    playersInNewGame[i] = getPlayerWithName(newGamePlayerList.getItems().get(i));
                }
                if (playersInNewGame.length < 2) {
                    AllertBox.displayAlert("Add Players", "You must add two or more players to start a game.");
                }
                else {
                    RecurringGame newRecurringGame = new RecurringGame(insertNewGameName.getText(), playersInNewGame);
                    recuringGames.add(newRecurringGame);
                    insertNewGameName.clear();
                    newGamePlayers.clear();
                    refreshNewGamePlayerList();
                    refreshRecurringGameList();
                    mainStage.setScene(mainScene);
                }
            }
        });

        GridPane newGamePane = new GridPane();
//        newGamePane.setGridLinesVisible(true);
        newGamePane.setPadding(new Insets(EDGE_OFFSET, EDGE_OFFSET, EDGE_OFFSET, EDGE_OFFSET));
        newGamePane.setVgap(EDGE_OFFSET);
        newGamePane.setHgap(EDGE_OFFSET);
        newGamePane.add(playerListLabel, 0, 0);
        newGamePane.add(playerList, 0, 1);
        newGamePane.add(insertNameLabel, 0, NUM_ROWS - 3);
        newGamePane.add(insertNameTextField, 0, NUM_ROWS - 2);
        newGamePane.add(addNewPlayerButton, 0, NUM_ROWS - 1);
        newGamePane.add(mainMenuButton, 0, NUM_ROWS);
        newGamePane.add(newGamePlayerListLabel, NUM_COLMNS, 0);
        newGamePane.add(newGamePlayerList, NUM_COLMNS, 1);
        newGamePane.add(clearNewPlayers, NUM_COLMNS, NUM_ROWS - 3);
        newGamePane.add(newGameNameLabel, NUM_COLMNS, NUM_ROWS - 2);
        newGamePane.add(insertNewGameName, NUM_COLMNS, NUM_ROWS - 1);
        newGamePane.add(createNewGame, NUM_COLMNS, NUM_ROWS);
        newGameScene = new Scene(newGamePane);

        // Finalize the main stage and show.
        mainStage.setTitle("Poker Game Manager");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        refreshRecurringGameList();
        refreshPlayerList();
        refreshNewGamePlayerList();
        mainStage.show();
    }

    private void closeProgram() {
        if (DescisionPropmterAlert.displayAlert("Quitting", "Are you sure you want to quit?")) {
            mainStage.close();
        }
    }

    private void refreshPlayerList() {
        playerList.getItems().clear();
        for (int i = 0; i < allPlayers.size(); i++) {
            playerList.getItems().add(allPlayers.get(i).getName());
        }
    }

    private void refreshNewGamePlayerList() {
        newGamePlayerList.getItems().clear();
        for (int i = 0; i < newGamePlayers.size(); i++) {
            newGamePlayerList.getItems().add(newGamePlayers.get(i).getName());
        }
    }

    private void refreshRecurringGameList() {
        recuringGameList.getItems().clear();
        for (int i = 0; i < recuringGames.size(); i++) {
            recuringGameList.getItems().add(recuringGames.get(i).getName());
        }
    }

    private void updatePlayersInRecurringGame(Player[] _players) {
        playersInRecuringGame.getItems().clear();
        for (int i = 0; i < _players.length; i++) {
            playersInRecuringGame.getItems().add(_players[i].getName());
        }
    }

    private static boolean isInPlayerList(Player _player) {
        for (int i = 0; i < allPlayers.size(); i++) {
            if (_player.getName().compareTo(allPlayers.get(i).getName()) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInNewGamePlayerList(Player _player) {
        for (int i = 0; i < newGamePlayers.size(); i++) {
            if (_player.getName().compareTo(newGamePlayers.get(i).getName()) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInRecuringGamesList(RecurringGame _game) {
        for (int i = 0; i < recuringGames.size(); i++) {
            if (_game.getName().compareTo(recuringGames.get(i).getName()) == 0) {
                return true;
            }
        }
        return false;
    }

    private Player getPlayerWithName(String _name) {
        for (int i = 0; i < allPlayers.size(); i++) {
            if (_name.compareTo(allPlayers.get(i).getName()) == 0) {
                return allPlayers.get(i);
            }
        }
        return null;
    }


}
