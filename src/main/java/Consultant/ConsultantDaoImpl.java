package Consultant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultantDaoImpl implements ConsultantDao {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=dbKonsulenternesHus;encrypt=false;";

    private static final String USERNAME = "sa";      // Superbrugeren i SQL Server
    private static final String PASSWORD = "123";   // Dit valgte password til sa brugeren

    public static Connection getConnection() throws Exception
    {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
            return conn;
    }
    // C i CRUD
    @Override
    public void saveConsultant(Consultant consultant) throws Exception
    {
        final String sql = "INSERT INTO tblConsultant VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, consultant.getId());
            pstmt.setString(2, consultant.getName());
            pstmt.setString(3, consultant.getPhoneNr());
            pstmt.setString(4, consultant.getEmail());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Consultant added successfully.");
            }
            else
            {
                System.out.println("Failed to add the Consultant.");
            }
        }
    }

    // R i CRUD
    @Override
    public Consultant getConsultant(String id) throws Exception
    {

        final String sql = "SELECT * FROM tblConsultant WHERE fldConsultantID = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1,  id);

            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next())
                {
                    Consultant consultant = new Consultant();
                    consultant.setId(rs.getString(1));
                    consultant.setName(rs.getString(2));
                    consultant.setPhoneNr(rs.getString(3));
                    consultant.setEmail(rs.getString(4));

                    return consultant;
                } else
                {
                    System.out.println("No consultant found with ID: " + id);
                    return null;
                }
            }
        }
    }

    // R i CRUD
    @Override
    public String[] getAllConsultants() throws Exception
    {
        final String sql = "SELECT * FROM tblConsultant";
        List<String> consultant = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String phoneNr = rs.getString(3);
                String email = rs.getString(4);
                String line = id + " " + name + " " + phoneNr + " " + email;
                consultant.add(line);
            }
        }
        return consultant.toArray(new String[0]);
    }

    // U i CRUD
    @Override
    public void updateConsultant(String id, Consultant consultant) throws Exception {
        // Ikke implementeret endnu - skal vist ikke bruges i projektet
        // Hvis alligevel -> brug evt delete og save lige efter hinanden

        return;
    }

    // D i CRUD
    @Override
    public void deleteConsultant(String no) throws Exception {
        if (no == null || no.isBlank()) {
            throw new IllegalArgumentException("Parameter 'no' må ikke være tom.");
        }
        final String sql = "DELETE FROM Consultant WHERE dept_no = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, no);
            int deleted = ps.executeUpdate();
            if (deleted == 0) {
                throw new Exception("Intet Consultant fundet med ConsultantID='" + no + "'.");
            }
        }
    }
}


