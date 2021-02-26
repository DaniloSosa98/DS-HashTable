
import java.sql.*;

public class Connector {

    public static Customer[] Connect() {
        Connection con = null; //create a Connection variable
        Customer[] c_array = new Customer[122];
        CustomerArray ca = new CustomerArray();
        String un = "root";
        String pw = "";
        String url = "jdbc:mysql://localhost/classicmodels";

        try {
            //load driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //create connection
            con = DriverManager.getConnection(url, un, pw);

            System.out.println("SUCCESS");

            //create a statement object
            Statement s = con.createStatement();
            String query = "SELECT * FROM customers;";
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            int count = 0;

            while (rs.next()) {
                Customer c = new Customer(rs.getInt("customerNumber"), rs.getString("customerName"),
                        rs.getString("contactLastName"), rs.getString("contactFirstName"), rs.getString("phone"),
                        rs.getString("addressLine1"), rs.getString("addressLine2"), rs.getString("city"), rs.getString("state"),
                        rs.getString("postalCode"), rs.getString("country"), rs.getInt("salesRepEmployeeNumber"), rs.getDouble("creditLimit"));
                c_array = ca.insert(c_array, count, c, 122);
                count++;
            }

        } catch (Exception e) {
            System.err.println("Something bad happened: " + e.getMessage());
        }

        return c_array;
    }

}
