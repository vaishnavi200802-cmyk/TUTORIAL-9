import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/college";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();

            String sql = "SELECT * FROM CourseRegistration WHERE CourseCode = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, courseCode);

                try (ResultSet rs = ps.executeQuery()) {
                    boolean found = false;

                    while (rs.next()) {
                        found = true;
                        System.out.println("Student ID: " + rs.getInt("StudentID"));
                        System.out.println("Student Name: " + rs.getString("StudentName"));
                        System.out.println("Course Code: " + rs.getString("CourseCode"));
                        System.out.println("Course Name: " + rs.getString("CourseName"));
                        System.out.println("Semester: " + rs.getString("Semester"));
                        System.out.println("--------------------");
                    }

                    if (!found) {
                        System.out.println(
                                "No students are registered for course " + courseCode);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
