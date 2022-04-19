package com.drivermonitor.database.pojo;

public class Registration {

    private int reg_id;
    private String email;
    private String pass;
    private String phone_num;
    private String address;
    private int rest_id;

    public Registration() {
    }

    public Registration(String email, String pass, String phone_num, String address, int rest_id) {
        this.email = email;
        this.pass = pass;
        this.phone_num = phone_num;
        this.address = address;
        this.rest_id = rest_id;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "reg_id=" + reg_id +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", address='" + address + '\'' +
                ", rest_id=" + rest_id +
                '}';
    }
}
