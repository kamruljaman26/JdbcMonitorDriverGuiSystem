package com.drivermonitor.database.pojo;

public class Customer {

    private int cust_id;
    private String full_name;
    private String address;
    private int past_order;
    private int order;
    private int admin_id;
    private int reg_id;

    public Customer() {
    }

    public Customer(String full_name, String address, int past_order, int order, int admin_id, int reg_id) {
        this.full_name = full_name;
        this.address = address;
        this.past_order = past_order;
        this.order = order;
        this.admin_id = admin_id;
        this.reg_id = reg_id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPast_order() {
        return past_order;
    }

    public void setPast_order(int past_order) {
        this.past_order = past_order;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", full_name='" + full_name + '\'' +
                ", address='" + address + '\'' +
                ", past_order=" + past_order +
                ", order=" + order +
                ", admin_id=" + admin_id +
                ", reg_id=" + reg_id +
                '}';
    }
}
