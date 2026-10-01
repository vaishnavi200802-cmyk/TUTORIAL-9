import java.sql.*;
import java.util.Scanner;

public class ProductJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/store";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            insertProduct(con, sc);
            retrieveProduct(con, sc);
            updateQuantity(con, sc);
            displayLowStock(con);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void insertProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        String sql = "INSERT INTO Product VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.executeUpdate();
            System.out.println("Product inserted.");
        }
    }

    private static void retrieveProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM Product WHERE ProductID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printProduct(rs);
                } else {
                    System.out.println("Product not found.");
                }
            }
        }
    }

    private static void updateQuantity(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();

        System.out.print("New quantity: ");
        int quantity = sc.nextInt();

        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Quantity updated.");
        }
    }

    private static void displayLowStock(Connection con) throws SQLException {
        String sql = "SELECT * FROM Product WHERE Quantity < 10";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nProducts with quantity below 10:");
            while (rs.next()) {
                printProduct(rs);
            }
        }
    }

    private static void printProduct(ResultSet rs) throws SQLException {
        System.out.println("ID: " + rs.getInt("ProductID"));
        System.out.println("Name: " + rs.getString("ProductName"));
        System.out.println("Price: " + rs.getDouble("Price"));
        System.out.println("Quantity: " + rs.getInt("Quantity"));
        System.out.println("--------------------");
    }
}
