package com.drivermonitor.database.pojo;

public class Admin {

    private int admin_id;
    private int cust_name;
    private int all_order;
    private int rest_menu;
    private int order_id;

    public Admin() {
    }

    public Admin(int cust_name, int all_order, int rest_menu, int order_id) {
        this.cust_name = cust_name;
        this.all_order = all_order;
        this.rest_menu = rest_menu;
        this.order_id = order_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getCust_name() {
        return cust_name;
    }

    public void setCust_name(int cust_name) {
        this.cust_name = cust_name;
    }

    public int getAll_order() {
        return all_order;
    }

    public void setAll_order(int all_order) {
        this.all_order = all_order;
    }

    public int getRest_menu() {
        return rest_menu;
    }

    public void setRest_menu(int rest_menu) {
        this.rest_menu = rest_menu;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", cust_name=" + cust_name +
                ", all_order=" + all_order +
                ", rest_menu=" + rest_menu +
                ", order_id=" + order_id +
                '}';
    }
}
