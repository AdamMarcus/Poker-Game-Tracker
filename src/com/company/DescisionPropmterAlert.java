package com.company;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by adamaustin on 7/14/17.
 *
 * This class is a window that asks the user to make a decision and allows yes or no answers.
 */

public class DescisionPropmterAlert {
    static boolean result;

    final static int ALERT_BOX_WIDTH = 200;
    final static int ALERT_BOX_HEIGHT = 100;
    final static double EDGE_OFFSET = 10.0;

    public static boolean displayAlert(String title, String message) {
        Stage window = new Stage();
        window.setMinWidth(ALERT_BOX_WIDTH);
        window.setMinHeight(ALERT_BOX_HEIGHT);
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        Label alertText = new Label(message);
        alertText.setAlignment(Pos.CENTER);

        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            result = false;
            window.close();
        });
        noButton.setAlignment(Pos.BOTTOM_RIGHT);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            result = true;
            window.close();
        });
        yesButton.setAlignment(Pos.BOTTOM_RIGHT);

        AnchorPane alertPane = new AnchorPane();
        alertPane.getChildren().addAll(alertText, noButton, yesButton);
        alertPane.setBottomAnchor(yesButton, EDGE_OFFSET);
        alertPane.setRightAnchor(yesButton, EDGE_OFFSET);

        alertPane.setBottomAnchor(noButton, EDGE_OFFSET);
        alertPane.setLeftAnchor(noButton, EDGE_OFFSET);

        Scene alertScene = new Scene(alertPane);
        window.setScene(alertScene);
        window.showAndWait();

        return result;
    }
}
