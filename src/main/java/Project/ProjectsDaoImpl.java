package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDaoImpl implements ProjectsDao {

        private static final String URL =
                "jdbc:sqlserver://localhost:1433;databaseName=dbKonsulenternesHus;encrypt=false;";

        private static final String USERNAME = "sa";        // Superbrugeren i SQL Server
        private static final String PASSWORD = "123";       // Dit valgte password til sa brugeren

        public static Connection getConnection() throws Exception {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
            return conn;
        }

        // C i CRUD
        @Override
        public void saveProject(Project projects) throws Exception {
            final String sql = "INSERT INTO Projects VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, projects.getId());
                pstmt.setString(2, projects.getName());
                pstmt.setString(3, projects.getStart());
                pstmt.setString(4, projects.getSlut());
                pstmt.setDouble(5, projects.getPrice());
                pstmt.setString(6, projects.getCId());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Projects added successfully.");
                } else {
                    System.out.println("Failed to add the Projects.");
                }
            }
        }

        // R i CRUD
        @Override
        public Project getProject(String id) throws Exception {

            final String sql = "SELECT * FROM tblProject WHERE fldProjectID = ?";

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, id);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        Project project = new Project();
                        project.setId(rs.getString(1));
                        project.setName(rs.getString(2));
                        project.setStart(rs.getString(3));
                        project.setSlut(rs.getString(4));
                        project.setPrice(rs.getDouble(5));
                        project.setCId(rs.getString(6));

                        return project;
                    } else {
                        System.out.println("No consultant found with ID: " + id);
                        return null;
                    }
                }
            }
        }

        // R i CRUD
        @Override
        public String[] getAllProjects() throws Exception {
            final String sql = "SELECT * FROM Projects";
            List<String> project = new ArrayList<>();

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String start = rs.getString(3);
                    String slut = rs.getString(4);
                    String price = rs.getString(5);
                    String cId = rs.getString(6);
                    String line = id + " " + name + " " + start + " " + slut + " " + price + " " + cId;
                    project.add(line);
                }
            }
            return project.toArray(new String[0]);
        }

        // U i CRUD
        @Override
        public void updateProject(String id, Project project) throws Exception {
            // Ikke implementeret endnu - skal vist ikke bruges i projektet
            // Hvis alligevel -> brug evt delete og save lige efter hinanden

            return;
        }

        // D i CRUD
        @Override
        public void deleteProject(String id) throws Exception {
            if (id == null || id.isBlank()) {
                throw new IllegalArgumentException("Parameter 'no' må ikke være tom.");
            }
            final String sql = "DELETE FROM tblProject WHERE fldProjectID = ?";

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, id);
                int deleted = ps.executeUpdate();
                if (deleted == 0) {
                    throw new Exception("Intet Project fundet med ProjectID='" + id + "'.");
                }
            }
        }
    }

