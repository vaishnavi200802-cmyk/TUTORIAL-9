package view;

import javax.swing.*;
import java.awt.*;

public class ServiceView extends JFrame {
    public JTextField registrationField = new JTextField();
    public JComboBox<String> vehicleType =
            new JComboBox<>(new String[]{"Two Wheeler", "Car"});
    public JCheckBox generalService = new JCheckBox("General Service - Rs.1000");
    public JCheckBox oilChange = new JCheckBox("Oil Change - Rs.800");
    public JCheckBox brakeService = new JCheckBox("Brake Service - Rs.1200");
    public JCheckBox batteryCheck = new JCheckBox("Battery Check - Rs.500");
    public JButton calculateButton = new JButton("Calculate Cost");

    public ServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(500, 350);
        setLayout(new GridLayout(7, 2, 8, 8));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Registration Number:"));
        add(registrationField);
        add(new JLabel("Vehicle Type:"));
        add(vehicleType);
        add(generalService);
        add(new JLabel());
        add(oilChange);
        add(new JLabel());
        add(brakeService);
        add(new JLabel());
        add(batteryCheck);
        add(new JLabel());
        add(calculateButton);

        setVisible(true);
    }

    public void showResult(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Service Cost", JOptionPane.INFORMATION_MESSAGE);
    }
}
