package com.drivermonitor.database.dao;

import com.drivermonitor.database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public abstract class AbstractDao<T> {

    protected static Connection connection;
    protected PreparedStatement statement;

    public AbstractDao() {
        connection = DbConnection.getConnection();
    }

    // insert data into the table
    abstract T create(T object);

    // insert data into the table
    abstract T update(T object);

    // delete
    abstract int delete(T object);

    // find by id
    abstract T findByID(String id);

    // read all from table
    abstract List<T> findAll();

    // total data in table
    public int size() {
        return findAll().size();
    }

}
