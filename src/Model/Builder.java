package Model;

import Model.Car.Car;

import java.util.ArrayList;

public class Builder {

    /**
     * Default constructor
     */
    public Builder() {
    }

    /**
     *
     */
    public ArrayList<Car> availableCars;


    /**
     *
     */
    public void orderCreation() {
        // TODO implement here
        // Check if car is in list of supported
        if (!this.isSupportedCar()) {
            this.nextBuilder();
        }
        // Call to car factory
    }

    public Builder nextBuilder() {
        return new Builder();
    };

    protected boolean isSupportedCar() {
        // search in cars list
        return false;
    }
}
