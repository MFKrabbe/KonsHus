package Hour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HourDAOImpl implements HourDAO
{
    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=dbKonsulenternesHus;encrypt=false;";

    private static final String USERNAME = "sa";      // Superbrugeren i SQL Server
    private static final String PASSWORD = "123";  // Dit valgte password til sa brugeren

    public static Connection getConnection() throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    // C i CRUD
    @Override
    public void saveHour(Hour hour) throws Exception {
        final String sql = "INSERT INTO tblHour VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hour.getID());
            pstmt.setInt(2, hour.getNr());
            pstmt.setString(3, hour.getCID());
            pstmt.setString(4, hour.getPID());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Hour added successfully.");
            } else {
                System.out.println("Failed to add the hour.");
            }
        }
    }

    // R i CRUD
    @Override
    public Hour getHour(String id) throws Exception {

        final String sql = "SELECT * FROM tblHour WHERE fldHourID = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Hour hour = new Hour();
                    hour.setID(rs.getString(1));
                    hour.setNr(rs.getInt(2));
                    hour.setCID(rs.getString(3));
                    hour.setPID(rs.getString(4));

                    return hour;
                } else {
                    System.out.println("No hour found with ID: " + id);
                    return null;
                }
            }
        }
    }

    // R i CRUD
    @Override
    public String[] getAllHours() throws Exception {
        final String sql = "SELECT * FROM tblHour";
        List<String> hours = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString(1);
                int nr = rs.getInt(2);
                String cID = rs.getString(3);
                String pID = rs.getString(4);
                String line = id + " " + nr + " " + cID + " " + pID;
                hours.add(line);
            }
        }
        return hours.toArray(new String[0]);
    }

    // U i CRUD
    @Override
    public void updateHour(String id, Hour hour) throws Exception {
        // Ikke implementeret endnu - skal vist ikke bruges i projektet
        // Hvis alligevel -> brug evt delete og save lige efter hinanden

        return;
    }

    // D i CRUD
    @Override
    public void deleteHour(String id) throws Exception {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Parameter 'id' cannot be empty.");
        }
        final String sql = "DELETE FROM tblHour WHERE fldHourID = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            int deleted = ps.executeUpdate();
            if (deleted == 0) {
                throw new Exception("No Hour found with fldHourID='" + id + "'.");
            }
        }
    }

}
