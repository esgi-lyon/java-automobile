package Controller;

import Exceptions.ServiceRegisteryException;
import Model.Client;
import Services.Entity.EntityManager;
import Model.Car.Car;
import Services.Layout;
import Services.Registery;
import View.CarView;
import View.ClientView;
import View.SwingModules.List;

/**
 * List / READ ONE cars (cars are provided by there builder so search cars in builders)
 */
public class CarController extends AbstractController {
    private EntityManager entityManager;

    private CarView carView;

    public CarController(Registery registery) throws ServiceRegisteryException {
        super(registery);
        this.entityManager = this.getEntityManager(Client.class);
        carView = new CarView(this.getLayout(), this);
    }

    @Override
    protected void actions(Layout ly) throws ServiceRegisteryException {

    }
}
