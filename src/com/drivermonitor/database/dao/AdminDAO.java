package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Admin;
import com.drivermonitor.database.pojo.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends AbstractDao<Admin> {

    //cust_name, all_orders, rest_menu, order_id
    private final String TABLE_NAME = "admin";
    private final String CREATE = String.format("INSERT INTO %s (cust_name, all_orders, rest_menu, order_id) "
            + "VALUES (?, ?, ?, ?);", TABLE_NAME);
    private final String UPDATE = String.format("UPDATE %s SET cust_name=?, all_orders=?, rest_menu=?, order_id=? WHERE admin_id=?;",
            TABLE_NAME);
    private final String DELETE = String.format("DELETE FROM %s WHERE admin_id = ?;", TABLE_NAME);
    private final String READ_ID = String.format("SELECT * FROM %s WHERE admin_id = ?;", TABLE_NAME);
    private final String READ_ALL = String.format("SELECT * FROM %s;", TABLE_NAME);


    @Override
    public Admin create(Admin object) {
        try {
            //cust_name, all_orders, rest_menu, order_id
            statement = connection.prepareStatement(CREATE);
            statement.setString(1, object.getCust_name());
            statement.setString(2, object.getAll_order());
            statement.setString(3, object.getRest_menu());
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
    public Admin update(Admin object) {
        try {
            //cust_name, all_orders, rest_menu, order_id
            statement = connection.prepareStatement(CREATE);
            statement.setString(1, object.getCust_name());
            statement.setString(2, object.getAll_order());
            statement.setString(3, object.getRest_menu());
            statement.setInt(4, object.getOrder_id());
            statement.setInt(5, object.getAdmin_id());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(Admin object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, object.getAdmin_id());
            int i = statement.executeUpdate();
            statement.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;    }

    @Override
    public Admin findByID(int id) {
        try {
            statement = connection.prepareStatement(READ_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setAdmin_id(resultSet.getInt("admin_id"));
                admin.setCust_name(resultSet.getString("cust_name"));
                admin.setAll_order(resultSet.getString("all_orders"));
                admin.setRest_menu(resultSet.getString("rest_menu"));
                admin.setOrder_id(resultSet.getInt("order_id"));
                return admin;
            } else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        try {
            statement = connection.prepareStatement(READ_ALL);
            ArrayList<Admin> list = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Admin admin = new Admin();
                admin.setAdmin_id(resultSet.getInt("admin_id"));
                admin.setCust_name(resultSet.getString("cust_name"));
                admin.setAll_order(resultSet.getString("all_orders"));
                admin.setRest_menu(resultSet.getString("rest_menu"));
                admin.setOrder_id(resultSet.getInt("order_id"));

                list.add(admin);
            }

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
