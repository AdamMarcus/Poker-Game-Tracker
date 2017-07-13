package com.company;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by adamaustin on 7/12/17.
 *
 * This window is to be used when sending an allert to the user.
 */

public class AllertBox {
    final static int ALERT_BOX_WIDTH = 200;
    final static int ALERT_BOX_HEIGHT = 100;
    final static double EDGE_OFFSET = 10.0;

    public static void displayAlert(String title, String message) {
        Stage window = new Stage();
        window.setMinWidth(ALERT_BOX_WIDTH);
        window.setMinHeight(ALERT_BOX_HEIGHT);
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        Label alertText = new Label(message);
        alertText.setAlignment(Pos.CENTER);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());
        closeButton.setAlignment(Pos.BOTTOM_RIGHT);

        AnchorPane alertPane = new AnchorPane();
        alertPane.getChildren().addAll(alertText, closeButton);
        alertPane.setBottomAnchor(closeButton, EDGE_OFFSET);
        alertPane.setRightAnchor(closeButton, EDGE_OFFSET);

        Scene alertScene = new Scene(alertPane);
        window.setScene(alertScene);
        window.showAndWait();
    }
}
