package model.CarBrands;

import model.Car;

public final class Hyundai extends Car {

    public Hyundai(String model, int carId, int price) {

        this.setType("Hyundai");
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
        return this.getPrice() * 0.4;
    }
}
