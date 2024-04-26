package br.com.fiap.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationsDAO {

    private String jdbcURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String username = "RM554286";
    private String password = "170304";

    private Connection getConnection() throws SQLException {
        // Asegura que o driver JDBC está carregado
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insert(Operation operation) throws SQLException {
        String sql = "INSERT INTO operations (id, description, type) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, operation.getId());
            pstmt.setString(2, operation.getDescription());
            pstmt.setInt(3, operation.getType());
            pstmt.executeUpdate();
} // try-with-resources irá automaticamente fechar recursos
    }       

            
    
    
    public List<Operation> getAll() throws SQLException {
        List<Operation> operations = new ArrayList<>();
        String sql = "SELECT * FROM operations";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                int type = rs.getInt("type");
                Operation operation = new Operation(id, description, type);
                operations.add(operation);
            }
        } // try-with-resources irá automaticamente fechar recursos
        return operations;
    }
}
