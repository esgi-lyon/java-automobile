package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeForm extends JPanel {
    private JButton usersButton;

    public HomeForm() {
        usersButton = new JButton("Manage Users");
        usersButton.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        
        add(usersButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;

        add(usersButton, gridBagConstraints);
    }

    public void pageUsers(ActionListener actionListener) {
        usersButton.addActionListener(actionListener);
    }
}
