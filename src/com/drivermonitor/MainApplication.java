package com.drivermonitor;

import com.drivermonitor.gui.HomeGUI;
import com.drivermonitor.gui.RegistrationGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX GUI");
        scene2 = new HomeGUI(primaryStage);
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
