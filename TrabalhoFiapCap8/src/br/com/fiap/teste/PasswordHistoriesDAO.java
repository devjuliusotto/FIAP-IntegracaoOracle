package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordHistoriesDAO {
    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(PasswordHistories passwordHistory) throws SQLException {
        String sql = "INSERT INTO password_histories (id, operator_id, change_operator_id, password, password_change_date) VALUES (password_histories_seq.nextval, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, passwordHistory.getOperatorId());
            pstmt.setInt(2, passwordHistory.getChangeOperatorId());
            pstmt.setString(3, passwordHistory.getPassword());
            pstmt.setDate(4, new java.sql.Date(passwordHistory.getPasswordChangeDate().getTime()));
            pstmt.executeUpdate();
        }
    }

    public List<PasswordHistories> getAll() throws SQLException {
        List<PasswordHistories> passwordHistoriesList = new ArrayList<>();
        String sql = "SELECT * FROM password_histories";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PasswordHistories passwordHistory = new PasswordHistories(
                    rs.getInt("id"),
                    rs.getInt("operator_id"),
                    rs.getInt("change_operator_id"),
                    rs.getString("password"),
                    rs.getDate("password_change_date")
                );
                passwordHistoriesList.add(passwordHistory);
            }
        }
        return passwordHistoriesList;
    }
}
