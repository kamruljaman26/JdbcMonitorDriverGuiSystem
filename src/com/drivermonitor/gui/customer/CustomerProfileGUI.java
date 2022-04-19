package com.drivermonitor.gui.customer;

import com.drivermonitor.MainApplication;
import com.drivermonitor.database.dao.OrderDAO;
import com.drivermonitor.database.pojo.Customer;
import com.drivermonitor.database.pojo.Order;
import com.drivermonitor.database.pojo.Registration;
import com.drivermonitor.uitls.CustomerData;
import com.drivermonitor.uitls.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomerProfileGUI extends Scene implements EventHandler<ActionEvent>, CustomerData {

    // set root layout based on need
    private VBox root;
    private int WIDTH = 350;
    private int HEIGHT = 500;
    private String TITLE = "Customer Profile";
    private Stage primaryStage;

    private Customer customer;
    private Registration registration;

    // init buttons
    private Button signoutBtn;
    private Button orderBtn;
    private Button pastOrderBtn;

    private Label nameLbl, phoneLbl, emailLbl;
    private CheckBox medaCkBox, stcpayCkBox;
    private Label warningLbl;

    public CustomerProfileGUI(Stage primaryStage, VBox root) {
        super(root, 350, 500);
        this.root = root;
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

        nameLbl = new Label("Name: ");
        phoneLbl = new Label("Phone: ");
        emailLbl = new Label("Email: ");
        warningLbl = new Label("");
        warningLbl.setTextFill(Color.GREEN);
        warningLbl.setAlignment(Pos.BOTTOM_CENTER);

        medaCkBox = new CheckBox("Meda");
        stcpayCkBox = new CheckBox("STCPAY");

        medaCkBox.setSelected(true);
        medaCkBox.setOnAction(this);
        stcpayCkBox.setOnAction(this);

        // init all horizontal box
        HBox buttonsHBox = Utils.getFormattedHBox(signoutBtn, orderBtn, pastOrderBtn);
        HBox paymentHBox = Utils.getFormattedHBox(new Label("Payment Method "), medaCkBox, stcpayCkBox);

        // add all children
        addChildren(nameLbl, phoneLbl, emailLbl, paymentHBox, buttonsHBox, warningLbl);
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

        if (event.getSource().equals(orderBtn)) {
            handleOrderBtnAction();
        }

        if (event.getSource().equals(pastOrderBtn)) {
            handlePastOrderBtnAction();
        }

        if (event.getSource().equals(medaCkBox)) {
            stcpayCkBox.setSelected(false);
        }

        if (event.getSource().equals(medaCkBox)) {
            medaCkBox.setSelected(false);
        }
    }

    // order button
    private void handleOrderBtnAction() {
        //double tax, String meals, double price, String driver_name
        Order order = new Order();
        order.setTax(getRandomNumber(1, 100));
        order.setMeals("Meal " + getRandomNumber(1, 100));
        order.setPrice(getRandomNumber(1, 100));
        order.setDriver_name(customer.getFull_name());

        OrderDAO dao = new OrderDAO();
        dao.create(order);

        warningLbl.setText("Order created successfully!");
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // past order button
    private void handlePastOrderBtnAction() {
        OrderDAO dao = new OrderDAO();
        Order order = dao.findByID(customer.getPast_order());
        warningLbl.setText(String.format("Past OrderInfo: Order id: %d\nTax: %.2f\nMeal: %s,\nPrice %.2f\nDriver Name: %s",
                order.getOrder_id(), order.getTax(), order.getMeals(), order.getPrice(), order.getDriver_name()));
    }

    @Override
    public void setData(Customer customer, Registration registration) {
        this.customer = customer;
        this.registration = registration;

        nameLbl.setText(nameLbl.getText() + "" + customer.getFull_name());
        phoneLbl.setText(phoneLbl.getText() + "" + registration.getPhone_num());
        emailLbl.setText(emailLbl.getText() + "" + registration.getEmail());
    }
}
