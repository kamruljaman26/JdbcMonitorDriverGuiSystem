package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Customer;
import com.drivermonitor.database.pojo.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends AbstractDao<Customer> {

    // MySQL QUERY
    private final String TABLE_NAME = "customer";
    private final String CREATE = String.format("INSERT INTO %s (full_name, address, past_order, order_t, admin_id, reg_id) "
            + "VALUES (?, ?, ?, ?, ?, ?);", TABLE_NAME);
    private final String UPDATE = String.format("UPDATE %s SET full_name=?, address=?, past_order=?, order_t=?" +
                    "admin_id=?, reg_id=? WHERE cust_id=?;",
            TABLE_NAME);
    private final String DELETE = String.format("DELETE FROM %s WHERE cust_id = ?;", TABLE_NAME);
    private final String READ_ID = String.format("SELECT * FROM %s WHERE cust_id = ?;", TABLE_NAME);
    private final String READ_ALL = String.format("SELECT * FROM %s;", TABLE_NAME);

    @Override
    public Customer create(Customer object) {
        try {
            // create and execute db statement
            //full_name, address, past_order, order_t, admin_id, reg_id
            statement = connection.prepareStatement(CREATE);
            statement.setString(1, object.getFull_name());
            statement.setString(2, object.getAddress());
            statement.setInt(3, object.getPast_order());
            statement.setInt(4, object.getOrder());
            statement.setInt(5, object.getAdmin_id());
            statement.setInt(6, object.getReg_id());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer update(Customer object) {
        try {
            // create and execute db statement
            //full_name, address, past_order, order_t, admin_id, reg_id
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getFull_name());
            statement.setString(2, object.getAddress());
            statement.setInt(3, object.getPast_order());
            statement.setInt(4, object.getOrder());
            statement.setInt(5, object.getAdmin_id());
            statement.setInt(6, object.getReg_id());
            statement.setInt(7, object.getCust_id());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(Customer object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, object.getCust_id());
            int i = statement.executeUpdate();
            statement.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;    }

    @Override
    public Customer findByID(int id) {
        try {
            statement = connection.prepareStatement(READ_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                //full_name, address, past_order, order_t, admin_id, reg_id
                Customer customer = new Customer();
                customer.setCust_id(resultSet.getInt("cust_id"));
                customer.setFull_name(resultSet.getString("full_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPast_order(resultSet.getInt("past_order"));
                customer.setOrder(resultSet.getInt("order_t"));
                customer.setAdmin_id(resultSet.getInt("admin_id"));
                customer.setReg_id(resultSet.getInt("reg_id"));

                return customer;
            } else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        try {
            statement = connection.prepareStatement(READ_ALL);
            ArrayList<Customer> list = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                //full_name, address, past_order, order_t, admin_id, reg_id
                Customer customer = new Customer();
                customer.setCust_id(resultSet.getInt("cust_id"));
                customer.setFull_name(resultSet.getString("full_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPast_order(resultSet.getInt("past_order"));
                customer.setOrder(resultSet.getInt("order_t"));
                customer.setAdmin_id(resultSet.getInt("admin_id"));
                customer.setReg_id(resultSet.getInt("reg_id"));

                list.add(customer);
            }

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstractDao<Customer> dao = new CustomerDAO();
        System.out.println(dao.findAll());
    }
}
