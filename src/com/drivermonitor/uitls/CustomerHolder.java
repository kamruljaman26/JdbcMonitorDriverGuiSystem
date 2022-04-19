package com.drivermonitor.uitls;

import com.drivermonitor.database.pojo.Customer;

public class CustomerHolder {

    private Customer customer;
    private final static CustomerHolder INSTANCE = new CustomerHolder();

    private CustomerHolder() {}

    public static CustomerHolder getInstance() {
        return INSTANCE;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
