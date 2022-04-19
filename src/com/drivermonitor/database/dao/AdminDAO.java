package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Admin;

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
        return null;
    }

    @Override
    public Admin update(Admin object) {
        return null;
    }

    @Override
    public int delete(Admin object) {
        return 0;
    }

    @Override
    public Admin findByID(int id) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }
}
