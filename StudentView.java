package view;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {
    public JTextField nameField = new JTextField();
    public JTextField mark1Field = new JTextField();
    public JTextField mark2Field = new JTextField();
    public JTextField mark3Field = new JTextField();
    public JButton calculateButton = new JButton("Calculate Result");

    public StudentView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Student Name:"));
        add(nameField);
        add(new JLabel("Subject 1 Marks:"));
        add(mark1Field);
        add(new JLabel("Subject 2 Marks:"));
        add(mark2Field);
        add(new JLabel("Subject 3 Marks:"));
        add(mark3Field);
        add(new JLabel());
        add(calculateButton);

        setVisible(true);
    }

    public void showResult(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
