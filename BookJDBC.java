import java.sql.*;
import java.util.Scanner;

public class BookJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n1. Insert Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> insertBook(con, sc);
                    case 2 -> searchBook(con, sc);
                    case 3 -> displayAvailableBooks(con);
                    case 4 -> issueBook(con, sc);
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void insertBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        String sql = "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            System.out.println("Book inserted successfully.");
        }
    }

    private static void searchBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM Book WHERE BookID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printBook(rs);
                } else {
                    System.out.println("Book not found.");
                }
            }
        }
    }

    private static void displayAvailableBooks(Connection con) throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability = TRUE";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                printBook(rs);
            }
        }
    }

    private static void issueBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        String sql = "UPDATE Book SET Availability = FALSE WHERE BookID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Book issued." : "Book not found.");
        }
    }

    private static void printBook(ResultSet rs) throws SQLException {
        System.out.println("ID: " + rs.getInt("BookID"));
        System.out.println("Title: " + rs.getString("Title"));
        System.out.println("Author: " + rs.getString("Author"));
        System.out.println("Price: " + rs.getDouble("Price"));
        System.out.println("Available: " + rs.getBoolean("Availability"));
        System.out.println("--------------------");
    }
}
