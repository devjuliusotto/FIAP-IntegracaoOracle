package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PermissionProfilesDAO {

    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(PermissionProfiles profile) throws SQLException {
        String sql = "INSERT INTO permission_profiles (id, code, description, access_level, password_policies_id) VALUES (permission_profiles_seq.nextval, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, profile.getCode());
            pstmt.setString(2, profile.getDescription());
            pstmt.setInt(3, profile.getAccessLevel());
            pstmt.setInt(4, profile.getPasswordPoliciesId());
            pstmt.executeUpdate();
        }
    }

    public List<PermissionProfiles> getAll() throws SQLException {
        List<PermissionProfiles> profilesList = new ArrayList<>();
        String sql = "SELECT * FROM permission_profiles";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PermissionProfiles profile = new PermissionProfiles(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("description"),
                        rs.getInt("access_level"),
                        rs.getInt("password_policies_id")
                );
                profilesList.add(profile);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar perfis de permissão: " + e.getMessage());
            throw e;
        }
        return profilesList;
    }
}
