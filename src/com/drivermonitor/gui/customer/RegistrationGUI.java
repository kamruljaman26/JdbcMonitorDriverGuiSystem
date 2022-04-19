package com.drivermonitor.gui.customer;

import com.drivermonitor.MainApplication;
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

public class RegistrationGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
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
        root.setPadding(new Insets(50, 20, 20, 20));

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

        fullNameTxtFld = new TextField("");
        usernameTxtFld = new TextField("");
        phoneTxtFld = new TextField("");
        emailTxtFld = new TextField("");
        passwordTxtFld = new PasswordField();

        maleCkBox = new CheckBox("Male");
        femaleCkBox = new CheckBox("Female");
        customerCkBox = new CheckBox("Customer");
        driverCkBox = new CheckBox("Driver");

        customerCkBox.setSelected(true);
        maleCkBox.setSelected(true);

        maleCkBox.setOnAction(this);
        femaleCkBox.setOnAction(this);
        customerCkBox.setOnAction(this);
        driverCkBox.setOnAction(this);

        // init all horizontal box
        HBox fullNameHBox = Utils.getFormattedHBox(new Label("Full name"), fullNameTxtFld);
        HBox usernameHBox = Utils.getFormattedHBox(new Label("Username"), usernameTxtFld);
        HBox phoneHBox = Utils.getFormattedHBox(new Label("Phone"), phoneTxtFld);
        HBox emailHBox = Utils.getFormattedHBox(new Label("Email"), emailTxtFld);
        HBox passwordHBox = Utils.getFormattedHBox(new Label("Password"), passwordTxtFld);
        HBox genderHBox = Utils.getFormattedHBox(new Label("Gender"), maleCkBox, femaleCkBox);
        HBox userHBoxTitle = Utils.getFormattedHBox(new Label("Customer or Driver"));
        HBox userHBox = Utils.getFormattedHBox(customerCkBox, driverCkBox);

        // add all children
        addChildren(fullNameHBox, usernameHBox, phoneHBox, emailHBox,
                passwordHBox, genderHBox, userHBoxTitle, userHBox);
    }


    // init all button & design
    private void createBtnGUI() {
        // cancel button
        cancelBtn = new Button("Back");
        cancelBtn.setBackground(Utils.getBackground(Color.RED));
        cancelBtn.setTextFill(Color.WHITE);
        cancelBtn.setPadding(new Insets(10, 10, 10, 10));
        cancelBtn.setOnAction(this);

        // register button
        registerBtn = new Button("Register");
        registerBtn.setBackground(Utils.getBackground(Color.BLUE));
        registerBtn.setTextFill(Color.WHITE);
        registerBtn.setPadding(new Insets(10, 10, 10, 10));
        registerBtn.setOnAction(this);

        // add both button horizontally
        HBox hBox = Utils.getFormattedHBox(cancelBtn, registerBtn);
        addChildren(hBox);
    }

    // add children to root layout
    private void addChildren(Node... node) {
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
        if (event.getSource().equals(cancelBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("home"));
        }

        // gender checkbox
        if (event.getSource().equals(maleCkBox)) {
            femaleCkBox.setSelected(false);
        } else if (event.getSource().equals(femaleCkBox)) {
            maleCkBox.setSelected(false);
        }

        // customer driver checkbox
        if (event.getSource().equals(customerCkBox)) {
            driverCkBox.setSelected(false);
        } else if (event.getSource().equals(driverCkBox)) {
            customerCkBox.setSelected(false);
        }
    }

    // todo register & save data into database
    private void handleRegisterButtonAction() {
        String fullName = fullNameTxtFld.getText();
        String username = usernameTxtFld.getText();
        String phone = phoneTxtFld.getText();
        String email = emailTxtFld.getText();
        String password = emailTxtFld.getText();
        String userType = getUserType();

        System.out.println("User Registration");
    }


    // return user type from checkbox
    private String getUserType() {
        return "";
    }
}
