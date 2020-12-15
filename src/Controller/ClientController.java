package Controller;

import Exceptions.ServiceRegisteryException;
import Services.Entity.EntityManager;
import Model.Client;
import Services.Layout;
import Services.Registery;
import View.ClientView;
import View.SwingModules.List;
import View.SwingModules.Form;

import javax.swing.*;

public class ClientController extends AbstractController {
    // Dependencies
    private EntityManager entityManager;
    // Views
    private ClientView clientView;

    public ClientController(Registery registery) throws ServiceRegisteryException {
        super(registery);
        this.entityManager = this.getEntityManager(Client.class);
        clientView = new ClientView(this.getLayout(), this);
    }

    @Override
    protected void actions(Layout ly) {

        // submit user
        clientView.createForm.submit(e -> {
            System.out.println("Cleintzefizeijfjze");
            String firstname = clientView.getFirstname().trim();
            String lastname = clientView.getLastname().trim();

            // simple validations
            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(clientView.createForm.getPanel(), "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (lastname.isEmpty()) {
                JOptionPane.showMessageDialog(clientView.createForm.getPanel(), "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.entityManager.add(new Client(firstname, lastname));
            this.entityManager.save();
            clientView.createForm.reset(true);
        });

        // load users
        clientView.createForm.list(e -> {
            clientView.list.getDetails(this.entityManager.loadEntities());
        });

        // TODO delete here

    }
}
