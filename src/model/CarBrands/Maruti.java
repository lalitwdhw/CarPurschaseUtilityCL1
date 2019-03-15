package model.CarBrands;

import model.Car;

public final class Maruti extends Car {

    public Maruti(String model, int carId, int price) {


        this.setType("Maruti");
        this.setModel(model);
        this.setId(carId);
        this.setPrice(price);


    }

    /*
     * calculates the value of resale price for the car depending on the car model;
     * @return resaleValue
     */
    @Override
    public Double getResaleValue() {
        return this.getPrice() * 0.8;
    }
}
