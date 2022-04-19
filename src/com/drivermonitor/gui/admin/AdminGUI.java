package com.drivermonitor.gui.admin;

import com.drivermonitor.MainApplication;
import com.drivermonitor.uitls.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
    private static final int WIDTH = 350;
    private static final int HEIGHT = 500;
    private static final String TITLE = "Admin";
    private final Stage primaryStage;

    // init buttons
    private Button orderBtn;
    private Button customerBtn;
    private Button driverBtn;
    private Button restBtn;
    private Button backBtn;

    public AdminGUI(Stage primaryStage) {
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
        Label header = new Label("ADMIN");
        header.setFont(Font.font(25));
        header.setTextFill(Color.GREEN);
        addChildren(header);
    }

    // crate home GUI
    private void createHomeGUI() {

        // init button
        orderBtn = new Button("Click here");
        orderBtn.setOnAction(this);
        customerBtn = new Button("Click here");
        customerBtn.setOnAction(this);
        driverBtn = new Button("Click here");
        driverBtn.setOnAction(this);
        restBtn = new Button("Click here");
        restBtn.setOnAction(this);
        backBtn = new Button("Click here");
        backBtn.setOnAction(this);

        // init all horizontal box
        HBox orderHBox = Utils.getFormattedHBox(new Label("All Order"), orderBtn);
        HBox customerHBox = Utils.getFormattedHBox(new Label("All Customer"), customerBtn);
        HBox driverHBox = Utils.getFormattedHBox(new Label("All Driver"), driverBtn);
        HBox restHBox = Utils.getFormattedHBox(new Label("All Restaurant"), restBtn);
        HBox backHBox = Utils.getFormattedHBox(new Label("Back to Home"), backBtn);

        // add all children
        addChildren(orderHBox, customerHBox, driverHBox, restHBox,backHBox);
    }


    // add children to root layout
    private void addChildren(Node... node) {
        root.getChildren().addAll(node);
    }

    // handle button events
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(orderBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("order_panel"));
        }

        if (event.getSource().equals(customerBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("customer_panel"));
        }

        if (event.getSource().equals(driverBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("driver_panel"));
        }

        if (event.getSource().equals(restBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("rest_panel"));
        }

        if (event.getSource().equals(backBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("home"));
        }
    }

}
