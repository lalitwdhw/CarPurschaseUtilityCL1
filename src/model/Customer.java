package model;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {

    private int id;
    private String name;
    private ArrayList<Car> customerCars;

    public Customer(int id, String name, ArrayList<Car> customerCars) {
        this.id = id;
        this.name = name;
        this.customerCars = customerCars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getCustomerCars() {
        return customerCars;
    }

    public void setCustomerCars(ArrayList<Car> customerCars) {
        this.customerCars = customerCars;
    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name);
    }

}
