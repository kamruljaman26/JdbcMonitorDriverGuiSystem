package com.drivermonitor.gui;

import com.drivermonitor.uitls.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomeGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
    private static final int WIDTH = 350;
    private static final int HEIGHT = 500;
    private static final String TITLE = "Customer Home";
    private final Stage primaryStage;

    // init buttons
    private Button loginBtn;
    private Button registerBtn;

    public HomeGUI(Stage primaryStage) {
        super(root, WIDTH, HEIGHT);
        this.primaryStage = primaryStage;
        primaryStage.setTitle(TITLE);

        // customize header & add design in root layout
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(Utils.getBackground(Color.WHITESMOKE));
        root.setPadding(new Insets(50, 20, 20, 20));

        // create header
        createHeadingGUI();

        createHomeGUI();
    }

    // create header
    private void createHeadingGUI() {
        // header
        Label header = new Label("Login Home");
        header.setFont(Font.font(25));
        header.setTextFill(Color.GREEN);
        addChildren(header);
    }

    // crate home GUI
    private void createHomeGUI() {

        // init button
        loginBtn = new Button("Login");
        registerBtn = new Button("Registration");

        loginBtn.setOnAction(this);
        registerBtn.setOnAction(this);

        // init all horizontal box
        HBox fullNameHBox = Utils.getFormattedHBox(loginBtn, registerBtn);

        // add all children
        addChildren(fullNameHBox);
    }


    // add children to root layout
    private void addChildren(Node... node) {
        root.getChildren().addAll(node);
    }

    // handle button events
    @Override
    public void handle(ActionEvent event) {
        // login button
        if (event.getSource().equals(loginBtn)) {
            // load login GUI
            primaryStage.setScene(new LoginGUI(primaryStage));
        }

        // registration button
        if (event.getSource().equals(registerBtn)) {
            // load registration GUI
            primaryStage.setScene(new RegistrationGUI(primaryStage));
        }
    }

}
