package com.drivermonitor.gui.admin;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomerPanelGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final String TITLE = "Admin Panel : CUstomer";
    private final Stage primaryStage;

    // init buttons
    private Button mainPanelBtn;
    private Button driverPanelBtn;

    public CustomerPanelGUI(Stage primaryStage) {
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
        Label header = new Label("Admin Panel: Customer");
        header.setFont(Font.font(25));
        header.setTextFill(Color.GREEN);
        addChildren(header);
    }

    // crate home GUI
    private void createHomeGUI() {

        // init button
        mainPanelBtn = new Button("Main Admin");
        mainPanelBtn.setOnAction(this);
        driverPanelBtn = new Button("Driver Panel");
        driverPanelBtn.setOnAction(this);

        // init all horizontal box
        HBox orderHBox = Utils.getFormattedHBox(mainPanelBtn, driverPanelBtn);

        createTable();

        // add all children
        addChildren(orderHBox);
    }

    private void createTable() {
        TableView<Customer> tableView = new TableView<>();

        TableColumn<Customer, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("full_name"));

        TableColumn<Customer, String> column2 = new TableColumn<>("Address");
        column2.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Customer, String> column3 = new TableColumn<>("Admin ID");
        column3.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Customer, String> column4 = new TableColumn<>("Registration ID");
        column4.setCellValueFactory(new PropertyValueFactory<>("admin_id"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        for (Customer customer : new CustomerDAO().findAll()) {
            tableView.getItems().add(customer);

        }

        addChildren(tableView);
    }


    // add children to root layout
    private void addChildren(Node... node) {
        root.getChildren().addAll(node);
    }

    // handle button events
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(mainPanelBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("admin"));
        }
        if (event.getSource().equals(driverPanelBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("driver_panel"));
        }
    }

}
