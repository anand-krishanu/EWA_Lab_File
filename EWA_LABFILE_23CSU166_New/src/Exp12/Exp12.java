package Exp12;

import java.sql.*;

public class Exp12 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student";
            String userName = "root";
            String password = "admin";

            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();

            String query = "SELECT * FROM StudentData";
            rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("FirstName");
                String grade = rs.getString("grade");

                System.out.println("ID: " + id + ", FirstName: " + firstName + ", Grade: " + grade);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
