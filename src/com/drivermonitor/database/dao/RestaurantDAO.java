package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO extends AbstractDao<Order> {

    // MySQL QUERY
    private final String TABLE_NAME = "order_t";
    private final String CREATE = String.format("INSERT INTO %s (tax, meals, price, driver_name) "
            + "VALUES (?, ?, ?, ?);", TABLE_NAME);
    private final String UPDATE = String.format("UPDATE %s SET tax=?, meals=?, price=?, driver_name=? WHERE order_id=?;",
            TABLE_NAME);
    private final String DELETE = String.format("DELETE FROM %s WHERE order_id = ?;", TABLE_NAME);
    private final String READ_ID = String.format("SELECT * FROM %s WHERE order_id = ?;", TABLE_NAME);
    private final String READ_ALL = String.format("SELECT * FROM %s;", TABLE_NAME);


    @Override
    Order create(Order object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(CREATE);
            statement.setFloat(1, (float) object.getTax());
            statement.setString(2, object.getMeals());
            statement.setFloat(3, (float) object.getPrice());
            statement.setString(4, object.getDriver_name());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    Order update(Order object) {
        try {
            // INSERT INTO %s (tax, meals, price, driver_name)
            statement = connection.prepareStatement(UPDATE);
            statement.setFloat(1, (float) object.getTax());
            statement.setString(2, object.getMeals());
            statement.setFloat(3, (float) object.getPrice());
            statement.setString(4, object.getDriver_name());
            statement.setInt(5, object.getOrder_id());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    int delete(Order object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, object.getOrder_id());
            int i = statement.executeUpdate();
            statement.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


    @Override
    Order findByID(String id) {
        try {
            statement = connection.prepareStatement(READ_ID);
            statement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setOrder_id(resultSet.getInt("tax"));
                order.setTax(resultSet.getFloat("tax"));
                order.setMeals(resultSet.getString("meals"));
                order.setPrice(resultSet.getFloat("price"));
                order.setDriver_name(resultSet.getString("driver_name"));
                return order;
            } else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    List<Order> findAll() {
        try {
            statement = connection.prepareStatement(READ_ALL);
            ArrayList<Order> list = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Order order = new Order();
                order.setOrder_id(resultSet.getInt("order_id"));
                order.setTax(resultSet.getFloat("tax"));
                order.setMeals(resultSet.getString("meals"));
                order.setPrice(resultSet.getFloat("price"));
                order.setDriver_name(resultSet.getString("driver_name"));

                list.add(order);
            }

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


/*    // test dao
    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();

        Order order = new Order();
        order.setPrice(24.32);
        order.setMeals("Doco");
        order.setTax(24.32);
        order.setDriver_name("Humayan ALi");

//        Order order1 = dao.create(order);
//        System.out.println(order1);

//        order.setOrder_id(4);
//        dao.update(order);

        System.out.println(dao.findAll());
    }*/

}
