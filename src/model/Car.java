package model;

public abstract class Car {

    private String type;
    private String model;
    private int id;
    private int price;

    public Car(String type, String model, int id, int price) {
        this.type = type;
        this.model = model;
        this.id = id;
        this.price = price;
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract Double getResaleValue();


}
