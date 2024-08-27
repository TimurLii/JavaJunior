package org.example.Reflection_API_2;

public class Car {
    //region Поля
    public String name;
    public String price;
    public String enginType;
    public String enginPower;
    public int maxSpeed;
    //endregion
    //region Конструктор
    public Car(String name) {
        this.name = name;
        this.enginType = "V8";
        this.enginPower = "123";
        this.maxSpeed = 222;
        this.price = "10000";
    }
    //endregion
    //region Method
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", enginType='" + enginType + '\'' +
                ", enginPower='" + enginPower + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
//endregion

    //region Getter/Setter
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    //endregion
}
