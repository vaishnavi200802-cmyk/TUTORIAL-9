package controller;

import model.EmployeeModel;
import view.LoginView;
import view.MainView;
import view.EmployeeDialogs;

import javax.swing.*;

public class EmployeeController {
    private EmployeeModel model;
    private LoginView loginView;

    public EmployeeController(EmployeeModel model, LoginView loginView) {
        this.model = model;
        this.loginView = loginView;

        loginView.loginButton.addActionListener(e -> login());
    }

    private void login() {
        String username = loginView.usernameField.getText();
        String password = new String(loginView.passwordField.getPassword());

        if (model.validateLogin(username, password)) {
            JOptionPane.showMessageDialog(loginView, "Login successful!");
            loginView.dispose();
            showMainWindow();
        } else {
            JOptionPane.showMessageDialog(loginView,
                    "Invalid username or password.");
        }
    }

    private void showMainWindow() {
        MainView mainView = new MainView();

        mainView.addEmployee.addActionListener(
                e -> EmployeeDialogs.addEmployee(mainView));

        mainView.viewEmployee.addActionListener(
                e -> JOptionPane.showMessageDialog(mainView,
                        "Employee records can be displayed here."));

        mainView.changePassword.addActionListener(e -> {
            String[] passwords = EmployeeDialogs.changePassword(mainView);

            if (passwords != null) {
                boolean changed = model.changePassword(
                        passwords[0], passwords[1], passwords[2]);

                JOptionPane.showMessageDialog(mainView,
                        changed ? "Password changed successfully."
                                : "Password change failed. Check old password and confirmation.");
            }
        });

        mainView.logout.addActionListener(e -> {
            mainView.dispose();
            new EmployeeController(model, new LoginView());
        });

        mainView.exitApplication.addActionListener(e -> System.exit(0));
    }
}
