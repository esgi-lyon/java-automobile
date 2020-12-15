package Controller;

import Exceptions.ServiceRegisteryException;
import Model.Order;
import Model.Car.Car;

import javax.swing.JOptionPane;

import Model.Client;
import View.SwingModules.List;
import View.OrderView;
import View.SwingModules.Form;
import Services.Entity.EntityManager;
import Services.Layout;
import Services.Registery;
import View.OrderView;

/**
 * Process order and manage CRUD operations
 */
public class OrderController extends AbstractController {
    private EntityManager entityManager;
    // Associated View
    protected OrderView orderView;

    private Form orderForm;
    private List orderDetails;
    
    public OrderController(Form orderForm, List orderDetails, OrderView orderView) {
        this.entityManager = new EntityManager(Order.class);
        this.orderForm = orderForm;
        this.orderDetails = orderDetails;
        
        // submit order
        this.orderForm.submit(e -> {
        	Client client = (Client)orderView.getClientList().getSelectedItem();
            Car car = (Car)orderView.getCarList().getSelectedItem();
            String id = orderView.getId().trim();

            // simple validations
            if (client.toString().isEmpty()) {
                JOptionPane.showMessageDialog(this.orderForm.getPanel(), "Client Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (car.toString().isEmpty()) {
                JOptionPane.showMessageDialog(this.orderForm.getPanel(), "Car Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this.orderForm.getPanel(), "ID Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.entityManager.add(new Order(Integer.parseInt(id), client, car));
            this.entityManager.save();
            this.orderForm.reset(true);
        	
        });
    }
    

}
