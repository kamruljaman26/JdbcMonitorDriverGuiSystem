package com.drivermonitor.uitls;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Utils {

    public static HBox getFormattedHBox(Node... elements) {
        HBox hBox = new HBox(30);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(elements);
        return hBox;
    }

    public static Background getBackground(Color color) {
        return new Background(new BackgroundFill(color, null, null));
    }
}
