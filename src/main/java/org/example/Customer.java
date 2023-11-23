package org.example;

public class Customer {

    private String customerName;

    private String customerId;

    Customer(String customerId , String customerName){
        this.customerName = customerName;
        this.customerId = customerId;

    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

}
