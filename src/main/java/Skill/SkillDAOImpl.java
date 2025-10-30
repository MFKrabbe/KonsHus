package Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements SkillDAO {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=dbKonsulenternesHus;encrypt=false;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Override
    public void saveSkill(Skill skill) throws Exception {
        final String sql = "INSERT INTO tblSkill (fldSkillID, fldSkillCategory) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, skill.getID());
            pstmt.setString(2, skill.getCategory());
            pstmt.executeUpdate();
            System.out.println("Skill added successfully.");
        }
    }

    @Override
    public Skill getSkillById(String ID) throws Exception {
        final String sql = "SELECT * FROM tblSkill WHERE fldSkillID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Skill(rs.getString("fldSkillID"), rs.getString("fldSkillCategory"));
                }
            }
        }
        return null;
    }

    @Override
    public List<Skill> getAllSkills() throws Exception {
        final String sql = "SELECT * FROM tblSkill";
        List<Skill> skills = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                skills.add(new Skill(rs.getString("fldSkillID"), rs.getString("fldSkillCategory")));
            }
        }
        return skills;
    }

    @Override
    public void updateSkill(String ID, Skill skill) throws Exception
    {
        final String sql = "UPDATE tblSkill SET fldSkillCategory = ? WHERE fldSkillID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, skill.getCategory());
            pstmt.setString(2, skill.getID());
            pstmt.executeUpdate();
            System.out.println("Skill updated successfully.");
        }

    }

    @Override
    public void deleteSkill(String ID) throws Exception {
        final String sql = "DELETE FROM tblSkill WHERE fldSkillID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ID);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Skill deleted successfully.");
            } else {
                System.out.println("No skill found with ID: " + ID);
            }
        }
    }
}