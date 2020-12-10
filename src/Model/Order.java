package Model;

import Model.Car.Car;

public class Order {

    private int id;

    private enum status{
        done,
        processing,
        cancelled,
    };

    private Car car;

    public Order() {
    }
}
