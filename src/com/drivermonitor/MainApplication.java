package com.drivermonitor;

import com.drivermonitor.gui.customer.CustomerProfileGUI;
import com.drivermonitor.gui.customer.HomeGUI;
import com.drivermonitor.gui.customer.LoginGUI;
import com.drivermonitor.gui.customer.RegistrationGUI;
import com.drivermonitor.gui.admin.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class MainApplication extends Application {

    public static HashMap<String,Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        // add all scenes
        scenes.put("home",new HomeGUI(primaryStage));
        scenes.put("login",new LoginGUI(primaryStage));
        scenes.put("reg",new RegistrationGUI(primaryStage));
        scenes.put("admin",new AdminGUI(primaryStage));
        scenes.put("driver_panel",new DriverPanelGUI(primaryStage));
        scenes.put("customer_panel",new CustomerPanelGUI(primaryStage));
        scenes.put("rest_panel",new RestaurantPanelGUI(primaryStage));
        scenes.put("order_panel",new OrderPanelGUI(primaryStage));
        scenes.put("customer_profile_panel",new CustomerProfileGUI(primaryStage));

        primaryStage.setScene(scenes.get("home"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
