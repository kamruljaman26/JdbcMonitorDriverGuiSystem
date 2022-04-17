package com.drivermonitor.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TempleteGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(20);
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private final Stage primaryStage;

    // init buttons
    private Button cancelBtn;
    private Button registerBtn;

    public TempleteGUI(Stage primaryStage) {
        super(root, WIDTH, HEIGHT);
        this.primaryStage = primaryStage;

        // init buttons
        initButtons();

        // create GUI
        createGUI();
    }

    // init all button & design
    private void initButtons() {
        cancelBtn = new Button("Cancel");
        cancelBtn.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
    }

    // design and make full GUI interface
    private void createGUI(){
        root.getChildren().addAll(cancelBtn);
    }

    // handle button events
    @Override
    public void handle(ActionEvent event) {

    }
}
