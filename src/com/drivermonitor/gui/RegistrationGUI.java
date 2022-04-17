package com.drivermonitor.gui;

import com.drivermonitor.uitls.Utils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(20);
    private static final int WIDTH = 350;
    private static final int HEIGHT = 500;
    private static final String TITLE = "Registration";
    private final Stage primaryStage;

    // init buttons
    private Button cancelBtn;
    private Button registerBtn;

    // init all input fields for registration from
    private TextField fullNameTxtFld;
    private TextField usernameTxtFld;
    private TextField phoneTxtFld;
    private TextField emailTxtFld;
    private PasswordField passwordTxtFld;
    private CheckBox maleCkBox;
    private CheckBox femaleCkBox;
    private CheckBox customerCkBox;
    private CheckBox driverCkBox;


    public RegistrationGUI(Stage primaryStage) {
        super(root, WIDTH, HEIGHT);
        this.primaryStage = primaryStage;
        primaryStage.setTitle(TITLE);

        // customize header & add design in root layout
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(Utils.getBackground(Color.WHITESMOKE));
        root.setPadding(new Insets(50,20,20,20));

        // create header
        createHeadingGUI();

        // create GUI
        createRegistrationGui();

        // init buttons
        createBtnGUI();
    }

    // create header
    private void createHeadingGUI() {
        // header
        Label header = new Label("Register Form");
        header.setFont(Font.font(25));
        header.setTextFill(Color.GREEN);
//        header.setStyle("-fx-font-weight: 18");
        addChildren(header);
    }

    // init all registration levels & fields
    private void createRegistrationGui() {

        fullNameTxtFld = new TextField("Enter full name");
        usernameTxtFld = new TextField("Enter username");
        phoneTxtFld = new TextField("Enter phone number");
        emailTxtFld = new TextField("Enter email");
        passwordTxtFld = new PasswordField();
        maleCkBox = new CheckBox("Male");
        femaleCkBox = new CheckBox("Female");
        customerCkBox = new CheckBox("Customer");
        customerCkBox = new CheckBox("Driver");

        // init all horizontal box
        HBox fullNameHBox = Utils.getFormattedHBox(new Label("Full name"), fullNameTxtFld);
        HBox usernameHBox = Utils.getFormattedHBox(new Label("Username"), usernameTxtFld);
        HBox phoneHBox = Utils.getFormattedHBox(new Label("Phone"), phoneTxtFld);
        HBox emailHBox = Utils.getFormattedHBox(new Label("Email"), emailTxtFld);
        HBox passwordHBox = Utils.getFormattedHBox(new Label("Password"), passwordTxtFld);

        // add all children
        addChildren(fullNameHBox, usernameHBox, phoneHBox, emailHBox, passwordHBox);
    }


    // init all button & design
    private void createBtnGUI() {
        // cancel button
        cancelBtn = new Button("Cancel");
        cancelBtn.setBackground(Utils.getBackground(Color.RED));
        cancelBtn.setTextFill(Color.WHITE);
        cancelBtn.setPadding(new Insets(10,10,10,10));
        cancelBtn.setOnAction(this);

        // register button
        registerBtn = new Button("Register");
        registerBtn.setBackground(Utils.getBackground(Color.BLUE));
        registerBtn.setTextFill(Color.WHITE);
        registerBtn.setPadding(new Insets(10,10,10,10));
        registerBtn.setOnAction(this);

        // add both button horizontally
        HBox hBox = Utils.getFormattedHBox(cancelBtn, registerBtn);
        addChildren(hBox);
    }

    // add children to root layout
    private void addChildren(Node... node){
        root.getChildren().addAll(node);
    }

    // handle button events
    @Override
    public void handle(ActionEvent event) {
        // registration button
        if (event.getSource().equals(registerBtn)) {
            handleRegisterButtonAction();
        }

        // cancel button
        else if (event.getSource().equals(cancelBtn)) {
            System.exit(0);
        }
    }

    // todo register & save data into database
    private void handleRegisterButtonAction() {
        System.out.println("User Registration");
    }
}
