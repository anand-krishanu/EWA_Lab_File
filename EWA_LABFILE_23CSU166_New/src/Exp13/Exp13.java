package Exp13;

import java.sql.*;
import java.util.Scanner;

public class Exp13 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rt = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student";
            String userName = "root";
            String password = "admin";

            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();

            String queryInsert = "INSERT INTO employees (id, name, salary) VALUES (?,?,?)";
            pstmt = con.prepareStatement(queryInsert);

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Employee Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();

            String resultQuery = "SELECT * FROM employees";
            st = con.createStatement();
            rt = st.executeQuery(resultQuery);

            System.out.println("Employee details:");
            while (rt.next()) {
                System.out.println("ID: " + rt.getInt("id") +
                        ", Name: " + rt.getString("name") +
                        ", Salary: " + rt.getDouble("salary"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rt != null) rt.close();
                if (st != null) st.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
