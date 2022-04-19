package com.drivermonitor.gui.customer;

import com.drivermonitor.MainApplication;
import com.drivermonitor.database.pojo.Customer;
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

public class CustomerProfileGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
    private static final int WIDTH = 350;
    private static final int HEIGHT = 500;
    private static final String TITLE = "Customer Profile";
    private final Stage primaryStage;
    private Customer customer;

    // init buttons
    private Button signoutBtn;
    private Button orderBtn;
    private Button pastOrderBtn;


    public CustomerProfileGUI(Stage primaryStage) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // create header
    private void createHeadingGUI() {
        // header
        Label header = new Label("My Profile");
        header.setFont(Font.font(25));
        header.setTextFill(Color.GREEN);
        addChildren(header);
    }

    // crate home GUI
    private void createHomeGUI() {

        // init button
        signoutBtn = new Button("Sign-out");
        orderBtn = new Button("Order");
        pastOrderBtn = new Button("Past Order");

        signoutBtn.setOnAction(this);
        orderBtn.setOnAction(this);
        pastOrderBtn.setOnAction(this);
        


        // init all horizontal box
        HBox buttonsHBox = Utils.getFormattedHBox(signoutBtn, orderBtn, pastOrderBtn);

        // add all children
        addChildren(buttonsHBox);
    }


    // add children to root layout
    private void addChildren(Node... node) {
        root.getChildren().addAll(node);
    }

    // handle button events
    @Override
    public void handle(ActionEvent event) {
        // login button
        if (event.getSource().equals(signoutBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("home"));
        }

        // back button button
        if (event.getSource().equals(orderBtn)) {
            handleOrderBtnAction();
        }
    }

    // order button
    private void handleOrderBtnAction() {

    }

    // past order button
    private void handlePastOrderBtnAction() {

    }
}
