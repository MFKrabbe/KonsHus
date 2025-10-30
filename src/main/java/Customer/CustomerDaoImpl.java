package Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao
{

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=dbKonsulenternesHus;encrypt=false;";

    private static final String USERNAME = "sa";        // Superbrugeren i SQL Server
    private static final String PASSWORD = "123";       // Dit valgte password til sa brugeren

    public static Connection getConnection() throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    // C i CRUD
    @Override
    public void saveCustomer(Customer c) throws Exception
    {
        final String sql = "INSERT INTO tblCustomer(fldCustomerName, fldCustomerCvrNr, fldCustomerPhoneNr, fldCustomerEmail) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            //pstmt.setString(1, c.getId());
            pstmt.setString(1, c.getName());        // gamle 2
            pstmt.setString(2, c.getCvrNr());
            pstmt.setString(3, c.getPhoneNr());
            pstmt.setString(4, c.getEmail());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Customer added successfully.");
            }
            else
            {
                System.out.println("Failed to add Customer.");
            }
        }
    }

    // R i CRUD
    @Override
    public Customer getCustomer(String id) throws Exception
    {

        final String sql = "SELECT * FROM tblCustomer WHERE fldCustomerID = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next())
                {
                    Customer customer = new Customer();
                    customer.setId(rs.getString(1));
                    customer.setName(rs.getString(2));
                    customer.setCvrNr(rs.getString(3));
                    customer.setPhoneNr(rs.getString(4));
                    customer.setEmail(rs.getString(5));

                    return customer;
                }
                else
                {
                    System.out.println("No Customer found with ID: " + id);
                    return null;
                }
            }
        }
    }

    // R i CRUD
    @Override
    public String[] getAllCustomers() throws Exception
    {
        final String sql = "SELECT * FROM tblCustomer";
        List<String> customers = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cvrNr = rs.getString(3);
                String phoneNr = rs.getString(4);
                String email = rs.getString(5);
                String line = id + " " + name + " " + cvrNr+ " " + phoneNr+ " " + email;
                customers.add(line);
            }
        }
        return customers.toArray(new String[0]);
    }

    // U i CRUD
    @Override
    public void updateCustomerName(String id, String newName) throws Exception
    {
        if (!(id == null))
        {
            final String sql = "UPDATE tblCustomer SET fldCustomerName = ? WHERE fldCustomerID = ?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql))
            {

                pstmt.setString(1, newName);
                pstmt.setString(2, id);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0)
                {
                    System.out.println("Customer's name updated successfully.");
                } else
                {
                    System.out.println("Failed to update customer's name.");
                }
            }
        }
    }

    public void updateCustomerCvrNr(String id, String newCvrNr) throws Exception
    {
        if (!(id == null))
        {
            final String sql = "UPDATE tblCustomer SET fldCustomerCvrNr = ? WHERE fldCustomerID = ?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql))
            {

                pstmt.setString(1, newCvrNr);
                pstmt.setString(2, id);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0)
                {
                    System.out.println("Customer's cvr number updated successfully.");
                } else
                {
                    System.out.println("Failed to update customer's cvr number.");
                }
            }
        }
    }

    public void updateCustomerPhoneNr(String id, String newPhoneNr) throws Exception
    {
    if (!(id == null))
    {
        final String sql = "UPDATE tblCustomer SET fldCustomerPhoneNr = ? WHERE fldCustomerID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, newPhoneNr);
            pstmt.setString(2, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0)
            {
                System.out.println("Customer's phone number updated successfully.");
            } else
            {
                System.out.println("Failed to update customer's phone number.");
            }
        }
    }
}

    public void updateCustomerEmail(String id, String newEmail) throws Exception
    {
        if (!(id == null))
        {
            final String sql = "UPDATE tblCustomer SET fldCustomerEmail = ? WHERE fldCustomerID = ?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql))
            {

                pstmt.setString(1, newEmail);
                pstmt.setString(2, id);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0)
                {
                    System.out.println("Customer's Email updated successfully.");
                } else
                {
                    System.out.println("Failed to update customer's Email.");
                }
            }
        }
    }

    // D i CRUD
    @Override
    public void deleteCustomer(String id) throws Exception
    {
        if (id == null || id.isBlank())
        {
            throw new IllegalArgumentException("Parameter 'id' can't be empty!.");
        }
        final String sql = "DELETE FROM tblCustomer WHERE fldCustomerID = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {

            ps.setString(1, id);
            int deleted = ps.executeUpdate();
            if (deleted == 0)
            {
                throw new Exception("No Customer found with fldCustomerID='" + id + "'.");
            }
        }
    }
}