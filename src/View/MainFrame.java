package View;

import Controller.UserController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();
        Form form = new Form();
        AbstractDetails abstractDetails = new UserAbstractDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        new UserController(form, abstractDetails);

        // adds view to card layout with unique constraints
        add(form, "form");
        add(abstractDetails, "user details");
        // switch view according to its constraints on click
        form.viewUsers(e -> cardLayout.show(MainFrame.this.getContentPane(), "user details"));
        abstractDetails.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "form"));

        // icon for our application
        ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
        setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
