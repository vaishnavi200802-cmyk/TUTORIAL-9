package view;

import javax.swing.*;
import java.awt.*;

public class EmployeeDialogs {
    public static void addEmployee(JFrame parent) {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField department = new JTextField();

        panel.add(new JLabel("Employee ID:"));
        panel.add(id);
        panel.add(new JLabel("Employee Name:"));
        panel.add(name);
        panel.add(new JLabel("Department:"));
        panel.add(department);

        int result = JOptionPane.showConfirmDialog(parent, panel,
                "Add Employee", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(parent,
                    "Employee added successfully.");
        }
    }

    public static String[] changePassword(JFrame parent) {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JPasswordField oldPassword = new JPasswordField();
        JPasswordField newPassword = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();

        panel.add(new JLabel("Old Password:"));
        panel.add(oldPassword);
        panel.add(new JLabel("New Password:"));
        panel.add(newPassword);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPassword);

        int result = JOptionPane.showConfirmDialog(parent, panel,
                "Change Password", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            return new String[]{
                    new String(oldPassword.getPassword()),
                    new String(newPassword.getPassword()),
                    new String(confirmPassword.getPassword())
            };
        }

        return null;
    }
}
