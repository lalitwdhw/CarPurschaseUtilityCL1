package model.CarBrands;

import model.Car;

public final class Toyota extends Car {

   public Toyota(String model, int carId, int price) {

       this.setType("Toyota");
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
        return this.getPrice() * 0.6;
    }
}
