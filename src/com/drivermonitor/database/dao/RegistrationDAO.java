package com.drivermonitor.database.dao;

import com.drivermonitor.database.pojo.Registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationDAO extends AbstractDao<Registration> {

    // MySQL QUERY
    private final String TABLE_NAME = "registration";
    private final String CREATE = String.format("INSERT INTO %s (email, pass, phone_num, address, rest_id) "
            + "VALUES (?, ?, ?, ?, ?);", TABLE_NAME);
    private final String UPDATE = String.format("UPDATE %s SET email=?, pass=?, phone_num=?, address=? , " +
            "rest_id=? WHERE reg_id=?;", TABLE_NAME);
    private final String DELETE = String.format("DELETE FROM %s WHERE reg_id = ?;", TABLE_NAME);
    private final String READ_ID = String.format("SELECT * FROM %s WHERE reg_id = ?;", TABLE_NAME);
    private final String READ_ALL = String.format("SELECT * FROM %s;", TABLE_NAME);
    ;

    @Override
    public Registration create(Registration object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(CREATE);
            statement.setString(1, object.getEmail());
            statement.setString(2, object.getPass());
            statement.setString(3, object.getPhone_num());
            statement.setString(4, object.getAddress());
            statement.setInt(5, object.getRest_id());
            int i = statement.executeUpdate();
            statement.close();
            object.setReg_id(i);
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Registration update(Registration object) {
        try {
            //    private final String UPDATE = String.format("UPDATE %s SET email=?, pass=?, phone_num=?, address=? , " +
            //            "rest_id=? WHERE reg_id=?;", TABLE_NAME);
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getEmail());
            statement.setString(2, object.getPass());
            statement.setString(3, object.getPhone_num());
            statement.setString(4, object.getAddress());
            statement.setInt(5, object.getRest_id());
            statement.setInt(6, object.getReg_id());
            int i = statement.executeUpdate();
            statement.close();
            object.setReg_id(i);
            return object;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(Registration object) {
        try {
            // create and execute db statement
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, object.getReg_id());
            int i = statement.executeUpdate();
            statement.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Registration findByID(int id) {
        try {
            statement = connection.prepareStatement(READ_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Registration registration = new Registration();
                registration.setReg_id(resultSet.getInt("reg_id"));
                registration.setEmail(resultSet.getString("email"));
                registration.setPass(resultSet.getString("pass"));
                registration.setPhone_num(resultSet.getString("phone_num"));
                registration.setAddress(resultSet.getString("address"));
                registration.setRest_id(resultSet.getInt("rest_id"));
                return registration;
            } else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Registration> findAll() {
        try {
            statement = connection.prepareStatement(READ_ALL);
            ArrayList<Registration> list = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Registration registration = new Registration();
                //email, pass, phone_num, address, rest_id
                registration.setReg_id(resultSet.getInt("reg_id"));
                registration.setEmail(resultSet.getString("email"));
                registration.setPass(resultSet.getString("pass"));
                registration.setPhone_num(resultSet.getString("phone_num"));
                registration.setAddress(resultSet.getString("address"));
                registration.setRest_id(resultSet.getInt("rest_id"));

                list.add(registration);
            }

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

/*    // test dao
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.setEmail("zosdhagaaddn@gmail.com");
        registration.setPhone_num("+23sadd23ad5");
        registration.setPass("fsadfc");
        registration.setAddress("Damaadmm");
        registration.setRest_id(2);

        AbstractDao<Registration> dao = new RegistrationDAO();
//        Registration registration1 = dao.create(registration);

//        registration.setPass("1234ad5");
//        dao.update(registration);

//        System.out.println(dao.findAll());
//        System.out.println(dao.findByID("1"));
//        registration.setReg_id(12);
        Registration byID = dao.findByID("13");
        byID.setPhone_num("123AA123");
        System.out.println(dao.update(byID));
    }*/
}
