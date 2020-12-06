package Controller;

import Model.Database;
import Model.User;
import View.Form;
import View.AbstractDetails;

import javax.swing.*;
import java.io.File;

public class UserController {
    // database file
    private String databaseFile = "src/assets/users.txt";
    private Database database;
    private Form form;
    private AbstractDetails abstractDetails;

    public UserController(Form form, AbstractDetails abstractDetails) {
        this.database = new Database();
        this.form = form;
        this.abstractDetails = abstractDetails;

        // submit user
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();
            String lastname = this.form.getLastname().trim();

            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.database.addUser(new User(firstname, lastname));
            this.database.saveUser(new File(databaseFile));
            this.form.reset(true);
        });

        // load users
        this.form.viewUsers(e -> {
            this.abstractDetails.getDetails(this.database.loadUsers(new File(databaseFile)));
        });
    }
}
