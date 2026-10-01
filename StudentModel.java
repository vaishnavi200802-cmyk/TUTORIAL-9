package model;

public class StudentModel {
    private String name;
    private double mark1, mark2, mark3;
    private double total, average;
    private String grade;

    public void calculate(String name, double mark1, double mark2, double mark3) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;

        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }

    public String getName() { return name; }
    public double getTotal() { return total; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }
}
