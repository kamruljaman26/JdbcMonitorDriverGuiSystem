package com.drivermonitor.gui.admin;

import com.drivermonitor.MainApplication;
import com.drivermonitor.database.dao.RegistrationDAO;
import com.drivermonitor.database.dao.RestaurantDAO;
import com.drivermonitor.database.pojo.Registration;
import com.drivermonitor.database.pojo.Restaurant;
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

public class RestaurantPanelGUI extends Scene implements EventHandler<ActionEvent> {

    // set root layout based on need
    private static final VBox root = new VBox(15);
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final String TITLE = "Admin Panel : Restaurant";
    private final Stage primaryStage;

    // init buttons
    private Button mainPanelBtn;
    private Button orderPanelBtn;

    public RestaurantPanelGUI(Stage primaryStage) {
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
        Label header = new Label("Admin Panel: Restaurant");
        header.setFont(Font.font(25));
        header.setTextFill(Color.GREEN);
        addChildren(header);
    }

    // crate home GUI
    private void createHomeGUI() {

        // init button
        mainPanelBtn = new Button("Main Panel");
        mainPanelBtn.setOnAction(this);
        orderPanelBtn = new Button("Order Panel");
        orderPanelBtn.setOnAction(this);

        // init all horizontal box
        HBox orderHBox = Utils.getFormattedHBox(mainPanelBtn, orderPanelBtn);

        createTable();

        // add all children
        addChildren(orderHBox);
    }

    private void createTable() {
        TableView<Restaurant> tableView = new TableView<>();

        TableColumn<Restaurant, String> column1 = new TableColumn<>("Offers");
        column1.setCellValueFactory(new PropertyValueFactory<>("offers"));

        TableColumn<Restaurant, String> column2 = new TableColumn<>("Type of food");
        column2.setCellValueFactory(new PropertyValueFactory<>("type_of_food"));

        TableColumn<Restaurant, String> column3 = new TableColumn<>("Meal Name");
        column3.setCellValueFactory(new PropertyValueFactory<>("meal_name"));

        TableColumn<Restaurant, String> column4 = new TableColumn<>("Order ID");
        column4.setCellValueFactory(new PropertyValueFactory<>("order_id"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        for (Restaurant rest : new RestaurantDAO().findAll()) {
            tableView.getItems().add(rest);

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
        if (event.getSource().equals(orderPanelBtn)) {
            primaryStage.setScene(MainApplication.scenes.get("order_panel"));
        }
    }
}
