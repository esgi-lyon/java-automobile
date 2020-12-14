package View;

import Controller.OrderController;
import Model.Order;
import Model.EntityManager;
import View.SwingModules.Form;
import View.SwingModules.FormBuilder;
import View.SwingModules.List;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;
import Model.Client;

public class OrderView {
	static String[] tableColumn = { "ID", "CAR", "CLIENT" };
	OrderController oc;
	static final String ADD = "order_add";
	static final String LIST = "order_list";

	public OrderView(CardLayout cardLayout, MainFrame mainFrame, Home home) throws HeadlessException {
		Form orderForm = this.CREATE();
		View.SwingModules.List orderList = this.LIST();
		// initialize user controller
		oc = new OrderController(orderForm, orderList);

		orderForm.getBackButton().onClick(e -> cardLayout.show(mainFrame.getContentPane(), "Home"));
		// adds view to card layout with unique constraints
		mainFrame.add(orderForm.getPanel(), ADD);
		mainFrame.add(orderList, LIST);
		// Home access
		home.ordersPage(e -> cardLayout.show(mainFrame.getContentPane(), ADD));
		// switch view according to its constraints on click
		orderForm.list(e -> cardLayout.show(mainFrame.getContentPane(), LIST));
		orderList.backButton.onClick(e -> cardLayout.show(mainFrame.getContentPane(), ADD));
	}

	public View.SwingModules.List LIST() {
		return new List(tableColumn);
	}

	public Form CREATE() {
		Object[] listeClients = this.getClients();

		String[] clientID = {};
		
		for (var i = 0; i < listeClients.length; i++) {
			//clientID[i].add(new String(listeClients[i]));
			System.out.println(listeClients[i].toString());
			//clientID.add(listeClients[i]);
			
		}

		String[] carID = { "car1", "car2", "car3", "car4" };
		JComboBox carList = new JComboBox(carID);
		JComboBox clientList = new JComboBox(clientID);

		FormBuilder builder = (new FormBuilder(true)).addField("id", new JTextField(25)).addField("voiture", carList)
				.addField("client", clientList);

		return builder.create(Optional.empty());
	}
	
    public Object[] getClients() {
    	return (new EntityManager(Client.class)).loadEntities();
    }
    
}
