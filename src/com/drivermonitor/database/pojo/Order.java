package com.drivermonitor.database.pojo;

public class Order {

    // CREATE = String.format("INSERT INTO %s (tax, meals, price, driver_name) "
    private int order_id;
    private double tax;
    private String meals;
    private double price;
    private String driver_name;

    public Order() {
    }

    public Order(double tax, String meals, double price, String driver_name) {
        this.tax = tax;
        this.meals = meals;
        this.price = price;
        this.driver_name = driver_name;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", tax=" + tax +
                ", meals='" + meals + '\'' +
                ", price=" + price +
                ", driver_name='" + driver_name + '\'' +
                '}';
    }
}
