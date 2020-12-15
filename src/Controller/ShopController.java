package Controller;

import Exceptions.ServiceRegisteryException;
import Model.Shop;
import Services.Entity.EntityManager;
import Services.Layout;
import Services.Registery;

public class ShopController extends AbstractController {
    private EntityManager entityManager;

    // Views
    // private ShopView shopView;

    public ShopController(Registery registery) {
        super(registery);
        this.entityManager = new EntityManager(Shop.class);
    }

    @Override
    protected void actions(Layout ly) throws ServiceRegisteryException {

    }
}
