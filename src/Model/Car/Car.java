package Model.Car;

/**
 * 
 */
public class Car {

    /**
     * Default constructor
     */
    public Car() {}

    /**
     * 
     */
    public CarBrand carBrand;

    /**
     * 
     */
    public CarModel type;

    @Override
    public String toString() {
        return carBrand +
                ", " + type;
    }

    /**
     * 
     */
    public void Operation1() {
        // TODO implement here
    }

}