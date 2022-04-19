package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Restaurant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// todo: not tested yet
public class RestaurantDAO extends AbstractDao<Restaurant> {

    // MySQL QUERY
    private final String TABLE_NAME = "restaurant";
    private final String CREATE = String.format("INSERT INTO %s (offers, type_of_food, meal_name, order_id) "
            + "VALUES (?, ?, ?, ?);", TABLE_NAME);
    private final String UPDATE = String.format("UPDATE %s SET offers=?, type_of_food=?, meal_name=?, order_id=? WHERE rest_id=?;",
            TABLE_NAME);
    private final String DELETE = String.format("DELETE FROM %s WHERE rest_id = ?;", TABLE_NAME);
    private final String READ_ID = String.format("SELECT * FROM %s WHERE rest_id = ?;", TABLE_NAME);
    private final String READ_ALL = String.format("SELECT * FROM %s;", TABLE_NAME);

    @Override
    public Restaurant create(Restaurant object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(CREATE);
            statement.setString(1, object.getOffers());
            statement.setString(2, object.getType_of_food());
            statement.setString(3, object.getMeal_name());
            statement.setInt(4, object.getOrder_id());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Restaurant update(Restaurant object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getOffers());
            statement.setString(2, object.getType_of_food());
            statement.setString(3, object.getMeal_name());
            statement.setInt(4, object.getOrder_id());
            statement.setInt(5, object.getRest_id());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(Restaurant object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, object.getRest_id());
            int i = statement.executeUpdate();
            statement.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Restaurant findByID(int id) {
        try {
            statement = connection.prepareStatement(READ_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                //(offers, type_of_food, meal_name, order_id)
                Restaurant restaurant = new Restaurant();
                restaurant.setRest_id(resultSet.getInt("rest_id"));
                restaurant.setOffers(resultSet.getString("offers"));
                restaurant.setOffers(resultSet.getString("type_of_food"));
                restaurant.setOffers(resultSet.getString("meal_name"));
                restaurant.setOrder_id(resultSet.getInt("order_id"));

                return restaurant;
            } else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        try {
            statement = connection.prepareStatement(READ_ALL);
            ArrayList<Restaurant> list = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                //(offers, type_of_food, meal_name, order_id)
                Restaurant restaurant = new Restaurant();
                restaurant.setRest_id(resultSet.getInt("rest_id"));
                restaurant.setOffers(resultSet.getString("offers"));
                restaurant.setOffers(resultSet.getString("type_of_food"));
                restaurant.setOffers(resultSet.getString("meal_name"));
                restaurant.setOrder_id(resultSet.getInt("order_id"));

                list.add(restaurant);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
