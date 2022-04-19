package com.drivermonitor.gui.customer;

import com.drivermonitor.MainApplication;
import com.drivermonitor.database.dao.CustomerDAO;
import com.drivermonitor.database.dao.RegistrationDAO;
import com.drivermonitor.database.pojo.Customer;
import com.drivermonitor.database.pojo.Registration;
import com.drivermonitor.uitls.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
    private static final int WIDTH = 350;
    private static final int HEIGHT = 500;
    private static final String TITLE = "Customer Login";
    private final Stage primaryStage;

    // init buttons
    private Button backBtn;
    private Button loginBtn;

    private TextField emailTxtFld;
    private PasswordField passTxtFld;
    private Label warningLabel;

    public LoginGUI(Stage primaryStage) {
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
        backBtn = new Button("Back");
        loginBtn = new Button("Login");
        warningLabel = new Label();
        warningLabel.setTextFill(Color.RED);

        emailTxtFld = new TextField();
        passTxtFld = new PasswordField();

        loginBtn.setOnAction(this);
        backBtn.setOnAction(this);


        // init all horizontal box
        HBox emailHBox = Utils.getFormattedHBox(new Label("Enter email"), emailTxtFld);
        HBox passwordHBox = Utils.getFormattedHBox(new Label("Enter password"), passTxtFld);
        HBox fullNameHBox = Utils.getFormattedHBox(backBtn, loginBtn);

        // add all children
        addChildren(emailHBox, passwordHBox, fullNameHBox, warningLabel);
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
            handleLoginCustomer();
        }

        // back button button
        if (event.getSource().equals(backBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("home"));
            warningLabel.setText("");
        }
    }

    // handle login and validation
    private void handleLoginCustomer() {

        // dao
        RegistrationDAO regDao = new RegistrationDAO();
        CustomerDAO cusDao = new CustomerDAO();

        String email = emailTxtFld.getText();
        String pass = passTxtFld.getText();

        if (email.equals("") || pass.equals("")) {
            warningLabel.setText("email or password can't be empty");
        }

        Customer customer = null;
        Registration registration = null;
        for (Registration reg : regDao.findAll()) {
            // check email and pass
            if (reg.getEmail().equals(email) && reg.getPass().equals(pass)) {
                // check register user is customer or not
                for (Customer cus : cusDao.findAll()) {
                    if (cus.getReg_id() == reg.getReg_id()) {
                        customer = cus;
                        registration = reg;
                    }
                }
            }
        }

        // if customer font and validation done and customer is not null-> login success
        if (customer != null) {
            VBox vBox = new VBox(15);
            CustomerProfileGUI customerProfileGUI = new CustomerProfileGUI(primaryStage, vBox);
            customerProfileGUI.setData(customer, registration);
            primaryStage.setScene(customerProfileGUI);
            warningLabel.setText("");
        } else {
            warningLabel.setText("Invalid username or password! try again");
        }
    }

}
