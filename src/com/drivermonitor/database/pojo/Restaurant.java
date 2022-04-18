package com.drivermonitor.database.pojo;

public class Restaurant {

    private int rest_id;
    private String offers;
    private String type_of_food;
    private String meal_name;
    private String order_id;

    public Restaurant() {
    }

    public Restaurant(String offers, String type_of_food, String meal_name, String order_id) {
        this.offers = offers;
        this.type_of_food = type_of_food;
        this.meal_name = meal_name;
        this.order_id = order_id;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getType_of_food() {
        return type_of_food;
    }

    public void setType_of_food(String type_of_food) {
        this.type_of_food = type_of_food;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "rest_id=" + rest_id +
                ", offers='" + offers + '\'' +
                ", type_of_food='" + type_of_food + '\'' +
                ", meal_name='" + meal_name + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
