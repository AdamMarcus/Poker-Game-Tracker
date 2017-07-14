package com.company;

import com.company.Player;
import com.company.Game;
import com.company.AllertBox;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by adamaustin on 7/3/17.
 *
 * This class will be used to run the app and contains the Main function.
 */
public class MainStory extends Application {

    Stage mainStage;
    Scene mainScene, newGameScene;

    static final int WINDOW_WIDTH = 600;
    static final int WINDOW_HEIGHT = 300;
    static final double EDGE_OFFSET = 10;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        primaryStage.setTitle("Poker Games");
//        okay = new Button("Okay");
//        okay.setOnAction(e -> System.out.println("WOWSA"));
//
//        StackPane layout = new StackPane();
//
//        layout.getChildren().add(okay);
//
//        Scene welcomeScene = new Scene(layout, 300, 250);
//        primaryStage.setScene(welcomeScene);
//        primaryStage.show();

        mainStage = primaryStage;

        // Make the main scene
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> mainStage.setScene(newGameScene));

        Button playGameButton = new Button("Play Selected Game");
        playGameButton.setOnAction(e -> AllertBox.displayAlert("Window is not implemented", "I am sorry, but the window you are trying to access is not yet implemented."));

        AnchorPane mainScenePane = new AnchorPane();
        mainScenePane.getChildren().addAll(playGameButton, newGameButton);
        mainScenePane.setRightAnchor(newGameButton, EDGE_OFFSET);
        mainScenePane.setBottomAnchor(newGameButton, EDGE_OFFSET);
        mainScenePane.setRightAnchor(playGameButton, EDGE_OFFSET);
        mainScenePane.setBottomAnchor(playGameButton, 4*EDGE_OFFSET);
        mainScene = new Scene(mainScenePane, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Make the New Game scene
        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setOnAction(e -> mainStage.setScene(mainScene));

        AnchorPane newGamePane = new AnchorPane();
        newGamePane.getChildren().addAll(mainMenuButton);
        newGamePane.setLeftAnchor(mainMenuButton, EDGE_OFFSET);
        newGamePane.setBottomAnchor(mainMenuButton, EDGE_OFFSET);
        newGameScene = new Scene(newGamePane, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Finalize the main stage and show.
        mainStage.setTitle("Poker Game Manager");
        mainStage.setScene(mainScene);
        mainStage.show();
    }


}
