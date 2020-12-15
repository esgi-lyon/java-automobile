package Controller;

import Exceptions.ServiceRegisteryException;
import Services.Entity.EntityManager;
import Model.Builder;
import Services.Layout;
import Services.Registery;
import View.BuilderView;

public class BuilderController extends AbstractController {
    private EntityManager entityManager;

    private BuilderView view;
    // Form create, List list
    public BuilderController(Registery registery) throws ServiceRegisteryException {
        super(registery);
        this.entityManager = new EntityManager(Builder.class);
        view = new BuilderView(this.getLayout(), this);
    }

    @Override
    protected void actions(Layout ly) throws ServiceRegisteryException {
        // Open list page from create form
        view.builderCreateForm.list(e -> {

        });

        view.builderCreateForm.submit(e -> {

        });
    }
}
