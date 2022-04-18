package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// todo: fixed according to ERD
public class RegistrationDAO extends AbstractDao<Registration> {

    // MySQL QUERY
    private final String TABLE_NAME = "registration";
    private final String CREATE = String.format("INSERT INTO %s (full_name, email, pass,phone_num,address) "
            + "VALUES (?, ?, ?, ?, ?);", TABLE_NAME);
    private final String UPDATE = String.format("UPDATE %s SET full_name=?, email=?, pass=?, phone_num=? , " +
            "address=? WHERE reg_id=?;", TABLE_NAME);
    private final String DELETE = String.format("DELETE FROM %s WHERE reg_id = ?;", TABLE_NAME);
    private final String READ_ID = String.format("SELECT * FROM %s WHERE reg_id = ?;", TABLE_NAME);
    private final String READ_ALL = String.format("SELECT * FROM %s;", TABLE_NAME);;

    @Override
    Registration create(Registration object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(CREATE);
            statement.setString(1, object.getFullName());
            statement.setString(2, object.getEmail());
            statement.setString(3, object.getPassword());
            statement.setString(4, object.getPhoneNum());
            statement.setString(5, object.getAddress());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    Registration update(Registration object) {
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getFullName());
            statement.setString(2, object.getEmail());
            statement.setString(3, object.getPassword());
            statement.setString(4, object.getPhoneNum());
            statement.setString(5, object.getAddress());
            statement.setInt(6, object.getRegID());
            statement.executeUpdate();
            statement.close();
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    int delete(Registration object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, object.getRegID());
            int i = statement.executeUpdate();
            statement.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    Registration findByID(String id) {
        try {
            statement = connection.prepareStatement(READ_ID);
            statement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Registration registration = new Registration();
                registration.setRegID(resultSet.getInt("reg_id"));
                registration.setFullName(resultSet.getString("full_name"));
                registration.setPassword(resultSet.getString("pass"));
                registration.setPhoneNum(resultSet.getString("phone_num"));
                registration.setEmail(resultSet.getString("email"));
                registration.setAddress(resultSet.getString("address"));
                return registration;
            } else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    List<Registration> findAll() {
        try {
            statement = connection.prepareStatement(READ_ALL);
            ArrayList<Registration> list = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Registration registration = new Registration();
                registration.setRegID(resultSet.getInt("reg_id"));
                registration.setFullName(resultSet.getString("full_name"));
                registration.setPassword(resultSet.getString("pass"));
                registration.setPhoneNum(resultSet.getString("phone_num"));
                registration.setEmail(resultSet.getString("email"));
                registration.setAddress(resultSet.getString("address"));
                list.add(registration);
            }

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // test dao
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.setFullName("Zohan");
        registration.setEmail("zohan26@gmail.com");
        registration.setPhoneNum("+880545985152");
        registration.setPassword("65567");
        registration.setAddress("Hatirjhil, Bangladesh");

        AbstractDao<Registration> dao = new RegistrationDAO();
//        dao.create(registration);

        Registration adib = new Registration();
        adib.setRegID(3);
        adib.setFullName("Zohan Norr Hasan");
        adib.setEmail("zohan.hasan26@gmail.com");
        adib.setPhoneNum("+880545982");
        adib.setPassword("655asd67");
        adib.setAddress("Dhaka, Bangladesh");
//        dao.update(adib);

        System.out.println(dao.findAll());
    }
}
