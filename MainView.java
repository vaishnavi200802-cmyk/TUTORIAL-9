package view;

import javax.swing.*;

public class MainView extends JFrame {
    public JMenuItem addEmployee = new JMenuItem("Add Employee");
    public JMenuItem viewEmployee = new JMenuItem("View Employee");
    public JMenuItem changePassword = new JMenuItem("Change Password");
    public JMenuItem logout = new JMenuItem("Logout");
    public JMenuItem exitApplication = new JMenuItem("Exit Application");

    public MainView() {
        setTitle("Employee Management Portal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar bar = new JMenuBar();

        JMenu employeeMenu = new JMenu("Employee");
        employeeMenu.add(addEmployee);
        employeeMenu.add(viewEmployee);

        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(changePassword);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logout);
        exitMenu.add(exitApplication);

        bar.add(employeeMenu);
        bar.add(toolsMenu);
        bar.add(exitMenu);

        setJMenuBar(bar);
        add(new JLabel("Welcome to Employee Management Portal",
                SwingConstants.CENTER));

        setVisible(true);
    }
}
