package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationsTypeDAO {

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

    public void insert(OperationsType operationsType) throws SQLException {
        String sql = "INSERT INTO operations_type (id, code, description, enabled, type_operation) VALUES (operations_type_seq.nextval, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, operationsType.getCode());
            pstmt.setString(2, operationsType.getDescription());
            pstmt.setBoolean(3, operationsType.isEnabled());
            pstmt.setInt(4, operationsType.getTypeOperation());
            pstmt.executeUpdate();
        }
    }

    public List<OperationsType> getAll() throws SQLException {
        List<OperationsType> operationsTypesList = new ArrayList<>();
        String sql = "SELECT * FROM operations_type";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OperationsType operationsType = new OperationsType(
                        rs.getInt("id"),
                        rs.getInt("code"),
                        rs.getString("description"),
                        rs.getBoolean("enabled"),
                        rs.getInt("type_operation")
                );
                operationsTypesList.add(operationsType);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar tipos de operação: " + e.getMessage());
            throw e;
        }
        return operationsTypesList;
    }
}
