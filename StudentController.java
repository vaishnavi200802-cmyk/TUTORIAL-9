package controller;

import model.StudentModel;
import view.StudentView;

public class StudentController {
    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;

        view.calculateButton.addActionListener(e -> calculateResult());
    }

    private void calculateResult() {
        try {
            String name = view.nameField.getText();
            double m1 = Double.parseDouble(view.mark1Field.getText());
            double m2 = Double.parseDouble(view.mark2Field.getText());
            double m3 = Double.parseDouble(view.mark3Field.getText());

            model.calculate(name, m1, m2, m3);

            view.showResult(
                    "Student: " + model.getName()
                    + "\nTotal: " + model.getTotal()
                    + "\nAverage: " + String.format("%.2f", model.getAverage())
                    + "\nGrade: " + model.getGrade()
            );
        } catch (NumberFormatException ex) {
            view.showResult("Please enter valid marks.");
        }
    }
}
