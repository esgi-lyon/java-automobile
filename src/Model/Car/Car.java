package Model.Car;

import Services.Entity.Entity;

public class Car implements Entity {

    /**
     * Default constructor
     */
    public Car() {}
    
    public Car(CarBrand carBrand, CarModel type) {
		this.carBrand = carBrand;
		this.type = type;
	}

	private CarBrand carBrand;

    private CarModel type;

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public CarModel getType() {
        return type;
    }

    public void setType(CarModel type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return carBrand.getName() +
                ", " + type.getName();
    }

    @Override
    public Entity factory(String[] dbData) {
        for (String str: dbData) {
            return new Car(new CarBrand("TODO", "TODO"));
        }
    }

    public void Operation1() {
        // TODO implement here
    }
}