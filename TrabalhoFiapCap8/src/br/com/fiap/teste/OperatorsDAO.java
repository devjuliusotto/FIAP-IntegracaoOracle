package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperatorsDAO {

    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(Operator operator) throws SQLException {
        String sql = "INSERT INTO operators (id, first_name, last_name, email, password, passcode_expiry_date, passwd_failure_retry, last_passwd_failure_date, permission_profile_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, operator.getId());
            pstmt.setString(2, operator.getFirstName());
            pstmt.setString(3, operator.getLastName());
            pstmt.setString(4, operator.getEmail());
            pstmt.setString(5, operator.getPassword());
            pstmt.setDate(6, new java.sql.Date(operator.getPasscodeExpiryDate().getTime()));
            pstmt.setInt(7, operator.getPasswdFailureRetry());
            pstmt.setDate(8, operator.getLastPasswdFailureDate() != null ? new java.sql.Date(operator.getLastPasswdFailureDate().getTime()) : null);
            pstmt.setInt(9, operator.getPermissionProfileId());
            pstmt.executeUpdate();
        }
    }

    public List<Operator> getAll() throws SQLException {
        List<Operator> operators = new ArrayList<>();
        String sql = "SELECT * FROM operators";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Operator operator = new Operator(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getDate("passcode_expiry_date"),
                    rs.getInt("passwd_failure_retry"),
                    rs.getDate("last_passwd_failure_date"),
                    rs.getInt("permission_profile_id")
                );
                operators.add(operator);
            }
        }
        return operators;
    }
}
