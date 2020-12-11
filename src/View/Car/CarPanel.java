package View.Car;

import Controller.CarController;
import View.MainFrame;

import java.awt.*;

public class CarPanel {
    public CarPanel(CardLayout cardLayout, MainFrame mainFrame) throws HeadlessException {
        // initialize user controller
        CarDetails carDetails = new CarDetails();
        new CarController(new CarDetails());

        // adds view to card layout with unique constraints
        // mainFrame.add(clientForm, "form");
        mainFrame.add(carDetails, "Car details");
        // switch view according to its constraints on click
        // clientForm.viewUsers(e -> cardLayout.show(mainFrame.getContentPane(), "User details"));
    }
}
