package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordPoliciesDAO {

    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(PasswordPolicies policy) throws SQLException {
        String sql = "INSERT INTO password_policies (id, code, description, password_length, number_alpha_characters, number_numeric_characters, number_special_characters, number_uppercase_characters, password_reuse_history, password_expiration_days, failed_login_attempts) VALUES (password_policies_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, policy.getCode());
            pstmt.setString(2, policy.getDescription());
            pstmt.setInt(3, policy.getPasswordLength());
            pstmt.setInt(4, policy.getNumberAlphaCharacters());
            pstmt.setInt(5, policy.getNumberNumericCharacters());
            pstmt.setInt(6, policy.getNumberSpecialCharacters());
            pstmt.setInt(7, policy.getNumberUppercaseCharacters());
            pstmt.setInt(8, policy.getPasswordReuseHistory());
            pstmt.setInt(9, policy.getPasswordExpirationDays());
            pstmt.setInt(10, policy.getFailedLoginAttempts());
            pstmt.executeUpdate();
        }
    }

    public List<PasswordPolicies> getAll() throws SQLException {
        List<PasswordPolicies> policies = new ArrayList<>();
        String sql = "SELECT * FROM password_policies";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PasswordPolicies policy = new PasswordPolicies(
                        rs.getInt("id"),
                        rs.getLong("code"),
                        rs.getString("description"),
                        rs.getInt("password_length"),
                        rs.getInt("number_alpha_characters"),
                        rs.getInt("number_numeric_characters"),
                        rs.getInt("number_special_characters"),
                        rs.getInt("number_uppercase_characters"),
                        rs.getInt("password_reuse_history"),
                        rs.getInt("password_expiration_days"),
                        rs.getInt("failed_login_attempts")
                );
                policies.add(policy);
            }
        }
        return policies;
    }
}
